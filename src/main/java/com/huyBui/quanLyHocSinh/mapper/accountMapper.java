package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.huyBui.quanLyHocSinh.DTO.accountDTO;
import com.huyBui.quanLyHocSinh.Entity.account;

@Mapper(componentModel = "spring")
public interface accountMapper {

	@Mapping(target = "hocSinh", ignore = true)
	@Mapping(target = "giaoVien", ignore = true)
	@Mapping(target = "admin", ignore = true)
	account toAccountEntity(accountDTO accountDTO);
	
	accountDTO toAccountDTO(account account);
	
	
}
