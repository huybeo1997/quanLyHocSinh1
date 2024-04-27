package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.Entity.phanCongGVBomon;

public interface phanCongGVBoMonRepository extends JpaRepository<phanCongGVBomon, Long>{

	phanCongGVBomon findByLop(lop lop);
}
