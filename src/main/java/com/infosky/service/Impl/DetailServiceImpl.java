package com.infosky.service.Impl;

import com.infosky.entity.Base;
import com.infosky.entity.BaseDetail;
import com.infosky.entity.Detail;
import com.infosky.mapper.DetailMapper;
import com.infosky.service.Interface.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("DetailService")
public class DetailServiceImpl implements DetailService {
    @Autowired
    private DetailMapper detailMapper;

    //一对多批量新增
    public void insert() {
        long startTime = System.currentTimeMillis();
        List<BaseDetail> list = initParamsList();
        detailMapper.insert(list);
        long endTime = System.currentTimeMillis();
        System.out.println("批量插入方法执行时间：" + (endTime - startTime) + "ms");
    }


    private List<BaseDetail> initParamsList() {
        List<BaseDetail> list = new ArrayList<BaseDetail>();
        BaseDetail baseDetail = new BaseDetail();

        // 主表数据1
        Base base = new Base();
        base.setFee(520);

        // 子表数据1
        List<Detail> details = new ArrayList<Detail>();
        for (int i = 0; i < 2; i++) {
            Detail detail = new Detail();
            detail.setBaseRecId(1);
            detail.setFee(520);
            details.add(detail);
        }

        baseDetail.setBase(base);
        baseDetail.setDetail(details);

        for (int m = 0; m < 1000; m++) {
            list.add(baseDetail);
        }

        return list;
    }

}