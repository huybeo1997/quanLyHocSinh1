package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.KQ_MonHoc_Lop;
import com.huyBui.quanLyHocSinh.Entity.lop;

public interface KQ_MonHoc_LopRepository extends JpaRepository<KQ_MonHoc_Lop, Long>{

	KQ_MonHoc_Lop findByLop(lop lop);
}
