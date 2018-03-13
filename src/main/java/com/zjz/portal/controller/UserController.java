package com.zjz.portal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zjz.sso_client2.SSOClient;

@RestController
@RequestMapping("portal")
public class UserController {
	@RequestMapping(value = "/login")
	public Map<String,String> login(String username,String password,HttpServletRequest request,HttpServletResponse response){
/*		System.out.println("execute login");
		Cookie[] cookies = request.getCookies();  
        if (null==cookies) {  
            System.out.println("没有cookie==============");  
        } else {  
        	for(Cookie cookie : cookies){  
        		System.out.println("cookie============="+cookie.getName()+"--"+cookie.getValue());  
            } 
        }*/
		String token = SSOClient.createTokenAndWriteCookie(username, "myselfremark", response);
		Map<String,String> map = new HashMap<String,String>();
		map.put("code","0");
		map.put("msg","成功");
		map.put("token",token);
		return map;
	}
	@RequestMapping(value = "/loginout")
	public Map<String,String> loginout(HttpServletRequest request,HttpServletResponse response){
		SSOClient.logout(request, response);
		Map<String,String> map = new HashMap<String,String>();
		map.put("code","0");
		map.put("msg","成功");
		return map;
	}
	@RequestMapping(value = "/commonTrans")
	public Map<String,String> commonTrans(HttpServletRequest request,HttpServletResponse response){
		boolean result = SSOClient.verify(SSOClient.getToken(request));
		Map<String,String> map = new HashMap<String,String>();
		if(result) {
			map.put("code","0");
			map.put("msg","成功");
		}else {
			map.put("code","1");
			map.put("msg","失败");
		}
		return map;
	}
}
