package com.example.actions;
import com.example.entities.ExampleEntity;
import com.example.services.ExampleService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
public class ExampleAction extends ActionSupport {
    @Autowired
    private ExampleService exampleService;
    private ExampleEntity exampleEntity;
    @Action(value = "exampleAction", results = {@Result(name = "success", location = "/WEB - INF/views/success.jsp")})
    public String execute() {
        exampleService.saveExample(exampleEntity);
        return SUCCESS;
    }
    // Getter和Setter方法
    public ExampleEntity getExampleEntity() {
        return exampleEntity;
    }
    public void setExampleEntity(ExampleEntity exampleEntity) {
        this.exampleEntity = exampleEntity;
    }
}