package cn.wangdian.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 25065 on 2016/10/13.
 */
public class ShopCartArrays {

    private List<Integer> shopCartIdList=new ArrayList<>();
    private List<Integer> countList=new ArrayList<>();

    public List<Integer> getShopCartIdList() {
        return shopCartIdList;
    }

    public void setShopCartIdList(List<Integer> shopCartIdList) {
        this.shopCartIdList = shopCartIdList;
    }

    public List<Integer> getCountList() {
        return countList;
    }

    public void setCountList(List<Integer> countList) {
        this.countList = countList;
    }
}
