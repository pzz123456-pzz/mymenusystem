package com.ac.test;

/**
 * 菜单类
 * @author: zhanzheng.pang
 * @time: 2021/11/3
 */
public class Dish {

    /**
     * 编号
     */
    int id;
    /**
     *  菜名
     */
    String name;
    /**
     * 价格
     */
    double price;

    public Dish() {
    }

    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
