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
@Table(name = "wd_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String nickname;//昵称

    private String username;//真实的用户名

    private String email;//邮箱

    private String telephone;//手机号

    private String password;//密码

    private Integer status;//状态 ，0正常，1锁定

    private Integer isDel;//0存在，1删除

    //地址


    public User() {
    }

    public User(String nickname, String username, String email, String telephone, String password, Integer status, Integer isDel) {
        this.nickname = nickname;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String decoderPassword() throws Exception{
        return new String(new BASE64Decoder().decodeBuffer(password));
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
}
