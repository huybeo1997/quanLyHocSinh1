package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.lopDTO;
import com.huyBui.quanLyHocSinh.Entity.KQ_HS_HocKy;
import com.huyBui.quanLyHocSinh.Entity.KQ_LopHoc_HocKy;
import com.huyBui.quanLyHocSinh.Entity.KQ_MonHoc_Lop;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;
import com.huyBui.quanLyHocSinh.Entity.giaoVien;
import com.huyBui.quanLyHocSinh.Entity.hocKy;
import com.huyBui.quanLyHocSinh.Entity.khoiLop;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.Entity.phanCongGVBomon;
import com.huyBui.quanLyHocSinh.Entity.phanLop;

@Mapper(componentModel = "spring")
public abstract class lopMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "khoiLop", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "hocKy", ignore = true)
	@Mapping(target = "giaoVienChuNhiem", ignore = true)
	@Mapping(target = "lstPhanLop", ignore = true)
	@Mapping(target = "listPhanCongGVBomon", ignore = true)
	@Mapping(target = "listDiem", ignore = true)
	@Mapping(target = "listKQHK", ignore = true)
	@Mapping(target = "listKq_MonHoc_Lop", ignore = true)
	@Mapping(target = "listkKq_LopHoc_HocKy", ignore = true)
	public abstract lop toLopEntity(lopDTO lopDTO);
	
	@Mapping(target = "khoiLop", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "hocKy", ignore = true)
	@Mapping(target = "giaoVienChuNhiem", ignore = true)
	@Mapping(target = "lstPhanLop", ignore = true)
	@Mapping(target = "listPhanCongGVBomon", ignore = true)
	@Mapping(target = "listDiem", ignore = true)
	@Mapping(target = "listKQHK", ignore = true)
	@Mapping(target = "listKq_MonHoc_Lop", ignore = true)
	@Mapping(target = "listkKq_LopHoc_HocKy", ignore = true)
	public abstract lop toLopEntity(@MappingTarget lop lop,lopDTO lopDTO);
	
	@Mapping(target = "tenKhoi", source = "khoiLop")
	@Mapping(target = "namHoc", source = "namHoc")
	@Mapping(target = "hocKy", source = "hocKy")
	@Mapping(target = "giaoVienChuNhiem", source = "giaoVienChuNhiem")
	@Mapping(target = "listHocSinh", source = "lstPhanLop")
	@Mapping(target = "listGVBoMon", source = "listPhanCongGVBomon")
	@Mapping(target = "listDiemHS", source = "listDiem")
	@Mapping(target = "listKQHKHocSinh", source = "listKQHK")
	@Mapping(target = "listKq_MonHoc_Lop", source = "listKq_MonHoc_Lop")
	@Mapping(target = "listkKq_LopHoc_HocKy", source = "listkKq_LopHoc_HocKy")
	public abstract lopDTO toLopDTO(lop lop);
	
	public String fromKhoiLop(khoiLop khoiLop) {
		return khoiLop.getTenKhoi();
	}
	
	public String fromNamHoc(NamHoc namHoc) {
		return namHoc.getNamHoc();
	}
	
	public String fromHocKy(hocKy hocKy) {
		return hocKy.getTenHocKy();
	}
	
	public String fromGiaoVien(giaoVien giaoVien) {
		return giaoVien.getTenGiaoVien();
	}
	
	public String fromPhanLop(phanLop phanLop) {
		return phanLop.getHocSinh().getTenHocSinh();
	}
	
	public String fromPhanCongGVBomon(phanCongGVBomon phanCongGVBomon) {
		return phanCongGVBomon.getGiaoVien().getTenGiaoVien();
	}
	
	public String fromDiemThiMonHoc(diemThiMonHoc diemThiMonHoc) {
		return diemThiMonHoc.getHocSinh().getTenHocSinh();
	}
	
	public String fromKQ_HS_HocKy(KQ_HS_HocKy kq_HS_HocKy) {
		return kq_HS_HocKy.getHocSinh().getTenHocSinh();
	}
	
	public String fromKQ_MonHoc_Lop(KQ_MonHoc_Lop kq_MonHoc_Lop) {
		return kq_MonHoc_Lop.getMonHoc().getTenMonHoc();
	}
	
	public String fromKQ_LopHoc_HocKy(KQ_LopHoc_HocKy kq_LopHoc_HocKy) {
		return kq_LopHoc_HocKy.getHocKy().getTenHocKy();
	}
}
