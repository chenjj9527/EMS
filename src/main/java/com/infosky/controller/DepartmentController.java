package com.infosky.controller;

import com.infosky.dto.DepartmentDto;
import com.infosky.dto.QueryDto;
import com.infosky.service.Interface.DepartmentService;
import com.infosky.util.Page;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/department/list")
    public String list(QueryDto queryDto, Model model)
    {
        // 分页查询数据
        Page<DepartmentDto> page = departmentService.selectPageByQueryDto(queryDto);

        // 把分页查询的结果放到模型中
        model.addAttribute("page", page);
        model.addAttribute("queryDto", queryDto);
        return "department";
    }

    @RequestMapping(value = "/department/checkDepartmentId", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String checkDepartmentId(@RequestParam Integer departmentId) throws Exception {
        boolean result = true;
        List<DepartmentDto> department = departmentService.findDepartmentById(departmentId);
        if(department!=null&&department.size()>0){
            result = false;
        }
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("valid", result);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(map);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    // 数据回显
    @RequestMapping(value = "/department/edit")
    @ResponseBody
    public DepartmentDto edit(Integer departmentRecId)
    {
        return departmentService.selectDepartmentById(departmentRecId);
    }

    // 更新保存
    @RequestMapping(value = "/department/update")
    public
    @ResponseBody
    String update(DepartmentDto departmentdto)
    {
        departmentService.updateDepartment(departmentdto);
        return "OK";
    }

    // 新增
    @RequestMapping(value = "/department/insert")
    public
    @ResponseBody
    String insert(DepartmentDto departmentDto)
    {
        departmentService.insertDepartment(departmentDto);
        return "OK";
    }

    // 删除
    @RequestMapping(value = "/department/delete")
    public
    @ResponseBody
    Integer delete(Integer departmentRecId)
    {
        int count = departmentService.deleteDepartmentById(departmentRecId);
        return count;
    }

    // 批量删除
    @RequestMapping(value="/department/deleteMany")
    public
    @ResponseBody
    String deleteMany(String ids) {
        if (ids == null ) {
            return "FAILURE";
        }
        String[] array = ids.split(",");
        List<Integer> list = new ArrayList();
        for (String s: array) {
            int departmentRecId = Integer.parseInt(s);
            list.add(departmentRecId);
        }
        Integer count = departmentService.deleteMany(list);
        if (count != null && count > 0) {
            return "SUCCESS";
        }
        return "FAILURE";
    }
}
