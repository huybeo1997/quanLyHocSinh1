package com.huyBui.quanLyHocSinh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.namHocDTO;

public interface INamHocService {

	apiResponse<namHocDTO> createNamHoc(namHocDTO namHocDTO);
	
	apiResponse<List<namHocDTO>> findAll(Pageable pageable);
}
