package com.xym.rush;

import com.xym.rush.spring.TestIoc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class RushManApplication {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
//        TestIoc test = (TestIoc) context.getBean("messageService");
//        test.getMessage();



       SpringApplication.run(RushManApplication.class, args);


    }

}
