package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.KQ_LopHoc_HocKy;
import com.huyBui.quanLyHocSinh.Entity.lop;

public interface KQ_LopHoc_HocKyRepository extends JpaRepository<KQ_LopHoc_HocKy, Long> {

	KQ_LopHoc_HocKy findByLop(lop lop);
}
