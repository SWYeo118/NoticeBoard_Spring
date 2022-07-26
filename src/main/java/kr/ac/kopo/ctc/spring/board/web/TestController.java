package kr.ac.kopo.ctc.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.spring.board.repository.TestReplyRepository;
import kr.ac.kopo.ctc.spring.board.repository.TestRepository;

@Controller
public class TestController {
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	TestReplyRepository testReplyRepository;
	
	@RequestMapping(value = "/test") 
	private String view(Model model) {
			model.addAttribute("datas", testRepository.findAll());
		return "test";
	}
	
	@RequestMapping(value = "/testAllView") 
	private String viewKey(Model model, @RequestParam("key") Integer key) {
			model.addAttribute("datas", testRepository.findAll());
			model.addAttribute("datasReply", testReplyRepository.findAll());
			model.addAttribute("key", key);
		return "test";
	}
}

