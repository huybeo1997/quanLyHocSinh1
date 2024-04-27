package com.huyBui.quanLyHocSinh.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "monhoc")
public class monHoc{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "mamonhoc",unique = true)
	private String maMonHoc;
	
	@Column(name = "tenmonhoc")
	private String tenMonHoc;
	
	@Column(name = "sotiet")
	private int soTiet;
	
	@Column(name = "heso")
	private int heSo;
	
	@OneToMany(mappedBy = "monHoc")
	private List<giaoVien> listGiaoVien;
	
	@OneToMany(mappedBy = "monHoc")
	private List<phanCongGVBomon> listPhanCongGVBomon;
	
	@OneToMany(mappedBy = "monHoc")
	private List<diemThiMonHoc> listDiem;
	
	@OneToMany(mappedBy = "monHoc")
	private List<KQ_MonHoc_Lop> listKq_MonHoc_Lop;
}
