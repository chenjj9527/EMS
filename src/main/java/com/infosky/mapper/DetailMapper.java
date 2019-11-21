package com.infosky.mapper;

import com.infosky.entity.BaseDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DetailMapper")
public interface DetailMapper {

      // 批量插入一对多的数据
      void insert(List<BaseDetail> baseDetail);
}