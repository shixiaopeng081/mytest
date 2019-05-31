package com.mytest.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author shixiaopeng
 * 
 */

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

	 @Autowired
	 private RedisTemplate redisTemplate;

	@PostMapping("/files")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {

		String name = new String(file.getOriginalFilename().getBytes(), "UTF-8");
		log.info("name = {}", name);
		String fileName = new String(file.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8");
		log.info("fileName = {}", fileName);
		return null;
	}
	
	@RequestMapping(value = "updateStatus")
    @ResponseBody
    public void updateStatus() {
		
		//String类型
		 redisTemplate.opsForValue().set("aaa", "111");
	        String value = redisTemplate.opsForValue().get("aaa").toString();
	        log.info("value=============="+ value);
	        
	        
	        //zset数据类型
		redisTemplate.opsForZSet().add("custom1-user1", "sfdafdas", 2);
		redisTemplate.opsForZSet().add("custom1-user1", "qqqqqqqqa", 1);
		redisTemplate.opsForZSet().add("custom1-user1", "wwwwwwwwww", 3);
		redisTemplate.opsForZSet().add("custom1-user1", "sfdafdas", 4);

		redisTemplate.opsForZSet().remove("custom1-user1", "sfdafdas");
		//根据排序的区间删除
		//redisTemplate.opsForZSet().removeRangeByScore()

		log.info("zSet=============="+ redisTemplate.opsForZSet().range("custom1-user1", 0, 0));
        log.info("zSet=============="+ redisTemplate.opsForZSet().range("custom1-user1", 0, -1));
        redisTemplate.expire("custom1-user1", 30, TimeUnit.SECONDS);

        //set
        redisTemplate.opsForSet().add("redis-set","11","aaa","8888","fdsafdas");
        log.info("redis-set = {}", redisTemplate.opsForSet().members("redis-set"));
        redisTemplate.expire("redis-set", 30, TimeUnit.SECONDS);


	        //list数据类型
	        log.info("list********************"+ redisTemplate.opsForList().range("list", 0, -1));
	        long r0 = redisTemplate.opsForList().leftPush("list", "11");
		redisTemplate.delete("list");
	        long r1 = redisTemplate.opsForList().leftPush("list", "11");
	        long r2 = redisTemplate.opsForList().leftPush("list", "22");
	        long r3 = redisTemplate.opsForList().leftPush("list", "22");
	        long r4 =  redisTemplate.opsForList().leftPush("list", "33");
	        long r5 = redisTemplate.opsForList().leftPush("list", "44");
	        long r6 = redisTemplate.opsForList().leftPush("list", "55");
	        long r7 = redisTemplate.opsForList().leftPush("list", "11");
	        long r8 = redisTemplate.opsForList().leftPush("list", "11");
	        
	        log.info("list=============="+ redisTemplate.opsForList().range("list", 0, -1));
	        
	        long remove1 =  redisTemplate.opsForList().remove("list", -2, "11");
	        long remove2 =  redisTemplate.opsForList().remove("list", 0, "22");
	        long remove3 =  redisTemplate.opsForList().remove("list", 0, "22");
	        
	        log.info("list=============="+ redisTemplate.opsForList().range("list", 0, -1));
	        
	        List<Object> msgList = redisTemplate.opsForList().range("list", 0, -1);

		redisTemplate.opsForList().size("list");
	        
	        log.info("listOperations.size=============="+ redisTemplate.opsForList().size("custom-user"));
		redisTemplate.opsForList().leftPush("custom-user", "sss");
		redisTemplate.opsForList().leftPush("custom-user", "sss");
		redisTemplate.opsForList().leftPush("custom-user", "sss");
		redisTemplate.opsForList().leftPush("custom-user", "sss");

		redisTemplate.opsForList().remove("custom-user", 0, "sss");

		redisTemplate.opsForList().range("custom-user", 0, -1);
	        
		log.info("list=============="+ redisTemplate.opsForList().range("custom-user", 0, -1));

		//hash
        redisTemplate.opsForHash().put("redis-hash","key1","1");
        redisTemplate.opsForHash().put("redis-hash","key1","2");
        redisTemplate.opsForHash().put("redis-hash","hashkey","qqqq");
        redisTemplate.opsForHash().put("redis-hash","key2","qqqq");
        redisTemplate.opsForHash().put("redis-hash","key3","3");
        redisTemplate.opsForHash().put("redis-hash","key4","4");

        log.info("hash = {}", redisTemplate.opsForHash().get("redis-hash","key1"));
        log.info("hash = {}", redisTemplate.opsForHash().keys("redis-hash"));
        log.info("hash = {}", redisTemplate.opsForHash().values("redis-hash"));
        log.info("hash = {}", redisTemplate.opsForHash().hasKey("redis-hash","key1"));

        redisTemplate.expire("redis-hash", 30, TimeUnit.SECONDS);
    }
}
