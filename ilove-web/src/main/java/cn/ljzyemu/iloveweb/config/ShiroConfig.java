package cn.ljzyemu.iloveweb.config;


import org.apache.shiro.mgt.SecurityManager;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import org.springframework.context.annotation.Bean;

import java.util.HashMap;

import java.util.Map;

/**
 * @Author :ljz
 * @Date :2018/5/23  16:37
 **/
public class ShiroConfig {
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        shiroFilterFactoryBean.setLoginUrl("/index/login");
        Map<String, String> map = new HashMap<>();
        map.put("/index/login","anon");
        map.put("/**","anon");
        map.put("/static/**","anon");
        map.put("/static/index/**","anon");
        map.put("/static/admin/**","anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }
}
