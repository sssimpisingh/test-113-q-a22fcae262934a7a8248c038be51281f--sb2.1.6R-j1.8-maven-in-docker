package org.codejudge.sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="quiz")
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "quiz_id")
	private int quiz_id;
	@Column(name = "quiz_name")
	@NotNull
	private String name;
	@Column(name = "quiz_description")
	@NotNull
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	@Override
	public String toString() {
		return "Quiz [quiz_id=" + quiz_id + ", name=" + name + ", description=" + description + "]";
	}
	public Quiz(int quiz_id, String name, String description) {
		super();
		this.quiz_id = quiz_id;
		this.name = name;
		this.description = description;
	}
	public Quiz() {
		
	}
	
	

}
