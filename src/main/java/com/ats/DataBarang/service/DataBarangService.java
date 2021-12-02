package com.ats.DataBarang.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.DataBarang.model.DataBarangModel;
import com.ats.DataBarang.repository.DataBarangRepository;

@Service
@Transactional
public class DataBarangService {
	
	@Autowired
	DataBarangRepository dr ;
	
	public List<DataBarangModel> read(String barang, String submit){
		if(submit!=null) {
			return dr.orderByNamaBarang();
		}
		
		if(barang.isEmpty()) {
			return dr.findAll();	
		}
		else {
			return dr.searchByNamaBarang(barang);
		}
	}
	
	public void create(DataBarangModel dm) {
		dr.save(dm);
	}
	
	public void update(DataBarangModel dm) {
		dr.save(dm);
	}
	public void delete(List<Integer> ids) {
		dr.deleteBarangWithIds(ids);
	}
	
	

}
