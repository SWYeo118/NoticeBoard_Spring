package kr.ac.kopo.ctc.spring.board.service;

public interface SampleService {
	String testNoAop();
	String testAop();
	
	String testNoTransactional();
	String testTransactional();
}
