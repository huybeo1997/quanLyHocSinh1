package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.danhSachDiem;

public interface danhSachDiemRepository extends JpaRepository<danhSachDiem, Integer> {

	danhSachDiem findById(long l);
}
