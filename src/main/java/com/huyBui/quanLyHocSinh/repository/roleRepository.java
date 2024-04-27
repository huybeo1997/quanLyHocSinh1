package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.role;

public interface roleRepository extends JpaRepository<role, Integer>{

	role findByRoleName(String roleName);
}
