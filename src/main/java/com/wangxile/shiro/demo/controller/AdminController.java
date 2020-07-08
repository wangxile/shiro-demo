package com.wangxile.shiro.demo.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqi
 * @version 1.0
 * @date 2020/5/29 0029 10:26
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequiresRoles("admin")
    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public String getMessage() {
        return "您拥有管理员权限，可以获得该接口的信息！";
    }
}
