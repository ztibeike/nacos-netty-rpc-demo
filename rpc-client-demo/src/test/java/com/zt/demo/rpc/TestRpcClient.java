package com.zt.demo.rpc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRpcClient {

    // To avoid error reporting of IDEA, set required to false
    @Autowired
    private HelloService helloService;

    @Test
    public void test() {
        System.out.println(helloService.hello("ZT"));
    }

}
