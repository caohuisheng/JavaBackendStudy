/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp209;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * see https://gitee.com/xiaoym/knife4j/issues/I2D6D4
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2021/03/13 18:21
 * @since:knife4j-spring-boot-demo 1.0
 */
public class UserListModelRegex {
    @ApiModelProperty(value = "名称",notes = "我是备注信息")
    private String name;

    private String createTime;
    private String createUser;
    private String createUserId;
    private String createTimer;
    @ApiModelProperty(value = "工单等级(1:一级，2：二级，3：三级)",example = "[1,2]")
    private List<String> workOrderGradeList;

    @ApiModelProperty(value = "map属性")
    private Map<String,DicDimension> dicDimensionMap;

    public Map<String, DicDimension> getDicDimensionMap() {
        return dicDimensionMap;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTimer() {
        return createTimer;
    }

    public void setCreateTimer(String createTimer) {
        this.createTimer = createTimer;
    }

    public void setDicDimensionMap(Map<String, DicDimension> dicDimensionMap) {
        this.dicDimensionMap = dicDimensionMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWorkOrderGradeList() {
        return workOrderGradeList;
    }

    public void setWorkOrderGradeList(List<String> workOrderGradeList) {
        this.workOrderGradeList = workOrderGradeList;
    }
}
