package com.zjz.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class IndexController {
    @RequestMapping("/")
    public String index() {
        return "forward:/index.html";
    }
/*    @RequestMapping("/dispatch")
    public String dispatch(String desturl,String token,HttpServletResponse response) {
    	System.out.println("token:"+token);
    	System.out.println("desturl:"+desturl);
        return "forward:/"+desturl;
    }*/
}