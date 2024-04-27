package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.hocKy;

public interface hocKyRepository extends JpaRepository<hocKy, Long>{

	hocKy findByTenHocKy(String tenHocKy);
	
	hocKy findById(long id);
}
