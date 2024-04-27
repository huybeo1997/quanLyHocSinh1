package com.huyBui.quanLyHocSinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.hocKyDTO;

public interface IHocKyService {

	apiResponse<hocKyDTO> createHocKy(hocKyDTO hocKyDTO);
	
	apiResponse<hocKyDTO> updateHocKy(hocKyDTO hocKyDTO);
	
	apiResponse<List<hocKyDTO>> findAll(Pageable pageable);
	
	void delete(long[] ids);
	
	int totalItem();
}
