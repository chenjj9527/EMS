package com.infosky.mapper;

import com.infosky.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EmpMapper")
public interface EmpMapper {

      List<Emp> select();

      //单个插入
      void insertSingle(Emp emp);

      //批量插入
      void insert(List<Emp> emps);

      void updateSingle(Emp emp);

      //批量更新
      void update(List<Emp> list);

}