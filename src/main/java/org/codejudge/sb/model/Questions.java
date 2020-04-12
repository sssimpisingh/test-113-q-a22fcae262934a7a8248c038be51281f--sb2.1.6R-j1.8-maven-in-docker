package org.codejudge.sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questions")
public class Questions {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	@NotNull
	private String name;
	@Column(name = "option")
	@NotNull
	private String option;
	@Column(name = "correct_option")
	@NotNull
	private String correct_option;
	@Column(name="quiz")
	@NotNull
	private int quiz;
	@Column(name = "points")
	@NotNull
	private int points;

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

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getCorrect_option() {
		return correct_option;
	}

	public void setCorrect_option(String correct_option) {
		this.correct_option = correct_option;
	}

	

	public int getQuiz() {
		return quiz;
	}

	public void setQuiz(int quiz) {
		this.quiz = quiz;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
