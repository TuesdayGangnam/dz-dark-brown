package com.dz.admin.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yong on 2018. 11. 20..
 */
@Controller
public class Login {

    @RequestMapping("/login")
    public String login(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        System.out.println("111");
        return "admin/pages/login";

    }

    @RequestMapping("/test")
    public String test(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", "222");
        System.out.println("222");
        return "test";
    }
}
