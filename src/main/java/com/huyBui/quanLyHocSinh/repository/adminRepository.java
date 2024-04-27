package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.admin;

public interface adminRepository extends JpaRepository<admin, Integer>{

	admin findByEmail(String email);
}
