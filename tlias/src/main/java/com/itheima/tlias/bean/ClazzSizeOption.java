package com.itheima.tlias.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzSizeOption {
    private List clazzList;
    private List dataList;
}