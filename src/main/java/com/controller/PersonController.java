package com.controller;

import com.domain.Person;
import com.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * web控制器
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService = null;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层，查询所有人员信息");
        // 此处调用service层的方法
        List<Person> list = personService.findAll();
        model.addAttribute("list",list);
        return "success";
    }

    @RequestMapping("/save")
    public void save(Person person, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层，保存人员信息");
        // 此处调用service层的方法
        personService.savePerson(person);
        response.sendRedirect(request.getContextPath()+"/person/findAll");
        return;
    }
}
