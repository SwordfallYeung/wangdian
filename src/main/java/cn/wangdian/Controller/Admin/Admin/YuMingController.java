package cn.wangdian.Controller.Admin.Admin;

import cn.wangdian.Model.YuMing;
import cn.wangdian.Service.YuMingService;
import cn.wangdian.utils.ExecuteResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 25065 on 2016/9/18.
 */
@Controller
@RequestMapping("/admin")
public class YuMingController {

    private ExecuteResult executeResult=new ExecuteResult();

    private Log logger= LogFactory.getLog(YuMingController.class);

    @Autowired
    private YuMingService yuMingService;

    @RequestMapping("/yuMing/list")
    public String yuMing(Model model){
        YuMing yuMing= null;
        try {
            yuMing = yuMingService.onlyOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("yuMing",yuMing);
        return "/backPage/admin/yuming/list";
    }

    @ResponseBody
    @RequestMapping(value = "/yuMing/add",method = RequestMethod.POST)
    public Object add(YuMing yuMing){

        System.out.println(yuMing.getId()+yuMing.getYuming());
        try {
            if (yuMing.getId()==null||yuMing.getId().equals("")){
                //添加
                yuMingService.save(yuMing);
            }else {
                //编辑
                yuMingService.update(yuMing);
            }
            return executeResult.jsonReturn(200);
        } catch (Exception e) {
            return executeResult.jsonReturn(300,e.getMessage());
        }
    }
}
