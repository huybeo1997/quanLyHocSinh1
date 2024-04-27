package com.huyBui.quanLyHocSinh.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.adminDTO;
import com.huyBui.quanLyHocSinh.service.IAdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/API/admin")
public class adminAPI {

	@Autowired
	private IAdminService adminService;
	
	@PostMapping(produces = "application/json;charset=UTF-8")
	public apiResponse<adminDTO> createAdmin(@Valid @RequestBody adminDTO adminDto) {

		return adminService.createAdmin(adminDto);
	} 
}
