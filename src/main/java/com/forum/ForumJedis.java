package com.forum;

import redis.clients.jedis.Jedis;

public class ForumJedis {
	private Jedis jedis;

	public ForumJedis() {
		jedis = new Jedis("localhost", 6379);
	}

	public void setZset(String postNo) {
		jedis.zincrby("viewZset", 1, postNo);
	}

	public Integer getZset(String postNo) {
		if (jedis.zscore("viewZset", postNo) == null) {
			return 0;
		}
		return jedis.zscore("viewZset", postNo).intValue();
	}

	public void addZset(String postNo) {
		jedis.zadd("viewZset", 0, postNo);
	}

	public void close() {
		jedis.close();
	}
}