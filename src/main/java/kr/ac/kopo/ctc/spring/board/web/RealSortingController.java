package kr.ac.kopo.ctc.spring.board.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.spring.board.domain.Notice;
import kr.ac.kopo.ctc.spring.board.dto.numBack;
import kr.ac.kopo.ctc.spring.board.service.NoticeService;

// 각각 Domain은 @Entity, Controller는 @Controller, Repository는 @Repository annotation을 적어준다.

@Controller
@RequestMapping(value = "/sorting")
public class RealSortingController {
	
	@Autowired
	public sortingService SortingService; 
	
	
	@RequestMapping(value = "")
	public String e_01(Model model, HttpServletRequest req) throws ClassNotFoundException, SQLException, IOException {
		req.setCharacterEncoding("utf-8");
		return "sorting";
	}
	
	@RequestMapping(value = "selectColumn")
	public String e_02(Model model, HttpServletRequest req) throws ClassNotFoundException, SQLException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int selectColumn = Integer.parseInt(req.getParameter("selectColumn"));
		numBack backDatasBubble = SortingService.doSortBubble(selectColumn);
		numBack backDatasInsertion = SortingService.doSortInsertion(selectColumn);
		model.addAttribute("backDatasBubble", backDatasBubble);
		model.addAttribute("backDatasInsertion", backDatasInsertion);
		return "sorting";
	}
	
	
	
	
	
	@RequestMapping(value = "oneview")
	public String e_02_oneview(Model model, HttpServletRequest req) throws ClassNotFoundException, SQLException {
		String key = req.getParameter("key");
		Integer keyNum = Integer.parseInt(key);
		
		return "e_02_oneview";
	}
	
	@RequestMapping(value = "allview_pageWrite")
	public String allview_pageWrite(Model model, @RequestParam("title") String title, @RequestParam("content") String content)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		return "redirect:/e_02";
	}
	
	
	@RequestMapping(value = "pageWrite")
	public String e_02_pageWrite(Model model, HttpServletRequest req)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatDate = now.format(formatter);
		model.addAttribute("formatDate", formatDate);
		return "e_02_pageWrite";
	}

}
