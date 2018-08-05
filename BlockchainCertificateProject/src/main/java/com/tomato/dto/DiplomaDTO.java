package com.tomato.dto;

import org.json.simple.JSONObject;

/**
 * @author hahava
 *
 */
public class DiplomaDTO {
	String no;
	String type;
	String name;
	String dateOfBirth;
	String college;
	String major;
	String dateOfMatriculation;
	String dateOfGraduation;
	String nameOfDegree;
	String degreeRegistrationNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getDateOfMatriculation() {
		return dateOfMatriculation;
	}

	public void setDateOfMatriculation(String dateOfMatriculation) {
		this.dateOfMatriculation = dateOfMatriculation;
	}

	public String getDateOfGraduation() {
		return dateOfGraduation;
	}

	public void setDateOfGraduation(String dateOfGraduation) {
		this.dateOfGraduation = dateOfGraduation;
	}

	public String getNameOfDegree() {
		return nameOfDegree;
	}

	public void setNameOfDegree(String nameOfDegree) {
		this.nameOfDegree = nameOfDegree;
	}

	public String getDegreeRegistrationNo() {
		return degreeRegistrationNo;
	}

	public void setDegreeRegistrationNo(String degreeRegistrationNo) {
		this.degreeRegistrationNo = degreeRegistrationNo;
	}

	@Override
	public String toString() {
		return "DiplomaDTO [no=" + no + ", type=" + type + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", college=" + college + ", major=" + major + ", dateOfMatriculation=" + dateOfMatriculation
				+ ", dateOfGraduation=" + dateOfGraduation + ", nameOfDegree=" + nameOfDegree
				+ ", degreeRegistrationNo=" + degreeRegistrationNo + "]";
	}

	public static DiplomaDTO getJsonToDto(JSONObject dataObject) {
		DiplomaDTO diplomaDTO = new DiplomaDTO();
		diplomaDTO.setNo(dataObject.get("no").toString());
		diplomaDTO.setType(dataObject.get("type").toString());
		diplomaDTO.setName(dataObject.get("name").toString());
		diplomaDTO.setDateOfBirth(dataObject.get("dateOfBirth").toString());
		diplomaDTO.setCollege(dataObject.get("college").toString());
		diplomaDTO.setMajor(dataObject.get("major").toString());
		diplomaDTO.setDateOfMatriculation(dataObject.get("dateOfMatriculation").toString());
		diplomaDTO.setDateOfGraduation(dataObject.get("dateOfGraduation").toString());
		diplomaDTO.setNameOfDegree(dataObject.get("nameOfDegree").toString());
		diplomaDTO.setDegreeRegistrationNo(dataObject.get("degreeRegistrationNo").toString());
		return diplomaDTO;
	}

}