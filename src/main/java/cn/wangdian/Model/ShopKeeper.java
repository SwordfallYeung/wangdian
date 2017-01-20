package cn.wangdian.Model;

import sun.misc.BASE64Decoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 25065 on 2016/9/14.
 */
@Entity
@Table(name = "wd_shopkeeper")
public class ShopKeeper {

    @Id
    @GeneratedValue
    private Integer id;

    private String nickname;//昵称

    private String username;//真实的用户名

    private String email;//电子邮件

    private String telephone;//手机号

    private String password;//密码

    private String zhifubao;//支付宝

    private String webUrl;//网址

    private float allProfit;//截止目前为止的总收益

    private float yiTiXian;//已提现

    private String message;//提现消息

    private Integer status;//状态 ，0正常，1锁定

    private Integer isDel;//0存在，1删除

    public ShopKeeper() {
    }

    public ShopKeeper(String nickname, String username, String email, String telephone, String password, String zhifubao, Integer status, Integer isDel) {
        this.nickname = nickname;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.zhifubao = zhifubao;
        this.status = status;
        this.isDel = isDel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String decoderPassword() throws Exception{
        return new String(new BASE64Decoder().decodeBuffer(password));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZhifubao() {
        return zhifubao;
    }

    public void setZhifubao(String zhifubao) {
        this.zhifubao = zhifubao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

//    public String webUrl(){
//        return webUrl.substring(0,webUrl.length()-1);
//    }

    public float getAllProfit() {
        return allProfit;
    }

    public void setAllProfit(float allProfit) {
        this.allProfit = allProfit;
    }

    public float getYiTiXian() {
        return yiTiXian;
    }

    public void setYiTiXian(float yiTiXian) {
        this.yiTiXian = yiTiXian;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
