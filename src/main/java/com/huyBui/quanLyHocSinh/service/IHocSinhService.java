package com.huyBui.quanLyHocSinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.hocSinhDTO;

public interface IHocSinhService {

	apiResponse<hocSinhDTO> createHocSinh(hocSinhDTO hocSinhDTO);
	
	apiResponse<hocSinhDTO> updateHocSinh(hocSinhDTO hocSinhDTO);
	
	apiResponse<List<hocSinhDTO>> findAll(Pageable pageable);
	
	void delete(long[] ids);
	
	int totalItem();
}
