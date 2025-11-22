# Spring Cloud Gateway网关聚合

项目结构
- gateway-service:网关服务
- order-service:子服务，基于openapi2规范
- order-service-openapi2:子服务，基于openapi2规范
- user-service:子服务，基于openapi2规范
- user-service-openapi2:子服务，基于openapi2规范

## 手动聚合模式(manual)

通过配置knfie4j.gateway.routes手动配置聚合各个子服务，这种情况下可以任意聚合openapi2或者openapi3规范的子服务，没有任何限制

配置文件示例如下：
```yaml
knife4j:
  gateway:
    enabled: true
    strategy: manual
    routes:
      # openapi2规范的子服务
      - name: 订单openapi2
        service-name: user-service
        url: /order-service-openapi2/v2/api-docs?group=default
        # 值得注意的是openapi2规范不能配置context-path,因为springfox会自动根据url追加basePath的路径在响应的swagger2规范中
        context-path: /
      # openapi3规范的子服务
      - name: 订单openapi3
        service-name: order-service
        url: /order/v3/api-docs/default
        context-path: /order
```

## 服务发现模式(discover)

**注意：**服务发现模式所有的子服务必须统一规范，既要么都是swagger2，要么都是openapi3，不可混用

配置文件示例如下：

```yaml
knife4j:
  gateway:
    enabled: true
    strategy: discover
    discover:
      version: swagger2
      enabled: true
```