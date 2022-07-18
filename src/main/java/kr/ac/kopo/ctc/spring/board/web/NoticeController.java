package kr.ac.kopo.ctc.spring.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value = "/e_02")
public class NoticeController {

	@RequestMapping(value = "")
	public String hello(Model model) {
		return "e_02";
	}
}
	
