package kr.ac.kopo.ctc.spring.board.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@RunWith(SpringRunner.class)
@SpringBootTest
class BoardGroupRepositoryTest {
	
	@Autowired
	BoardItemRepository boardItemRepository;
	
	@Autowired
	private BoardGroupRepository boardGroupRepository;
	
//	@Test
//	public void setBasicData() {
//		BoardGroup first = new BoardGroup();
//		first.setId(1);
//		first.setName("아이유");
//		first.setTitle("아이유갤러리");
//		boardGroupRepository.save(first);
//	}
//	@Test
//	void selectOne() {
//	Optional<BoardGroup> boardGroupOpt = boardGroupRepository.findById(1);
//	BoardGroup boardGroups = boardGroupOpt.get();
//	System.out.println(boardGroups);
//}
//	@Test
//	void deleteById() {
//		boardGroupRepository.deleteById(1);
//	}
//	@Test
//	public void oneToMany_TwoWay() {
//		BoardItem boardItem = new BoardItem();
//		BoardGroup first = new BoardGroup();
//		first.addBoardItems(boardItem);
//	}
//	
//	@Test
//	void createById() {
//		BoardItem boardItems = new BoardItem();
//		boardItems.setAuthor("김문수2");
//		boardItems.setCreated(new Date(122, 5, 10)); // 1900년부터 시작, 6월달로 나옴
//		boardItems.setNo(3444);
//		boardItems.setTitle("넥스트레벨");
//		boardItems.setView(9999);
//		boardItemRepository.save(boardItems);
//	}
//	
//	@Test
//	void updateById() {
//		Optional<BoardItem> boardItemOpt = boardItemRepository.findById(3L);
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
//		boardItemRepository.deleteById(1L);
//	}
//	
//	@Test
//	void selectOne() {
//		Optional<BoardItem> boardItemOpt = boardItemRepository.findById(1L);
//		BoardItem boardItem = boardItemOpt.get();
//	}
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
