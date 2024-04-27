package com.huyBui.quanLyHocSinh.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "diemthimonhoc")
public class diemThiMonHoc extends base{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hocsinh")
	private hocSinh hocSinh;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_monhoc")
	private monHoc monHoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hocky")
	private hocKy hocKy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_namhoc")
	private NamHoc namHoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lop")
	private lop lop;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_diem", referencedColumnName = "id")
	private danhSachDiem danhSachDiem;
	
}
