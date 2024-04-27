package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.huyBui.quanLyHocSinh.DTO.adminDTO;
import com.huyBui.quanLyHocSinh.Entity.admin;
import com.huyBui.quanLyHocSinh.Entity.role;

@Mapper(componentModel = "spring")
public abstract class adminMapper {

	@Mapping(target = "listRoleName", source = "roles")
	public abstract adminDTO toAdminDTO(admin admin);

	@Mapping(target = "roles", ignore = true)
	@Mapping(target = "account", ignore = true)
	@Mapping(target = "id",ignore = true)
	public abstract admin toAdminEntity(adminDTO adminDTO);
	
	public String fromRole(role role) {
        return role.getRoleName();
    }
}
