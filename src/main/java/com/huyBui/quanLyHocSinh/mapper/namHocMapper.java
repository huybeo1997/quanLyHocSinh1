package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.namHocDTO;
import com.huyBui.quanLyHocSinh.Entity.KQ_HS_HocKy;
import com.huyBui.quanLyHocSinh.Entity.KQ_LopHoc_HocKy;
import com.huyBui.quanLyHocSinh.Entity.KQ_MonHoc_Lop;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;
import com.huyBui.quanLyHocSinh.Entity.hocKy;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.Entity.phanCongGVBomon;
import com.huyBui.quanLyHocSinh.Entity.phanLop;

@Mapper(componentModel = "spring")
public abstract class namHocMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "listHocKy", ignore = true)
	@Mapping(target = "listLop", ignore = true)
	@Mapping(target = "listPhanLop", ignore = true)
	@Mapping(target = "listPhanCongGVBomon", ignore = true)
	@Mapping(target = "listDiem", ignore = true)
	@Mapping(target = "listKQHK", ignore = true)
	@Mapping(target = "listKq_MonHoc_Lop", ignore = true)
	@Mapping(target = "listKq_LopHoc_HocKy", ignore = true)
	public abstract NamHoc toNamHocEntity(namHocDTO namHocDTO);
	
	@Mapping(target = "listHocKy", ignore = true)
	@Mapping(target = "listLop", ignore = true)
	@Mapping(target = "listPhanLop", ignore = true)
	@Mapping(target = "listPhanCongGVBomon", ignore = true)
	@Mapping(target = "listDiem", ignore = true)
	@Mapping(target = "listKQHK", ignore = true)
	@Mapping(target = "listKq_MonHoc_Lop", ignore = true)
	@Mapping(target = "listKq_LopHoc_HocKy", ignore = true)
	public abstract NamHoc toNamHocEntity(@MappingTarget NamHoc namHoc,namHocDTO namHocDTO);
	
	@Mapping(target = "listHocKy", source = "listHocKy")
	@Mapping(target = "listLop", source = "listLop")
	@Mapping(target = "listHSLop", source = "listPhanLop")
	@Mapping(target = "listPhanCongGVBomon", source = "listPhanCongGVBomon")
	@Mapping(target = "listDiemHS", source = "listDiem")
	@Mapping(target = "listKQHK", source = "listKQHK")
	@Mapping(target = "listKq_MonHoc_Lop", source = "listKq_MonHoc_Lop")
	@Mapping(target = "listKq_LopHoc_HocKy", source = "listKq_LopHoc_HocKy")
	public abstract namHocDTO toNamHocDTO(NamHoc namHoc);
	
	public String fromHocKy(hocKy hocKy) {
		return hocKy.getTenHocKy();
	}
	
	public String fromLop(lop lop) {
		return lop.getTenLop();
	}
	
	public String fromPhanLop(phanLop phanLop) {
		return phanLop.getLop().getTenLop();
	}
	
	public String fromPhanCongGVBoMon(phanCongGVBomon phanCongGVBomon) {
		return phanCongGVBomon.getGiaoVien().getTenGiaoVien();
	}
	
	public String fromDiemThiMonHoc(diemThiMonHoc diemThiMonHoc) {
		return diemThiMonHoc.getMonHoc().getMaMonHoc();
	}
	
	public String fromKQ_HS_HocK(KQ_HS_HocKy kq_HS_HocKy) {
		return kq_HS_HocKy.getHocKy().getTenHocKy();
	}
	
	public String fromKQ_MonHoc_Lop(KQ_MonHoc_Lop kq_MonHoc_Lop) {
		return kq_MonHoc_Lop.getMonHoc().getMaMonHoc();
	}
	
	public String fromKQ_LopHoc_HocKy(KQ_LopHoc_HocKy kq_LopHoc_HocKy) {
		return kq_LopHoc_HocKy.getHocKy().getTenHocKy();
	}
}
