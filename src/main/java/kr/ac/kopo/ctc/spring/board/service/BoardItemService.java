package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.dto.Pagenation;

@Service
public interface BoardItemService {
	Pagenation getPagenation(int countPerPage, int pageSize, int totalCount);
	BoardItem create(BoardItem boardItem);
	BoardItem selectOne(int id);
	List<BoardItem> selectAll(int page, int countPerPage);
}
