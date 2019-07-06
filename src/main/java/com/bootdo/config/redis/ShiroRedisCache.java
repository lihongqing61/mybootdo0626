package com.bootdo.config.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import java.util.Collection;
import java.util.Set;

/**
 * @Author: lihq
 * @Date: 2019/7/6 12:49
 * @Description:
 */
public class ShiroRedisCache<K, V> implements Cache<K, V> {

    private String keyPrefix = "shiro_redis_session:";

    private ShiroRedisManager cache;


    /**
     * 通过一个JedisManager实例构造RedisCache
     */
    public ShiroRedisCache(ShiroRedisManager cache){
        if (cache == null) {
            throw new IllegalArgumentException("Cache argument cannot be null.");
        }
        this.cache = cache;
    }

    public ShiroRedisCache(ShiroRedisManager shiroRedisManager, String keyPrefix) {
        this(shiroRedisManager);

        // set the prefix
        this.keyPrefix = keyPrefix;
    }

    @Override
    public V get(K key) throws CacheException {
        return null;
    }

    @Override
    public V put(K key, V value) throws CacheException {
        return null;
    }

    @Override
    public V remove(K key) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
