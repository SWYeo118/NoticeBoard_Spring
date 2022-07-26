package kr.ac.kopo.ctc.spring.board.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String title;
	
	@Column
	private Date date;
	
	@Column
	private String content;
	
	@Column
	private Integer viewingCount;
	
	// 부모 내에 있는 자식(Reply) Column
	// 기본값은 LAZY, 그래야지 자식의 모든 값을 다 가져 올 필요는 없으니까. 
	// 기본적으로는 모든 값을 다 가져왔다고 치고 진행이 된다.
	// cascade 설정이 되어있으면 부모가 지워지면, 연결되어있는 자식이 모두 지워진다.
	// Notice라는 부모 클래스의 속성 중에 noticeReplys라는 자식이 포함되는 것! 따라서 noticeReplys는 자식 클래스이다.
	// mappedBy는 자식클래스에서만 존재한다.
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY ,mappedBy="notice")
	private List<NoticeReply> noticeReplys;
	
	public List<NoticeReply> getNoticeReplys() {
		if( noticeReplys == null ) {
			noticeReplys = new ArrayList<NoticeReply>();
		}
		return noticeReplys;
	}
	
	public void setNoticeReplys(List<NoticeReply> noticeReplys) {
		this.noticeReplys = noticeReplys;
	}
	
	public void addNoticeReplys(NoticeReply n) {
		List<NoticeReply> noticeReplys = getNoticeReplys();
		noticeReplys.add(n);
	}
	
	@Override
	public String toString() {
		String result = "["+id+"] " + date + title;
		for(NoticeReply n : getNoticeReplys()) {
			result += "\n" + n.toString();
		}
		return result;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewingCount() {
		return viewingCount;
	}
	public void setViewingCount(int viewingCount) {
		this.viewingCount = viewingCount;
	}
	public void setViewingCount(Integer viewingCount) {
		this.viewingCount = viewingCount;
	}
	
}

