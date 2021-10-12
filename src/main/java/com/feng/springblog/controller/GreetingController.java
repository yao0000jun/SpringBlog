package com.feng.springblog.controller;


import com.feng.springblog.entity.SysUser;
import com.feng.springblog.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;


/**
 * @author paida 派哒 zeyu.pzy@alibaba-inc.com
 */
@Controller
public class GreetingController {

    @Resource
    private SysUserService userService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "1") String name, Model model) {

        SysUser user = userService.getById(name);

        model.addAttribute("name", user.getUserName())
                .addAttribute("email", user.getEmail())
                .addAttribute("sex", user.getSex());

        //这里返回的数据类型是String，但实际上更多的数据通过本函数中Model model传给了前端。
        // 返回值String也会被SpringMVC整合为一个ModelAndView，以供前端使用。
        // （Controller可以返回多种数值，比如void、String、ModelAndView。同学们可以自行搜索学习）
        return "greeting";
    }
}