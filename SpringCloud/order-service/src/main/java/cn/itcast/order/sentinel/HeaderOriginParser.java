package cn.itcast.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-12-29
 */
@Component
public class HeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        // 1.获取请求头
        String origin = httpServletRequest.getHeader("origin");
        // 2.非空判断
        if(StringUtils.isEmpty(origin)){
            origin = "blank";
        }
        return origin;
    }
}
