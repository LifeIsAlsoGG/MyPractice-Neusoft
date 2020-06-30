package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.example.demo.entity.Course;
import com.example.demo.excelUtils.ExcelForList;
import com.example.demo.service.CourseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * (Course)表控制层
 *
 * @author makejava
 * @since 2020-05-27 17:23:43
 */
@RestController
@RequestMapping("course")
public class CourseController {
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Course selectOne(Integer id) {
        return this.courseService.queryById(id);
    }

//    使用easyexcel导入excel到数据库
    @PostMapping(value="/importExcel")
    //@RequestMapping(value="/import",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8"})
    public Object upload(MultipartFile file) throws IOException {
        Common
    EasyExcel.read(file.getInputStream(),Course.class,);
    }







//    导入excel到数据库
/*    @RequestMapping(value="/import",method = RequestMethod.POST,produces = { "application/json;charset=UTF-8"})
    public  String imporCourse(@RequestParam("excelFile") MultipartFile excelFile, HttpSession httpSession) throws IOException {
        InputStream in =excelFile.getInputStream();
        String fileOriginalName=excelFile.getOriginalFilename();
        String fileName=excelFile.getName();
        String excelType=fileOriginalName.substring(fileOriginalName.indexOf(".")+1);

        //记录插入多条记录到了数据库；
        int importSuccessNum=0;
        int importAllNum=0;
        boolean importSuccess;

        System.out.println("in:::"+in);
        System.out.println("fileOriginalName:::"+fileOriginalName);
        System.out.println("fileName:::"+fileName);
        System.out.println("excelType:::"+excelType);
        List<Object> forlist= ExcelForList.ExcelForList(excelFile,Course.class,true,excelType);
        for (Object object: forlist) {
            Course course=(Course) object;
            importAllNum++;
            importSuccess=courseService.importExcel(course);
            if(importSuccess)
                importSuccessNum++;

        }
        httpSession.setAttribute("importAllNum",importAllNum);
        httpSession.setAttribute("importSuccessNum",importSuccessNum);

        if(importSuccessNum>0)
            return "success!"+"应处理"+importAllNum+"条,已成功处理"+importSuccessNum+"条！";
        else{
            return "error!";
        }
    }*/

}