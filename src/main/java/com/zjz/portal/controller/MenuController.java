package com.zjz.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("portal")
public class MenuController {
	@RequestMapping("/menus")
    public String index() {
		String content="<ul class=\"nav nav-pills\">\r\n" + 
				"  <li role='presentation' id='index'><a href='/'>首页</a></li>\r\n" + 
				"  <li role='presentation' id='news'><a href='/news.html'>新闻</a></li>\r\n" + 
				"  <li role='presentation' id='meeting'><a href='http://aa.njcb.com:8081/meeting.html'>会务系统</a></li>\r\n" + 
				"  <li role='presentation' id='meeting_new'><a href='http://aa.njcb.com:8081/meeting.html' target='_blank'>会务系统new</a></li>\r\n" + 
				"  <li role='presentation' id='train'><a href='/train.html'>培训系统</a></li>\r\n" + 
				"  <li role='presentation' id='mine'><a href='/mine.html'>会员中心</a></li>\r\n" + 
				"  <li role='presentation' id='login'><a href='/login.html'>网站登录</a></li>\r\n" + 
				"</ul>";
        return content;
    }
}
