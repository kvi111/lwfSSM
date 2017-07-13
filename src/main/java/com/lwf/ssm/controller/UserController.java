package com.lwf.ssm.controller;

import com.lwf.ssm.model.User;
import com.lwf.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lwf on 2017/3/15
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        //log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);

        //事务回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return "showUser";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model){
        return "login";
    }

    @RequestMapping("/anonymous")
    public String anonymous(HttpServletRequest request, Model model){
        //测试全局异常
        int errInt = 100 / 0;
        return "anonymous";
    }

    @ResponseBody
    @RequestMapping("/json")
    public List<User> json(HttpServletRequest request, Model model){
        return userService.getAllUser();
    }
}
