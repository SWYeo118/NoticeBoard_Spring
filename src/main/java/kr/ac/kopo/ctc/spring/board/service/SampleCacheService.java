package kr.ac.kopo.ctc.spring.board.service;

public interface SampleCacheService {
	String testNoCache(Long id);
	String testCache(Long id);
	void testCacheClear(Long id);
}
