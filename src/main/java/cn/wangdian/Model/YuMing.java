package cn.wangdian.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 25065 on 2016/9/18.
 */
@Entity
@Table(name = "wd_yuming")
public class YuMing {

    @Id
    @GeneratedValue
    private Integer id;
    private String yuming;

    public YuMing() {
    }

    public YuMing(String yuming) {
        this.yuming = yuming;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYuming() {
        return yuming;
    }

    public void setYuming(String yuming) {
        this.yuming = yuming;
    }
}
