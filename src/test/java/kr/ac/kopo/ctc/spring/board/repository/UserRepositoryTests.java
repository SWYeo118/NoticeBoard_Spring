//package kr.ac.kopo.ctc.spring.board.repository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.catalina.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//
//class UserRepositoryTests {
//	
//	@Autowired
//	UserRepository userRepository;
//
//	@Test
//	void findAll() {
//		Map<String, Object> filter = new HashMap<String, Object>();
//		filter.put("username", "a");
//		PageRequest pageable = PageRequest.of(0, 10);
//		Page<User> page = userRepository.findAll(UserSpecs.search(filter), pageable);
//		
//		for(User u : page) {
//			System.out.println(u.getName());
//		}
//	}
//
//}
