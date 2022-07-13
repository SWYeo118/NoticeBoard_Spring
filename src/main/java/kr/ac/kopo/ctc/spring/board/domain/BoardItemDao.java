package kr.ac.kopo.ctc.spring.board.domain;

import java.util.List;

public interface BoardItemDao {
	BoardItem create(BoardItem boardItem);
	BoardItem selectOne(int id);
	List<BoardItem> selectAll(int page, int countPerPage);

}
