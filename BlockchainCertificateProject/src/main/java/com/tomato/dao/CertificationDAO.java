package com.tomato.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.tomato.dto.DiplomaDTO;
import com.tomato.dto.EnrollmentDTO;

@Repository
public class CertificationDAO {

	public EnrollmentDTO getEnlloment(HttpServletRequest request, String userId) {
		EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
		try {
			JSONObject jsonObject = (JSONObject) getJsonObject(request, userId);
			JSONObject dataObject1 = (JSONObject) jsonObject.get("certificate1");
			JSONObject dataObject2 = (JSONObject) jsonObject.get("certificate2");

			enrollmentDTO.setNo(dataObject1.get("no").toString());
			enrollmentDTO.setType(dataObject1.get("type").toString());
			enrollmentDTO.setName(dataObject1.get("name").toString());
			enrollmentDTO.setDateOfBirth(dataObject1.get("dateOfBirth").toString());
			enrollmentDTO.setCollege(dataObject1.get("college").toString());
			enrollmentDTO.setMajor(dataObject1.get("major").toString());
			enrollmentDTO.setGrade(dataObject1.get("grade").toString());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return enrollmentDTO;
	}

	public DiplomaDTO getDiploma(HttpServletRequest request, String userId) {
		// TODO Auto-generated method stub
		DiplomaDTO diplomaDTO = new DiplomaDTO();
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) getJsonObject(request, userId);
			JSONObject dataObject1 = (JSONObject) jsonObject.get("certificate1");
			JSONObject dataObject2 = (JSONObject) jsonObject.get("certificate2");
			diplomaDTO.setNo(dataObject2.get("no").toString());
			diplomaDTO.setType(dataObject2.get("type").toString());
			diplomaDTO.setName(dataObject2.get("name").toString());
			diplomaDTO.setDateOfBirth(dataObject2.get("dateOfBirth").toString());
			diplomaDTO.setCollege(dataObject2.get("college").toString());
			diplomaDTO.setMajor(dataObject2.get("major").toString());
			diplomaDTO.setDateOfMatriculation(dataObject2.get("dateOfMatriculation").toString());
			diplomaDTO.setDateOfGraduation(dataObject2.get("dateOfGraduation").toString());
			diplomaDTO.setNameOfDegree(dataObject2.get("nameOfDegree").toString());
			diplomaDTO.setDegreeRegistrationNo(dataObject2.get("degreeRegistrationNo").toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return diplomaDTO;
	}
	//파일을 읽어서 json 형태로 반환한다.
	private Object getJsonObject(HttpServletRequest request, String userId)
			throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(request.getRealPath("/resources/json/") + userId + ".json"));
		return obj;
	}

}
