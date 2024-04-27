package com.huyBui.quanLyHocSinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.lopDTO;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.giaoVien;
import com.huyBui.quanLyHocSinh.Entity.hocKy;
import com.huyBui.quanLyHocSinh.Entity.khoiLop;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.enums.errorCode;
import com.huyBui.quanLyHocSinh.exception.AppException;
import com.huyBui.quanLyHocSinh.mapper.lopMapper;
import com.huyBui.quanLyHocSinh.repository.giaoVienRepository;
import com.huyBui.quanLyHocSinh.repository.hocKyRepository;
import com.huyBui.quanLyHocSinh.repository.khoiLopRepository;
import com.huyBui.quanLyHocSinh.repository.lopRepository;
import com.huyBui.quanLyHocSinh.repository.namHocRepository;
import com.huyBui.quanLyHocSinh.service.ILopService;

@Service
public class lopService implements ILopService {

	@Autowired
	private lopMapper lopMapper;
	@Autowired
	private lopRepository lopRepository;
	@Autowired
	private khoiLopRepository khoiLopRepository;
	@Autowired
	private namHocRepository namHocRepository;
	@Autowired
	private hocKyRepository hocKyRepository;
	@Autowired
	private giaoVienRepository giaoVienRepository;
	
	@Override
	public apiResponse<lopDTO> createLop(lopDTO lopDTO) {
		lop lop = new lop();
		lop = lopMapper.toLopEntity(lopDTO);
		
		khoiLop khoiLop = khoiLopRepository.findByTenKhoi(lopDTO.getTenKhoi());
		NamHoc namHoc = namHocRepository.findByNamHoc(lopDTO.getNamHoc());
		hocKy hocKy = hocKyRepository.findByTenHocKy(lopDTO.getHocKy());
		giaoVien giaoVien = giaoVienRepository.findByMaGiaoVien(lopDTO.getGiaoVienChuNhiem());
		
		lop.setKhoiLop(khoiLop);
		lop.setNamHoc(namHoc);
		lop.setHocKy(hocKy);
		lop.setGiaoVienChuNhiem(giaoVien);
		
		lop = lopRepository.save(lop);
		
		apiResponse<lopDTO> apiResponse = new apiResponse<lopDTO>();
		apiResponse.setResult(lopMapper.toLopDTO(lop));
		return apiResponse;
	}

	@Override
	public apiResponse<lopDTO> updateLop(lopDTO lopDTO) {
		lop lop = lopRepository.findById(lopDTO.getId());
		if(lop == null) throw new AppException(errorCode.LOP_NOT_EXISTED);
		
		lop = lopMapper.toLopEntity(lop, lopDTO);
		
		khoiLop khoiLop = khoiLopRepository.findByTenKhoi(lopDTO.getTenKhoi());
		NamHoc namHoc = namHocRepository.findByNamHoc(lopDTO.getNamHoc());
		hocKy hocKy = hocKyRepository.findByTenHocKy(lopDTO.getHocKy());
		giaoVien giaoVien = giaoVienRepository.findByMaGiaoVien(lopDTO.getGiaoVienChuNhiem());
		
		lop.setKhoiLop(khoiLop);
		lop.setNamHoc(namHoc);
		lop.setHocKy(hocKy);
		lop.setGiaoVienChuNhiem(giaoVien);
		
		lop = lopRepository.save(lop);
		
		apiResponse<lopDTO> apiResponse = new apiResponse<lopDTO>();
		apiResponse.setResult(lopMapper.toLopDTO(lop));
		return apiResponse;
	}

	@Override
	public apiResponse<List<lopDTO>> findAll(Pageable pageable) {
		List<lop> listLop = lopRepository.findAll(pageable).getContent();
		List<lopDTO> listLopDTO = new ArrayList<lopDTO>();
		
		for (lop lop : listLop) {
			listLopDTO.add(lopMapper.toLopDTO(lop));
		}
		apiResponse<List<lopDTO>> apiResponse = new apiResponse<List<lopDTO>>();
		apiResponse.setResult(listLopDTO);
		return apiResponse;
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			lopRepository.deleteById(id);
		}
		
	}

	@Override
	public int totalItem() {
		
		return (int) lopRepository.count();
	}

	
}
