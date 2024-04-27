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
@Table(name = "hocky")
public class hocKy extends base{
	
	@Column(name = "tenhocky")
	@NotBlank
	private String tenHocKy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_namhoc")
	private NamHoc namHoc;
	
	@OneToMany(mappedBy = "hocKy")
	private List<diemThiMonHoc> listDiem;
	
	@OneToMany(mappedBy = "hocKy")
	private List<KQ_HS_HocKy> listKQHK;
	
	@OneToMany(mappedBy = "hocKy")
	private List<KQ_MonHoc_Lop> listkKq_MonHoc_Lop;
	
	@OneToMany(mappedBy = "hocKy")
	private List<KQ_LopHoc_HocKy> listKq_LopHoc_HocKy ;
	
	@OneToMany(mappedBy = "hocKy")
	private List<lop> listLop;
}
