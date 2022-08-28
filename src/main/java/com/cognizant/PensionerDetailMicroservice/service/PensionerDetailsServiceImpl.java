package com.cognizant.PensionerDetailMicroservice.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.PensionerDetailMicroservice.repository.PensionerDetailsRepository;
import com.cognizant.PensionerDetailMicroservice.exception.DetailsNotFoundException;
import com.cognizant.PensionerDetailMicroservice.model.BankDetails;
import com.cognizant.PensionerDetailMicroservice.model.PensionerDetails;

@Service
public class PensionerDetailsServiceImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailsServiceImpl.class);
	private PensionerDetailsRepository pensionerDetailsRepository;

	@Autowired
	public PensionerDetailsServiceImpl(PensionerDetailsRepository pensionerDetailsRepository) {
		this.pensionerDetailsRepository = pensionerDetailsRepository;
	}

	@PostConstruct
	public void savePensionerDate() {
		LOGGER.info("Saving pensioner Details");
		List<PensionerDetails> pensionerDetailsList = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Details.csv"));
			String line="";
			while((line = br.readLine()) != null) {
				String[] data = line.split(",");
				PensionerDetails pensionerDetails=new PensionerDetails();
				pensionerDetails.setAadhaarNumber(data[0]);
				pensionerDetails.setName(data[1]);
				pensionerDetails.setDOB(data[2]);
				pensionerDetails.setPanNumber(data[3]);
				pensionerDetails.setSalary(Double.parseDouble(data[4]));
				pensionerDetails.setAllowance(Double.parseDouble(data[5]));
				pensionerDetails.setPensionType(data[6]);
				pensionerDetails.setBankDetails(new BankDetails(data[7],data[8],data[9]));
				pensionerDetailsList.add(pensionerDetails);
				
			}
			
		}
		catch(IOException e) {
			LOGGER.error("Exception while setting pensionerDetails value");
			throw new DetailsNotFoundException("Pensioner not found");
		}
		pensionerDetailsRepository.saveAll(pensionerDetailsList);

	}
}
