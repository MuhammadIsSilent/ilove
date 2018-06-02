package cn.ljzyemu.iloveweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author :ljz
 * @Date :2018/5/14  14:28
 **/

@RequestMapping("/index")
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);


    @RequestMapping("/index")
    public String index() {

        logger.debug("admin--> index");
        return "index";
    }

    @RequestMapping("/login")
    public String login() {

        logger.debug("admin--> index");
        return "login";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout() {


        return "logout";
    }


}
