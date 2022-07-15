package kr.ac.kopo.ctc.spring.board.domain;

import java.util.ArrayList;
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
public class BoardGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String name;

	@Column
	private String title;
	
	// 기본값은 LAZY, 그래야지 boardItem의 모든 값을 다 가져 올 필요는 없으니까. 
	// 기본적으로는 모든 값을 다 가져왔다고 치고 진행이 된다.
	// cascade 설정이 되어있으면 boardGroup이 지워지면, 연결되어있는 boardGroup이 모두 지워진다.
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER ,mappedBy="boardGroup")
	private List<BoardItem> boardItems;
	
	public List<BoardItem> getBoardItems() {
		if( boardItems == null ) {
			boardItems = new ArrayList<BoardItem>();
		}
		return boardItems;
	}
	
	public void setBoardItems(List<BoardItem> boardItems) {
		this.boardItems = boardItems;
	}
	
	public void addBoardItems(BoardItem b) {
		List<BoardItem> boardItems = getBoardItems();
		boardItems.add(b);
	}
	
	@Override
	public String toString() {
		String result = "["+id+"] " + name + title;
		for(BoardItem b : getBoardItems()) {
			result += "\n" + b.toString();
		}
		return result;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}