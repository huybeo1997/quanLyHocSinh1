package com.huyBui.quanLyHocSinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.lopDTO;

public interface ILopService {

	apiResponse<lopDTO> createLop(lopDTO lopDTO);
	
	apiResponse<lopDTO> updateLop(lopDTO lopDTO);
	
	apiResponse<List<lopDTO>> findAll(Pageable pageable);
	
	void delete(long[] ids);
	
	int totalItem();
}
