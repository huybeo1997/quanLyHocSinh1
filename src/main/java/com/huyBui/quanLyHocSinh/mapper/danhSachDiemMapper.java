package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.danhSachDiemDTO;
import com.huyBui.quanLyHocSinh.Entity.danhSachDiem;
import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;

@Mapper(componentModel = "spring")
public abstract class danhSachDiemMapper {

	@Mapping(target = "diemThiMonHoc", ignore = true)
	@Mapping(target = "id", ignore = true)
	public abstract danhSachDiem toDanhSachDiemEntity(danhSachDiemDTO danhSachDiemDTO);
	
	@Mapping(target = "diemThiMonHoc", ignore = true)
	public abstract danhSachDiem toDanhSachDiemEntity(@MappingTarget danhSachDiem danhSachDiem,danhSachDiemDTO danhSachDiemDTO);
	
	@Mapping(target = "id_diemThiMonHocDTO", source = "diemThiMonHoc")
	public abstract danhSachDiemDTO toDanhSachDiemDTO(danhSachDiem danhSachDiem);

	
	public Long fromDiemThiMonHoc(diemThiMonHoc diemThiMonHoc) {
		return diemThiMonHoc.getId();
	}

}
