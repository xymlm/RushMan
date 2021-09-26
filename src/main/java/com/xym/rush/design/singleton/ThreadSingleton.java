package com.xym.rush.design.singleton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description: 异步方法bean
 * @author: 哈啦曼
 * @date: 2021/9/23 23:01
 */
@Slf4j
@Component
public class ThreadSingleton {

    @Async("singletonExecutor")
    public void getHungry() throws InterruptedException {
        HungryManMode hungryManMode = HungryManMode.getInstance();
        Thread.sleep(1000);
        log.info("线程：{}  实例对象：{}",Thread.currentThread().getName(),hungryManMode);
    }

    @Async("singletonExecutor")
    public void getFull() throws InterruptedException {
        FullManMode fullManMode = FullManMode.getInstance();
        log.info(Thread.currentThread().getName() + "-" + System.identityHashCode(fullManMode));
    }


}
