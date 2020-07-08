package com.wangxile.shiro.demo.controller;

import com.wangxile.shiro.demo.UserMapper;
import com.wangxile.shiro.demo.jwt.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangqi
 * @version 1.0
 * @date 2020/5/29 0029 10:27
 */
@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public String notLogin() {
        return "您尚未登陆！";
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public String notRole() {
        return "您没有权限！";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return "成功注销！";
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆 实际调用realm中的doGetAuthenticationInfo方法进行登录
        subject.login(token);
        //根据权限，指定返回数据
        String role = userMapper.getRole(username);
        if ("user".equals(role)) {
            return "欢迎登陆";
        }
        if ("admin".equals(role)) {
            return "欢迎来到管理员页面";
        }
        return "权限错误！";
    }

    @PostMapping("/jwt/login")
    public String jwtLogin(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        String realPassword = userMapper.getPassword(username);
        if (realPassword == null) {
            return "用户名错误";
        } else if (!realPassword.equals(password)) {
            return "密码错误";
        } else {
            return JWTUtil.createToken(username, password);
        }
    }
}
