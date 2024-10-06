package com.ats.DataBarang.dto;

import java.io.Serializable;

public class RestTemplateResponse{
	
	private String kategori;
	private String satuan;
	private Integer kodeBarang;
	private String namaBarang;
	private Integer hargaBeli;
	private Integer hargaJual;
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public String getSatuan() {
		return satuan;
	}
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
	public Integer getKodeBarang() {
		return kodeBarang;
	}
	public void setKodeBarang(Integer kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	public Integer getHargaBeli() {
		return hargaBeli;
	}
	public void setHargaBeli(Integer hargaBeli) {
		this.hargaBeli = hargaBeli;
	}
	public Integer getHargaJual() {
		return hargaJual;
	}
	public void setHargaJual(Integer hargaJual) {
		this.hargaJual = hargaJual;
	}
	
	
	
	
	

}
