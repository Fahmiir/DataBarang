package com.ats.DataBarang.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ats.DataBarang.dto.IdList;
import com.ats.DataBarang.model.DataBarangModel;
import com.ats.DataBarang.service.DataBarangService;

@RestController
@RequestMapping("/api")
public class DataBarangRestController {
	
	@Autowired
	DataBarangService ds;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public void createData(@RequestBody DataBarangModel dm) {
		System.out.println("Data :"+dm);
		ds.create(dm);
	}
	
    @RequestMapping(value="/",method=RequestMethod.GET)
    public List<DataBarangModel> readData(){
    	System.out.println("tes");
    	return ds.read("", null);
    }
    
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void deleteData(@PathVariable(value="id")Integer id) {
        ds.deleteOne(id);
    }
    
    @RequestMapping(value="/edit/",method=RequestMethod.PUT)
    public void editData(@RequestBody DataBarangModel dm) {
    	System.out.println("tesEdit");
    	ds.update(dm);
    }
    
	@RequestMapping(value="/deleteMultiple", method=RequestMethod.POST)
	public void deleteMultipleData(@RequestBody List<Integer> ids) {
		System.out.println("tes delete multiple");
		ds.delete(ids);
	}
	
	@RequestMapping(value="/deleteMultipleWithKey", method=RequestMethod.POST)
	public void deleteMultipleDataWithKey(@RequestBody IdList ids) {
		System.out.println("tes delete multiple with key");
		ds.deleteMultiple(ids.getIds());
	}
	
	@RequestMapping(value="/deletePathVariable/{id}",method=RequestMethod.DELETE)
	public void deletePathVariable(@PathVariable(value="id") Integer id) {
		System.out.println("id = "+id);
		ds.deleteOne(id);
	}
	
	@RequestMapping(value="/view",method=RequestMethod.POST)
	public Optional<DataBarangModel> readDataById(@RequestBody Integer id) {
		return ds.readById(id);
	}
	
	@RequestMapping(value="/viewMultiple",method=RequestMethod.POST)
	public List<DataBarangModel> readMultipleData(@RequestBody List<Integer> ids){
		return ds.readByMultipleId(ids);
	}
	
	@RequestMapping(value="/deleteQueryParam",method=RequestMethod.DELETE)
	public void deleteQueryParam(@RequestParam("id") List<Integer> ids) {
		ds.deleteMultiple(ids);
	}

}
