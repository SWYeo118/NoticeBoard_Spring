package kr.ac.kopo.ctc.spring.board.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardGroupRepository;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

@RestController
@RequestMapping(value = "/rest")
public class BoardItemRestController {
	
	@Autowired
	BoardItemRepository boardItemRepository;
	
	@Autowired
	BoardGroupRepository boardGroupRepository;

//	@RequestMapping(value = "/boardItem1" /* , method = RequestMethod.POST */)
//	public ResponseEntity<Hello> hello1() {
//		Hello hello = new Hello();
//		hello.setId(1);
//		hello.setName("abcd");
//		return ResponseEntity.ok(hello);
//	}
//
//	@RequestMapping(value = "/boardItem1")
//	public ResponseEntity<List<Hello>> hellos1() {
//		Hello hello1 = new Hello();
//		hello1.setId(1);
//		hello1.setName("abcd1");
//
//		Hello hello2 = new Hello();
//		hello2.setId(2);
//		hello2.setName("abcd2");
//
//		List<Hello> hellos = new ArrayList<Hello>();
//		hellos.add(hello1);
//		hellos.add(hello2);
//
//		return ResponseEntity.ok(hellos);
//	}
	@RequestMapping(value = "/boardItem1")
	public BoardItem hello2() {
		
		return boardItemRepository.findByBoardGroupId(1).get(0);
	}
	@RequestMapping(value = "/boardItem2")
	public List<BoardItem> hellos2() {
		
//		BoardItem hello2 = new BoardItem();
//		hello2.setId(2);
//		hello2.setTitle("abcd2");

//		List<BoardItem> hellos = new ArrayList<BoardItem>();
//		hellos.add(hello1);
//		hellos.add(hello2);

		return boardItemRepository.findByBoardGroupId(1);
	}
}
