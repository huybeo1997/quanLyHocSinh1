package com.huyBui.quanLyHocSinh.service;

import org.springframework.data.domain.Pageable;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.giaoVienDTO;
import java.util.List;

public interface IGiaoVienService {

	apiResponse<giaoVienDTO> createGiaoVien(giaoVienDTO giaoVienDTO);
	
	apiResponse<giaoVienDTO> updateGiaoVien(giaoVienDTO giaoVienDTO);
	
	apiResponse<List<giaoVienDTO>> findAll(Pageable pageable);
	
	void delete(long[] ids);
	
	int totalItem();
}
