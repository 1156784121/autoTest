package com.course.testing.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组的测试方法1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组的测试方法2");
    }

    @Test(groups = "Client")
    public void test3(){
        System.out.println("这是客服端组的测试方法3");
    }

    @Test(groups = "Client")
    public void test4(){
        System.out.println("这是客服端组的测试方法4");
    }

    @BeforeGroups("Client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客服端组运行之前运行的方法");
    }

    @AfterGroups("Client")
    public void afterGroupsOnClient(){
        System.out.println("这是客服端组运行之后运行的方法");
    }
}
