package com.freelandsite.webservices.FrmLogin;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrmLoginController {

	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/FrmLoginController/hola")
	@ResponseBody
	public String sayHola() {
		return "Hola Mundo";
	}
	
	
}
