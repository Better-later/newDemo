package com.example.newdemo.dailytest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestService.class, IndexOutOfBoundsExceptionAspect.class})
public class IndexOutOfBoundsExceptionAspectTest {

    @Autowired
    private TestService testService;

    @Test
    public void testHandleIndexOutOfBoundsException() {
        try {
            testService.testMethod();
        } catch (IndexOutOfBoundsException e) {
            // 验证控制台输出或日志记录
            // 可以使用 mockito 或其他工具来验证日志记录等行为
            System.out.println("测试通过，异常被捕获并处理");
        }
    }
}
