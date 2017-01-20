package cn.wangdian.Controller.Admin.Admin;

import cn.wangdian.Model.Admin;
import cn.wangdian.Model.Orders;
import cn.wangdian.Model.ShopKeeper;
import cn.wangdian.Model.YuMing;
import cn.wangdian.Service.OrdersService;
import cn.wangdian.Service.ShopKeeperService;
import cn.wangdian.Service.YuMingService;
import cn.wangdian.utils.ExecuteResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 25065 on 2016/9/11.
 */
@Controller
@RequestMapping("/admin")
public class ShopKeeperController {

    private ExecuteResult executeResult=new ExecuteResult();

    private Log logger= LogFactory.getLog(ShopKeeperController.class);

    @Autowired
    private ShopKeeperService shopKeeperService;
    @Autowired
    private YuMingService yuMingService;
    @Autowired
    private OrdersService ordersService;

    private static int parameterCountBefore=0;

    @RequestMapping("/shopKeeper/list")
    public String shopKeeperList(Model model,
                            String orderField,String orderDirection,Integer pageSize,Integer pageCurrent,
                            String username,String nickname,Integer status){
        Page<ShopKeeper> shopKeeperList= null;

        YuMing yuMing= null;
        try {
            yuMing = yuMingService.onlyOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("yuMing",yuMing);

        try {
            int parameterCountNow=0;
            if (username!=null&&!username.equals("")){
                model.addAttribute("username",username);
                parameterCountNow++;
            }
            if (nickname!=null&&!nickname.equals("")){
                model.addAttribute("nickname",nickname);
                parameterCountNow++;
            }
            if (status!=null&&!status.equals("")){
                model.addAttribute("status",status);
                parameterCountNow++;
            }


            if (pageSize==null||pageSize.equals("")){
                pageSize=5;
            }
            //有多少页
            int count=shopKeeperService.countAllByIsDel0(username,nickname,status);
            int pageNumbers=0;
            if (count%pageSize==0){
                //整除
                pageNumbers=count/pageSize;
            }else {
                //有余数
                pageNumbers=count/pageSize+1;
            }

            if (pageCurrent==null||pageCurrent.equals("")){
                pageCurrent=0;
            }else if (parameterCountNow!=parameterCountBefore){
                pageCurrent=0;
                parameterCountBefore=parameterCountNow;
            }else if (pageCurrent>pageNumbers){
                pageCurrent=0;
            }else {
                pageCurrent=pageCurrent-1;
            }

            PageRequest pageRequest=new PageRequest(pageCurrent,pageSize);
            shopKeeperList = shopKeeperService.findAllByIsDel0(username,nickname,status,orderField,orderDirection,pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (shopKeeperList!=null){
            for (ShopKeeper shopKeeper:shopKeeperList){
                float allProfit=0;
                List<Float> profitList=ordersService.findAllByShopKeeperAndStatus3(shopKeeper.getUsername());
                for (Float profit:profitList){
                    allProfit+=profit;
                }
                shopKeeper.setAllProfit(allProfit);
                shopKeeperService.updateAllProfitById(allProfit,shopKeeper.getId());
            }
        }
        model.addAttribute("shopKeeperList",shopKeeperList);
        return "backPage/admin/shopkeeper/shopKeeperList";
    }

    @RequestMapping(value = "/shopKeeper/add",method = RequestMethod.GET)
    public String shopKeeperAdd(Integer id,String type,Model model){
        YuMing yuMing=null;
        try {
            yuMing = yuMingService.onlyOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("yuMing",yuMing);

        if (id!=null){
            ShopKeeper shopKeeper=null;

            try {
                shopKeeper=shopKeeperService.findById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("shopKeeper",shopKeeper);
        }

        if (type!=null&&!type.equals("")&&type.equals("shopKeeper")){
            model.addAttribute("type","shopKeeper");
        }
        return "backPage/admin/shopkeeper/add";
    }

    @ResponseBody
    @RequestMapping(value = "/shopKeeper/add",method = RequestMethod.POST)
    public Object shopKeeperAdd(ShopKeeper shopKeeper, String type, Model model, HttpSession session){
        try {
            //base64加密
            shopKeeper.setPassword(new BASE64Encoder().encodeBuffer(shopKeeper.getPassword().getBytes("utf-8")));
            shopKeeper.setWebUrl(shopKeeper.getUsername());
            if (shopKeeper.getId()!=null){
                //编辑
                String usernameFromDatebase=shopKeeperService.findUsernameById(shopKeeper.getId());
                //编辑过程中所填的用户名与本来数据库的用户名不一样
                if (!usernameFromDatebase.equals(shopKeeper.getUsername())){
                    String name=shopKeeperService.checkUsername(shopKeeper.getUsername());
                    if (name!=null){
                        return executeResult.jsonReturn(300,"该用户名已被注册",false);
                    }
                }
                shopKeeperService.update(shopKeeper);

                session.setMaxInactiveInterval(30*60);
                session.setAttribute("user",shopKeeper);
//                ShopKeeper shopKeeper1=(ShopKeeper)session.getAttribute("user");
//                System.out.println(shopKeeper1.getNickname()+"昵称");

            }else {
                //添加
                String name=shopKeeperService.checkUsername(shopKeeper.getUsername());
                if (name!=null){
                    return executeResult.jsonReturn(300,"该用户名已被注册",false);
                }else {
                    shopKeeperService.save(shopKeeper);
                }
            }

            if (type!=null&&!type.equals("")&&type.equals("shopKeeper")){
                return executeResult.jsonReturnForHead(200);
            }else {
                return executeResult.jsonReturn(200);
            }

        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage());
        }
//        return "backPage/Common/ajaxDone";
    }


    /**
     * 店主用户名检测是否存在
     * @return
     */
    @ResponseBody
    @RequestMapping("/shopKeeper/checkUsername")
    public Object checkUsername(String username){
        try {
            String name=shopKeeperService.checkUsername(username);
            if (name==null){
                return executeResult.jsonReturn(200,"该用户名可以使用",false);
            }else {
                return executeResult.jsonReturn(300,"该用户名已被注册",false);
            }
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

    /**
     * 店主锁定
     * @return
     */
    @ResponseBody
    @RequestMapping("/shopKeeper/suoDing")
    public Object suoDing(Integer id){
        try {
            shopKeeperService.suoDingById(id);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }

    /**
     * 店主解锁
     * @return
     */
    @ResponseBody
    @RequestMapping("/shopKeeper/jieDing")
    public Object jieDing(Integer id){
        try {
            shopKeeperService.jieDingById(id);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }


    /**
     * 店主删除
     * @return
     */
    @ResponseBody
    @RequestMapping("/shopKeeper/delete")
    public Object delete(Integer id){
        try {
            shopKeeperService.deleteByPrimaryKey(id);
            return executeResult.jsonReturn(200,false);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage(),false);
        }
    }
}
