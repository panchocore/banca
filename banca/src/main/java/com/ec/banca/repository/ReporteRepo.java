package com.ec.banca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ec.banca.model.Reporte;

@Repository
public interface ReporteRepo extends JpaRepository<Reporte, Integer>{

	@Query(value = "CALL GET_REPORTE(:id, :f1, :f2);", nativeQuery = true)
	List<Reporte> getReporte(@Param("id") Integer id, @Param("f1") String f1, @Param("f2") String f2);
}
