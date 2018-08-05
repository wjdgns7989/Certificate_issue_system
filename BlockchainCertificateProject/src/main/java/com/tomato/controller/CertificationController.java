package com.tomato.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

	// json 데이터를 get방식으로 받아와서 뷰를 만들어준다.
	@RequestMapping(value = "certification.do/diploma/{diploma_data}/enrollment/{enrollment_data}", method = RequestMethod.GET)
	public ModelAndView certification(@PathVariable String diploma_data, @PathVariable String enrollment_data,
			ModelAndView mv) {
		if (!diploma_data.equals("null")) {
			JsonParser parser = new JsonParser();
			Object tempDiploma = parser.parse(diploma_data);
			DiplomaDTO diplomaDTO = null;
			mv.addObject("diploma", diplomaDTO);
		}

		if (!enrollment_data.equals("null")) {
			EnrollmentDTO enrollmentDTO = null;
			mv.addObject("enrollment", enrollmentDTO);
		}

		mv.setViewName("checker");
		return mv;
	}

	// 체크박스에 체크가 되어 있는 항목을 json파일에서 파싱한다.(재학, 졸업 증명)
	@RequestMapping(value = "/boxcheck.do")
	public ModelAndView boxCheck(HttpServletRequest request, ModelAndView mv) {

		String userId = request.getSession().getAttribute("loginOk").toString();
		DiplomaDTO diplomaDTO = new DiplomaDTO();
		EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
		String[] value = request.getParameterValues("checkbox");

		// 체크 박스에 체크가 하나 이상 되지 않을 경우 리턴한다. (자바스크립트가 적용안될 경우 대비)
		if (value == null) {
			mv.setViewName("check");
			return mv;
		}

		for (int i = 0; i < value.length; i++) {
			switch (value[i]) {
			case "certification":
				enrollmentDTO = certificationService.getEnlloment(request, userId);
				mv.addObject("enrollment", enrollmentDTO);
				break;

			case "diploma":
				diplomaDTO = certificationService.getDiploma(request, userId);
				mv.addObject("diploma", diplomaDTO);
				break;

			default:
				break;
			}

			String time = StringUtil.getDateTime();
			// 블록체인에 timestamp를 붙여서 등록한다.
			BlockChainNetwork.addHashMap(time + userId, time + enrollmentDTO.toString() + diplomaDTO.toString());
			mv.addObject("timestamp", time);
		}
		// 결과 값을 result.jsp로 리턴한다.
		mv.setViewName("result");
		return mv;
	}
}