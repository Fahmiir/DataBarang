package com.ats.DataBarang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.DataBarang.model.DataBarangModel;

public interface DataBarangRepository extends JpaRepository<DataBarangModel, Integer>{
	
	@Modifying
	@Query("delete from DataBarangModel d where d.id in ?1")
	void deleteBarangWithIds(List<Integer> ids);
	

}
