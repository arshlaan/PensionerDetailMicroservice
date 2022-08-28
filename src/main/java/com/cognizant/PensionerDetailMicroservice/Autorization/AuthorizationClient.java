package com.cognizant.PensionerDetailMicroservice.Autorization;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="authorizationService" , url="${AUTHOTIZATION_URL:localhost:8200}")
public interface AuthorizationClient {
	
	
	@GetMapping("/authorization-service/authorize")
	public boolean authorization(@RequestHeader("Authorization") String token);

}
