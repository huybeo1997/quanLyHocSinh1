package com.huyBui.quanLyHocSinh.Entity;

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
@Table(name = "phanconggiaovienbomon")
public class phanCongGVBomon extends base{
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_namhoc")
	private NamHoc namHoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lop")
	private lop lop;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_monhoc")
	private monHoc monHoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_giaovien")
	private giaoVien giaoVien;
}
