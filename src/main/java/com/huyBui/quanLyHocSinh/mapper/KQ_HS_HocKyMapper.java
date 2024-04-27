package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.KQ_HS_HocKyDTO;
import com.huyBui.quanLyHocSinh.Entity.KQ_HS_HocKy;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.hocKy;
import com.huyBui.quanLyHocSinh.Entity.hocSinh;
import com.huyBui.quanLyHocSinh.Entity.lop;

@Mapper(componentModel = "spring")
public abstract class KQ_HS_HocKyMapper {

	@Mapping(target = "id" , ignore = true)
	@Mapping(target = "hocSinh" , ignore = true)
	@Mapping(target = "lop" , ignore = true)
	@Mapping(target = "hocKy" , ignore = true)
	@Mapping(target = "namHoc" , ignore = true)
	public abstract KQ_HS_HocKy toKQ_HS_HocKyEntity(KQ_HS_HocKyDTO kq_HS_HocKyDTO);
	
	@Mapping(target = "hocSinh" , ignore = true)
	@Mapping(target = "lop" , ignore = true)
	@Mapping(target = "hocKy" , ignore = true)
	@Mapping(target = "namHoc" , ignore = true)
	public abstract KQ_HS_HocKy toKQ_HS_HocKyEntity(@MappingTarget KQ_HS_HocKy kq_HS_HocKy,KQ_HS_HocKyDTO kq_HS_HocKyDTO);
	
	@Mapping(target = "tenHocSinh", source = "hocSinh")
	@Mapping(target = "tenLop", source = "lop")
	@Mapping(target = "tenHocKy", source = "hocKy")
	@Mapping(target = "namHoc", source = "namHoc")
	public abstract KQ_HS_HocKyDTO toKQ_HS_HocKyDTO(KQ_HS_HocKy kq_HS_HocKy);
	
	public String fromHocSinh(hocSinh hocSinh) {
		return hocSinh.getTenHocSinh();
	}
	
	public String fromLop(lop lop) {
		return lop.getTenLop();
	}
	
	public String fromHocKy(hocKy hocKy) {
		return hocKy.getTenHocKy();
	}
	
	public String fromNamHoc(NamHoc namHoc) {
		return namHoc.getNamHoc();
	}
}
