/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.domain.resp209;

import com.swagger.bootstrap.ui.demo.domain.resp208.ValidateBean;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2021/05/04 15:47
 * @since:knife4j-spring-boot-demo 1.0
 */
public class DicDimension {
    @ApiModelProperty(name = "id", value = "ID")
    private Long id;

    @ApiModelProperty(name = "code", value = "代码")
    private String code;

    @ApiModelProperty(name = "description", value = "描述")
    private String description;

    @ApiModelProperty(value = "map属性")
    private Map<String, ValidateBean> validateBeanMap;

    public Map<String, ValidateBean> getValidateBeanMap() {
        return validateBeanMap;
    }

    public void setValidateBeanMap(Map<String, ValidateBean> validateBeanMap) {
        this.validateBeanMap = validateBeanMap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
