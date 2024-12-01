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
		if(submit==null && barang.isEmpty()) {
			return dr.findAll();
		}
		else if(submit!=null && barang.isEmpty()) {
			return dr.orderByNamaBarang();
		}
		else if(submit==null && !barang.isEmpty()) {
			return dr.searchByNamaBarang(barang);
		}
		else if(submit!=null && !barang.isEmpty()) {
			return dr.searchAndOrder(barang);
		}
		return null;
	}
	
	public void create(DataBarangModel dm) {
		dr.save(dm);
	}
	
	public void createAll(List<DataBarangModel> dm) {
		dr.saveAll(dm);
	}
	
	public void update(DataBarangModel dm) {
		dr.save(dm);
	}
	
	public void delete(List<Integer> ids) {
		dr.deleteBarangWithIds(ids);
	}
	
	public void deleteMultiple(List<Integer> ids) {
		dr.deleteBarangWithMultipleIds(ids);
	}
	
	public void deleteOne(Integer id) {
		dr.deleteById(id);
	}
	
	
	public Optional<DataBarangModel> readById(Integer id) {
		return dr.findById(id);
	}
	
	public List<DataBarangModel> readByMultipleId(List<Integer> ids){
		return dr.searchByIds(ids);
	}
	

}
