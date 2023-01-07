package com.tibame.forum;

import java.util.Set;

import redis.clients.jedis.Jedis;

//@Repository
public class ForumJedisDAO {

	private Jedis jedis;

//	@Autowired
//	public ForumJedisDAO(Jedis jedis) {
//		this.jedis = jedis;
//	}

	public ForumJedisDAO() {
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

	public Set<String> getTop5() {
		return jedis.zrevrange("viewZset", 0, 4);
	}

	public void close() {
		jedis.close();
	}
}