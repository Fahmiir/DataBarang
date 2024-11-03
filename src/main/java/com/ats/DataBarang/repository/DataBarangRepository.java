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
	
	@Modifying
	@Query("delete from DataBarangModel d where d.id in ?1")
	void deleteBarangWithMultipleIds(List<Integer> ids);
	
	@Modifying
	@Query(value="Select * from tabel_barang tb where tb.nama_barang like %?1%", nativeQuery = true)
	List<DataBarangModel> searchByNamaBarang (String barang);
	
	@Modifying
	@Query(value="Select * from tabel_barang tb order by tb.nama_barang", nativeQuery= true)
	List<DataBarangModel> orderByNamaBarang();
	
	@Modifying
	@Query(value="Select * from tabel_barang tb where tb.nama_barang like %?1% order by tb.nama_barang", nativeQuery=true)
	List<DataBarangModel> searchAndOrder(String barang);

	
	@Modifying
	@Query("select d from DataBarangModel d where d.id in ?1")
	List<DataBarangModel> searchByIds(List<Integer> ids);
}
