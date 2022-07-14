package kr.ac.kopo.ctc.spring.board.service;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleServiceCacheTest {
	
	@Autowired
	private SampleCacheService sampleCacheService;

	private long startTime;
	private long endTime;
	
	@Before
	public void onBefore() {
		startTime = System.currentTimeMillis();
	}
	
	@After
	public void onAfter() {
		endTime = System.currentTimeMillis();
		long periodTime = endTime - startTime;
		System.out.println("소요시간 : "+ periodTime + "ms");
	}
	
	@Test
	public void testNoCache() {
		sampleCacheService.testNoCache(1L);
	}
	
	@Test
	public void testCache1() {
		sampleCacheService.testCache(1L);
	}
	
	@Test
	public void testCache2() {
		sampleCacheService.testCache(1L);
	}
	
	@Test
	public void testCache3() {
		sampleCacheService.testCache(2L);
	}
	
	@Test
	public void testCache4() {
		sampleCacheService.testCache(1L);
	}
	
	@Test
	public void testCache5() {
		sampleCacheService.testCacheClear(1L);
		sampleCacheService.testCache(1L);
	}
}
