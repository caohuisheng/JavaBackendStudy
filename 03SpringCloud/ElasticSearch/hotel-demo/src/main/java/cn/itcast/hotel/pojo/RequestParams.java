package cn.itcast.hotel.pojo;

import lombok.Data;

/**
 * Author: chs
 * Description: 请求参数
 * CreateTime: 2024-12-28
 */
@Data
public class RequestParams {
    private String key;
    private Integer page;
    private Integer size;
    private String sortBy;
    // 下面是新增的过滤条件参数
    private String city;
    private String brand;
    private String starName;
    private Integer minPrice;
    private Integer maxPrice;
    private String location;
}
