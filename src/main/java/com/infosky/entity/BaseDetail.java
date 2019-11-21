package com.infosky.entity;/**
 * Created with IDEA
 * author:ChenJianJun
 * Date:2019/3/19
 * Time:9:19
 */

import java.util.List;

/**
 * @program: springmvc
 *
 * @description:
 *
 * @author: Mr.Chen
 *
 * @create: 2019-03-19 09:19
 **/
public class BaseDetail {

    private Base base;

    private List<Detail> detail;

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }


    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }
}
