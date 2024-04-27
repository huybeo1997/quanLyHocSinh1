package com.huyBui.quanLyHocSinh.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Kq_lophoc_hocky")
public class KQ_LopHoc_HocKy extends base{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lop")
	private lop lop;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_namhoc")
	private NamHoc namHoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hocky")
	private hocKy hocKy;

	@Column(name = "soluongdat")
	private int soLuongDat;
	
	@Column(name = "tile")
	private String tiLe;
}
