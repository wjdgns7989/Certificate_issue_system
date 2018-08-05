package com.tomato.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.tomato.dto.DiplomaDTO;
import com.tomato.dto.EnrollmentDTO;
import com.tomato.util.BlockChainNetwork;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Controller
public class CertificationController {

	@RequestMapping(value = "certification.do/diploma/{diploma_data}", method = RequestMethod.GET)
	public String certification(@PathVariable String diploma_data) {
		System.out.println(diploma_data + "\t");
		return null;
	}

	// 체크박스에 체크가 되어 있는 항목을 json파일에서 파싱한다.(재학, 졸업 증명)
	@RequestMapping(value = "/boxcheck.do")
	public ModelAndView boxCheck(HttpServletRequest request) {

		String userId = request.getSession().getAttribute("loginOk").toString();
		DiplomaDTO diplomaDTO = new DiplomaDTO();
		EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
		ModelAndView mv = new ModelAndView();
		JSONParser parser = new JSONParser();
		String[] value = request.getParameterValues("checkbox");

		// 체크 박스에 체크가 하나 이상 되지 않을 경우 리턴한다.
		if (value == null) {
			mv.setViewName("check");
			return mv;
		}

		try {
			// id에 해당하는 json 파일을 파싱한다.
			Object obj = parser.parse(new FileReader(request.getRealPath("/resources/json/") + userId + ".json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject dataObject1 = (JSONObject) jsonObject.get("certificate1");
			JSONObject dataObject2 = (JSONObject) jsonObject.get("certificate2");

			for (int i = 0; i < value.length; i++) {
				switch (value[i]) {
				case "certification":
					enrollmentDTO.setNo(dataObject1.get("no").toString());
					enrollmentDTO.setType(dataObject1.get("type").toString());
					enrollmentDTO.setName(dataObject1.get("name").toString());
					enrollmentDTO.setDateOfBirth(dataObject1.get("dateOfBirth").toString());
					enrollmentDTO.setCollege(dataObject1.get("college").toString());
					enrollmentDTO.setMajor(dataObject1.get("major").toString());
					enrollmentDTO.setGrade(dataObject1.get("grade").toString());
					mv.addObject("enrollment", enrollmentDTO);
					break;

				case "diploma":
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
					mv.addObject("diploma", diplomaDTO);
					break;

				default:
					break;
				}
			} // for

			/*
			 * 해쉬 값 만드는 부분 추가 해야 함 makeHash();
			 */

			BlockChainNetwork.addHashMap("userId", enrollmentDTO.toString() + diplomaDTO.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 결과 값을 result.jsp로 리턴한다.
		mv.setViewName("result");
		return mv;
	}
}