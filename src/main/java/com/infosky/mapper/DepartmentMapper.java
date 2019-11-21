package com.infosky.mapper;

import com.infosky.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("DepartmentMapper")
public interface DepartmentMapper {

    //分页查询数据总条数
    int departmentCountByQueryDto(Map map);

    //分页查询数据结果集
    List<Department> selectDepartmentListByQueryDto(Map map);

    //查询部门编号
    List<Department> findDepartmentById(Integer departmentId);

    //通过departmentRecId查询部门信息
    Department selectDepartmentById(Integer departmentRecId);

    //更新
    void updateDepartment(Department department);

    //删除
    int deleteDepartmentById(Integer departmentRecId);

    //批量删除
    int deleteMany(List list);

    //新增
    void insertDepartment(Department department);

    //查询部门名称
    List<Department> selectDepartmentName(Map map);
}