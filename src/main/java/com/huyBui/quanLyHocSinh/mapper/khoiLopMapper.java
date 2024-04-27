package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.khoiLopDTO;
import com.huyBui.quanLyHocSinh.Entity.khoiLop;
import com.huyBui.quanLyHocSinh.Entity.lop;

@Mapper(componentModel = "spring")
public abstract class khoiLopMapper {

	@Mapping(target = "id",ignore = true)
	@Mapping(target = "listLop", ignore = true)
	public abstract khoiLop toKhoiLopEntity(khoiLopDTO khoiLopDTO);
	
	@Mapping(target = "listLop", ignore = true)
	public abstract khoiLop toKhoiLopEntity(@MappingTarget khoiLop khoiLop,khoiLopDTO khoiLopDTO);
	
	@Mapping(target = "listLop", source = "listLop")
	public abstract khoiLopDTO toKhoiLopDTO(khoiLop khoiLop);
	
	public String fromLop(lop lop) {
		return lop.getTenLop();
	}
}
