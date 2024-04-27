package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.khoiLop;

public interface khoiLopRepository extends JpaRepository<khoiLop, Integer> {

	khoiLop findByTenKhoi(String tenKhoi);
	
	khoiLop findById(int id);

}
