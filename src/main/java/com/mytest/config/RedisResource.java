package com.mytest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisResource {

    private static volatile Object lock = null;

    private JedisPool pool = null;
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.pool.max-active}")
    private int maxActive;
    @Value("${spring.redis.pool.max-wait}")
    private long maxWait;
    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.pool.min-idle}")
    private long minIdle;

    private JedisPool getPool() {
        if (lock == null) {
            synchronized (RedisResource.class) {
                if (lock == null) {
                    lock = new Object();

                    JedisPoolConfig config = new JedisPoolConfig();
                    config.setMaxTotal(maxActive);
                    config.setMaxIdle(maxIdle);
                    config.setMaxWaitMillis(1000 * 100L);
                    config.setTestOnBorrow(true);
                    if (StringUtils.isEmpty(password)) {
                        pool = new JedisPool(config, host, port, timeout);
                    } else {
                        pool = new JedisPool(config, host, port, timeout, password, database);
                    }
                }
            }
        }
        return pool;
    }

    public void close(Jedis redis) {
        if (redis != null) {
            redis.close();
        }
    }

    public Jedis get() {
        JedisPool jedisPool = getPool();
        return jedisPool.getResource();
    }

}
