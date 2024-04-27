package com.huyBui.quanLyHocSinh.service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.danhSachDiemDTO;

public interface IDanhSachDiemService {

	apiResponse<danhSachDiemDTO> upDateDiem(danhSachDiemDTO danhSachDiemDTO);
}
