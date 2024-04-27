package com.huyBui.quanLyHocSinh.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "namhoc")
public class NamHoc extends base {

	@Column(name = "namhoc",unique = true)
	@NotBlank
	private String namHoc;
	
	@OneToMany(mappedBy = "namHoc")
	private List<hocKy> listHocKy;
	
	@OneToMany(mappedBy = "namHoc")
	private List<lop> listLop; 
	
	@OneToMany(mappedBy = "namHoc")
	private List<phanLop> listPhanLop;
	
	@OneToMany(mappedBy = "namHoc")
	private List<phanCongGVBomon> listPhanCongGVBomon; 
	
	@OneToMany(mappedBy = "namHoc")
	private List<diemThiMonHoc> listDiem;
	
	@OneToMany(mappedBy = "namHoc")
	private List<KQ_HS_HocKy> listKQHK;
	
	@OneToMany(mappedBy = "namHoc")
	private List<KQ_MonHoc_Lop> listKq_MonHoc_Lop;
	
	@OneToMany(mappedBy = "namHoc")
	private List<KQ_LopHoc_HocKy> listKq_LopHoc_HocKy;
}
