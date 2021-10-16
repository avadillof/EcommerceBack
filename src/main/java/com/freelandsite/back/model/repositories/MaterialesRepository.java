package com.freelandsite.back.model.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.freelandsite.back.model.jpa.Cyca_Materialesproductosfaricacion;
import com.freelandsite.back.model.jpa.Cyca_Usuarios;



public interface MaterialesRepository extends JpaRepository<Cyca_Materialesproductosfaricacion, Long> {

		public Page<Cyca_Materialesproductosfaricacion> findAll(Pageable pageable);
				
		
		
	 
}
