package com.infosky.entity;/**
 * Created with IDEA
 * author:ChenJianJun
 * Date:2019/3/14
 * Time:11:17
 */

import java.io.Serializable;

/**
 * @program: springmvc
 *
 * @description:
 *
 * @author: Mr.Chen
 *
 * @create: 2019-03-14 11:17
 **/
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer recId;

    private String empName;

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

}
