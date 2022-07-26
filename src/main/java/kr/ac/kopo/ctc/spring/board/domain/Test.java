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
public class Test {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String title;
	
	@Column
	private Date time;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "test")
	@JsonManagedReference
	private List<TestReply> TestMembers;

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<TestReply> getTestMembers() {
		if (TestMembers == null) {
			TestMembers = new ArrayList<TestReply>();
		}
		
		return TestMembers;
	}

	public void setTestMembers(List<TestReply> testMembers) {
		TestMembers = testMembers;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", title=" + title + ", time=" + time + ", TestMembers=" + TestMembers + ", getId()="
				+ getId() + ", getTitle()=" + getTitle() + ", getTime()=" + getTime() + ", getTestMembers()="
				+ getTestMembers() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
