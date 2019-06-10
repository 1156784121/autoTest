package com.course.testing.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name ,int age){
        System.out.println("name="+name+" age="+age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhjanghsang",20},
                {"lisi",10},
                {"wangwu5",5}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name ,int age){
        System.out.println("test1111方法：name="+name+ " age="+age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name ,int age){
        System.out.println("test2222方法：name="+name+ " age="+age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result=null;

        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangshang",50},
                    {"lisi",60},
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu",20},
                    {"zhangliu",1000000},
            };
        }
        return result;
    }
}
