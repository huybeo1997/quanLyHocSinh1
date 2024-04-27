package com.huyBui.quanLyHocSinh.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "lop")
public class lop extends base {
	
	@Column(name = "tenlop")
	@NotBlank
	private String tenLop;
	
	@Column(name = "siso")
	private int siSo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_khoilop")
	private khoiLop khoiLop;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_namhoc")
	private NamHoc namHoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hocky")
	private hocKy hocKy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_giaovien")
	private giaoVien giaoVienChuNhiem;
	
	@OneToMany(mappedBy = "lop")
	private List<phanLop> lstPhanLop;
	
	@OneToMany(mappedBy = "lop")
	private List<phanCongGVBomon> listPhanCongGVBomon;
	
	@OneToMany(mappedBy = "lop")
	private List<diemThiMonHoc> listDiem;
	
	@OneToMany(mappedBy = "lop")
	private List<KQ_HS_HocKy> listKQHK;
	
	@OneToMany(mappedBy = "lop")
	private List<KQ_MonHoc_Lop> listKq_MonHoc_Lop;
	
	@OneToMany(mappedBy = "lop")
	private List<KQ_LopHoc_HocKy> listkKq_LopHoc_HocKy;
}
