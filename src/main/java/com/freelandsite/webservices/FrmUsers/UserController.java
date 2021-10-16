package com.freelandsite.webservices.FrmUsers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelandsite.back.model.jpa.Cyca_Usuarios;
import com.freelandsite.back.model.jpa.DataUsers;
import com.freelandsite.back.model.repositories.UserRepository;
import com.freelandsite.webservices.OrderHandler;

@RestController
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private UserRepository repoUser;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/allusers/{page}/{sizeperpage}", produces = MediaType.APPLICATION_JSON_VALUE)		
	@ResponseBody
	public ResponseEntity<DataUsers> getAllUsersHolaPost(@PathVariable(name = "page") int page, @PathVariable(name = "sizeperpage") int sizeperpage,@RequestBody OrderHandler orderHandler) {
		logger.info("Get /allUsers "+page + " / "+sizeperpage + " / "+orderHandler.getFieldSort());

		try {
			DataUsers dsataUser = new DataUsers();
			List<Cyca_Usuarios> users = new ArrayList<Cyca_Usuarios>();
			
			Pageable paging;
			if(orderHandler.getFieldSort()!=null) {
				if(orderHandler.getSortDirection().equals("ASC")) {
					paging = PageRequest.of(page, sizeperpage,Sort.by(orderHandler.getFieldSort()).descending());
				}else {
					paging = PageRequest.of(page, sizeperpage,Sort.by(orderHandler.getFieldSort()).ascending());
				}
			}else {				
				paging = PageRequest.of(page, sizeperpage);
			}
			
			
			Page<Cyca_Usuarios> pageTuts = repoUser.findAll(paging);
			users = pageTuts.getContent();			
			dsataUser.setTotalrows(pageTuts.getTotalElements());
			dsataUser.setTotalpages(pageTuts.getTotalPages());
			dsataUser.setRows(users);
			

			return new ResponseEntity<>(dsataUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/getUser", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)		
	@ResponseBody
	public ResponseEntity<Cyca_Usuarios> getUser(@RequestParam(name = "alias",required =false) String alias,@RequestParam(name = "password",required =false) String password) {

		try {
			
			byte[] digest=password.getBytes();
			password= DigestUtils.md5DigestAsHex(digest);
			System.out.println(password);
			Cyca_Usuarios user = repoUser.getUserByCodeAndPassword(alias,password);
			return new ResponseEntity<Cyca_Usuarios>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	

}
