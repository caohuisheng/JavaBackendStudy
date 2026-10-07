package cn.itcast.hotel.service;

import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.PageResult;
import cn.itcast.hotel.pojo.RequestParams;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface IHotelService extends IService<Hotel> {

    /**
     * 根据关键字搜索酒店信息
     * @param params 请求参数对象，包含用户输入的关键字
     * @return 酒店文档列表
     */
    PageResult search(RequestParams params);

    /**
     * 根据关键字进行聚合搜索，获取过滤条件
     * @param params 请求参数对象，包含用户输入的关键字
     * @return 过滤条件
     */
    Map<String, List<String>> filters(RequestParams params);

    /**
     * 根据关键字获取补全词条集合
     * @param prefix 关键字
     * @return 补全词条集合
     */
    List<String> getSuggestions(String prefix);

    void deleteById(Long id);

    void insertById(Long id);

}
