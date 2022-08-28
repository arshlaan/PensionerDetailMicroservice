package com.cognizant.PensionerDetailMicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.PensionerDetailMicroservice.model.PensionerDetails;

@Repository
public interface PensionerDetailsRepository extends JpaRepository<PensionerDetails, String> {


}
