package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.lop;

public interface lopRepository extends JpaRepository<lop, Integer>{

	lop findByTenLop(String tenLop);
	
	lop findById(long id);
	
	void deleteById(long id);
	
}
