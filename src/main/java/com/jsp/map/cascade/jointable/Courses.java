package com.jsp.map.cascade.jointable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Courses {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int duration;
	
	@ManyToMany
	@JoinTable (name= "my_course_student",
	joinColumns = @JoinColumn (name="courses"),
	inverseJoinColumns = @JoinColumn (name="student"))
	private List<Student> student;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	

}
