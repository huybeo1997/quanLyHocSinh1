package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.hocSinh;

public interface hocSinhRepository extends JpaRepository<hocSinh, Long>{

	hocSinh findByTenHocSinh(String tenHocSinh);
	
	hocSinh findByEmail(String email);
	
	hocSinh findById(long id);
}
