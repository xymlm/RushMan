package com.xym.rush;

import com.xym.rush.design.singleton.FullManMode;
import com.xym.rush.design.singleton.HungryManMode;
import com.xym.rush.design.singleton.ThreadSingleton;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

@SpringBootTest
@Slf4j
class DesignRushManTest {

    @Autowired
    ThreadSingleton threadSingleton;

    @Test
    void testSingleton() throws InterruptedException {
//        // 饿汉单线程
//        HungryManMode hungry1 = HungryManMode.getInstance();
//        log.info("1："+hungry1.toString());
//        HungryManMode hungry2 = HungryManMode.getInstance();
//        log.info("2："+hungry2.toString());
//        // 无效,实例对象已经静态初始化
//        hungry1.setName("新名字");
//        log.info(hungry1.toString());
//        log.info("饿汉1 == 饿汉2 ? " + (hungry1 == hungry2));
//
//
//        // 饿汉多线程测试
//        for (int i = 0 ; i < 100 ; i++){
//            threadSingleton.getHungry();
//        }
//        Thread.sleep(5000);

        // 饱汉单线程
//        FullManMode fullManMode1 = FullManMode.getInstance();
//        FullManMode fullManMode2 = FullManMode.getInstance();
//        log.info("饱汉1 == 饱汉2?：" + (fullManMode1 == fullManMode2));
//        // identityHashCode获取Object默认实现的哈希码
//        log.info("实例对象：" + System.identityHashCode(fullManMode1));


        log.info("饱汉多线程测试");
        // 饱汉多线程
        for(int i = 0 ; i < 10 ; i++){
            threadSingleton.getFull();
        }

        Thread.sleep(10000);
    }



}
