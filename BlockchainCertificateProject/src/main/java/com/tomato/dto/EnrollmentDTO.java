package com.tomato.dto;

import org.json.simple.JSONObject;

public class EnrollmentDTO {
	String no;
	String type;
	String name;
	String dateOfBirth;
	String college;
	String major;
	String grade;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "EnrollmentDTO [no=" + no + ", type=" + type + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", college=" + college + ", major=" + major + ", grade=" + grade + "]";
	}

	public static EnrollmentDTO getJsonToDto(JSONObject dataObject) {
		EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
		enrollmentDTO.setNo(dataObject.get("no").toString());
		enrollmentDTO.setType(dataObject.get("type").toString());
		enrollmentDTO.setName(dataObject.get("name").toString());
		enrollmentDTO.setDateOfBirth(dataObject.get("dateOfBirth").toString());
		enrollmentDTO.setCollege(dataObject.get("college").toString());
		enrollmentDTO.setMajor(dataObject.get("major").toString());
		enrollmentDTO.setGrade(dataObject.get("grade").toString());
		return enrollmentDTO;

	}

}