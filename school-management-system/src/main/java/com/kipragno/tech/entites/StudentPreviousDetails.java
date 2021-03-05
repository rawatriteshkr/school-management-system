package com.kipragno.tech.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_previous_details")
public class StudentPreviousDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "previous_detail_id")
	private Long previousDetailId;
	@Column(name = "previous_school")
	private String previousSchool;
	@Column(name = "class_name")
	private String className;
	@Column(name = "section")
	private String section;
	@Column(name = "board")
	private String board;
	@Column(name = "tc")
	private String tc;
	@Column(name = "percentage")
	private Double percentage;
	@Column(name = "academic_year")
	private Long academicYear;

	public StudentPreviousDetails() {
		super();
	}

	public StudentPreviousDetails(Long previousDetailId, String previousSchool, String className, String section,
			String board, String tc, Double percentage, Long academicYear) {
		super();
		this.previousDetailId = previousDetailId;
		this.previousSchool = previousSchool;
		this.className = className;
		this.section = section;
		this.board = board;
		this.tc = tc;
		this.percentage = percentage;
		this.academicYear = academicYear;
	}

	public Long getPreviousDetailId() {
		return previousDetailId;
	}

	public void setPreviousDetailId(Long previousDetailId) {
		this.previousDetailId = previousDetailId;
	}

	public String getPreviousSchool() {
		return previousSchool;
	}

	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Long getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(Long academicYear) {
		this.academicYear = academicYear;
	}

}
