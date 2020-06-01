package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user")
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.printf("Hello,springMVC!");
        return "success";
    }

    /**
     * 注解的属性：
     *      path/value : 用于指定请求的url，两者的作用一样
     *      method：用于指定请求的方式
     *      params:用于指定限制请求参数的条件。支持简单的表达式，要求请求的参数的key和value必须和配置的一模一样
     *      headers:用于指定限制请求消息头的条件
     *
     *
     * @return
     */
    @RequestMapping(path = "/testRequestMapping",method = RequestMethod.GET,headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试requestMapping..");
        return "success";
    }
}
