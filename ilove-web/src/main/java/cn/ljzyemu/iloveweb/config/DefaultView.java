package cn.ljzyemu.iloveweb.config;


import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @Author :ljz
 * @Date :2018/5/22  19:11
 **/
@Configuration
public class DefaultView extends WebMvcAutoConfiguration {


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        addViewControllers(registry);
    }


}
