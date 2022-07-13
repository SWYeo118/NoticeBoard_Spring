package kr.ac.kopo.ctc.spring.board.service;

import java.util.List;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.domain.BoardItemDao;
import kr.ac.kopo.ctc.spring.board.domain.BoardItemDaoImpl;
import kr.ac.kopo.ctc.spring.board.dto.Pagenation;

public class BoardItemServiceImpl implements BoardItemService{
	
	private BoardItemDao boardItemDao = new BoardItemDaoImpl();
	
	@Override
	public Pagenation getPagenation(int countPerPage, int pageSize, int totalCount) {
		
		return null;
	}

	@Override
	public BoardItem create(BoardItem boardItem) {
		
		return boardItemDao.create(boardItem);
	}

	@Override
	public BoardItem selectOne(int id) {
		// TODO Auto-generated method stub
		return boardItemDao.selectOne(id);
	}

	@Override
	public List<BoardItem> selectAll(int page, int countPerPage) {
		// TODO Auto-generated method stub
		return boardItemDao.selectAll(page, countPerPage);
	}

}
