package com.course.testing.multiThread;

import org.testng.annotations.Test;

public class MultiThreadAnnotion {

    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread ID:%s%n",Thread.currentThread().getId());
    }
}
