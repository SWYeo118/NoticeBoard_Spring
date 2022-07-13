package kr.ac.kopo.ctc.spring.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

//@Controller
//public class BoardItemController {
//	
//		@Autowired
//		private BoardItemRepository boardItemRepository;
//		
//		@RequestMapping(value = "/boardItem/list")
//		@ResponseBody
//		public List<BoardItem> list(Model model) {
//			return boardItemRepository.findAll();
//		}
//}
