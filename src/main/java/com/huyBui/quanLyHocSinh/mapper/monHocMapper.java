package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.monHocDTO;
import com.huyBui.quanLyHocSinh.Entity.KQ_MonHoc_Lop;
import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;
import com.huyBui.quanLyHocSinh.Entity.giaoVien;
import com.huyBui.quanLyHocSinh.Entity.monHoc;
import com.huyBui.quanLyHocSinh.Entity.phanCongGVBomon;

@Mapper(componentModel = "spring")
public abstract class monHocMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "listGiaoVien", ignore = true)
	@Mapping(target = "listPhanCongGVBomon", ignore = true)
	@Mapping(target = "listDiem", ignore = true)
	@Mapping(target = "listKq_MonHoc_Lop", ignore = true)
	public abstract monHoc toMonHocEntity(monHocDTO monHocDTO);
	
	@Mapping(target = "listGiaoVien", ignore = true)
	@Mapping(target = "listPhanCongGVBomon", ignore = true)
	@Mapping(target = "listDiem", ignore = true)
	@Mapping(target = "listKq_MonHoc_Lop", ignore = true)
	public abstract monHoc toMonHocEntity(@MappingTarget monHoc monHoc,monHocDTO monHocDTO);
	
	@Mapping(target = "listGiaoVien", source = "listGiaoVien")
	@Mapping(target = "listPhanCongGVBomon", source = "listPhanCongGVBomon")
	@Mapping(target = "listDiemHS", source = "listDiem")
	@Mapping(target = "listKq_MonHoc_Lop", source = "listKq_MonHoc_Lop")
	public abstract monHocDTO toMonHocDTO(monHoc monHoc);
	
	public String fromGiaoVien(giaoVien giaoVien) {
		return giaoVien.getTenGiaoVien();
	}
	
	public String fromPhanCongGVBomon(phanCongGVBomon phanCongGVBomon) {
		return phanCongGVBomon.getGiaoVien().getTenGiaoVien();
	}
	
	public String fromDiemThiMonHoc(diemThiMonHoc diemThiMonHoc) {
		return diemThiMonHoc.getHocSinh().getTenHocSinh();
	}
	
	public String fromKQ_MonHoc_Lop(KQ_MonHoc_Lop kq_MonHoc_Lop) {
		return kq_MonHoc_Lop.getLop().getTenLop();
	}
}
