package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;
import com.huyBui.quanLyHocSinh.Entity.monHoc;

public interface diemThiMonHocRepository extends JpaRepository<diemThiMonHoc, Long>{

	diemThiMonHoc findById(long id);
	
	diemThiMonHoc findByMonHoc(monHoc monHoc);
}
