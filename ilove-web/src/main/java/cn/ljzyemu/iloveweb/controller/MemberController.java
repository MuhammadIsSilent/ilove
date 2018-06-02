package cn.ljzyemu.iloveweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author :ljz
 * @Date :2018/5/22  19:24
 **/
@RequestMapping("/Member")
@Controller
public class MemberController {


    @RequestMapping("/login")
    public String index() {

        return "login";
    }
}
