package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.Shuju;

import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.ShujuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class hiController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/register")
    public String reg() {
        return "register";
    }
   //用户更改
    @RequestMapping("/denglu")
    public String denglu(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginuser = userMapper.login(username, password);
        System.out.println(loginuser);
        if (loginuser != null) {

            return "chaxun";
        } else {
            map.put("msg", "用户名或密码错误！");
            return "register";
        }

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




    @RequestMapping("/deleteuser")
    public String deleteuser(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User sh = userMapper.login(username, password);
        //String username = request.getParameter("username");
        //User getuser = userMapper.getuser(username);
        if (sh!= null) {
            userMapper.deleteuser(username);
            map.put("msg2", "用户已经被删除!");
            return "register";
        } else {
            map.put("msg2", "用户名不合法或密码不正确!");
            return "zhuye";
        }
    }
    @RequestMapping("/getuser")
    public  String getuser(HttpServletRequest request, Map<String,Object> map) {
        String username = request.getParameter("username");
        User user = userMapper.getuser(username);
        if (user != null) {
            map.put("msg3",username+"已被注册!");
            return "zhuye";
        } else {
            map.put("msg3", username+"还未被注册!");
            return "zhuye";

        }
    }
    @RequestMapping("/updateuser")//此类命令可与html页面相应的动作按钮关联起来，否则报错
    public String update(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");
        String opassword = request.getParameter("opassword");
        String npassword = request.getParameter("npassword");
        User naa = userMapper.login(username,opassword );
        if (naa != null) {
            userMapper.updateuser(username, npassword);

            return "register";
        } else {
            map.put("msg4", "用户名不合法或密码不正确!");
            return "zhuye";
        }
    }
    @RequestMapping("/zhuye")
    public String Stack(HttpServletRequest request, Map<String,Object> map) {
        return "zhuye";
    }
    @RequestMapping("/chaxun")
    public String chaxun(HttpServletRequest request, Map<String,Object> map) {
        return "chaxun";
    }

    //数据库知识点更改
    @Autowired//每次的mapper都需要一个@Autowired
    private ShujuMapper ShujuMapper;

    @RequestMapping("/addshuju")
    public String addshuju(HttpServletRequest request, Map<String, Object> map) {

        String biaoti = request.getParameter("biaoti");
        String date = request.getParameter("date");
        System.out.println(biaoti);
        System.out.println(date);

        Shuju shuju = new Shuju();
        shuju.setbiaoti(biaoti) ;
        shuju.setdate(date);

        Shuju shuju1 = ShujuMapper.getshuju(biaoti);
        if (shuju1!= null) {
            map.put("msg5", "该标题已经存在!");
            return "chaxun";
        } else {
            ShujuMapper.addshuju(shuju);
            map.put("msg5", "添加成功!");
            return "chaxun";
        }
    }
    @RequestMapping("/zhankai")
    public String zhankai(HttpServletRequest request, Map<String, Object> map) {
        List<String> bt = ShujuMapper.findAll();
        map.put("msg8", bt);
        return "chaxun";
    }
    @RequestMapping("/shouqi")
    public String shouqi(HttpServletRequest request, Map<String, Object> map) {

        map.put("msg8", "");
        return "chaxun";
    }
    @RequestMapping("/updateshuju")//此类命令可与html页面相应的动作按钮关联起来，否则报错
    public String updateshuju(HttpServletRequest request, Map<String, Object> map) {
        String biaoti = request.getParameter("biaoti");
        String date = request.getParameter("date");
        Shuju getshuju = ShujuMapper.getshuju(biaoti);
        if (getshuju != null) {
            ShujuMapper.updateshuju(biaoti, date);
            map.put("msg6",date);
            return "chaxun";
        } else {
            map.put("msg6", "该标题不存在!");
            return "chaxun";
        }
    }
    @RequestMapping("/getshuju")
    public  String getshuju(HttpServletRequest request, Map<String,Object> map) {
        String biaoti = request.getParameter("biaoti");
        Shuju shuju = ShujuMapper.getshuju(biaoti) ;
        String date =ShujuMapper.neirong(biaoti ) ;
        if (shuju!= null) {
            map.put("msg7",date );
            map.put("msg10",biaoti );
            return "chaxun";
        } else {
            map.put("msg11", biaoti+"不存在!");
            return "chaxun";


        }
    }
    @RequestMapping("/deleteshuju")
    public  String deleteshuju(HttpServletRequest request, Map<String,Object> map) {
        String biaoti = request.getParameter("biaoti");
        Shuju shuju = ShujuMapper.getshuju(biaoti) ;
        if (shuju!= null) {
           ShujuMapper.deleteshuju(biaoti ) ;
            map.put("msg9","标题已删除!");
            return "chaxun";
        } else {
            map.put("msg9", biaoti+"不存在!");
            return "chaxun";


        }
    }

}







