package com.example.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;

@Data
public class LoginAction extends ActionSupport {
    private String userName;
    private String blogUrl;

    public String execute() {
        if ("admin".equals(userName) && "http://blog.example.com".equals(blogUrl)) {
            return SUCCESS;
        } else {
            addActionError("用户名或博客地址不正确！");
            return INPUT;
        }
    }
}
