package com.wangxile.shiro.demo.controller;

import org.apache.shiro.authc.AccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wangqi
 * @version 1.0
 * @date 2020/5/29 0029 10:26
 */
@RestControllerAdvice
public class ExceptionController {


    // 捕捉 CustomRealm 抛出的异常
    @ExceptionHandler(AccountException.class)
    public String handleShiroException(Exception ex) {
        return ex.getMessage();
    }
}
