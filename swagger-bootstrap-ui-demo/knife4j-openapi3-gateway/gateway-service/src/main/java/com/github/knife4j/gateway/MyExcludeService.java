package com.github.knife4j.gateway;

import com.github.xiaoymin.knife4j.spring.gateway.Knife4jGatewayProperties;
import com.github.xiaoymin.knife4j.spring.gateway.discover.spi.GatewayServiceExcludeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/7/10 09:02
 * @since knife4j-openapi3-gateway
 */
@Slf4j
@Component
public class MyExcludeService implements GatewayServiceExcludeService {
    @Override
    public Set<String> exclude(Environment environment, Knife4jGatewayProperties properties, List<String> services) {
        log.info("自定义过滤器.");
        if (!CollectionUtils.isEmpty(services)){
            //return services.stream().filter(s -> s.contains("order")).collect(Collectors.toSet());
            log.info("11");
        }
        return new TreeSet<>();
    }
}
