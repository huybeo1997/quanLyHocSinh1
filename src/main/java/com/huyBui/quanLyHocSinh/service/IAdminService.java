package com.huyBui.quanLyHocSinh.service;

import java.util.List;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.adminDTO;

public interface IAdminService {

	List<adminDTO> findAll();
	
	apiResponse<adminDTO> createAdmin(adminDTO adminDTO);
}
