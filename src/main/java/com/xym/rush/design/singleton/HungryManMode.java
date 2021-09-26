package com.xym.rush.design.singleton;

/**
 * @description: 懒汉模式
 * @author: 哈啦曼
 * @date: 2021/9/22 23:01
 */
public class HungryManMode {
    private String name;

    private static HungryManMode lazyManMode = new HungryManMode("懒汉");
    // 私有构造方法
    private HungryManMode(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "HungryManMode{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public static HungryManMode getInstance(){
        return lazyManMode;
    }
}
