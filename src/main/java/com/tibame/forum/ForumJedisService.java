package com.tibame.forum;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class ForumJedisService {
	
	@Autowired
	private Jedis jedis;
	
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
	
	public Set<String> getTop5() {
		return jedis.zrevrange("viewZset", 0, 4);
	}

	public void close() {
		jedis.close();
	}
}