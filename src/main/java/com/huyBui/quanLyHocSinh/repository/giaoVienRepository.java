package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.giaoVien;

public interface giaoVienRepository extends JpaRepository<giaoVien, Long>{

	giaoVien findByEmail(String email);
	
	giaoVien findById(long id);
	
	giaoVien findByMaGiaoVien(String maGiaoVien);
}
