package kr.ac.kopo.ctc.spring.board.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class NoticeReply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String content;
	
	@Column
	private String author;
	
	@Column
	private Date date;
	
	// NoticeReply에 있는 부모 속성. 따라서 ManyToOne
	// 기본값은 EAGER, 그래야지 자식의 id값을 다 가져 올 수 있으니까.
	// optional=false면 null값이 포함될 수 없고 무조건 값이 들어가야 한다.
	@JsonBackReference
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="notice_id")
	private Notice notice;
	
	@JsonBackReference
	@ManyToOne(optional=true, fetch = FetchType.EAGER)
	@JoinColumn(name="notice_pid")
	private NoticeReply noticeReplyRoot;
	
	// cascade가 적용되는 쪽(자식)에 Cascade.All 설정.
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY ,mappedBy="noticeReplyRoot")
	private List<NoticeReply> noticeReply; 
	
	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		String result = "[notice_"+id+"] " + author + date;
		return result;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public NoticeReply getNoticeReplyRoot() {
		return noticeReplyRoot;
	}

	public void setNoticeReplyRoot(NoticeReply noticeReplyRoot) {
		this.noticeReplyRoot = noticeReplyRoot;
	}

	public List<NoticeReply> getNoticeReply() {
		return noticeReply;
	}

	public void setNoticeReply(List<NoticeReply> noticeReply) {
		this.noticeReply = noticeReply;
	}

}
