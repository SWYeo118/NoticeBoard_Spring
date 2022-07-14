package kr.ac.kopo.ctc.spring.board.service;

import org.springframework.stereotype.Service;

@Service
public class BoardItemServiceImpl implements BoardItemService{

	@Override
	public void test() {
		System.out.println("BoardItemServiceImpl.test() 메소드 호출");
	}

	@Override
	public void testAopBefore() {
		System.out.println("BoardItemServiceImpl.testAopBefore() 메소드 호출");
	}

	@Override
	public void testAopAfter() {
		System.out.println("BoardItemServiceImpl.testAopAfter() 메소드 호출");
	}

	@Override
	public String testAopAfterReturning() {
		System.out.println("BoardItemServiceImpl.testAopAfterReturning() 메소드 호출");
		return "Success";
	}

	@Override
	public void testAopAfterThrowing() {
		System.out.println("BoardItemServiceImpl.testAopAfterThrowing() 메소드 호출");
		throw new RuntimeException("runtime exception 발생");
	}

	@Override
	public void testAopAround() {
		System.out.println("BoardItemServiceImpl.testAopAround() 메소드 호출");
	}
	
}
