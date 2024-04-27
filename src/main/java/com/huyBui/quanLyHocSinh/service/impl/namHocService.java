package com.huyBui.quanLyHocSinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.namHocDTO;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.enums.errorCode;
import com.huyBui.quanLyHocSinh.exception.AppException;
import com.huyBui.quanLyHocSinh.mapper.namHocMapper;
import com.huyBui.quanLyHocSinh.repository.namHocRepository;
import com.huyBui.quanLyHocSinh.service.INamHocService;

@Service
public class namHocService implements INamHocService{

	@Autowired
	private namHocRepository namHocRepository;
	@Autowired
	private namHocMapper namHocMapper;
	@Override
	public apiResponse<namHocDTO> createNamHoc(namHocDTO namHocDTO) {
		NamHoc namHoc = namHocRepository.findByNamHoc(namHocDTO.getNamHoc());
		if(namHoc != null) throw new AppException(errorCode.NAM_HOC_EXISTED);
		namHoc = namHocMapper.toNamHocEntity(namHocDTO);
		
		apiResponse<namHocDTO> apiResponse = new apiResponse<namHocDTO>();
		apiResponse.setResult(namHocMapper.toNamHocDTO(namHoc));
 		return apiResponse;
	}

	@Override
	public apiResponse<List<namHocDTO>> findAll(Pageable pageable) {
		List<NamHoc> listNamHoc = namHocRepository.findAll(pageable).getContent();
		List<namHocDTO> listNamHocDto = new ArrayList<namHocDTO>();
		
		for (NamHoc namHoc : listNamHoc) {
			listNamHocDto.add(namHocMapper.toNamHocDTO(namHoc));
		}
		apiResponse<List<namHocDTO>> apiResponse = new apiResponse<List<namHocDTO>>();
		apiResponse.setResult(listNamHocDto);
 		return apiResponse;
	}

}
