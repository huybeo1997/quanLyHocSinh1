package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.giaoVienDTO;
import com.huyBui.quanLyHocSinh.Entity.giaoVien;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.Entity.monHoc;
import com.huyBui.quanLyHocSinh.Entity.phanCongGVBomon;
import com.huyBui.quanLyHocSinh.Entity.role;

@Mapper(componentModel = "spring")
public abstract class giaoVienMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "account", ignore = true)
	@Mapping(target = "roles", ignore = true)
	@Mapping(target = "listLop",ignore = true)
	@Mapping(target = "lisPhanCongGVBomon",ignore = true)
	@Mapping(target = "monHoc", ignore = true)
	public abstract giaoVien toGiaoVienEntity(giaoVienDTO giaoVienDTO);
	
	@Mapping(target = "account", ignore = true)
	@Mapping(target = "roles", ignore = true)
	@Mapping(target = "listLop",ignore = true)
	@Mapping(target = "lisPhanCongGVBomon",ignore = true)
	@Mapping(target = "monHoc", ignore = true)
	public abstract giaoVien toGiaoVienEntity(@MappingTarget giaoVien giaoVien,giaoVienDTO giaoVienDTO);
	
	@Mapping(target = "listRoleName", source = "roles")
	@Mapping(target = "listLopChuNhiem",source = "listLop")
	@Mapping(target = "listLopGiangDay", source = "lisPhanCongGVBomon")
	@Mapping(target = "monGiangDay", source = "monHoc")
	public abstract giaoVienDTO toGiaoVienDTO(giaoVien giaoVien);
	
	public String fromRole(role role) {
        return role.getRoleName();
    }

    public String fromLop(lop lop) {
        return lop.getTenLop();
    }

    public String fromPhanCongGVBoMon(phanCongGVBomon phanCongGVBomon) {
        return phanCongGVBomon.getLop().getTenLop();
    }

    public String fromMonHoc(monHoc monHoc) {
    	return monHoc.getTenMonHoc();
    }

}
