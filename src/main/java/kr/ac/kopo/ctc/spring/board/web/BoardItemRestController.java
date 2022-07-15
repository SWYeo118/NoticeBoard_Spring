package kr.ac.kopo.ctc.spring.board.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Controller
@RequestMapping(value = "/rest")
public class BoardItemRestController {
//
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
//
//	@RequestMapping(value = "/boardItem1")
//	public Hello hello2() {
//		Hello hello = new Hello();
//		hello.setId(1);
//		hello.setName("abcd");
//		return hello;
//	}
//
//	@RequestMapping(value = "/boardItem1")
//	public List<Hello> hellos2() {
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
//		return hellos;
//	}
}
