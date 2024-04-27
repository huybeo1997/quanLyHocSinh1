package com.huyBui.quanLyHocSinh.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "kq_hs_canam")
public class KQ_HS_CaNam extends base{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hocsinh")
	private hocSinh hocSinh;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lop")
	private lop lop;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_namhoc")
	private NamHoc namHoc;
	
	@Column
	@Min(0)
	@Max(10)
	private float diemTBHK1;
	
	@Column
	@Min(0)
	@Max(10)
	private float diemTBHK2;
	
	@Column
	@Min(0)
	@Max(10)
	private float diemTBCaNam;
	
	@Column(name = "hanhkiem")
	private String hanhKiem;
	
	@Column(name = "kqua")
	private String ketQua;
	
	
}
