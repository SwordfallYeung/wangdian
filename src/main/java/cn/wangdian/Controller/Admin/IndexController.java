package cn.wangdian.Controller.Admin;

import cn.wangdian.Model.Admin;
import cn.wangdian.Model.AdminLogin;
import cn.wangdian.Model.ShopKeeper;
import cn.wangdian.Service.AdminLoginService;
import cn.wangdian.Service.AdminService;
import cn.wangdian.Service.ShopKeeperService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;

/**
 * Created by 25065 on 2016/8/4.
 */
@Controller
@RequestMapping("/admin")
public class IndexController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminLoginService adminLoginService;
    @Autowired
    private ShopKeeperService shopKeeperService;

    private Log logger= LogFactory.getLog(IndexController.class);

    @RequestMapping("")
    public String toIndex(){
        return "redirect:/admin/index";
    }

//    暂时注释
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password,
                        @RequestParam(value = "authCode")String authCode,
                        @RequestParam(value = "peopleType")String peopleType,
                        HttpSession session, Model model){
        try {
            String validateCode=(String) session.getAttribute("validateCode");

            String loginName="";
            String loginPassword="";
            Integer status=0;

            ShopKeeper shopKeeper=new ShopKeeper();
            Admin admin=new Admin();

            if (peopleType.equals("shopKeeper")){

                shopKeeper=shopKeeperService.selectByUsername(username);
                if (shopKeeper!=null){
                    loginName=shopKeeper.getUsername().trim();
                    loginPassword=shopKeeper.getPassword().trim();
                    status=shopKeeper.getStatus();
                }else {
                    model.addAttribute("message","该用户名不存在");
                    return "backPage/fail";
                }

            }else if (peopleType.equals("admin")){
                admin=adminService.selectByUsername(username);
                if (admin!=null){
                    loginName=admin.getUsername().trim();
                    loginPassword=admin.getPassword().trim();
                    status=admin.getStatus();
                }else {
                    model.addAttribute("message","该用户名不存在");
                    return "backPage/fail";
                }

            }

            String encoder=new BASE64Encoder().encodeBuffer(password.getBytes("utf-8")).trim();
            System.out.println(encoder+"-=--=-=--=");

            if (!username.equals(loginName)){
                model.addAttribute("message","该用户名不存在");
                return "backPage/fail";
            }else if (!encoder.equals(loginPassword)){
                model.addAttribute("message","用户名或密码错误");
                return "backPage/fail";
            }else if (!authCode.equals(validateCode)){
                model.addAttribute("message","验证码错误");
                return "backPage/fail";
            }else if (status==1){
                model.addAttribute("message","该用户已被锁定，请联系管理员解锁");
                return "backPage/fail";
            }else {

                if (peopleType.equals("shopKeeper")){
                    //店主
                    session.setMaxInactiveInterval(30*60);
                    session.setAttribute("peopleType","shopKeeper");
                    session.setAttribute("user",shopKeeper);
                }else if (peopleType.equals("admin")){
                    //管理员
                    //保存上一次的登录时间以及登录次数
                    admin.setLoginTime(adminLoginService.findLastLoginTimeByAdminId(admin.getId()));
                    admin.setLoginCount(adminLoginService.findCountByAdminId(admin.getId())+1);
                    adminService.update(admin);
//                //保存这次登录时间
                    Calendar calendar=Calendar.getInstance();
                    AdminLogin adminLogin=new AdminLogin(calendar.getTime(),admin.getId());
                    adminLoginService.save(adminLogin);
                    session.setMaxInactiveInterval(30*60);
                    session.setAttribute("peopleType","admin");
                    session.setAttribute("user",admin);
                }
                session.setAttribute("login","success");
                return "redirect:/admin/index";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("login");
        session.removeAttribute("user");
        session.removeAttribute("peopleType");
        return "backPage/login";
    }

    @RequestMapping("/validatecode")
    public String validatecode(){
        return "backPage/validatecode";
    }

    @RequestMapping("/index")
    public String index(HttpSession session, Model model){
        logger.info("主页");
//        暂时注释
        try {
            String login=(String) session.getAttribute("login");
            if (login.equals("success")){
                //登录成功
                String peopleType=(String) session.getAttribute("peopleType");
                System.out.println(peopleType+"--==-=-=-=-");

                if (peopleType.equals("shopKeeper")){
                    //店主
                    ShopKeeper shopKeeper=(ShopKeeper)session.getAttribute("user");
                    model.addAttribute("user",shopKeeper);
                }else if (peopleType.equals("admin")){
                    //管理员
                    Admin admin=(Admin)session.getAttribute("user");
                    model.addAttribute("user",admin);
                }
                model.addAttribute("peopleType",peopleType);
                return "backPage/backIndex";
            }else {
                session.removeAttribute("login");
                return "backPage/login";
            }
        } catch (Exception e) {
            //session login不存在，报错
            return "backPage/login";
        }
//        return "backPage/backIndex";
    }
}
