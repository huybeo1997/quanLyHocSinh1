package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.monHoc;

public interface monHocRepository extends JpaRepository<monHoc, Integer>{

	monHoc findByTenMonHoc(String tenMonHoc);
	
	monHoc findByMaMonHoc(String maMonhoc);
}
