package com.lwf.ssm.controller;

import com.lwf.ssm.model.User;
import com.lwf.ssm.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lwf on 2017/3/7.
 */
@RestController
public class TestController {
    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public List<User> test (){
         return userService.getAllUser();
    }
}
