package com.infosky.entity;/**
 * Created with IDEA
 * author:ChenJianJun
 * Date:2019/3/14
 * Time:11:17
 */

/**
 * @program: springmvc
 *
 * @description:
 *
 * @author: Mr.Chen
 *
 * @create: 2019-03-14 11:17
 **/
public class Detail {


    private Integer detailRecId;

    private Integer baseRecId;

    private Integer fee;

    public Integer getDetailRecId() {
        return detailRecId;
    }

    public void setDetailRecId(Integer detailRecId) {
        this.detailRecId = detailRecId;
    }

    public Integer getBaseRecId() {
        return baseRecId;
    }

    public void setBaseRecId(Integer baseRecId) {
        this.baseRecId = baseRecId;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }


}
