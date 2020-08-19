package com.example.demo.controller;

import com.example.demo.model.User;

import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class hiController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/register")
    public String reg() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, Map<String, Object> map) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User user1 = userMapper.getuser(username);
        if (user1 != null) {
            map.put("msg1", "该用户已被注册！");
            return "register";
        } else {
            userMapper.adduser(user);
            map.put("msg1", "注册成功，请登录！");
            return "register";
        }
    }

    @RequestMapping("/getuser")
    public String getuser(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");

        String password = request.getParameter("password");
        User loginuser = userMapper.login(username, password);
        System.out.println(loginuser);
        map.put("msg", "用户名或密码错误！");
        if (loginuser != null) {

            return "zhuye";
        } else {

            return "register";
        }

    }


    @RequestMapping("/deleteuser")
    public String deleteuser(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");
        User getuser = userMapper.getuser(username);
        if (getuser != null) {
            userMapper.deleteuser(username);
            map.put("msg3", "the user has been deleted!");
            return "login";
        } else {
            map.put("msg3", "the user is not a legal user");
            return "login";
        }
    }

    @RequestMapping("/updateuser")
    public String update(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User getuser = userMapper.getuser(username);
        if (getuser != null) {
            userMapper.updateuser(username, password);
            map.put("msg4", "the user has been updated!");
            return "login";
        } else {
            map.put("msg4", "the user is not a legal user");
            return "login";
        }


    }
    @RequestMapping("/zhuye")
    public String zhuye(HttpServletRequest request, Map<String, Object> map) { return "zhuye";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) { return "login";
    }
    @RequestMapping("/shu")
    public String shu(HttpServletRequest request, Map<String, Object> map) {
        return "shu";
    }

    @RequestMapping("/tu")
    public String tu(HttpServletRequest request, Map<String, Object> map) {
        return "tu";
    }

    @RequestMapping("/xianxingbiao")
    public String xianxingbiao(HttpServletRequest request, Map<String, Object> map) {
        return "xianxingbiao";
    }

    @RequestMapping("/shuzu")
    public String shuzu(HttpServletRequest request, Map<String, Object> map) {
        return "shuzu";
    }

    @RequestMapping("/lianbiao")
    public String lianbiao(HttpServletRequest request, Map<String, Object> map) {
        return "lianbiao";
    }

    @RequestMapping("/duilie")
    public String duilie(HttpServletRequest request, Map<String, Object> map) {
        return "duilie";
    }

    @RequestMapping("/zhan")
    public String zhan(HttpServletRequest request, Map<String, Object> map) {
        return "zhan";
    }
    @RequestMapping("/gailun")
    public String gailun(HttpServletRequest request, Map<String, Object> map) {
        return "gailun";
    }

    @RequestMapping("/chazhaopaixu")
    public String Other(HttpServletRequest request, Map<String, Object> map) {
        return "chazhaopaixu";
    }

}