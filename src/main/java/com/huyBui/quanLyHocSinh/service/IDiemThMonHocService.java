package com.huyBui.quanLyHocSinh.service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.diemThiMonHocDTO;

public interface IDiemThMonHocService {

	apiResponse<diemThiMonHocDTO> createDiemThiMonHoc(diemThiMonHocDTO diemThiMonHocDTO);
	
	apiResponse<diemThiMonHocDTO> updateDiemthiMonHoc(diemThiMonHocDTO diemThiMonHocDTO);
	
	void delete(long[] ids);
}
