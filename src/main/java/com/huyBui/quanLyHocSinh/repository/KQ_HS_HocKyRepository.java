package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.KQ_HS_HocKy;
import com.huyBui.quanLyHocSinh.Entity.hocSinh;

public interface KQ_HS_HocKyRepository extends JpaRepository<KQ_HS_HocKy, Long>{

	KQ_HS_HocKy findByHocSinh(hocSinh hocSinh);
}
