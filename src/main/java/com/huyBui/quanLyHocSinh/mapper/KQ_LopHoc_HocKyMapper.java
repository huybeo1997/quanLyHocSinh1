package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.KQ_LopHoc_HocKyDTO;
import com.huyBui.quanLyHocSinh.Entity.KQ_LopHoc_HocKy;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.hocKy;
import com.huyBui.quanLyHocSinh.Entity.lop;

@Mapper(componentModel = "spring")
public abstract class KQ_LopHoc_HocKyMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "hocKy", ignore = true)
	public abstract KQ_LopHoc_HocKy toKQ_LopHoc_HocKyEntity(KQ_LopHoc_HocKyDTO kq_LopHoc_HocKyDTO);
	
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "hocKy", ignore = true)
	public abstract KQ_LopHoc_HocKy toKQ_LopHoc_HocKyEntity(@MappingTarget KQ_LopHoc_HocKy hoc_HocKy,KQ_LopHoc_HocKyDTO kq_LopHoc_HocKyDTO);
	
	@Mapping(target = "tenLop", source = "lop")
	@Mapping(target = "namHoc", source = "namHoc")
	@Mapping(target = "hocKy", source = "hocKy")
	public abstract KQ_LopHoc_HocKyDTO toKQ_LopHoc_HocKyDTO(KQ_LopHoc_HocKy kq_LopHoc_HocKy);
	
	public String toLop(lop lop) {
		return lop.getTenLop();
	}
	
	public String toNamHoc(NamHoc namHoc) {
		return namHoc.getNamHoc();
	}
	
	public String toHocKy(hocKy hocKy) {
		return hocKy.getTenHocKy();
	}
}
