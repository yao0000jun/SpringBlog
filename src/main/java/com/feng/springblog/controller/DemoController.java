package com.feng.springblog.controller;

import com.feng.springblog.entity.SysUser;
import com.feng.springblog.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jam
 * @date 2021/7/8 10:00 上午
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public void async() {
        asyncService.executeAsync();
    }

    @GetMapping("/hello")
    public String getStr() {
        return "hello,javadaily";
    }

    @GetMapping("/aniaml")
    public SysUser getAniaml() {
        SysUser user = new SysUser();
        user.setUserName("Hello");
        user.setEmail("yao00jun@163.com");
        log.info("user is {}", user);
        return user;
    }

    @GetMapping("/wrong")
    public int error() {
        int i;
        try {
            i = 9 / 0;
        } catch (Exception e) {
            log.error("error:{}", e);
            i = 0;
        }
        return i;
    }

    @GetMapping("error1")
    public void empty() {
        throw new RuntimeException("自定义异常");
    }

}
