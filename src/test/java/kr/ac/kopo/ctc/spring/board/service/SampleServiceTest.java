package kr.ac.kopo.ctc.spring.board.service;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleServiceTest {
	
	@Autowired
	private SampleService sampleService;
	
//	@Ignore
//	@Test
//	public void testNoTransactional() throws Exception{
//		sampleService.testNoTransactional();
//	}	
	@Test
	public void testTransactional() throws Exception{
		sampleService.testTransactional();
	}
}
