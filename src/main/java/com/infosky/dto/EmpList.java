package com.infosky.dto;/**
 * Created with IDEA
 * author:ChenJianJun
 * Date:2019/3/15
 * Time:10:26
 */

/**
 * @program: springmvc
 *
 * @description:
 *
 * @author: Mr.Chen
 *
 * @create: 2019-03-15 10:26
 **/

import com.infosky.entity.Emp;

import java.util.List;

public class EmpList {
    public List<Emp> addEmp;

    @Override
    public String toString() {
        return "EmpList{" +
                "addEmp=" + addEmp +
                '}';
    }

    public List<Emp> getAddEmp() {
        return addEmp;
    }

    public void setAddEmp(List<Emp> addEmp) {
        this.addEmp = addEmp;
    }
}