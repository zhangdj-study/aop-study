package com.qyhy.dao;

import com.qyhy.config.Log;
import org.springframework.stereotype.Component;

/**
 * @author zhangdj
 * @date 2021/03/09
 */
@Component
public class UserDao implements Dao {

    public void query() {
        System.out.println("query");
    }

    @Log
    public void query2() {
        System.out.println("query2");
    }

    @Log
    public void queryWithParam(String a) {
        System.out.println("query param is " + a);
    }


}
