package com.zs.control;

import com.zs.domain.User;
import com.zs.service.UserService;
import com.zs.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Component//将本类加入spring容器中
@RequestMapping("/user")//请求映射
public class UserControl {
    /*请求映射，访问资源时候，必须加上类上的即http://localhost
    :8080/user/service01 */
    @RequestMapping(value = "/service01")
    public String test01(){
        return "success";
    }
    //自动注入基本类型数据
    @RequestMapping("/service02")
    @ResponseBody//一旦配置将不会返回页面
    public void test02(String name,String age){
        System.out.println(name);
        System.out.println(age);
    }
    //自动注入对象
    @RequestMapping("/service03")
    @ResponseBody
    public void test03(User user){
        System.out.println(user);
    }
    @RequestMapping("/service04")
    @ResponseBody
    //@RequestParam("name")前后端参数名不一致需要进行绑定
    //比如前端传来的是name=xxx
    public void test04(@RequestParam(value = "name",required = false,defaultValue = "zs") String username){
        System.out.println(username);
    }
    @RequestMapping(value = "/service05/{username}")
    @ResponseBody
    public void test05(@PathVariable("username") String name){
        System.out.println(name);
    }
    @RequestMapping("/service06")
    @ResponseBody
    public void test06(HttpServletRequest request, HttpServletResponse response, HttpSession session){

    }
    @RequestMapping("/service07")
    @ResponseBody
    public void test07(@RequestHeader(value = "Host",required = false) String host){
        System.out.println(host);
        //localhost:8080
    }
    @RequestMapping("/service08")
    @ResponseBody
    public void test08(@CookieValue(value ="JSESSIONID",required = false) String jsessionId){
        System.out.println(jsessionId);
    }
    @RequestMapping("/service09")
    @ResponseBody
    public void test09(String name,MultipartFile uploadFile)throws Exception {
        String filename=uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("E:"+File.separator+"test"+File.separator+filename));
        System.out.println(name);
    }
    @RequestMapping("/service10")
    @ResponseBody
    public void test10(String name,MultipartFile[] uploadFile) throws Exception{
        for(MultipartFile file:uploadFile){
            //遍历每个上传文件得到每个文件名
           String fileName= file.getOriginalFilename();
           //将每个文件保存到哪里
           file.transferTo(new File("E:"+File.separator+"test"+fileName));
        }
    }
    @Resource(name = "userService")
    private UserService userService;
    @RequestMapping("/login")
    public String loginUser(String username,String password,HttpSession session){
        User user=userService.login(username,password);
        System.out.println(user);
        if (user!=null){
            session.setAttribute("user",user);
            return "redirect:/success";
        }
        return "redirect:/login";
    }
}
