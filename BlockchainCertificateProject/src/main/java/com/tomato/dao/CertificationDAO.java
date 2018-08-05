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
		EnrollmentDTO enrollmentDTO = null;
		try {
			JSONObject jsonObject = (JSONObject) getJsonObject(request, userId);
			JSONObject dataObject = (JSONObject) jsonObject.get("certificate1");
			enrollmentDTO = EnrollmentDTO.getJsonToDto(dataObject);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return enrollmentDTO;
	}

	public DiplomaDTO getDiploma(HttpServletRequest request, String userId) {
		// TODO Auto-generated method stub
		DiplomaDTO diplomaDTO = null;
		try {
			JSONObject jsonObject = (JSONObject) getJsonObject(request, userId);
			JSONObject dataObject = (JSONObject) jsonObject.get("certificate2");
			diplomaDTO = DiplomaDTO.getJsonToDto(dataObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diplomaDTO;
	}

	// 파일을 읽어서 json 형태로 반환한다.
	private Object getJsonObject(HttpServletRequest request, String userId)
			throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(request.getRealPath("/resources/json/") + userId + ".json"));
		return obj;
	}

}
