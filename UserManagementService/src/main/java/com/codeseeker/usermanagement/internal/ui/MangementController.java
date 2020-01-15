package com.codeseeker.usermanagement.internal.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class MangementController 
{
	@GetMapping("/status/check")
	public String status()
	{
		return "Running mangement Service with Eureka Server";
	}
}
