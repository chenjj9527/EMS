package com.infosky.service.Interface;

import com.infosky.dto.DepartmentDto;
import com.infosky.dto.QueryDto;
import com.infosky.util.Page;

import java.util.List;

public interface DepartmentService
{
    //根据条件分页查询
    Page<DepartmentDto> selectPageByQueryDto(QueryDto queryDto);

    //通过departmentRecId查询部门信息
    DepartmentDto selectDepartmentById(Integer departmentRecId);

    //查询部门编号
    List<DepartmentDto> findDepartmentById(Integer  departmentId);

    //更新
    void updateDepartment(DepartmentDto departmentDto);

    //删除
    int deleteDepartmentById(Integer departmentRecId);

    //批量删除
    Integer deleteMany(List list) ;

    //新增
    void insertDepartment(DepartmentDto departmentDto);

    //查询部门名称
    List<DepartmentDto> selectDepartmentName(DepartmentDto departmentDto) ;

}