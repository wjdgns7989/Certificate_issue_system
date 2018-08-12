package com.tomato.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonParser;
import com.tomato.dto.DiplomaDTO;
import com.tomato.dto.EnrollmentDTO;
import com.tomato.service.CertificationService;
import com.tomato.util.BlockChainNetwork;
import com.tomato.util.StringUtil;

@Controller
public class CertificationController {

	@Autowired
	CertificationService certificationService;

	// json 방식으로 보낸 요청이 서버에 있는 데이터와 맞는지 검증한다.
	@RequestMapping(value = "/resultCheck.do", method = RequestMethod.GET)
	public ModelAndView resultCheck(HttpServletRequest request, ModelAndView mv) {

		EnrollmentDTO enrollmentDTO = (EnrollmentDTO) request.getSession().getAttribute("check_enrollment");
		DiplomaDTO diplomaDTO = (DiplomaDTO) request.getSession().getAttribute("check_diploma");
		String time = (String) request.getSession().getAttribute("check_time");

		String blockValue = time;
		if (enrollmentDTO != null) {
			blockValue += enrollmentDTO.toString();
		}
		if (diplomaDTO != null) {
			blockValue += diplomaDTO.toString();
		}

		if (!BlockChainNetwork.checkMap(time, blockValue)) {
			mv.addObject("isTrue", Boolean.FALSE);
		} else {
			mv.addObject("isTrue", Boolean.TRUE);
		}
		mv.setViewName("checkerResult");
		return mv;
	}

	// json 데이터를 get방식으로 받아와서 뷰를 만들어준다.
	@RequestMapping(value = "certification.do/diploma/{diploma_data}/enrollment/{enrollment_data}/time/{time_data}", method = RequestMethod.GET)
	public ModelAndView certification(@PathVariable String diploma_data, @PathVariable String enrollment_data,
			@PathVariable String time_data, ModelAndView mv) {

		if (!diploma_data.equals("null")) {
			DiplomaDTO diplomaDTO = new DiplomaDTO();
			String temp = diploma_data.substring(1, diploma_data.length() - 1);
			String tempArr[] = temp.split(",");
			for (int i = 0; i < tempArr.length; i++) {
				String mapArr[] = tempArr[i].split(":");
				switch (mapArr[0]) {
				case "no":
					diplomaDTO.setNo(mapArr[1]);
					break;
				case "type":
					diplomaDTO.setType(mapArr[1]);
					break;
				case "name":
					diplomaDTO.setName(mapArr[1]);
					break;
				case "dateOfBirth":
					diplomaDTO.setDateOfBirth(mapArr[1]);
					break;
				case "college":
					diplomaDTO.setCollege(mapArr[1]);
					break;
				case "major":
					diplomaDTO.setMajor(mapArr[1]);
					break;
				case "dateOfMatriculation":
					diplomaDTO.setDateOfMatriculation(mapArr[1]);
					break;
				case "dateOfGraduation":
					diplomaDTO.setDateOfGraduation(mapArr[1]);
					break;
				case "nameOfDegree":
					diplomaDTO.setNameOfDegree(mapArr[1]);
					break;
				case "degreeRegistrationNo":
					diplomaDTO.setDegreeRegistrationNo(mapArr[1]);
					break;
				default:
					break;
				}
			}
			System.out.println(diplomaDTO.toString());
			mv.addObject("diploma", diplomaDTO);
		}

		if (!enrollment_data.equals("null")) {
			EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
			String temp = enrollment_data.substring(1, enrollment_data.length() - 1);
			String tempArr[] = temp.split(",");
			for (int i = 0; i < tempArr.length; i++) {
				String mapArr[] = tempArr[i].split(":");
				switch (mapArr[0]) {
				case "no":
					enrollmentDTO.setNo(mapArr[1]);
					break;
				case "type":
					enrollmentDTO.setType(mapArr[1]);
					break;
				case "name":
					enrollmentDTO.setName(mapArr[1]);
					break;
				case "dateOfBirth":
					enrollmentDTO.setDateOfBirth(mapArr[1]);
					break;
				case "college":
					enrollmentDTO.setCollege(mapArr[1]);
					break;
				case "major":
					enrollmentDTO.setMajor(mapArr[1]);
					break;
				case "grade":
					enrollmentDTO.setGrade(mapArr[1]);
					break;
				default:
					break;
				}
			}
			System.out.println(enrollmentDTO.toString());
			mv.addObject("enrollment", enrollmentDTO);
		}
		mv.addObject("time", time_data);
		mv.setViewName("checker");
		return mv;
	}

	// 체크박스에 체크가 되어 있는 항목을 json파일에서 파싱한다.(재학, 졸업 증명)
	@RequestMapping(value = "/boxcheck.do")
	public ModelAndView boxCheck(HttpServletRequest request, ModelAndView mv) {

		String userId = request.getSession().getAttribute("loginOk").toString();
		EnrollmentDTO enrollmentDTO = null;
		String[] value = request.getParameterValues("checkbox");
		DiplomaDTO diplomaDTO = null;
		// 체크 박스에 체크가 하나 이상 되지 않을 경우 리턴한다. (자바스크립트가 적용안될 경우 대비)
		if (value == null) {
			mv.setViewName("check");
			return mv;
		}

		for (int i = 0; i < value.length; i++) {
			switch (value[i]) {
			case "certification":
				enrollmentDTO = new EnrollmentDTO();
				enrollmentDTO = certificationService.getEnlloment(request, userId);
				mv.addObject("enrollment", enrollmentDTO);
				break;

			case "diploma":
				diplomaDTO = new DiplomaDTO();
				diplomaDTO = certificationService.getDiploma(request, userId);
				mv.addObject("diploma", diplomaDTO);
				break;

			default:
				break;
			}

			String time = StringUtil.getDateTime();
			// 블록체인에 timestamp를 붙여서 등록한다.
			String blockValue = time;
			if (enrollmentDTO != null) {
				blockValue += enrollmentDTO.toString();
			}
			if (diplomaDTO != null) {
				blockValue += diplomaDTO.toString();
			}
			BlockChainNetwork.addHashMap(time, blockValue);
			System.out.println("최초");
			System.out.println(time + "\t" + blockValue);
			mv.addObject("timestamp", time);
			request.getSession().setAttribute("time", time);
		}
		// 결과 값을 result.jsp로 리턴한다.
		mv.setViewName("result");
		return mv;
	}
}