package com.infosky.service.Impl;

import com.infosky.entity.Emp;
import com.infosky.mapper.EmpMapper;
import com.infosky.service.Interface.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("EmpService")
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    //单个新增
    public void insertSingle() {
        long startTime = System.currentTimeMillis();
        Emp e = new Emp();
        for (int i = 0; i < 500; i++) {
            e.setEmpName("陈建军");
            empMapper.insertSingle(e);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("单个插入方法执行时间：" + (endTime - startTime) + "ms");
    }

    //单个更新
    public void updateSingle() {
        long startTime = System.currentTimeMillis();
        List<Emp> empList = empMapper.select();
        for (int i = 0; i <empList.size(); i++) {
            Emp tempEmp = empList.get(i);
            tempEmp.setEmpName("夏燕");
            empMapper.updateSingle(tempEmp);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("单个更新方法执行时间：" + (endTime - startTime) + "ms");
    }


    //批量新增
    public void insert() {
        long startTime = System.currentTimeMillis();
        List<Emp> list = new ArrayList<Emp>();
        Emp emp = new Emp();
        for (int i = 0; i < 500; i++) {
            emp.setEmpName("陈建军");
            list.add(emp);
        }
        int size = list.size();
        int unitNum = 100;
        int startIndex = 0;
        int endIndex = 0;
        while (size > 0) {
            if (size > unitNum) {
                endIndex = startIndex + unitNum;
            } else {
                endIndex = startIndex + size;
            }
            List<Emp> insertData = list.subList(startIndex, endIndex);
            empMapper.insert(insertData);
            size = size - unitNum;
            startIndex = endIndex;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("批量插入方法执行时间：" + (endTime - startTime) + "ms");
    }

    //批量更新
    public void update() {
        long startTime = System.currentTimeMillis();
        List<Emp> empList = empMapper.select();
        int index = 0;
        for (Emp entity : empList) {
            entity.setEmpName(entity.getEmpName() + "111");
            index++;
            if (index == 100) {
                empMapper.update(empList);
                index = 0;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("批量更新方法执行时间：" + (endTime - startTime) + "ms");
    }

}


