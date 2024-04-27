package com.huyBui.quanLyHocSinh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.danhSachDiemDTO;
import com.huyBui.quanLyHocSinh.Entity.danhSachDiem;
import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;
import com.huyBui.quanLyHocSinh.enums.errorCode;
import com.huyBui.quanLyHocSinh.exception.AppException;
import com.huyBui.quanLyHocSinh.mapper.danhSachDiemMapper;
import com.huyBui.quanLyHocSinh.repository.danhSachDiemRepository;
import com.huyBui.quanLyHocSinh.repository.diemThiMonHocRepository;
import com.huyBui.quanLyHocSinh.service.IDanhSachDiemService;

@Service
public class danhSachDiemService implements IDanhSachDiemService {
	
	@Autowired
	private danhSachDiemRepository danhSachDiemRepository;
	
	@Autowired
	private danhSachDiemMapper danhSachDiemMapper;
	
	@Autowired
	private diemThiMonHocRepository diemThiMonHocRepository;

	@Override
	public apiResponse<danhSachDiemDTO> upDateDiem(danhSachDiemDTO danhSachDiemDTO) {
		danhSachDiem diem = danhSachDiemRepository.findById(danhSachDiemDTO.getId());
		if(diem == null) throw new AppException(errorCode.DIEM_EXISTED);
		
		diem = danhSachDiemMapper.toDanhSachDiemEntity(diem, danhSachDiemDTO);
		
		diemThiMonHoc diemThiMonHoc = diemThiMonHocRepository.findById(danhSachDiemDTO.getId_diemThiMonHocDTO());
		diem.setDiemThiMonHoc(diemThiMonHoc);
		diem = danhSachDiemRepository.save(diem);
		apiResponse<danhSachDiemDTO> apiResponse = new apiResponse<danhSachDiemDTO>();
		apiResponse.setResult(danhSachDiemMapper.toDanhSachDiemDTO(diem));
		return apiResponse;
	}

	
}
