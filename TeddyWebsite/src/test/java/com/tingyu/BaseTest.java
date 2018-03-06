package com.tingyu;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})

/**
 * Created by tingyu on 2017/4/4.
 * JUnit测试基类，主要用于初始化Spring 、 Mybatis 等
 */
public abstract class BaseTest {
    public BaseTest(){}
}
