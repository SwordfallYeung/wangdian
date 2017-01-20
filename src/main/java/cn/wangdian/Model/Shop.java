package cn.wangdian.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 25065 on 2016/9/16.
 */
@Entity
@Table(name = "wd_shop")
public class Shop {

    @Id
    @GeneratedValue
    private Integer id;

    private String number;//编号

    private String name;//商品名称

    private String shopType;//商品类型

    private String shopModel;//商品型号

    private float firstCost;//成本价

    private float secondCost;//销售价

    private Date inTime;//入库时间

    private Integer status;//0上架，1下架

    private Integer isDel;//0存在，1删除

    private String shopDescribe;//描述

    private String firstPhoto;//首页图片

    private Integer isRecommend;//是否为推荐商品 0为否，1为是

    public Shop() {
    }

    public Shop(String number, String name, String shopType, String shopModel, Integer status, Integer isDel, String shopDescribe) {
        this.number = number;
        this.name = name;
        this.shopType = shopType;
        this.shopModel = shopModel;
        this.status = status;
        this.isDel = isDel;
        this.shopDescribe = shopDescribe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getShopModel() {
        return shopModel;
    }

    public void setShopModel(String shopModel) {
        this.shopModel = shopModel;
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

    public String getShopDescribe() {
        return shopDescribe;
    }

    public void setShopDescribe(String shopDescribe) {
        this.shopDescribe = shopDescribe;
    }

    public float getFirstCost() {
        return firstCost;
    }

    public void setFirstCost(float firstCost) {
        this.firstCost = firstCost;
    }

    public float getSecondCost() {
        return secondCost;
    }

    public void setSecondCost(float secondCost) {
        this.secondCost = secondCost;
    }

    public String getFirstPhoto() {
        return firstPhoto;
    }

    public void setFirstPhoto(String firstPhoto) {
        this.firstPhoto = firstPhoto;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String inTimeToString(){
        if (inTime!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(inTime);
        }else {
            return null;
        }

    }
}
