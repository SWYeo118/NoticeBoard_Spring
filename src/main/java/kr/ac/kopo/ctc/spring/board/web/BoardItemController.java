package kr.ac.kopo.ctc.spring.board.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.domain.Hello;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

@Controller
@RequestMapping(value = "/board")
public class BoardItemController {
	
//		@Autowired
//		private BoardItemRepository boardItemRepository;
//		
//		@RequestMapping(value = "/boardItem/list")
//		@ResponseBody
//		public List<BoardItem> list(Model model) {
//			return boardItemRepository.findByTitleContaining("카리나");
//		}

		@RequestMapping(value = "")
		public String hello(Model model) {
			model.addAttribute("name", "여상우");
			return "board";
		}
		
		@RequestMapping(value = "/getParameter")
		public String getParameter(Model model, HttpServletRequest req) {
			String name = req.getParameter("name");
			model.addAttribute("name", name);
			return "board";
		}
		
		@RequestMapping(value = "/requestParam")
		public String requestParam(Model model, @RequestParam(value="name") String name) {
			model.addAttribute("name", name);
			return "board";
		}
		
		@RequestMapping(value = "/pathVariable/{name}")
		public String pathVariable(Model model, @PathVariable(value="name") String name) {
			model.addAttribute("name", name);
			return "board";
		}
		
		@RequestMapping(value = "/modelAttribute")
		public String modelAttribute(Model model, @ModelAttribute BoardItem hello) {
			model.addAttribute("name", hello.getTitle());
			return "board";
		}
		@RequestMapping(value = "/requestBody1")
		public String requestBody1(Model model, @RequestBody Map<String, Object> obj) {
			model.addAttribute("name", obj.get("name"));
			return "board";
		}
		
		@RequestMapping(value = "/requestBody2")
		public String requestBody2(Model model, @RequestBody BoardItem hello) {
			model.addAttribute("name", hello.getTitle());
			return "board";
		}
	}
	
