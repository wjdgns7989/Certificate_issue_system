package com.tomato.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.stream.JsonReader;
import com.tomato.dto.DiplomaDTO;
import com.tomato.dto.EnrollmentDTO;
import com.tomato.dto.UserDTO;
import com.tomato.util.LoginUser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Controller
public class CertificationController {

	@RequestMapping(value = "certification.do/diploma/{diploma_data}", method = RequestMethod.GET)
	public String certification(@PathVariable String diploma_data) {
		System.out.println(diploma_data+"\t");
		return null;
	}

	@RequestMapping(value = "/boxcheck.do")
	public ModelAndView boxCheck(HttpServletRequest request) {
		UserDTO userDTO = new UserDTO();
		DiplomaDTO diplomaDTO = new DiplomaDTO();
		EnrollmentDTO enrollmentDTO = new EnrollmentDTO();

		ModelAndView mv = new ModelAndView();
		JSONParser parser = new JSONParser();
		String[] value = request.getParameterValues("checkbox");
		System.out.println(Arrays.toString(value));

		try {

			if (request.getSession().getAttribute("loginOk").equals("junghoon")) {
				Object obj = parser.parse(new FileReader(request.getRealPath("/resources/") + "json/junghoon.json"));
				JSONObject jsonObject = (JSONObject) obj;
				JSONObject dataObject1 = (JSONObject) jsonObject.get("certificate1");
				JSONObject dataObject2 = (JSONObject) jsonObject.get("certificate2");
				
				if (value.length == 1) {
					if (value[0].equals("certification")) {
						enrollmentDTO.setNo(dataObject1.get("no").toString());
						enrollmentDTO.setType(dataObject1.get("type").toString());
						enrollmentDTO.setName(dataObject1.get("name").toString());
						enrollmentDTO.setDateOfBirth(dataObject1.get("dateOfBirth").toString());
						enrollmentDTO.setCollege(dataObject1.get("college").toString());
						enrollmentDTO.setMajor(dataObject1.get("major").toString());
						enrollmentDTO.setGrade(dataObject1.get("grade").toString());
						mv.addObject("enrollment", enrollmentDTO);
					} else if (value[0].equals("diploma")) {
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
					}
				} else {
					enrollmentDTO.setNo(dataObject1.get("no").toString());
					enrollmentDTO.setType(dataObject1.get("type").toString());
					enrollmentDTO.setName(dataObject1.get("name").toString());
					enrollmentDTO.setDateOfBirth(dataObject1.get("dateOfBirth").toString());
					enrollmentDTO.setCollege(dataObject1.get("college").toString());
					enrollmentDTO.setMajor(dataObject1.get("major").toString());
					enrollmentDTO.setGrade(dataObject1.get("grade").toString());

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
					mv.addObject("enrollment", enrollmentDTO);
					mv.addObject("diploma", diplomaDTO);
				}
			}

			else if (request.getSession().getAttribute("loginOk").equals("halin")) {
				Object obj = parser.parse(new FileReader(request.getRealPath("/resources/") + "json/halin.json"));
				JSONObject jsonObject = (JSONObject) obj;
				JSONObject dataObject1 = (JSONObject) jsonObject.get("certificate1");
				JSONObject dataObject2 = (JSONObject) jsonObject.get("certificate2");
				if (value.length == 1) {
					if (value[0].equals("certification")) {
						enrollmentDTO.setNo(dataObject1.get("no").toString());
						enrollmentDTO.setType(dataObject1.get("type").toString());
						enrollmentDTO.setName(dataObject1.get("name").toString());
						enrollmentDTO.setDateOfBirth(dataObject1.get("dateOfBirth").toString());
						enrollmentDTO.setCollege(dataObject1.get("college").toString());
						enrollmentDTO.setMajor(dataObject1.get("major").toString());
						enrollmentDTO.setGrade(dataObject1.get("grade").toString());
						mv.addObject("enrollment", enrollmentDTO);
					} else if (value[0].equals("diploma")) {
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
					}
				} else {
					enrollmentDTO.setNo(dataObject1.get("no").toString());
					enrollmentDTO.setType(dataObject1.get("type").toString());
					enrollmentDTO.setName(dataObject1.get("name").toString());
					enrollmentDTO.setDateOfBirth(dataObject1.get("dateOfBirth").toString());
					enrollmentDTO.setCollege(dataObject1.get("college").toString());
					enrollmentDTO.setMajor(dataObject1.get("major").toString());
					enrollmentDTO.setGrade(dataObject1.get("grade").toString());

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
					mv.addObject("enrollment", enrollmentDTO);
					mv.addObject("diploma", diplomaDTO);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("result");
		return mv;
	}
}