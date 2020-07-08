package com.wangxile.shiro.demo.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author wangqi
 * @version 1.0
 * @date 2020/5/29 0029 13:24
 * <p>
 * doGetAuthenticationInfo 方法中的token就是该token
 * 传参通过登录接口中的subject.login(token);
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
