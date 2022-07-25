package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.NoticeReply;

@Repository
public interface NoticeReplyRepository extends JpaRepository<NoticeReply, Integer>, JpaSpecificationExecutor<NoticeReply>, PagingAndSortingRepository<NoticeReply, Integer>  {
	List<NoticeReply> findByNoticeId(Integer id);
	void deleteByNoticeReplyRoot(int id);
	void deleteByNoticeReplyRootId(int id);
	
}
