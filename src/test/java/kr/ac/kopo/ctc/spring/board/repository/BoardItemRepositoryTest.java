package kr.ac.kopo.ctc.spring.board.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@SpringBootTest
class BoardItemRepositoryTest {
	
	@Autowired
	BoardItemRepository boardItemRepository;
	
	@Autowired
	BoardGroupRepository boardGroupRepository;
	
	@Test
	void createById() {
		BoardGroup first = new BoardGroup();
		first.setId(1);
		first.setName("아이유");
		first.setTitle("아이유갤러리");
		boardGroupRepository.save(first);
		
		BoardItem boardItems = new BoardItem();
		boardItems.setAuthor("아이유사랑해");
		boardItems.setCreated(new Date()); // 1900년부터 시작, 6월달로 나옴
		boardItems.setNo(3);
		boardItems.setTitle("카리나예쁘지않음?");
		boardItems.setView(4);
		boardItems.setBoardGroup(first);
		boardItemRepository.save(boardItems);
	}
	@Test
	void selectOne() {
		Optional<BoardItem> boardItemOpt = boardItemRepository.findById(1);
		BoardItem boardItems = boardItemOpt.get();
		System.out.println(boardItems);
	}
//	
//	@Test
//	void updateById() {
//		Optional<BoardItem> boardItemOpt = boardItemRepository.findById(3);
//		boardItemOpt.ifPresent(boardItem->{
//			boardItem.setAuthor("아이유");
//			boardItem.setCreated(new Date(122, 5, 10)); // 1900년부터 시작, 6월달로 나옴
//			boardItem.setNo(3444);
//			boardItem.setTitle("넥스트레벨");
//			boardItem.setView(9999);
//			boardItemRepository.save(boardItem);
//		});
//	}
//	
//	@Test
//	void deleteById() {
//		boardItemRepository.deleteById(1);
//	}
//	

//	
//	@Test
//	void selectAll() {
//		List<BoardItem> boardItems = boardItemRepository.findAll();
//	}
//	
//	@Test
//	void selectAllPage() {
////		PageRequest pageRequest = PageRequest.of(page, size, option);
//		PageRequest pageRequest = PageRequest.of(2, 1);
//		Page<BoardItem> boardItems = boardItemRepository.findAll(pageRequest);
//		System.out.println(boardItems);
//	}
//	
//	@Test
//	void selectAllPageSearch() {
//		PageRequest pageRequest = PageRequest.of(2, 1);
//		boardItemRepository.findByTitleContaining("아이유", pageRequest);
//	}
//	
//	@Test
//	void selectSearch() {
//		List<BoardItem> a = boardItemRepository.findByTitleContaining("넥스트");
//		for(BoardItem ab : a) {
//			System.out.println(ab.getTitle());
//		}
//	}

}
