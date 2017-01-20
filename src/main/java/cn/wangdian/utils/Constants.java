package cn.wangdian.utils;

public class Constants {
//    public static final String DOMAIN = "you.com";
//    public static final String WWW_DOMAIN = "www.you.com";

    public  String domain;
    public  String www_domain;

    public Constants() {
    }

    public Constants(String domain, String www_domain) {
        this.domain = domain;
        this.www_domain = www_domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWww_domain() {
        return www_domain;
    }

    public void setWww_domain(String www_domain) {
        this.www_domain = www_domain;
    }
}
