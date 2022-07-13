package kr.ac.kopo.ctc.spring.board.repo.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@SpringBootTest
class BoardItemMapperTest {
	
	@Autowired
	BoardItemMapper boardItemMapper;
	
//	@Test
//	public void insertOne() {
//		BoardItemCondition boarditem = new BoardItemCondition();
//		boarditem.setId(14L);
//		boarditem.setAuthor("미인박명");
//		boarditem.setCreated(new Date());
//		boarditem.setNo(888);
//		boarditem.setTitle("미인박명수");
//		boarditem.setView(9);
//		
//		boardItemMapper.insertOne(boarditem);
//	}
//	
//	@Test
//	public void findOne() {
//		BoardItemCondition boardItemCondition = new BoardItemCondition(3L);
//		List<BoardItem> boarditems = boardItemMapper.findOne(boardItemCondition);
//		for (BoardItem boarditem : boarditems) {
//			System.out.println(boarditem.getId());
//			System.out.println(boarditem.getAuthor());
//			System.out.println(boarditem.getCreated());
//			System.out.println(boarditem.getNo());
//			System.out.println(boarditem.getTitle());
//			System.out.println(boarditem.getView());
//		}
//	}
//	
//	@Test
//	public void findAll() {
//		List<BoardItem> boarditems = boardItemMapper.findAll();
//		for (BoardItem boarditem : boarditems) {
//			System.out.println(boarditem.getAuthor());
//		}
//	}
//	
//	@Test
//	void findByPaging() {
//		BoardItemCondition boardItemCondition = new BoardItemCondition();
//		boardItemCondition.setAuthor("아이유");
//		
//		RowBounds rowBounds = new RowBounds(0, 10); // 1번째부터 10개씩 (1, 10)으로 설정하면 2번째부터 10개가 보여진다.
//		
//		List<BoardItem> boarditems = boardItemMapper.findByPaging(boardItemCondition, rowBounds);
//		for (BoardItem boarditem : boarditems) {
//			System.out.println(boarditem.getAuthor());
//		}
//	}
//	@Test
//	void findBySearching() {
//		BoardItemCondition boarditems = new BoardItemCondition("아이유");
//		
//		List<BoardItem> boarditem = boardItemMapper.findBySearching(boarditems);
//		for (BoardItem boarditemOne : boarditem) {
//			System.out.println(boarditemOne.getId());
//			System.out.println(boarditemOne.getAuthor());
//			System.out.println(boarditemOne.getCreated());
//			System.out.println(boarditemOne.getNo());
//			System.out.println(boarditemOne.getTitle());
//			System.out.println(boarditemOne.getView());
//		}
//	}
//	@Test
//	void findBySearchingAndPaging() {
//		BoardItemCondition boarditems = new BoardItemCondition("아이유");
//		RowBounds rowBounds = new RowBounds(0, 3);
//		List<BoardItem> boarditem = boardItemMapper.findBySearchingAndPaging(boarditems, rowBounds);
//		for (BoardItem boarditemOne : boarditem) {
//			System.out.println(boarditemOne.getId());
//			System.out.println(boarditemOne.getAuthor());
//			System.out.println(boarditemOne.getCreated());
//			System.out.println(boarditemOne.getNo());
//			System.out.println(boarditemOne.getTitle());
//			System.out.println(boarditemOne.getView());
//		}
//	}
//
//	@Test
//	public void updateOne() {
//		boardItemMapper.updateOne();
//	}
//	
//	@Test
//	public void deleteOne() {
//		boardItemMapper.deleteOne();
//	}
	

}
