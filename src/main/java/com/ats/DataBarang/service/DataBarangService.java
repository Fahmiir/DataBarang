package com.ats.DataBarang.service;

import java.util.List;

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
	
	public List<DataBarangModel> read(){
		return dr.findAll();
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
