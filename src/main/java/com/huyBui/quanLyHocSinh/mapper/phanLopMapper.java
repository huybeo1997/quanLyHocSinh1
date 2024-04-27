package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.phanLopDTO;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.hocSinh;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.Entity.phanLop;

@Mapper(componentModel = "spring")
public abstract class phanLopMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "hocSinh", ignore = true)
	public abstract phanLop toPhanLopEntity(phanLopDTO phanLopDTO);
	
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "hocSinh", ignore = true)
	public abstract phanLop toPhanLopEntity(@MappingTarget phanLop phanLop,phanLopDTO phanLopDTO);
	
	@Mapping(target = "namHoc", source = "namHoc")
	@Mapping(target = "lop", source = "lop")
	@Mapping(target = "hocSinh", source = "hocSinh")
	public abstract phanLopDTO toPhanLopDTO(phanLop phanLop);

	public String fromNamHoc(NamHoc namHoc) {
		return namHoc.getNamHoc();
	}
	
	public String fromLop(lop lop) {
		return lop.getTenLop();
	}
	
	public String fromHocSinh(hocSinh hocSinh) {
		return hocSinh.getTenHocSinh();
	}
}
