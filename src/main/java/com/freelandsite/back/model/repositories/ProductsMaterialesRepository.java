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
import com.freelandsite.back.model.jpa.Cyca_ProductosFabricacion;
import com.freelandsite.back.model.jpa.Cyca_Usuarios;



public interface ProductsMaterialesRepository extends JpaRepository<Cyca_ProductosFabricacion, Long> {

		public Page<Cyca_ProductosFabricacion> findAll(Pageable pageable);
				
		
		
		
		@Query("Select Cyca_ProductosFabricacion from Cyca_ProductosFabricacion Cyca_ProductosFabricacion where Cyca_ProductosFabricacion.material=:idMaterial and (Cyca_ProductosFabricacion.codigo LIKE %:filter% or Cyca_ProductosFabricacion.descripcion LIKE %:filter%)")	
		public Page<Cyca_ProductosFabricacion> findAllProductsWithMaterial(Pageable pageable,int idMaterial,String filter);
		
	 
}
