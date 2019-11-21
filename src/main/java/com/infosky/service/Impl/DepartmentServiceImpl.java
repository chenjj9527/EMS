package com.infosky.service.Impl;

import com.infosky.dto.DepartmentDto;
import com.infosky.dto.QueryDto;
import com.infosky.entity.Department;
import com.infosky.mapper.DepartmentMapper;
import com.infosky.service.Interface.DepartmentService;
import com.infosky.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService
{
    @Autowired
    private DepartmentMapper departmentMapper;
    
    public Page<DepartmentDto> selectPageByQueryDto(QueryDto queryDto)
    {
        // 封装返回的page对象,包含分页信息和查询信息
        Page<DepartmentDto> page = new Page<DepartmentDto>();
        page.setPage(queryDto.getPage());
        page.setSize(queryDto.getSize());
        if (queryDto != null)
        {
            // 判断当前页
            if (queryDto.getSize() != null)
                page.setSize(queryDto.getSize());
            if (queryDto.getPage() != null)
            {
                // 设置查询条件,从哪一条数据开始查
                queryDto.setStartRow((queryDto.getPage() - 1) * queryDto.getSize() + 1);
                page.setPage(queryDto.getPage());

                if (queryDto.getDepartmentId() != null && !"".equals(queryDto.getDepartmentId()))
                {
                    queryDto.setDepartmentId(queryDto.getDepartmentId());
                }
                if (queryDto.getDepartmentName() != null && !"".equals(queryDto.getDepartmentName().trim()))
                {
                    queryDto.setDepartmentName(queryDto.getDepartmentName().trim());
                }
            }
        }

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("page",queryDto.getPage());
        map.put("size",queryDto.getSize());
        map.put("startRow",queryDto.getStartRow());
        map.put("departmentId",queryDto.getDepartmentId());
        map.put("departmentName",queryDto.getDepartmentName());

        // 分页查询数据结果集
        List<Department> departmentList = departmentMapper.selectDepartmentListByQueryDto(map);
        List<DepartmentDto> departmentDtoList = new ArrayList<DepartmentDto>();
        for (Department department : departmentList)
        {
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setDepartmentRecId(department.getDepartmentRecId());
            departmentDto.setDepartmentId(department.getDepartmentId());
            departmentDto.setDepartmentName(department.getDepartmentName());
            departmentDto.setDepartmentManager(department.getDepartmentManager());
            departmentDto.setDepartmentDescription(department.getDepartmentDescription());
            departmentDtoList.add(departmentDto);
        }

        // 查询到的数据总条数
        page.setTotal(departmentMapper.departmentCountByQueryDto(map));
        page.setRows(departmentDtoList);
        return page;
    }

    //查询部门编号,验证部门编号唯一性
    public List<DepartmentDto> findDepartmentById(Integer departmentId)
    {
        List<DepartmentDto> DepartmentDtoList = new ArrayList<DepartmentDto>();
        List<Department> departmentList = departmentMapper.findDepartmentById(departmentId);
        for (Department department : departmentList)
        {
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setDepartmentId(department.getDepartmentId());
            DepartmentDtoList.add(departmentDto);
        }
        return DepartmentDtoList;
    }

    //查询部门信息
    public DepartmentDto selectDepartmentById(Integer DepartmentRecId)
    {
        Department department = departmentMapper.selectDepartmentById(DepartmentRecId);
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentRecId(department.getDepartmentRecId());
        departmentDto.setDepartmentId(department.getDepartmentId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentManager(department.getDepartmentManager());
        departmentDto.setDepartmentDescription(department.getDepartmentDescription());
        return departmentDto;
    }

    //更新
    public void updateDepartment(DepartmentDto departmentdto)
    {
        Department department =new Department();
        department.setDepartmentRecId(departmentdto.getDepartmentRecId());
        department.setDepartmentId(departmentdto.getDepartmentId());
        department.setDepartmentName(departmentdto.getDepartmentName());
        department.setDepartmentManager(departmentdto.getDepartmentManager());
        department.setDepartmentDescription(departmentdto.getDepartmentDescription());
        departmentMapper.updateDepartment(department);
    }

    //删除
    public int deleteDepartmentById(Integer DepartmentRecId)
    {
        return departmentMapper.deleteDepartmentById(DepartmentRecId);
    }

    //批量删除
    public Integer deleteMany(List list)
    {
        return departmentMapper.deleteMany(list);
    }

    //新增
    public void insertDepartment(DepartmentDto departmentdto)
    {
        Department department =new Department();
        department.setDepartmentRecId(departmentdto.getDepartmentRecId());
        department.setDepartmentId(departmentdto.getDepartmentId());
        department.setDepartmentName(departmentdto.getDepartmentName());
        department.setDepartmentManager(departmentdto.getDepartmentManager());
        department.setDepartmentDescription(departmentdto.getDepartmentDescription());
        departmentMapper.insertDepartment(department);
    }

    //查询部门名称
    public List<DepartmentDto> selectDepartmentName(DepartmentDto departmentdto)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("departmentId",departmentdto.getDepartmentId());
        map.put("departmentName",departmentdto.getDepartmentName());
        List<Department> departmentList = departmentMapper.selectDepartmentName(map);
        List<DepartmentDto> departmentName = new ArrayList<DepartmentDto>();
        for (Department entity : departmentList)
        {
            DepartmentDto department = new DepartmentDto();
            department.setDepartmentId(entity.getDepartmentId());
            department.setDepartmentName(entity.getDepartmentName());
            departmentName.add(department);
        }
        return departmentName;
    }
}
