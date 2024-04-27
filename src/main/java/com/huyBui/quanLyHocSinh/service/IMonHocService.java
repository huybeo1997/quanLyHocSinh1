package com.huyBui.quanLyHocSinh.service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.monHocDTO;

public interface IMonHocService {

	apiResponse<monHocDTO> createMonHoc(monHocDTO monHocDTO);
}
