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

import com.freelandsite.back.model.jpa.Cyca_Usuarios;



public interface UserRepository extends JpaRepository<Cyca_Usuarios, Long> {

		public Page<Cyca_Usuarios> findAll(Pageable pageable);
		
		
				
		
		@Query("Select Cyca_Usuarios from Cyca_Usuarios Cyca_Usuarios where Cyca_Usuarios.alias=:alias and Cyca_Usuarios.password=:password")		
		public Cyca_Usuarios getUserByCodeAndPassword(@Param("alias")String alias,@Param("password")String password);
	
	 
}
