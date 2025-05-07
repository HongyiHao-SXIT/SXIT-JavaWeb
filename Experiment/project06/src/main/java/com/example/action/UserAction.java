package com.example.action;
import com.example.entity.User;
import com.example.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {
    private User user;
    @Autowired
    private UserService userService;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        userService.registerUser(user);
        request.setAttribute("message", "注册成功");
        return SUCCESS;
    }
}