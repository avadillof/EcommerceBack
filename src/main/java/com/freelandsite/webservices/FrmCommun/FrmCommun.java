package com.freelandsite.webservices.FrmCommun;

import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrmCommun {

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("FrmLoginController/getDate")
	@ResponseBody
	public Date getDate() {
		return new Date();
	}

}
