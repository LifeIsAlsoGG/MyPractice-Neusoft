package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2020-05-27 17:23:39
 */
@Data
public class Course implements Serializable {
//    private static final long serialVersionUID = -75534358626693959L;



    private Integer id;
    
    private String name;

    private  String classroom;

    private String stuId;

    private String remark;



}