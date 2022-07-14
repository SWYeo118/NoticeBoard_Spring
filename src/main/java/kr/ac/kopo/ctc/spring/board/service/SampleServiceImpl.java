package kr.ac.kopo.ctc.spring.board.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.Sample;
import kr.ac.kopo.ctc.spring.board.repository.SampleServiceRepository;

@Service
public class SampleServiceImpl implements SampleService{
	
	@Autowired
	SampleServiceRepository sampleServiceRepository;

	@Override
	public String testNoAop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String testAop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String testNoTransactional() {
		Sample sample = sampleServiceRepository.findById(1).get();
		sample.setTitle("No Transaction");
		sampleServiceRepository.save(sample);
		
		throw new RuntimeException("Spring Boot No Transactional Test");
	}

	@Override
	@Transactional
	public String testTransactional() {
		Sample sample = sampleServiceRepository.findById(1).get();
		sample.setTitle("Yes Transaction");
		sampleServiceRepository.save(sample);
		
		throw new RuntimeException("Spring Boot Transactional Test");
	}
	
}
