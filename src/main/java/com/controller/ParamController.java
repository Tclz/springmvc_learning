package com.controller;

import com.domain.Account;
import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("参数绑定..");
        System.out.println("用户名："+username);
        System.out.println("密码"+password);
        return "success";
    }

    /**
     * 请求参数绑定 把数据封装到JavaBean的类中
     * @param
     * @param
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("数据封装.. ");
        System.out.println(String.valueOf(account));
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("自定义类型转换器");
        System.out.println(String.valueOf(user));
        return "success";
    }

    // 获取Servlet原生的API
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println(httpServletRequest);
        HttpSession session = httpServletRequest.getSession();
        System.out.println(session);
        ServletContext context = session.getServletContext();
        System.out.println(context);
        return "success";
    }
}
