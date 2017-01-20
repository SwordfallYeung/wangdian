package cn.wangdian.utils;

import cn.wangdian.Model.YuMing;
import cn.wangdian.Service.ShopKeeperService;
import cn.wangdian.Service.YuMingService;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by 25065 on 2016/9/18.
 */

public class URLFilter implements Filter {

    private static final Log log = LogFactory.getLog(URLFilter.class);
    //域名
    private static String DOMAIN_END ; //.gtafe.com
    private static String DOMAIN;
    private static String WWW_DOMAIN;

    ShopKeeperService shopKeeperService=new ShopKeeperService();
    YuMingService yuMingService=new YuMingService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("------------------------------init");
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        yuMingService=(YuMingService)ac.getBean("yuMingService");
        YuMing yuming=yuMingService.onlyOne();

        log.info("------------------------------数据库域名"+yuming);

        if (yuming!=null){
            DOMAIN=yuming.getYuming();
            DOMAIN_END="."+DOMAIN;
            WWW_DOMAIN="www."+DOMAIN;
        }else {
            DOMAIN=null;
            DOMAIN_END=null;
            WWW_DOMAIN=null;
        }

        log.info("------------------------------DOMAIN"+DOMAIN);
        log.info("------------------------------DOMAIN_END"+DOMAIN_END);
        log.info("------------------------------WWW_DOMAIN"+WWW_DOMAIN);

        shopKeeperService=(ShopKeeperService)ac.getBean("shopKeeperService");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        log.info("------------------------------doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取请求路径
        String requestURI=request.getRequestURI();

        //去除应用名（根据实际配置需要）
        if (requestURI.startsWith(request.getContextPath())){
            requestURI=requestURI.substring(request.getContextPath().length(),requestURI.length());
        }

        //获取域名
        String serverName=request.getServerName().toLowerCase();
        log.info("...........url路径 requestURI:" + requestURI);
        log.info("...........域名 serverName:" + serverName);

        if (DOMAIN!=null){
            String realURI=getRealRequestURI(serverName, requestURI);
            if (!realURI.equals("failUrl")){
                log.info("...........realURI:" + realURI);
                request.getRequestDispatcher(realURI).forward(request,response);
            }
        }else {
            request.getRequestDispatcher(requestURI).forward(request,response);
        }

    }


    @Override
    public void destroy() {
        log.info("------------------------------destroy");
    }


    /**
     * 获取域名解析后url
     *
     * @param serverName 域名
     * @param requestURI 请求uri
     * @return 解析后url
     * @author fengyu.wang
     * @date 2016年8月30日 上午8:42:36
     */
    private String getRealRequestURI(String serverName, String requestURI) {

        //这个有什么用,判断是否是一级域名，或者没有二级域名，以及静态资源
        if (WWW_DOMAIN.equals(serverName)||requestURI.startsWith("/frontAssets/")||requestURI.startsWith("/uploads/")||DOMAIN.equals(serverName)){
            return requestURI;
        }

//        if (Constants.WWW_DOMAIN.equals(serverName)||requestURI.startsWith("/frontAssets/")||requestURI.startsWith("/uploads/")||Constants.DOMAIN.equals(serverName)){
//            return requestURI;
//        }

        if (serverName.endsWith(DOMAIN_END)){
            //有二级域名
            String secondDomain=serverName.substring(0,serverName.indexOf("."));

            String webUrl=shopKeeperService.findWebUrlBySecondDomain(secondDomain);

            if (webUrl==null){
                return "failUrl";
            }

            log.info("...........二级域名 secondDomain:"+secondDomain);

            return secondDomain+requestURI;
        }else {
            //没有二级域名
            return requestURI;
        }
    }

}
