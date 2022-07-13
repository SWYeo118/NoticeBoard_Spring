package kr.ac.kopo.ctc.spring.board.repo.mapper;

import java.io.Serializable;
import java.util.Date;

public class BoardItemCondition implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private int no;
	private String title;
	private String author;
	private Date created;
	private int view;
	
	public BoardItemCondition() {
		super();
	}

	public BoardItemCondition(Long id) {
		super();
		this.id = id;
	}
	
	public BoardItemCondition(String author) {
		super();
		this.author = author;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
