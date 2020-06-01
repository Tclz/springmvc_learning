package com.controller;

import com.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 处理响应
 */
@Controller
@RequestMapping("/user")
public class UserController {
    // 返回字符串
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行..");
        User user = new User();
        user.setHobby("pingpong");
        user.setAge(20);
        user.setDate(new Date());
        model.addAttribute("user",user);
        return "success";
    }
    // Void

    /**
     * 请求转发 一次请求 不用编写项目名称
     */
    @RequestMapping("/testVoid")
    public  void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行..");
        // 编写请求转发程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 重定向  无法跳转到WEB-INF目录
        //response.sendRedirect(request.getContextPath() + "/index.jsp");

        //直接进行响应
        response.getWriter().println("gg,my friend.");
        return;
    }

    // ModelndView对象
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView执行..");
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setHobby("pingpong");
        user.setAge(20);
        user.setDate(new Date());
        // user对象存储到mv对象中，也会把user对象存到request对象
        mv.addObject(user);
        // 跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect..");
        // 请求转发 固定语法  此时无法使用视图解析器
       // return "forward:/WEB-INF/pages/success.jsp";
        // 重定向 无法跳转到web-inf目录
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     * @return
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax..");
        // 客户端发送Ajax请求，内容是json字符串，后端将json字符串封装到user对象中
        // 做响应 模拟查询数据库
        user.setHobby("pingpong");
        user.setAge(30);
        user.setDate(new Date());
        // 使用ResponseBody进行转换 返回前端
        return user;

    }
    /**
     * 文件上传  传统方式
     */
    @RequestMapping("/fileUpLoad1")
    public String fileUpLoad1(HttpServletRequest request) throws Exception {
        System.out.println("fileupload..");
        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            // 创建文件夹
            file.mkdirs();
        }
        // 解析request对象 获取上传的文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);
        // 遍历
        for(FileItem item:items){
            // 进行判断，当前item对象是否是文件项
            if(item.isFormField()){
                // 普通表单项
                System.out.println("普通表单");
            }
            else{
                // 说明是上传文件项
                // 获取上传文件名称
                String filename = item.getName();
                // 文件名称设置为唯一值,uuid
                String uuid = UUID.randomUUID().toString().replace("-","");
                filename = uuid+"_"+filename;
                // 完成文件上传
                item.write(new File(path,filename));
                // 删除临时文件
                item.delete();
            }
        }

        return "success";

    }

    /**
     * SpringMVC 文件上传
     */
    @RequestMapping("/fileUpLoad2")
    public String fileUpLoad2(HttpServletRequest request, @RequestParam(value = "uploadFile") MultipartFile uploadFile) throws IOException {
        System.out.println("SpringMVC文件上传..");
        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path1 = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path1);
        if(!file.exists()){
            // 创建文件夹
            file.mkdirs();
        }
        // 说明是上传文件项
        // 获取上传文件名称
        String filename = uploadFile.getOriginalFilename();
        // 文件名称设置成唯一值 uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+ "_" + filename;
        // 完成上传
        uploadFile.transferTo(new File(path1,filename));
        return "success";

    }

    /**
     * 跨服务器文件上传   未成功
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(@RequestParam(value = "upload3") MultipartFile upload) throws IOException {
        System.out.println("跨服务器文件上传");
        // 定义上传文件文件服务器路径
        String path = "http://localhost:8090/fileupload_war/";
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" + filename;
        // 创建客户端对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource webResource = client.resource(path+filename);
        // 上传文件
        webResource.put(upload.getBytes());
        return  "success";

    }

    /**
     * 拦截器实践
     */
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor..");
        return "success";
    }


}

