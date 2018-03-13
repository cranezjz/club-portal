package com.zjz.portal.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.zjz.sso_client2.SSOClient;

/**
 * 初始化启动类
 * 这里通过设定value的值来指定执行顺序
 */
@Component
@Order(value = 1)
public class MyApplicationRunner implements ApplicationRunner{
	@Value(value = "${cookie.domain}")
	private String domain;
    @Override
    public void run(ApplicationArguments var1) throws Exception{
    	String rediscluster="192.168.75.130:6381,192.168.75.130:6382,192.168.75.130:6383,192.168.75.130:6384,192.168.75.130:6385,192.168.75.130:6386";
		//SSOClient.init(rediscluster, "clubportal", domain);
		SSOClient.init(rediscluster, "clubportal", domain, 60, 180,true);
    }

}