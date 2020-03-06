package com.cuit.springboot.controller;

import com.cuit.springboot.entities.User;
import com.cuit.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @version JDK  1.8.151
 * @Author: Mirrors
 * @Description: Chengdu City
 */

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")                   //必须要对应页面中form表单的属性
    public String login(HttpSession session,String username, String password, Map<String,Object>map) {

      if(!StringUtils.isEmpty(username)
              && !StringUtils.isEmpty(password)) {

          User user = userMapper.getUserByUsername(username);
          if (user != null && user.getPassword().equals(password)) {

              //登录成功
              session.setAttribute("loginUser", user);
              return "redirect:/main.html";
          }

      }
        //登录失败
        map.put("msg", "用户名或密码错误");
        return "main/login";
    }

    //退出登录
    @GetMapping("/logout")
    public String logout(HttpSession session){
        //1.清空session中的用户信息
        session.removeAttribute("loginUser");
        //2.再将session进行注销
        session.invalidate();
        //3.返回登录页面       指定的是视图控制里的请求路径
        return "redirect:/index.html";
    }

}

