package cn.wangdian.Controller.Admin.ShopKeeper;

import cn.wangdian.Controller.Admin.Admin.ProfitController;
import cn.wangdian.Model.Orders;
import cn.wangdian.Model.ShopKeeper;
import cn.wangdian.Model.ShopKeeperProfit;
import cn.wangdian.Service.OrdersService;
import cn.wangdian.Service.ShopKeeperProfitService;
import cn.wangdian.Service.ShopKeeperService;
import cn.wangdian.utils.ExecuteResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 25065 on 2016/9/18.
 */
@Controller
@RequestMapping("/admin/shopKeeper")
public class ShopKeeperProfitController {

    private ExecuteResult executeResult=new ExecuteResult();

    private Log logger= LogFactory.getLog(ShopKeeperProfitController.class);

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ShopKeeperService shopKeeperService;
    @Autowired
    private ShopKeeperProfitService shopKeeperProfitService;


    @RequestMapping("/profit/list")
    public String ordersList(Model model,HttpSession session,
                             String shopType,String shopName,String shopModel,String shopNumber,
                             String startTime,String endTime){
        try {
            ShopKeeper shopKeeper123=(ShopKeeper) session.getAttribute("user");

            if (shopKeeper123==null){
                //session失效
                model.addAttribute("message","当前会话已失效，请重新登录");
                return "backPage/fail";
            }
            String shopKeeper=shopKeeper123.getUsername();

            if (shopType!=null&&!shopType.equals("")){
                model.addAttribute("shopType",shopType);
            }
            if (shopName!=null&&!shopName.equals("")){
                model.addAttribute("shopName",shopName);
            }

            if (shopModel!=null&&!shopModel.equals("")){
                model.addAttribute("shopModel",shopModel);
            }
            if (shopNumber!=null&&!shopNumber.equals("")){
                model.addAttribute("shopNumber",shopNumber);
            }
            if (startTime!=null&&!startTime.equals("")){
                model.addAttribute("startTime",startTime);
            }

            if (endTime!=null&&!endTime.equals("")){
                model.addAttribute("endTime",endTime);
            }

            //提交订单
            long tiJiaDingDanCount = ordersService.countAllByIsDel0(shopType,shopName,shopModel,shopNumber,shopKeeper,startTime,endTime,0);
            model.addAttribute("tiJiaDingDanCount",tiJiaDingDanCount);

            //已付款未发货
            long yiFuKuanWeiFaHuoCount=ordersService.countAllByIsDel0(shopType,shopName,shopModel,shopNumber,shopKeeper,startTime,endTime,1);
            model.addAttribute("yiFuKuanWeiFaHuoCount",yiFuKuanWeiFaHuoCount);

            //已付款已发货
            long yiFuKuanYiFaHuoCount=ordersService.countAllByIsDel0(shopType,shopName,shopModel,shopNumber,shopKeeper,startTime,endTime,2);
            model.addAttribute("yiFuKuanYiFaHuoCount",yiFuKuanYiFaHuoCount);

            //确认收货
            long yiQueShouHuoCount=ordersService.countAllByIsDel0(shopType,shopName,shopModel,shopNumber,shopKeeper,startTime,endTime,3);
            model.addAttribute("yiQueShouHuoCount",yiQueShouHuoCount);

            //申请退款
            long shenQingTuiHuoZhongCount=ordersService.countAllByIsDel0(shopType,shopName,shopModel,shopNumber,shopKeeper,startTime,endTime,4);
            model.addAttribute("shenQingTuiHuoZhongCount",shenQingTuiHuoZhongCount);

            //已退款
            long yiKuanCount=ordersService.countAllByIsDel0(shopType,shopName,shopModel,shopNumber,shopKeeper,startTime,endTime,5);
            model.addAttribute("yiKuanCount",yiKuanCount);

            model.addAttribute("shopKeeper",shopKeeper);

            float allProfit=0;
            /*List<Orders> profitList=ordersService.findAllByShopKeeperAndStatus3(shopKeeper);
            for (Orders orders:profitList){
//                allProfit+=orders.getProfits()*orders.getCount();
            }*/
            List<Float> profitList=ordersService.findAllByShopKeeperAndStatus3(shopKeeper);
            for(float profit:profitList){
                allProfit+=profit;
            }

            shopKeeperService.updateAllProfitById(allProfit,shopKeeper123.getId());

//            if (shopKeeper123.getAllProfit()!=allProfit){
//                model.addAttribute("errorMessage","你目前的总收益可能有误，请与管理员联系！！！");
//            }

            ShopKeeper shopKeeper1=shopKeeperService.selectByUsername(shopKeeper);

            model.addAttribute("yiTiXian",shopKeeper1.getYiTiXian());
            model.addAttribute("message",shopKeeper1.getMessage());
            model.addAttribute("allProfit",allProfit);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "backPage/shopKeeper/profit/list";
    }

    @RequestMapping(value = "/profit/tiXian",method = RequestMethod.GET)
    public String tiXian(String shopKeeper,Model model){
        model.addAttribute("shopKeeper",shopKeeper);
         return "backPage/shopKeeper/profit/tiXian";
    }

    @ResponseBody
    @RequestMapping(value = "/profit/tiXian",method = RequestMethod.POST)
    public Object tiXian(String shopKeeper,float money){
        try {

            ShopKeeper shopKeeper1=shopKeeperService.selectByUsername(shopKeeper);

            float weiTiXian=shopKeeper1.getAllProfit()-shopKeeper1.getYiTiXian();
            logger.info("没有提现为-------"+weiTiXian);
            logger.info("提现为-------"+money);
            if (money>weiTiXian){
                //不能提现
                return executeResult.jsonReturn(300,"，sorry，你所提现的金额超出了你的未提现金额！！！");
            }else {
                //可以提现
                ShopKeeperProfit shopKeeperProfit=new ShopKeeperProfit(shopKeeper,money,new Date(),0,0);
                shopKeeperProfitService.save(shopKeeperProfit);

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowDate=sdf.format(new Date());
                String message=(shopKeeper+"于"+nowDate+"申请提现"+money+"元");
                shopKeeperService.updateMessageByPrimaryKey(message,shopKeeper1.getId());
                return executeResult.jsonReturn(200);
            }
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage());
        }
    }
}
