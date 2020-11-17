package com.ats.DataBarang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TabelBarang")
public class DataBarangModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="KodeBarang")
	private int KodeBarang;
	
	@Column(name="NamaBarang")
	private String NamaBarang;
	
	@Column(name="HargaJual")
	private int HargaJual;
	
	@Column(name="HargaBeli")
	private int HargaBeli;
	
	@Column(name="Satuan")
	private String Satuan;
	
	@Column(name="Kategori")
	private String Kategori;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getKodeBarang() {
		return KodeBarang;
	}

	public void setKodeBarang(int kodeBarang) {
		KodeBarang = kodeBarang;
	}

	public String getNamaBarang() {
		return NamaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		NamaBarang = namaBarang;
	}

	public int getHargaJual() {
		return HargaJual;
	}

	public void setHargaJual(int hargaJual) {
		HargaJual = hargaJual;
	}

	public int getHargaBeli() {
		return HargaBeli;
	}

	public void setHargaBeli(int hargaBeli) {
		HargaBeli = hargaBeli;
	}

	public String getSatuan() {
		return Satuan;
	}

	public void setSatuan(String satuan) {
		Satuan = satuan;
	}

	public String getKategori() {
		return Kategori;
	}

	public void setKategori(String kategori) {
		Kategori = kategori;
	}
	
	

}
