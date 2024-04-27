//package com.huyBui.quanLyHocSinh.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import com.huyBui.quanLyHocSinh.DTO.roleDTO;
//import com.huyBui.quanLyHocSinh.Entity.admin;
//import com.huyBui.quanLyHocSinh.Entity.giaoVien;
//import com.huyBui.quanLyHocSinh.Entity.hocSinh;
//import com.huyBui.quanLyHocSinh.Entity.role;
//
//@Mapper(componentModel = "spring")
//public abstract class roleMapper {
//
//	@Mapping(target = "id", ignore = true)
//	@Mapping(target = "listAdmin", ignore = true)
//	@Mapping(target = "listGiaoVien", ignore = true)
//	@Mapping(target = "listHocSinh", ignore = true)
//	public abstract role toRoleEntity(roleDTO roleDTO);
//
//	@Mapping(target = "listAdmin", source = "listAdmin")
//	@Mapping(target = "listGiaoVien", source = "listGiaoVien")
//	@Mapping(target = "listHocSinh", source = "listHocSinh")
//	public abstract roleDTO roleDTO(role role);
//
//	public String fromAdmin(admin admin) {
//		return admin.getAdminName();
//	}
//
//	public String fromGiaoVien(giaoVien giaoVien) {
//		return giaoVien.getTenGiaoVien();
//	}
//
//	public String fromHocSinh(hocSinh hocSinh) {
//		return hocSinh.getTenHocSinh();
//	}
//}
