package com.niniblog.bean;

import javax.persistence.*;
/**
 * Created by lenovo on 2016/5/12
 * 博客文章bean.
 */
@Entity
@Table(name="tbblogarticles")
public class BlogArticle {

    @Id
    @GeneratedValue
    /**
     * 文章id
     */
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 发表用户id
     */
    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
