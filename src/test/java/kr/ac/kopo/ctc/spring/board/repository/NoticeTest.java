package kr.ac.kopo.ctc.spring.board.repository;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.ctc.spring.board.domain.Notice;
import kr.ac.kopo.ctc.spring.board.domain.NoticeReply;

@RunWith(SpringRunner.class)
@SpringBootTest
class NoticeTest {
	
	@Autowired
	NoticeRepository noticeRepository;
	
	@Autowired
	NoticeReplyRepository noticeReplyRepository;
	
	@Test
	void createById() {
		Notice first = new Notice();
		first.setContent("초기정보입니다");
		first.setDate(new Date());
		first.setTitle("초기글");
		first.setViewingCount(0);
		noticeRepository.save(first);
		
		NoticeReply noticeReplys = new NoticeReply();
		noticeReplys.setAuthor("아이유사랑해");
		noticeReplys.setDate(new Date()); // 1900년부터 시작, 6월달로 나옴
		noticeReplys.setContent("카리나예쁘지않음?");
		noticeReplys.setNotice(first);
		noticeReplyRepository.save(noticeReplys);
	}
}

