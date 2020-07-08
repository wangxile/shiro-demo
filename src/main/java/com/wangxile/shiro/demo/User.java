package com.wangxile.shiro.demo;

import lombok.Data;

import java.io.Serializable;

/**
 * user
 *
 * @author
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String role;

    private String permission;

    private static final long serialVersionUID = 1L;
}