package com.infosky.controller;

import com.infosky.service.Interface.DetailService;
import com.infosky.service.Interface.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EmpController
{
    @Autowired
    private EmpService empService;

    @Autowired
    private DetailService detailService;

    @RequestMapping(value="/baseDetailAdd")
    public
    @ResponseBody
    String baseDetailAdd(){
        detailService.insert();
        return "OK";
    }

    @RequestMapping(value="/empSingleAdd")
    public
    @ResponseBody
    String empSingleAdd(){
        empService.insertSingle();
        return "OK";
    }

    @RequestMapping(value="/index")
    public
    String index(){
        return "index";
    }

    @RequestMapping(value="/empAdd")
    public
    @ResponseBody
    String addEmp(){
        empService.insert();
        return "OK";
    }

    @RequestMapping(value="/empSingleUpdate")
    public
    @ResponseBody
    String empSingleUpdate(){
        empService.updateSingle();
        return "OK";
    }

    @RequestMapping(value="/empUpdate")
    public
    @ResponseBody
    String empUpdate(){
        empService.update();
        return "OK";
    }
}

