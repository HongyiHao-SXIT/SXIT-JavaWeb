package com.itheima.tlias.bean;

import lombok.Data;

@Data
public class ClazzQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private String begin;
    private String end;
}