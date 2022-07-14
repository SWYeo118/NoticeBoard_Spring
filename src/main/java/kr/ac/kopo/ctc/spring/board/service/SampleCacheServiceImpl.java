package kr.ac.kopo.ctc.spring.board.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SampleCacheServiceImpl implements SampleCacheService{
	
	@Override
	public String testNoCache(Long id) {
		String msg = "Hello, Spring Boot No Cache";
		System.out.println(msg);
		sleep(3);
		return msg;
	}

	@Override
	@Cacheable(value="sample", key="#id")
	public String testCache(Long id) {
		String msg = "Hello, Spring Boot Cache";
		System.out.println(msg);
		sleep(3);
		return msg;
	}

	@Override
	@CacheEvict(value="sample", key="#id")
	public void testCacheClear(Long id) {
		System.out.println("cache clear => " + id);
	}
	
	private void sleep(int second) {
		try {
			Thread.sleep(second * 1000L);
		} catch (InterruptedException e) {
			throw new IllegalStateException();
		}
	}
	
}
