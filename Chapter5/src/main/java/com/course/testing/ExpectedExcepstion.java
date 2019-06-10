package com.course.testing;

import org.testng.annotations.Test;

public class ExpectedExcepstion {
    /**
     * 在我们期望结果未某个异常的时候
     */
//这是一个失败的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    private void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

//    这是一个成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
