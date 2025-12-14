package com.chs.knife4j.entity;

import lombok.Data;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
public class SubResult extends Result<String> {

    private String subField;

    public String getSubField() {
        return subField;
    }

}
