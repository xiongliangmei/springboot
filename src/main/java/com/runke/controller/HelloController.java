package com.runke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello(ModelMap model){
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("users","sdfsd");
        mv.addObject("u","张哥");
        return mv;
    }
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
      return "index";
    }
}
