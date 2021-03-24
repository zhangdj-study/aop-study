package com.qyhy;

import com.qyhy.config.AppConfig;
import com.qyhy.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangdj
 * @date 2021/03/09
 */
public class AspectTests {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Dao bean = context.getBean(Dao.class);
//        bean.query();
//        bean.query2();
        bean.queryWithParam("1111");
    }

}
