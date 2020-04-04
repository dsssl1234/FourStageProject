package com.great.entity;

import java.util.List;

/*
    树形组件data数据源封装类
 */
public class Tree {

    private  String title;
    private  Integer id;
    private List<Tree>children;


    public Tree() {
    }

    public Tree(String title, Integer id, List<Tree> children) {
        this.title = title;
        this.id = id;
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }


    @Override
    public String toString() {
        return "Tree{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", children=" + children +
                '}';
    }
}
