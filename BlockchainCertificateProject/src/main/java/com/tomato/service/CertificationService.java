package com.tomato.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomato.dao.CertificationDAO;
import com.tomato.dto.DiplomaDTO;
import com.tomato.dto.EnrollmentDTO;

@Service
public class CertificationService {

	@Autowired
	CertificationDAO certificationDAO;

	public EnrollmentDTO getEnlloment(HttpServletRequest request, String userId) {
		// TODO Auto-generated method stub
		return certificationDAO.getEnlloment(request, userId);
	}

	public DiplomaDTO getDiploma(HttpServletRequest request, String userId) {
		// TODO Auto-generated method stub
		return certificationDAO.getDiploma(request, userId);
	}

}
