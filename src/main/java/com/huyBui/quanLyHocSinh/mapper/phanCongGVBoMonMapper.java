package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.phanCongGVBoMonDTO;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.giaoVien;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.Entity.monHoc;
import com.huyBui.quanLyHocSinh.Entity.phanCongGVBomon;

@Mapper(componentModel = "spring")
public abstract class phanCongGVBoMonMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "monHoc", ignore = true)
	@Mapping(target = "giaoVien", ignore = true)
	public abstract phanCongGVBomon toPhanCongGVBomonEntity(phanCongGVBoMonDTO phanCongGVBoMonDTO);
	
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "monHoc", ignore = true)
	@Mapping(target = "giaoVien", ignore = true)
	public abstract phanCongGVBomon toPhanCongGVBomonEntity(@MappingTarget phanCongGVBomon phanCongGVBomon,phanCongGVBoMonDTO phanCongGVBoMonDTO);
	
	@Mapping(target = "namHoc", source = "namHoc")
	@Mapping(target = "lop", source = "lop")
	@Mapping(target = "monHoc", source = "monHoc")
	@Mapping(target = "giaoVien", source = "giaoVien")
	public abstract phanCongGVBoMonDTO toCongGVBoMonDTO(phanCongGVBomon phanCongGVBomon);
	
	public String fromNamHoc(NamHoc namHoc) {
		return namHoc.getNamHoc();
	}
	
	public String fromLop(lop lop) {
		return lop.getTenLop();
	}
	
	public String fromMonHoc(monHoc monHoc) {
		return monHoc.getMaMonHoc();
	}
	
	public String fromGiaoVien(giaoVien giaoVien) {
		return giaoVien.getTenGiaoVien();
	}
}
