package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.hocSinhDTO;
import com.huyBui.quanLyHocSinh.Entity.KQ_HS_CaNam;
import com.huyBui.quanLyHocSinh.Entity.KQ_HS_HocKy;
import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;
import com.huyBui.quanLyHocSinh.Entity.hocSinh;
import com.huyBui.quanLyHocSinh.Entity.phanLop;
import com.huyBui.quanLyHocSinh.Entity.role;

@Mapper(componentModel = "spring")
public abstract class hocSinhMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "account", ignore = true)
	@Mapping(target = "roles", ignore = true)
	@Mapping(target = "listPhanLop",ignore = true)
	@Mapping(target = "listDiemThiMonHoc",ignore = true)
	@Mapping(target = "listKQHK", ignore = true)
	@Mapping(target = "listKQCaNam",ignore = true)
	public abstract hocSinh toHocSinhEntity(hocSinhDTO hocSinhDTO);
	
	@Mapping(target = "account", ignore = true)
	@Mapping(target = "roles", ignore = true)
	@Mapping(target = "listPhanLop",ignore = true)
	@Mapping(target = "listDiemThiMonHoc",ignore = true)
	@Mapping(target = "listKQHK", ignore = true)
	@Mapping(target = "listKQCaNam",ignore = true)
	public abstract hocSinh toHocSinhEntity(@MappingTarget hocSinh hocSinh,hocSinhDTO hocSinhDTO);
	

	@Mapping(target = "listRoleName", source = "roles")
	@Mapping(target = "listLop", source = "listPhanLop")
	@Mapping(target = "listDiemThiMonHoc", source = "listDiemThiMonHoc")
	@Mapping(target = "listKQHocKy", source = "listKQHK")
	@Mapping(target = "listKQCaNam", source = "listKQCaNam")
	public abstract hocSinhDTO toHocSinhDTO(hocSinh hocSinh);
	
	public String fromRoles(role role) {
		return role.getRoleName();
	}
	
	public String fromPhanLop(phanLop phanLop) {
		return phanLop.getLop().getTenLop();
	}
	
	public String fromDiemThiMonHoc(diemThiMonHoc diemThiMonHoc) {
		return diemThiMonHoc.getMonHoc().getMaMonHoc();
	}
	
	public String fromKQ_HS_HocKy(KQ_HS_HocKy kq_HS_HocKy) {
		return kq_HS_HocKy.getNamHoc().getNamHoc();
	}
	
	public String fromKQ_HS_CaNam(KQ_HS_CaNam kq_HS_CaNam) {
		return kq_HS_CaNam.getNamHoc().getNamHoc();
	}
}
