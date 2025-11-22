package com.xiaominfo.knife4j.demo.model;

import cn.hutool.core.util.ReflectUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2024/1/2 23:05
 * @since knife4j-springdoc-openapi-demo
 */
@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public class MyOrderParam  extends ArrayList<MyOrderParam.OrderInfo> {

    /**
     * 排序信息对象。
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class OrderInfo {
        /**
         * Java对象的字段名。如果fieldName为空，则忽略跳过。目前主要包含三种格式：
         * 1. 简单的属性名称，如userId，将会直接映射到与其关联的数据库字段。表名为当前ModelClazz所对应的表名。
         * 映射结果或为 my_main_table.user_id
         * 2. 字典属性名称，如userIdDictMap.id，由于仅仅支持字典中Id数据的排序，所以直接截取DictMap之前的字符串userId作为排序属性。
         * 表名为当前ModelClazz所对应的表名。映射结果或为 my_main_table.user_id
         * 3. 一对一关联表属性，如user.userId，这里将先获取user属性的对象类型并映射到对应的表名，后面的userId为
         * user所在实体的属性。映射结果或为：my_sys_user.user_id
         */
        private String fieldName;
        /**
         * 排序方向。true为升序，否则降序。
         */
        private Boolean asc = true;
        /**
         * 如果该值不为NULL，则会对日期型排序字段进行DATE_FORMAT函数的计算，并根据具体的值，将日期数据截取到指定的位。
         * day:   表示按照天聚合，将会截取到天。DATE_FORMAT(columnName, '%Y-%m-%d')
         * month: 表示按照月聚合，将会截取到月。DATE_FORMAT(columnName, '%Y-%m-01')
         * year:  表示按照年聚合，将会截取到年。DATE_FORMAT(columnName, '%Y-01-01')
         */
        private String dateAggregateBy;
    }

    @Data
    private static class OrderBaseData {
        private String modelName;
        private String fieldName;
        private String tableName;
        private String columnName;
    }
}
