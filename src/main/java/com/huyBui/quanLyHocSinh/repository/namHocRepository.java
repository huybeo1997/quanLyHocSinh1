package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.NamHoc;

public interface namHocRepository extends JpaRepository<NamHoc, Long>{

	NamHoc findByNamHoc(String namHoc);
}
