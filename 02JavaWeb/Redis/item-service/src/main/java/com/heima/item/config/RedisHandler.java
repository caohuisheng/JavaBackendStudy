package com.heima.item.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heima.item.pojo.Item;
import com.heima.item.pojo.ItemStock;
import com.heima.item.service.IItemService;
import com.heima.item.service.IItemStockService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-12-25
 */
@Component
public class RedisHandler implements InitializingBean {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private IItemService itemService;
    @Autowired
    private IItemStockService itemStockService;

    @Value("${item.isHotCache}")
    private Boolean isHotCache;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void afterPropertiesSet() throws Exception {
        if(!isHotCache){
            return;
        }
        // 初始化缓存
        // 1.缓存商品信息
        List<Item> itemList = itemService.list();
        for(Item item:itemList){
            String itemJsonStr = MAPPER.writeValueAsString(item);
            stringRedisTemplate.opsForValue().set("item:" + item.getId(), itemJsonStr);
        }
        // 1.缓存商品库存信息
        List<ItemStock> itemStockList = itemStockService.list();
        for(ItemStock itemstock:itemStockList){
            String itemStockJsonStr = MAPPER.writeValueAsString(itemstock);
            stringRedisTemplate.opsForValue().set("item:stock:" + itemstock.getId(), itemStockJsonStr);
        }
    }

    public void saveItem(Item item){
        try {
            String json = MAPPER.writeValueAsString(item);
            stringRedisTemplate.opsForValue().set("item:" + item.getId(), json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void deleteItemById(Long id){
        stringRedisTemplate.delete("item:" + id);
    }
}
