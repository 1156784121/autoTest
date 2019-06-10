package com.tester.extend.demo;

import junit.framework.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {

    @Test
    public void test1(){
        Assert.assertEquals(2,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals("aaaaa","aaaaa");
    }

    @Test
    public void logDemo(){
        Reporter.log("这是我们自己写的日志");
        throw  new RuntimeException("这是我自己抛的异常");
    }
}
