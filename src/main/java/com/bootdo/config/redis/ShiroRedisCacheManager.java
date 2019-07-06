package com.bootdo.config.redis;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: lihq
 * @Date: 2019/7/6 12:33
 * @Description:
 */
@Data
@Slf4j
public class ShiroRedisCacheManager implements CacheManager {

    private String keyPrefix = "shiro_redis_cache:";

    private ShiroRedisManager shiroRedisManager;

    // fast lookup by name map
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();


    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        log.info("获取名称为:"+name+"的redisCache实例");
        Cache cache = caches.get(name);
        if (cache == null) {
            log.info("cache为null..");
            shiroRedisManager = new ShiroRedisManager();
            //  cache = new RedisCache<K, V>(shiroRedisManager, keyPrefix);
            cache = new ShiroRedisCache<K, V>(shiroRedisManager, keyPrefix);
            caches.put(name, cache);
            log.info("put success..");
        }
        return cache;
    }
}
