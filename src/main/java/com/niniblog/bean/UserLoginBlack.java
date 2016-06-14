package com.niniblog.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 登录黑名单
 */
@Entity
@Table(name="tbuser_loginblacklist")
public class UserLoginBlack {
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 限制用户id
     */
    private Integer userid;

    /**
     * 限制用户ip
     */
    private String ipaddress;

    /**
     * 输入错误次数
     */
    private Integer limited;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Integer getLimited() {
        return limited;
    }

    public void setLimited(Integer limited) {
        this.limited = limited;
    }
}
