package com.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = "msg")  // 将msg这个属性存到session域中，可以多方法共享该属性
public class AnnoController {
    /**
     * 测试RequestParam注解
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("测试常用注解");
        System.out.println(username);
        return "success";
    }
    /**
     * 获取到请求体的内容
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }
    /**
     * PathVariable注解
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid")String id){
        System.out.println(id);
        return "success";
    }
    /**
     * 获取请求头信息
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println(header);
        return "success";
    }
    /**
     * 获取Cookie值
     */
    @RequestMapping("/testCookieValue")
    public String  testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println(cookieValue);
        return "success";
    }


    /**
     * ModelAttribute注解使用, 两种写法
     */

//    @RequestMapping("/testModelAttribute")
//    public String  testModelAttribute(User user){
//        System.out.println("testModelAttribute执行..");
//        System.out.println(user);
//        return "success";
//    }
    // 该方法将优先于控制器方法执行
    // 可以用于将提交的表单中缺失的字段做一些处理
    // 法一
    /*
    @ModelAttribute
    public User showUser(String hobby){
        System.out.println("showUser执行..");
        // 这里提交的表单缺失了Date属性
        // 用hobby属性查询数据库中的用户信息来补充一个默认Date字段（模拟）
        User user = new User();
        user.setHobby(hobby);
        user.setAge(20);
        user.setDate(new Date());
        return user;

    }

     */
    // 法二，利用容器map
    /**
     //     * ModelAttribute注解
     //     */
    @RequestMapping("/testModelAttribute")
    public String  testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行..");
        System.out.println(user);
        return "success";
    }
    @ModelAttribute
    public void showUser(String hobby, Map<String,User>map){
        System.out.println("showUser执行..");
        // 这里提交的表单缺失了Date属性
        // 用hobby属性查询数据库中的用户信息来补充一个默认Date字段（模拟）
        User user = new User();
        user.setHobby(hobby);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);

    }

    /**
     * SessionAttributes的注解
     * 往request域存值
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes执行..");
        // 底层会存到request域中
        model.addAttribute("msg","niubi");
        return "success";

    }
    // 取值
    @RequestMapping("/getSessionAttributes")
    public String testSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes执行..");
        // 底层会存到request域中
        String msg = (String) modelMap.getAttribute("msg");
        System.out.println(msg);
        return "success";

    }
    // 删去属性
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes执行..");
        status.setComplete();
        return "success";

    }
}
