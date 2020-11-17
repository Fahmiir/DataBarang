package com.ats.DataBarang.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ats.DataBarang.model.KategoriModel;
import com.ats.DataBarang.repository.KategoriRepository;

@Service
@Transactional
public class KategoriService {

	@Autowired
	KategoriRepository kr;
	
	public List<KategoriModel> read() {
		return kr.findAll();
	}
}
