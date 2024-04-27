package com.huyBui.quanLyHocSinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.khoiLopDTO;

public interface IKhoiLopService {

	apiResponse<khoiLopDTO> createKhoiLop(khoiLopDTO khoiLopDTO);
	
	apiResponse<khoiLopDTO> updateKhoiLop(khoiLopDTO khoiLopDTO);
	
	apiResponse<List<khoiLopDTO>> findAll(Pageable pageable);
	
	void delete(int[] ids);
	
	int totalItem();
}
