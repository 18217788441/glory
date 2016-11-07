package com.purple.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j2;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository("redisDataSource")
@Log4j2
@SuppressWarnings("deprecation")
public class RedisDataSourceImpl implements RedisDataSource {

	@Autowired
	private ShardedJedisPool shardedJedisPool;

	public ShardedJedis getRedisClient() {
		try {
			ShardedJedis shardJedis = shardedJedisPool.getResource();
			return shardJedis;
		} catch (Exception e) {
			log.error("getRedisClent error", e);
		}
		return null;
	}

	public void returnResource(ShardedJedis shardedJedis) {
		shardedJedisPool.returnResource(shardedJedis);
	}

	public void returnResource(ShardedJedis shardedJedis, boolean broken) {
		if (broken) {
			shardedJedisPool.returnBrokenResource(shardedJedis);
		} else {
			shardedJedisPool.returnResource(shardedJedis);
		}
	}
}
