package cn.wangdian.Controller.Home;

import cn.wangdian.Model.*;
import cn.wangdian.Service.*;
import cn.wangdian.utils.Encode;
import cn.wangdian.utils.StringUtil;
import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by 25065 on 2016/9/18.
 */
@Controller
public class HomeIndexController {

    private Log logger= LogFactory.getLog(HomeIndexController.class);

    private Encode encodeUtil = new Encode();

    @Autowired
    private AdvertService advertService;
    @Autowired
    private FirstPhotoService firstPhotoService;
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ShunShopService shunShopService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopPhotosService shopPhotosService;
    @Autowired
    private ShopAttributesService shopAttributesService;
    @Autowired
    private ShunShopPhotosService shunShopPhotosService;
    @Autowired
    private ShunShopAttributesService shunShopAttributesService;
    @Autowired
    private YunFeiService yunFeiService;
    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private ContactService contactService;

    @RequestMapping("/{shopKeeper}")
    public String toIndex(@PathVariable("shopKeeper")String shopKeeper){



        return "redirect:/index";
    }

    /**
     * 首页 start
     * @param shopKeeper
     * @return
     */

    @RequestMapping("/{shopKeeper}/index")
    public String index(@PathVariable("shopKeeper")String shopKeeper, Model model,HttpSession session){

        User user=(User)session.getAttribute("ordinaryUser");

        if (user!=null){
            model.addAttribute("ordinaryUser",user);
        }

        Page<Advert> advertList=null;
        Page<FirstPhoto> firstPhotoList=null;
        try {
            //只取最大的前5个数
            PageRequest pageRequest=new PageRequest(0,5);
            advertList=advertService.findAllByIsDel0("","","inTime","desc",pageRequest);
            firstPhotoList=firstPhotoService.findAllByIsDel0("","","inTime","desc",pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("advertList",advertList);
        model.addAttribute("firstPhotoList",firstPhotoList);
        return "frontPage/pages/home-page";
    }


    @RequestMapping(value = "/{shopKeeper}/login",method = RequestMethod.GET)
    public String login(@PathVariable("shopKeeper")String shopKeeper){
        return "frontPage/pages/login";
    }

    @RequestMapping("/{shopKeeper}/flashSale")
    public String flashSale(@PathVariable("shopKeeper")String shopKeeper,Model model){
        List<ShunShop> shunShopList=null;
        try {
            Integer page=0;
            shunShopList=shunShopService.findAllByIsDel0Limit20(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("shunShopList",shunShopList);
        return "frontPage/pages/flash-sale";
    }

    @ResponseBody
    @RequestMapping("/{shopKeeper}/flashSalePage")
    public Map<String,Object> flashSalePage(@PathVariable("shopKeeper")String shopKeeper,Integer page,Model model){
        Map<String,Object> map=new HashMap<String,Object>();
        List<ShunShop> shunShopList=null;
        try {
            shunShopList=shunShopService.findAllByIsDel0Limit20(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("shunShopList",shunShopList);
        return map;
    }

    @RequestMapping("/{shopKeeper}/userCenter")
    public String userCenter(@PathVariable("shopKeeper")String shopKeeper,
                             HttpSession session,
                             Model model){

        User user=(User)session.getAttribute("ordinaryUser");

        if (user!=null){
            model.addAttribute("ordinaryUser",user);
            return "frontPage/pages/user-center";
        }else {
            return "redirect:/login";
        }

    }

    /**
     * 首页 end
     * @param shopKeeper
     * @return
     */


    /**
     * 登录 start
     * @param shopKeeper
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/{shopKeeper}/login",method = RequestMethod.POST)
    public Map<String,String> login(@PathVariable("shopKeeper")String shopKeeper,
                                    @RequestParam("username")String username,
                                    @RequestParam("password")String password,
                                    HttpSession session){
        Map<String,String> map=new HashMap<String,String>();
        try {
            User user = new User();

            String regex_mobile = "^1[34578]\\d{9}$";

            String regex_email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

            if (Pattern.matches(regex_mobile, username)) {
                //是手机号
                user = userService.selectByTelephone(username);
            } else if (Pattern.matches(regex_email, username)) {
                //是邮箱
                user = userService.selectByEmail(username);
            }

            String encoder = new BASE64Encoder().encodeBuffer(password.getBytes("utf-8")).trim();
            System.out.println(encoder + "-=-=-==========");

            if (user == null) {
                map.put("message", "该用户不存在，请先注册！");
            } else if (!encoder.equals(user.getPassword().trim())) {
                map.put("message", "用户名或密码错误！");
            } else if (user.getStatus() == 1) {
                map.put("message", "当前用户已被锁定，请联系管理员或店主解锁！");
            } else {
                //成功登录
                session.setMaxInactiveInterval(60 * 60);
                session.setAttribute("ordinaryUser", user);
                map.put("message", "登录成功");
            }

        }catch (Exception e) {
            map.put("message","登录失败，请稍后再试！");
        }
        return map;
    }


    @RequestMapping("/{shopKeeper}/register")
    public String register(@PathVariable("shopKeeper")String shopKeeper){
        return "frontPage/pages/register";
    }

    @ResponseBody
    @RequestMapping(value = "/{shopKeeper}/register",method = RequestMethod.POST)
    public Map<String,String> register(@PathVariable("shopKeeper")String shopKeeper,User user){
        Map<String,String> map=new HashMap<String,String>();

        user.setStatus(0);
        user.setIsDel(0);

        try {

            //base64加密
            user.setPassword(new BASE64Encoder().encodeBuffer(user.getPassword().getBytes("utf-8")));

            if (user.getTelephone()!=null&&!user.getTelephone().equals("")){
                String telephone=userService.checkTelePhone(user.getTelephone());
                if (telephone!=null){
                    map.put("message","该手机号码已经注册过，请直接登录！！！");
                }else if (user.getEmail()!=null&&!user.getEmail().equals("")){
                    String email=userService.checkEmail(user.getEmail());
                    if (email!=null){
                        map.put("message","该邮箱已经注册过，请直接登录！！！");
                    }else{
                        userService.save(user);
                        map.put("message","注册成功");
                    }
                }
            }

        }catch (Exception e) {
            map.put("message","注册失败，请稍后再试！");
        }
        return map;
    }


    @RequestMapping("/{shopKeeper}/forgetPassword")
    public String forgetPassword(@PathVariable("shopKeeper")String shopKeeper){
        return "frontPage/pages/forget-password";
    }

    @ResponseBody
    @RequestMapping(value = "/{shopKeeper}/forgetPassword",method = RequestMethod.POST)
    public Map<String,String> forgetPassword(@PathVariable("shopKeeper")String shopKeeper,String email){
        Map<String,String> map=new HashMap<String,String>();

        try {
            if (email!=null&&!email.equals("")){

                String emailFromData=userService.checkEmail(email);
                if (emailFromData!=null){
                    String random= StringUtil.random();
                    userService.updatePasswordByEmail(email,new BASE64Encoder().encodeBuffer(random.getBytes("utf-8")).trim());
                    mailService.sendNotify(email,random);
                    map.put("message","发送成功");
                }else {
                    map.put("message","您所填写的邮箱不存在，请重新填写！");
                }
            }

        }catch (Exception e) {
            map.put("message","发送失败，请稍后再试！");
        }
        return map;
    }

    @RequestMapping("/changpassword")
    public String changPassword(String email,Model model){

        try {
            String password=userService.selectPasswordByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "frontPage/pages/change-password";
    }

    /**
     * 登录 end
     * @param shopKeeper
     * @return
     */

    /**
     * specification start
     * @param shopKeeper
     * @return
     */

    @RequestMapping("/{shopKeeper}/categories")
    public String categories(@PathVariable("shopKeeper")String shopKeeper,Model model){
        List<Shop> shopList= null;
        List<String> shopListAll= null;
        try {
            Integer page=0;
            shopList = shopService.findAllByIsDel0AndIsRecommend1Limit20(page);
            shopListAll = shopService.findAllShopTypeByIsDel0();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("shopList",shopList);
        model.addAttribute("shopListAll",shopListAll);
        return "frontPage/pages/categories";
    }

    @ResponseBody
    @RequestMapping("/{shopKeeper}/isRecommendPage")
    public Map<String,Object> isRecommendPage(@PathVariable("shopKeeper")String shopKeeper,Integer page,Model model){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Shop> shopList= null;

        try {
            shopList = shopService.findAllByIsDel0AndIsRecommend1Limit20(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("shopList",shopList);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/{shopKeeper}/specification",method = RequestMethod.POST)
    public List<String> specification(@PathVariable("shopKeeper")String shopKeeper,String styleNum){
        List<String> shopList= null;
        try {
            shopList= shopService.findAllShopModelByIsDel0AndType(styleNum);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return shopList;
    }

    @RequestMapping("/{shopKeeper}/search")
    public String search(@PathVariable("shopKeeper")String shopKeeper,String shopName,
                                Model model){
        List<Shop> shopList= null;
        try {
            Integer page=0;
            shopList = shopService.findAllByIsDel0AndShopName(shopName,page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("shopList",shopList);
        model.addAttribute("shopName",shopName);
//        model.addAttribute("type","search");
        return "frontPage/pages/commodity-list";
    }

    @ResponseBody
    @RequestMapping(value = "/{shopKeeper}/searchPage")
    public Map<String,Object>  searchAdd(@PathVariable("shopKeeper")String shopKeeper,String shopName,Integer page,
                         Model model){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Shop> shopList= null;
        try {

            shopList = shopService.findAllByIsDel0AndShopName(shopName,page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("shopList",shopList);
        return map;
    }


    @RequestMapping("/{shopKeeper}/commodityList")
    public String commodityList(@PathVariable("shopKeeper")String shopKeeper,String shopType,String shopModel,
                                Model model)throws Exception{
        List<Shop> shopList= null;

        String encode=encodeUtil.getEncoding(shopType);
        logger.info("编码格式为"+encode);

        //GB2312是服务器上的编码格式
        if(!encode.equals("GB2312")){
            shopType=new String(shopType.getBytes(encode),"UTF-8");
            shopModel=new String(shopModel.getBytes(encode),"UTF-8");
        }
        try {
            Integer page=0;
            shopList = shopService.findAllByIsDel0AndShopTypeAndShopModel(shopType,shopModel,page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("shopList",shopList);
        model.addAttribute("shopType",shopType);
        model.addAttribute("shopModel",shopModel);
        return "frontPage/pages/commodity-list";
    }

    @ResponseBody
    @RequestMapping("/{shopKeeper}/commodityListPage")
    public Map<String,Object> commodityListPage(@PathVariable("shopKeeper")String shopKeeper,String shopType,String shopModel,Integer page,
                                Model model){
        Map<String,Object> map=new HashMap<String,Object>();
        List<Shop> shopList= null;
        try {
            shopList = shopService.findAllByIsDel0AndShopTypeAndShopModel(shopType,shopModel,page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("shopList",shopList);
        return map;
    }

    @RequestMapping("/{shopKeeper}/commodityDetail")
    public String commodityDetail(@PathVariable("shopKeeper")String shopKeeper,
                                  Integer id,String type,Model model){

        if (type.equals("shunShop")){
            ShunShop shunShop=null;
            List<ShunShopPhotos> shunShopPhotosList= null;
            List<ShunShopPhotos> shunShopShowsList= null;
            List<ShunShopAttributes> shunShopAttributesList= null;

            try {
                shunShop=shunShopService.findById(id);
                shunShopPhotosList=shunShopPhotosService.findAllByIsDel0AndShopId(id,1);
                shunShopShowsList=shunShopPhotosService.findAllByIsDel0AndShopId(id,0);
                shunShopAttributesList=shunShopAttributesService.findAllByIsDel0AndShopId(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("type","shunShop");
            model.addAttribute("shopPhotosList",shunShopPhotosList);
            model.addAttribute("shopShowsList",shunShopShowsList);
            model.addAttribute("shopAttributesList",shunShopAttributesList);
            model.addAttribute("shop",shunShop);

        }else {
            Shop shop= null;
            List<ShopPhotos> shopPhotosList= null;
            List<ShopPhotos> shopShowsList= null;
            List<ShopAttributes> shopAttributesList= null;
            try {
                shop = shopService.findById(id);
                //商品详情
                shopPhotosList = shopPhotosService.findAllByIsDel0AndShopId(id,1);
                //商品轮播
                shopShowsList = shopPhotosService.findAllByIsDel0AndShopId(id,0);
                //商品属性
                shopAttributesList = shopAttributesService.findAllByIsDel0AndShopId(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("type","shop");
            model.addAttribute("shopPhotosList",shopPhotosList);
            model.addAttribute("shopShowsList",shopShowsList);
            model.addAttribute("shopAttributesList",shopAttributesList);
            model.addAttribute("shop",shop);
        }

        YunFei yunFei=yunFeiService.onlyOne();
        model.addAttribute("yunFei",yunFei);
        /*logger.info(promptInfo+"---------------------------=====");
        if(promptInfo!=null){
            if (promptInfo==0){
                logger.info(promptInfo+"---------------------------=====");
                model.addAttribute("promptInfo","加入购物车失败，请稍后再试！");
            }else if(promptInfo==1){
                logger.info(promptInfo+"---------------------------=====");
                model.addAttribute("promptInfo","成功加入购物车！");
            }
        }*/

        return "frontPage/pages/commodity-detail";
    }

    /**
     * specification end
     * @param shopKeeper
     * @return
     */

    /**
     * user center start
     * @param shopKeeper
     * @return
     */
    @RequestMapping("/{shopKeeper}/logout")
    public String logout(@PathVariable("shopKeeper")String shopKeeper,HttpSession session){
        session.removeAttribute("ordinaryUser");
        return "redirect:/index";
    }

    @RequestMapping(value = "/{shopKeeper}/changePassword",method = RequestMethod.GET)
    public String changePassword(@PathVariable("shopKeeper")String shopKeeper,Integer userId,Model model){
        model.addAttribute("userId",userId);
        return "frontPage/pages/change-password";
    }

    @ResponseBody
    @RequestMapping(value = "/{shopKeeper}/changePassword",method = RequestMethod.POST)
    public Map<String,String> changePassword(@PathVariable("shopKeeper")String shopKeeper,
                                             Integer userId, String password1,String password2){
        Map<String,String> map=new HashMap<String,String>();
        try {
            String passwordFromData=userService.selectPasswordById(userId).trim();

            //旧密码
            String encoder=new BASE64Encoder().encodeBuffer(password1.getBytes("utf-8")).trim();

            if (passwordFromData.equals(encoder)){
                //输入的旧密码与数据库的旧密码相符
                //可以修改密码
                userService.updatePasswordById(new BASE64Encoder().encodeBuffer(password2.getBytes("utf-8")).trim(),userId);
                map.put("message","修改成功");
            }else {
                //不符
                map.put("message","原始密码错误，请重新填写！");
            }
        } catch (Exception e) {
            map.put("message","修改失败！请稍后再试。");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/{shopKeeper}/updateNickname")
    public Map<String,String> updateNickname(@PathVariable("shopKeeper")String shopKeeper,
                                             Integer userId, String nickname,HttpSession session){
        Map<String,String> map=new HashMap<String,String>();
        try {
            if (nickname!=null&&!nickname.equals("")){
                userService.updateNicknameById(nickname,userId);
                map.put("message","修改成功！");
                map.put("nickname",nickname);

                User user = (User)session.getAttribute("ordinaryUser");
                user.setNickname(nickname);
                session.setAttribute("ordinaryUser",user);
            }else {
                map.put("message","你所填昵称为空！");
            }
        } catch (Exception e) {
            map.put("message","修改失败！请稍后再试。");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/{shopKeeper}/updateEmail")
    public Map<String,String> updateEmail(@PathVariable("shopKeeper")String shopKeeper,
                                          Integer userId, String email,HttpSession session){
        Map<String,String> map=new HashMap<String,String>();
        try {
            if (email!=null&&!email.equals("")){
                userService.updateEmailById(email,userId);
                map.put("message","修改成功！");
                map.put("email",email);

                User user = (User)session.getAttribute("ordinaryUser");
                user.setEmail(email);
                session.setAttribute("ordinaryUser",user);
            }else {
                map.put("message","你所填邮箱为空！");
            }
        } catch (Exception e) {
            map.put("message","修改失败！请稍后再试。");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/{shopKeeper}/updateTelephone")
    public Map<String,String> updateTelephone(@PathVariable("shopKeeper")String shopKeeper,
                                              Integer userId, String telephone,HttpSession session){
        Map<String,String> map=new HashMap<String,String>();
        try {
            if (telephone!=null&&!telephone.equals("")){
                userService.updateTelephoneById(telephone,userId);
                map.put("message","修改成功！");
                map.put("telephone",telephone);

                User user = (User)session.getAttribute("ordinaryUser");
                user.setTelephone(telephone);
                session.setAttribute("ordinaryUser",user);
            }else {
                map.put("message","你所填手机号为空！");
            }
        } catch (Exception e) {
            map.put("message","修改失败！请稍后再试。");
        }
        return map;
    }

    @RequestMapping("/{shopKeeper}/addressManagement")
    public String addressManagement(@PathVariable("shopKeeper")String shopKeeper,
                                    Integer userId,Model model){
        model.addAttribute("userId",userId);


        List<UserAddress> userAddressList= null;
        try {
            userAddressList = userAddressService.findAllByIsDel0(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userAddressList",userAddressList);
        return "frontPage/pages/address-management";
    }

    @RequestMapping(value = "/{shopKeeper}/addAddress",method = RequestMethod.GET)
    public String addAddress(@PathVariable("shopKeeper")String shopKeeper,
                             Integer userId,Model model){
        model.addAttribute("userId",userId);
        return "frontPage/pages/add-address";
    }

    @ResponseBody
    @RequestMapping(value = "/{shopKeeper}/addAddress",method = RequestMethod.POST)
    public Map<String,String> addAddress(@PathVariable("shopKeeper")String shopKeeper,
                                         UserAddress userAddress){
        Map<String,String> map=new HashMap<String,String>();
        try {
            userAddressService.save(userAddress);
            map.put("message","操作成功");
        } catch (Exception e) {
            map.put("message","添加失败！请稍后再试。");
        }
        return map;
    }


    @RequestMapping(value = "/{shopKeeper}/addAddressEdit",method = RequestMethod.GET)
    public String editAddress(@PathVariable("shopKeeper")String shopKeeper,
                             Integer id,Model model){
        UserAddress userAddress=null;
        try {
            userAddress=userAddressService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userAddress",userAddress);
        model.addAttribute("userId",userAddress.getUserId());
        return "frontPage/pages/add-address";
    }

    @RequestMapping(value = "/{shopKeeper}/addAddressDelete",method = RequestMethod.GET)
    public String deleteAddress(@PathVariable("shopKeeper")String shopKeeper,
                              Integer id,Model model){
        Integer userId= null;
        try {
            userAddressService.deleteByPrimaryKey(id);
            userId = userAddressService.findUserIdById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/addressManagement?userId="+userId;
    }

    @RequestMapping("/{shopKeeper}/myOrder")
    public String myOrder(@PathVariable("shopKeeper")String shopKeeper,
                          Integer userId,Model model){
        List<Orders> ordersList=null;
        try {
            String username=userService.findUsernameById(userId);
            ordersList=ordersService.findAllByIsDel0AndIsDelFromUser0AndUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("ordersList",ordersList);
        model.addAttribute("userId",userId);
        return "frontPage/pages/my-order";
    }

    @RequestMapping(value = "/{shopKeeper}/orderDetail",method = RequestMethod.GET)
    public String orderDetail(@PathVariable("shopKeeper")String shopKeeper,
                              Integer id,Integer userId,Integer shopId,String type,Model model){
        Orders orders= null;
        try {
            orders = ordersService.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("shopId",shopId);
        model.addAttribute("type",type);
        model.addAttribute("orders",orders);
        model.addAttribute("userId",userId);
        return "frontPage/pages/order-detail";
    }

    @RequestMapping(value = "/{shopKeeper}/ordersToRefund",method = RequestMethod.GET)
    public String ordersToRefund(@PathVariable("shopKeeper")String shopKeeper,
                              String shopOrderId,Integer userId,Model model){
        Orders orders= null;
        Contact contact=null;
        try {
            //申请退款中
            int status=ordersService.findStatusByByShopOrderId(shopOrderId);
            if (status==1){
                ordersService.updateStatusByShopOrderId(4,shopOrderId);
            }
           orders=ordersService.findByShopOrderId(shopOrderId);
            contact=contactService.onlyOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("orders",orders);
        model.addAttribute("contact",contact);
        return "frontPage/alipay/ordersToRefund";
    }

    @RequestMapping(value = "/{shopKeeper}/ordersToConfirmReceipt",method = RequestMethod.GET)
    public String ordersToConfirmReceipt(@PathVariable("shopKeeper")String shopKeeper,
                                 String shopOrderId,Integer userId,Model model){
        Orders orders= null;
        try {
            //确认收货
            int status=ordersService.findStatusByByShopOrderId(shopOrderId);
            if (status==2){
                ordersService.updateStatusByShopOrderId(3,shopOrderId);
            }
            orders=ordersService.findByShopOrderId(shopOrderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("orders",orders);
        model.addAttribute("message","收货成功");
        return "frontPage/include/success";
    }

    @RequestMapping(value = "/{shopKeeper}/ordersToWithdraw",method = RequestMethod.GET)
    public String ordersToWithdraw(@PathVariable("shopKeeper")String shopKeeper,
                                         String shopOrderId,Integer userId,Model model){
        Orders orders= null;
        try {
            //成功撤销退款申请
            int status=ordersService.findStatusByByShopOrderId(shopOrderId);
            if (status==4){
                ordersService.updateStatusByShopOrderId(1,shopOrderId);
            }
            orders=ordersService.findByShopOrderId(shopOrderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("orders",orders);
        model.addAttribute("message","成功撤销退款申请");
        return "frontPage/include/success";
    }


    @RequestMapping(value = "/{shopKeeper}/ordersContact",method = RequestMethod.GET)
    public String ordersContact(@PathVariable("shopKeeper")String shopKeeper, Model model){
        Contact contact=null;
        try {
            //联系卖家
            contact=contactService.onlyOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("contact",contact);
        return "frontPage/alipay/ordersContact";
    }

    @RequestMapping(value = "/{shopKeeper}/ordersCancel",method = RequestMethod.GET)
    public String ordersCancel(@PathVariable("shopKeeper")String shopKeeper,String shopOrderId,Integer userId,Model model){

        try {
            int status=ordersService.findStatusByByShopOrderId(shopOrderId);
            if (status==0){
                ordersService.updateStatusByShopOrderId(6,shopOrderId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/myOrder?userId="+userId;
    }

    @RequestMapping(value = "/{shopKeeper}/ordersDelete",method = RequestMethod.GET)
    public String ordersDelete(@PathVariable("shopKeeper")String shopKeeper,Integer id,Integer userId,Model model){

        try {
             ordersService.deleteIsDelFromUser1ByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/myOrder?userId="+userId;
    }

    /**
     * user center end
     * @param shopKeeper
     * @return
     */
    //选择参数页面
    @RequestMapping("/{shopKeeper}/chooseParam")
    public String chooseParam(@PathVariable("shopKeeper")String shopKeeper,Integer shopId,String type,String direction,
                              Model model,HttpSession session){

        User user=(User)session.getAttribute("ordinaryUser");
        model.addAttribute("user",user);

        if (user==null){
            return "redirect:/login";
        }
        List<ShopAttributes> shopAttributesList=null;
        List<ShunShopAttributes> shunShopAttributesList=null;
        try {

            if (type.equals("shop")){
                Shop shop = shopService.findById(shopId);
                shopAttributesList=shopAttributesService.findAllByIsDel0AndShopId(shopId);
                model.addAttribute("shop",shop);
                model.addAttribute("type","shop");
                model.addAttribute("shopAttributesList",shopAttributesList);
            }
            if (type.equals("shunShop")){
                ShunShop shunShop=shunShopService.findById(shopId);
                shunShopAttributesList=shunShopAttributesService.findAllByIsDel0AndShopId(shopId);
                model.addAttribute("shop",shunShop);
                model.addAttribute("type","shunShop");
                model.addAttribute("shunShopAttributesList",shunShopAttributesList);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("direction",direction);
        logger.info(direction+"----------------------");
        return "frontPage/pages/choose-param";
    }

    /*接收提交的参数*/
    @RequestMapping(value = "/{shopKeeper}/submitParam",method = RequestMethod.POST)
    public String submitParam(@PathVariable("shopKeeper")String shopKeeper,
                              Integer shopId,String type,String shopDetail,Integer count,String direction,
                              Model model,HttpSession session){
        logger.info(direction+"=============================");

        User user=(User)session.getAttribute("ordinaryUser");
        Integer orderId=null;
        Integer shopCartId=null;
        ShopCart shopCart=new ShopCart();

        String promptInfo;      //操作提示信息

        if (user==null){
            return "redirect:/login";
        }

        //保存用户所选的商品信息到数据库，即添加到购物车
        try {
            shopCart.setDetail(shopDetail);
            shopCart.setCount(count);
            shopCart.setIsDel(0);
            shopCart.setUserId(user.getId());
            shopCart.setStatus(0);

            if (type.equals("shop")){
                Shop shop = shopService.findById(shopId);
                shopCart.setShopId(shop.getId());
                shopCart.setShopNumber(shop.getNumber());
                shopCart.setShopModel(shop.getShopModel());
                shopCart.setShopName(shop.getName());
                shopCart.setShopType(shop.getShopType());
                shopCart.setFirstCost(shop.getFirstCost());
                shopCart.setAllFirstCost(shop.getFirstCost()*count);
                shopCart.setSecondCost(shop.getSecondCost());
                shopCart.setAllSecondCost(shop.getSecondCost()*count);
                float profits=shop.getSecondCost()-shop.getFirstCost();
                shopCart.setProfits(profits);
                shopCart.setAllProfits(profits*count);
                shopCart.setPhoto(shop.getFirstPhoto());
                shopCart.setType("shop");
            }
            if (type.equals("shunShop")){
                ShunShop shunShop=shunShopService.findById(shopId);
                shopCart.setShopId(shunShop.getId());
                shopCart.setShopNumber(shunShop.getNumber());
                shopCart.setShopModel(shunShop.getShopModel());
                shopCart.setShopName(shunShop.getName());
                shopCart.setShopType(shunShop.getShopType());
                shopCart.setFirstCost(shunShop.getFirstCost());
                shopCart.setAllFirstCost(shunShop.getFirstCost()*count);
                shopCart.setSecondCost(shunShop.getThirdCost());
                shopCart.setAllSecondCost(shunShop.getThirdCost()*count);
                float profits=shunShop.getThirdCost()-shunShop.getFirstCost();
                shopCart.setProfits(profits);
                shopCart.setAllProfits(profits*count);
                shopCart.setPhoto(shunShop.getFirstPhoto());
                shopCart.setType("shunShop");
            }

            promptInfo="成功加入购物车！";

            shopCartId=shopCartService.save(shopCart);
        } catch (Exception e) {
            promptInfo="加入购物车失败，请稍后再试！";
            e.printStackTrace();
        }

        //转到参数选择前的商品详情页面
        if (direction.equals("addToShopCart")){
            shopCartService.updateStatus1ById(shopCartId);
            session.setAttribute("promptInfo",promptInfo);
            return "redirect:/commodityDetail?id="+shopId+"&type="+type;
        } else if (direction.equals("submitOrder")){
            //直接购买，跳转到提交订单页面
            return "redirect:/submitOrder?shopCartId="+shopCartId;
        }
        return null;
    }

    @RequestMapping(value = "/{shopKeeper}/submitOrder",method = RequestMethod.GET)
    public String submitOrder(@PathVariable("shopKeeper")String shopKeeper,
                              Integer shopCartId,String shopCartIdListToString,
                              Model model,HttpSession session){

        User user=(User)session.getAttribute("ordinaryUser");
        List<ShopCart> shopCartList=new ArrayList<ShopCart>();

        if (user==null){
            return "redirect:/login";
        }

        List<UserAddress> userAddressList= null;
        ShopCart shopCart=null;
        YunFei yunFei=null;
        try {
            userAddressList = userAddressService.findAllByIsDel0AndUserId(user.getId());
            yunFei=yunFeiService.onlyOne();

            if (shopCartId!=null){
                shopCart=shopCartService.findById(shopCartId);
                model.addAttribute("shopId",shopCart.getShopId());
                model.addAttribute("type",shopCart.getType());
                model.addAttribute("direction","submitOrder");
                model.addAttribute("shopCart",shopCart);
            }


            if (shopCartIdListToString!=null||!shopCartIdListToString.equals("")){

                String[] shopCartIdList=shopCartIdListToString.split(",");

                if (shopCartIdList.length!=0){
                   for (int i=0;i<shopCartIdList.length;i++){
                       logger.info(shopCartIdList[i]+"------------------------------------------");
                       ShopCart shopC=shopCartService.findById(Integer.parseInt(shopCartIdList[i]));
                       shopCartList.add(shopC);
                   }
                }
                model.addAttribute("direction","addToShopCart");
                model.addAttribute("shopCartList",shopCartList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("userAddressList",userAddressList);
        model.addAttribute("user",user);
        model.addAttribute("yunFei",yunFei);
        return "frontPage/pages/submit-order";
    }


    @RequestMapping(value = "/{shopKeeper}/submitOrder",method = RequestMethod.POST)
    public String submitOrder(@PathVariable("shopKeeper")String shopKeeper,
                              Integer shopCartId,Integer count,Integer addressId,String liuYan,ShopCartArrays shopCartArrays,String direction,Integer shopId,String type,
                              Model model,HttpSession session){

        User user=(User)session.getAttribute("ordinaryUser");
        Integer orderId=null;

        if (user==null){
            return "redirect:/login";
        }

            try {
                long no=0;
                SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
                SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
                String nowDate=sdf.format(new Date());
                no=Long.parseLong(nowDate)*1000;
                int orderCount=ordersService.countAllByIsDel0AndToday(s.format(new Date()));
                System.out.println(orderCount+"------------------------------------------");
                orderCount=orderCount+1;
                String id=StringUtil.ziMuRandom()+no+orderCount;

                Orders orders=new Orders();
                orders.setShopOrderId(id);
                orders.setShopOrderTime(new Date());

                orders.setShopOrderMan(user.getUsername());
                orders.setTelephone(user.getTelephone());

                UserAddress userAddress=userAddressService.findById(addressId);
                orders.setReceiver(userAddress.getName());
                orders.setReceiverPhone(userAddress.getPhone());
                orders.setZipCode(userAddress.getZipcode());
                orders.setAddress(userAddress.getProvince()+userAddress.getCity()+userAddress.getArea()+userAddress.getTown()+userAddress.getAdddetail());

                orders.setStatus(0);
                orders.setIsDel(0);
                orders.setIsDelFromUser(0);
                orders.setShopKeeper(shopKeeper);
                orders.setLiuYan(liuYan);

                YunFei yunFei=yunFeiService.onlyOne();

                float ordersFirstCost=0;
                float ordersCost=0;
                float ordersProfits=0;

                //单个商品购买，计算总价以及利润价
                if (shopCartId!=null||count!=null){

                    ShopCart shopCart=shopCartService.findById(shopCartId);
                    ordersFirstCost=shopCart.getFirstCost()*count;
                    ordersCost=shopCart.getSecondCost()*count;
                    ordersProfits=shopCart.getProfits()*count;
                    shopCartService.deleteRealByPrimaryKey(shopCart);
                    shopCart.setAllFirstCost(ordersFirstCost);
                    shopCart.setAllSecondCost(ordersCost);
                    shopCart.setCount(count);
                    shopCart.setAllProfits(ordersProfits);
                    shopCart.setId(null);
                    shopCart.setStatus(2);//已下订
                    orders.addShopCartList(shopCart);
                }

                //多个商品购买，购物车形式
                List<Integer> shopCartIdList=shopCartArrays.getShopCartIdList();
                List<Integer> countList=shopCartArrays.getCountList();
                if (shopCartIdList.size()>0&&countList.size()>0){
                    for (int i=0;i<shopCartIdList.size();++i){
                        ShopCart shopCart=shopCartService.findById(shopCartIdList.get(i));
                        ordersFirstCost+=shopCart.getFirstCost()*countList.get(i);
                        ordersCost+=shopCart.getSecondCost()*countList.get(i);
                        ordersProfits+=shopCart.getProfits()*countList.get(i);
                        shopCartService.deleteRealByPrimaryKey(shopCart);
                        shopCart.setAllFirstCost(shopCart.getFirstCost()*countList.get(i));
                        shopCart.setAllSecondCost(shopCart.getSecondCost()*countList.get(i));
                        shopCart.setAllProfits(shopCart.getProfits()*countList.get(i));
                        shopCart.setCount(countList.get(i));
                        shopCart.setId(null);
                        shopCart.setStatus(2);//已下订
                        orders.addShopCartList(shopCart);
                    }
                }

                orders.setFirstCost(ordersFirstCost);
                orders.setProfits(ordersProfits);

                if (yunFei!=null){
                    if (ordersCost>=yunFei.getMianYunFei()){
                        //免运费
                        orders.setOrdersCost(ordersCost);
                        orders.setYunFei(0);
                    }else {
                        orders.setOrdersCost(ordersCost+yunFei.getYunFei());
                        orders.setYunFei(yunFei.getYunFei());
                    }
                }else {
                    orders.setOrdersCost(ordersCost);
                    orders.setYunFei(0);
                }
                orderId=ordersService.saveAndReturnId(orders);
                logger.info("--------------------------------------------orderId为"+orderId);
            } catch (Exception e) {
                e.printStackTrace();
            }
       if (direction.equals("addToShopCart")){
           return "redirect:/orderDetail?id="+orderId+"&userId="+user.getId();
       }else {
           return "redirect:/orderDetail?id="+orderId+"&userId="+user.getId()+"&direction="+direction+"&shopId="+shopId+"&type="+type;
       }
    }


    @ResponseBody
    @RequestMapping("/{shopKeeper}/deleteFromShopCart")
    public Map<String,String> deleteFromShopCart(@PathVariable("shopKeeper")String shopKeeper,String shopCartIdList,
                             Model model,HttpSession session){

        Map<String ,String> map=new HashMap<>();

        try{
            JSONArray idList=new JSONArray().fromObject(shopCartIdList);

            for(int i=0;i<idList.size();i++){
                logger.info(idList.getString(i));
                shopCartService.deleteByPrimaryKey(Integer.parseInt(idList.getString(i)));
            }
            map.put("message","success");
        }catch (Exception e) {
            e.printStackTrace();
            map.put("message","fail");
        }
        return map;
    }

    @RequestMapping("/{shopKeeper}/myShopCart")
    public String myShopCart(@PathVariable("shopKeeper")String shopKeeper,
                              Model model,HttpSession session){

        User user=(User)session.getAttribute("ordinaryUser");
        model.addAttribute("user",user);

        if (user==null){
            return "redirect:/login";
        }

        List<ShopCart> shopCartsList=null;
        try {

            shopCartsList=shopCartService.findAllByIsDel0AndUserIdAndStatus1(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("shopCartsList",shopCartsList);

        return "frontPage/pages/my-shopCart";
    }

    //我的购物车选择商品去提交订单
    @RequestMapping(value = "/{shopKeeper}/myShopCartToSubmitOrder")
    public String myShopCartToSubmitOrder(@PathVariable("shopKeeper")String shopKeeper,
                                          int[] shopCartIdList,
                                           Model model,HttpSession session){

        User user=(User)session.getAttribute("ordinaryUser");

        if (user==null){
            return "redirect:/login";
        }

        String shopCartIdListToString="";
        if (shopCartIdList.length!=0){
                for (int i=0;i<shopCartIdList.length;i++){
                   shopCartIdListToString+=shopCartIdList[i]+",";
                }
            shopCartIdListToString=shopCartIdListToString.substring(0,shopCartIdListToString.length()-1);
        }
        return "redirect:/submitOrder?shopCartIdListToString="+shopCartIdListToString;
    }
}
