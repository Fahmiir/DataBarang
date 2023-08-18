package com.ats.DataBarang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ats.DataBarang.model.DataBarangModel;
import com.ats.DataBarang.model.KategoriModel;
import com.ats.DataBarang.service.DataBarangService;
import com.ats.DataBarang.service.KategoriService;

@Controller
public class DataBarangController {
	
	@Autowired
	KategoriService ks;
	
	@Autowired
	DataBarangService ds;
	
	@RequestMapping(value="/")
	public String menuHome(Model model, 
			               @RequestParam(value="jenis",required=false,defaultValue="") String jenis,
			               @RequestParam(value="button", required = false) String button,
			               @RequestParam(value="cursor", required = false) String cursor,
			               HttpServletRequest request) {
		List<KategoriModel> lk = new ArrayList<>();
		List<DataBarangModel> dk = new ArrayList<>();
		lk = ks.read();
		dk = ds.read(jenis,button);
		model.addAttribute("Jenis",jenis);
		model.addAttribute("ListKategoriModel",lk);
		model.addAttribute("ListDataBarangModel",dk);
		model.addAttribute("Position", cursor);
		String html = "home";
		return html;
	}
	
	@RequestMapping(value="/save")
	public String addData(HttpServletRequest request,Model model) {
		int KodeBarang = Integer.valueOf(request.getParameter("KodeBarang"));
		String NamaBarang = request.getParameter("NamaBarang");
		int HargaJual = Integer.valueOf(request.getParameter("HargaJual"));
		int HargaBeli = Integer.valueOf(request.getParameter("HargaBeli"));
		String Satuan = request.getParameter("Satuan");
		String Kategori = request.getParameter("Kategori");
		DataBarangModel dm = new DataBarangModel();
		dm.setKodeBarang(KodeBarang);
		dm.setNamaBarang(NamaBarang);
		dm.setHargaJual(HargaJual);
		dm.setHargaBeli(HargaBeli);
		dm.setSatuan(Satuan);
		dm.setKategori(Kategori);
		ds.create(dm);
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit")
	public String editData(HttpServletRequest request,Model model) {
		int id = Integer.valueOf(request.getParameter("id"));
		int KodeBarang = Integer.valueOf(request.getParameter("KodeBarang"));
		String NamaBarang = request.getParameter("NamaBarang");
		int HargaJual = Integer.valueOf(request.getParameter("HargaJual"));
		int HargaBeli = Integer.valueOf(request.getParameter("HargaBeli"));
		String Satuan = request.getParameter("Satuan");
		String Kategori = request.getParameter("Kategori");
		DataBarangModel dm = new DataBarangModel();
		dm.setId(id);
		dm.setKodeBarang(KodeBarang);
		dm.setNamaBarang(NamaBarang);
		dm.setHargaJual(HargaJual);
		dm.setHargaBeli(HargaBeli);
		dm.setSatuan(Satuan);
		dm.setKategori(Kategori);
		ds.update(dm);
		return "redirect:/";
	}
	
	@RequestMapping(value="/view", produces="text/plain")
	@ResponseBody
	public String viewData(Model model, @RequestBody Integer i) {
		model.addAttribute("i",i);
		return "redirect:/";
	}
	


	@RequestMapping(value="/delete", produces="text/plain")
	@ResponseBody
	public String deleteData(@RequestBody List<Integer> ids) {
		ds.delete(ids);
		return "redirect:/";
	}
	
}
