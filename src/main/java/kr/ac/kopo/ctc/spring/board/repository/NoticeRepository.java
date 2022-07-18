package kr.ac.kopo.ctc.spring.board.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.dto.*;

@Repository
public interface NoticeRepository {
	void makingTable();
	void dropTable();
	int getTotalCount();
	Notice getOne(int id);
	List<Notice> selectAll(int page, int countPerPage) throws SQLException, ClassNotFoundException;
	List<Notice> selectAll();
	int getMax();
	int getReplyViewOrders(int originalPostId);
}
