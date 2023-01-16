package com.masai.app.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	private String cname;
	private Integer fee;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "courses")
	private List<Student> students = new ArrayList();
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(Integer cid, String cname, Integer fee, List<Student> students) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.fee = fee;
		this.students = students;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", fee=" + fee + ", students=" + students + "]";
	}
	
}
