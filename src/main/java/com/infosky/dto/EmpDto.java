package com.infosky.dto;/**
 * Created with IDEA
 * author:ChenJianJun
 * Date:2019/3/14
 * Time:11:15
 */

/**
 * @program: springmvc
 *
 * @description:
 *
 * @author: Mr.Chen
 *
 * @create: 2019-03-14 11:15
 **/
//public class EmpDto {
//    public List<Emp> emp;
//
//    public List<Emp> getEmp() {
//        return emp;
//    }
//
//    public void setEmp(List<Emp> emp) {
//        this.emp = emp;
//    }
//
//    @Override
//    public String toString() {
//        return "EmpDto{" +
//                "emp=" + emp +
//                '}';
//    }
//
//}
public class EmpDto {

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