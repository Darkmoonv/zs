package com.zs.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//测试拦截器
@Controller
public class InterceptorServlet {
    @RequestMapping("/target")
    public ModelAndView test01(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","zs");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
