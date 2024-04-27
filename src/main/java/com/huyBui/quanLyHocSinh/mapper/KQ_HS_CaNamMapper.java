package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.KQ_HS_CaNamDTO;
import com.huyBui.quanLyHocSinh.Entity.KQ_HS_CaNam;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.hocSinh;
import com.huyBui.quanLyHocSinh.Entity.lop;

@Mapper(componentModel = "spring")
public abstract class KQ_HS_CaNamMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "hocSinh", ignore = true)
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "ketQua", ignore = true)
	public abstract KQ_HS_CaNam toKQ_HS_CaNamEntity(KQ_HS_CaNamDTO kq_HS_CaNamDTO);
	
	@Mapping(target = "hocSinh", ignore = true)
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "ketQua", ignore = true)
	public abstract KQ_HS_CaNam toKQ_HS_CaNamEntity(@MappingTarget KQ_HS_CaNam kq_HS_CaNam,KQ_HS_CaNamDTO kq_HS_CaNamDTO);
	
	@Mapping(target = "tenHocSinh", source = "hocSinh")
	@Mapping(target = "tenLop", source = "lop")
	@Mapping(target = "namHoc", source = "namHoc")
	public abstract KQ_HS_CaNamDTO toKQ_HS_CaNamDTO(KQ_HS_CaNam kq_HS_CaNam);
	
	public String fromHocSinh(hocSinh hocSinh) {
		return hocSinh.getTenHocSinh();
	}
	
	public String fromLop(lop lop) {
		return lop.getTenLop();
	} 
	
	public String fromNamHoc(NamHoc namHoc) {
		return namHoc.getNamHoc();
	}
}
