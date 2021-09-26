package com.xym.rush.design.singleton;

import lombok.Data;

/**
 * @description: 饱汉模式
 *      对class加锁，在内部进行非空判断，该操作可以保证单例情况，但是每次车程序获取实例对象的时候都要加锁操作，浪费资源
 *      双重检查：防止不同进程都通过外层的非空判断，然后首先拿到类锁的线程创建新的实例对象，释放锁，其他线程创建实例，违背单例模式，
 *          所以在内层添加一个非空判断
 * @author: 哈啦曼
 * @date: 2021/9/23 23:16
 */
public class FullManMode {
    private static FullManMode fullManMode = null;

    // 私有构造函数
    private FullManMode(){}

    public static FullManMode getInstance() throws InterruptedException {

        if(fullManMode == null){
            synchronized (FullManMode.class){
                if(fullManMode == null){
                    Thread.sleep(1000);
                    fullManMode = new FullManMode();
                }
            }
        }

        return fullManMode;
    }
}
