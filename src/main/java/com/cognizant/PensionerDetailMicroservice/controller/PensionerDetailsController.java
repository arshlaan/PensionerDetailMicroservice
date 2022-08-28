package com.cognizant.PensionerDetailMicroservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.PensionerDetailMicroservice.Autorization.AuthorizationClient;
import com.cognizant.PensionerDetailMicroservice.exception.DetailsNotFoundException;
import com.cognizant.PensionerDetailMicroservice.model.PensionerDetails;
import com.cognizant.PensionerDetailMicroservice.repository.PensionerDetailsRepository;
import com.cognizant.PensionerDetailMicroservice.service.PensionerDetailsServiceImpl;

@RestController
public class PensionerDetailsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailsController.class);
	private AuthorizationClient authorizationClient;
	private PensionerDetailsRepository pensionerDetailsRepository;

	@Autowired
	public PensionerDetailsController(PensionerDetailsRepository pensionerDetailsRepository,
			PensionerDetailsServiceImpl penionserDetailsServiceImpl, AuthorizationClient authorizationClient) {

		this.pensionerDetailsRepository = pensionerDetailsRepository;
		this.authorizationClient = authorizationClient;
	}

	@GetMapping("/pensionerDetails/{aadhaarNumber}")
	public PensionerDetails findByAadhaar(@RequestHeader("Authorization") String token,
			@PathVariable String aadhaarNumber) throws Exception {
		System.out.println("*********Inside getaadhar" + aadhaarNumber);
		LOGGER.info("FindingByAadhaar Controller started by aadhaar : " + aadhaarNumber);

		if (authorizationClient.authorization(token)) {
			PensionerDetails pensionerDetails = pensionerDetailsRepository.findById(aadhaarNumber)
					.orElseThrow(() -> new DetailsNotFoundException(aadhaarNumber));
			System.out.println(pensionerDetails.getBankDetails().toString());
			return pensionerDetails;
		} else {
			LOGGER.error("Aadhaar Number not found");
			throw new Exception("token invalid");
		}
	}


}
