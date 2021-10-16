package com.freelandsite.webservices.Frm_Fabricacion;

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
import com.freelandsite.back.model.jpa.Cyca_Materialesproductosfaricacion;
import com.freelandsite.back.model.jpa.Cyca_ProductosFabricacion;
import com.freelandsite.back.model.jpa.Cyca_Usuarios;
import com.freelandsite.back.model.jpa.DataMateriales;
import com.freelandsite.back.model.jpa.DataProducts;
import com.freelandsite.back.model.jpa.DataUsers;
import com.freelandsite.back.model.repositories.MaterialesRepository;
import com.freelandsite.back.model.repositories.ProductsMaterialesRepository;
import com.freelandsite.back.model.repositories.UserRepository;
import com.freelandsite.webservices.OrderHandler;

@RestController
public class MaterialesController {
	private Logger logger = LoggerFactory.getLogger(MaterialesController.class);
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private MaterialesRepository repoUser;
	
	
	@Autowired
	private ProductsMaterialesRepository repoProductosFabricacion;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/allmateriales/{page}/{sizeperpage}", produces = MediaType.APPLICATION_JSON_VALUE)		
	@ResponseBody
	public ResponseEntity<DataMateriales> getAllMateriales(@PathVariable(name = "page") int page, @PathVariable(name = "sizeperpage") int sizeperpage,@RequestBody OrderHandler orderHandler) {
		logger.info("Get /allmateriales "+page + " / "+sizeperpage + " / "+orderHandler.getFieldSort());

		try {
			DataMateriales data = new DataMateriales();
			List<Cyca_Materialesproductosfaricacion> rows = new ArrayList<Cyca_Materialesproductosfaricacion>();
			
			Pageable paging;
			if(orderHandler.getFieldSort()!=null) {
				if(orderHandler.getSortDirection().equals("ASC")) {
					paging = PageRequest.of(page-1, sizeperpage,Sort.by(orderHandler.getFieldSort()).ascending());
				}else {
					paging = PageRequest.of(page-1, sizeperpage,Sort.by(orderHandler.getFieldSort()).descending());
				}
			}else {				
				paging = PageRequest.of(page-1, sizeperpage);
			}
			
			
			Page<Cyca_Materialesproductosfaricacion> pageTuts = repoUser.findAll(paging);
			rows = pageTuts.getContent();			
			data.setTotalrows(pageTuts.getTotalElements());
			data.setTotalpages(pageTuts.getTotalPages());
			data.setRows(rows);
			

			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/allproductsmateriales/{page}/{sizeperpage}/{idtypematerial}", produces = MediaType.APPLICATION_JSON_VALUE)		
	@ResponseBody
	public ResponseEntity<DataProducts> getAllProductosMateriales(@PathVariable(name = "page") int page, @PathVariable(name = "sizeperpage") int sizeperpage,@PathVariable(name = "idtypematerial") int idMaterial,@RequestBody OrderHandler orderHandler) {
		
		logger.info("Get /allmateriales products Page:"+page + " / SizePage:"+sizeperpage + " / SortBy:"+orderHandler.getFieldSort() +" / SortDirection:"+orderHandler.getSortDirection()+"/ Filter:"+orderHandler.getFilter()+"/ idMaterial:"+idMaterial);

		try {
			DataProducts data = new DataProducts();
			List<Cyca_ProductosFabricacion> rows = new ArrayList<Cyca_ProductosFabricacion>();
			
			Pageable paging;
			if(orderHandler.getFieldSort()!=null) {
				if(orderHandler.getSortDirection().equals("ASC")) {
					paging = PageRequest.of(page-1, sizeperpage,Sort.by(orderHandler.getFieldSort()).ascending());
				}else {
					paging = PageRequest.of(page-1, sizeperpage,Sort.by(orderHandler.getFieldSort()).descending());
				}
			}else {				
				paging = PageRequest.of(page-1, sizeperpage);
			}
			
			
			Page<Cyca_ProductosFabricacion> pageTuts = repoProductosFabricacion.findAllProductsWithMaterial(paging,idMaterial,orderHandler.getFilter());
			rows = pageTuts.getContent();			
			data.setTotalrows(pageTuts.getTotalElements());
			data.setTotalpages(pageTuts.getTotalPages());
			data.setRows(rows);
			

			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
	

}
