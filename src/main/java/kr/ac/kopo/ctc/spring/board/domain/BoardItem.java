package kr.ac.kopo.ctc.spring.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BoardItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private int no;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private Date created;
	
	@Column
	private int view;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="boardGroup_id")
	private BoardGroup boardGroup;
	
	public BoardGroup getBoardGroup() {
		return boardGroup;
	}

	public void setBoardGroup(BoardGroup boardGroup) {
		this.boardGroup = boardGroup;
	}

	@Override
	public String toString() {
		String result = "[boardItem_"+id+"] " + author + title;
		return result;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}

}
