package com.huyBui.quanLyHocSinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.khoiLopDTO;
import com.huyBui.quanLyHocSinh.Entity.khoiLop;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.enums.errorCode;
import com.huyBui.quanLyHocSinh.exception.AppException;
import com.huyBui.quanLyHocSinh.mapper.khoiLopMapper;
import com.huyBui.quanLyHocSinh.repository.khoiLopRepository;
import com.huyBui.quanLyHocSinh.repository.lopRepository;
import com.huyBui.quanLyHocSinh.service.IKhoiLopService;

@Service
public class khoiLopService implements IKhoiLopService{

	@Autowired
	private khoiLopRepository khoiLopRepository;
	@Autowired
	private khoiLopMapper khoiLopMapper;
	@Autowired
	private lopRepository lopRepository;
	
	@Override
	public apiResponse<khoiLopDTO> createKhoiLop(khoiLopDTO khoiLopDTO) {
		khoiLop khoiLop = khoiLopRepository.findByTenKhoi(khoiLopDTO.getTenKhoi());
		if(khoiLop != null) throw new AppException(errorCode.KHOI_LOP_EXISTED);
		khoiLop = khoiLopMapper.toKhoiLopEntity(khoiLopDTO);
		khoiLop = khoiLopRepository.save(khoiLop);
		apiResponse<khoiLopDTO> apiResponse = new apiResponse<khoiLopDTO>();
		apiResponse.setResult(khoiLopMapper.toKhoiLopDTO(khoiLop));
		return apiResponse;
	}

	@Override
	public apiResponse<khoiLopDTO> updateKhoiLop(khoiLopDTO khoiLopDTO) {
		khoiLop khoiLop = khoiLopRepository.findById(khoiLopDTO.getId());
		if(khoiLop == null) throw new AppException(errorCode.KHOI_LOP_NOT_EXISTED);
		khoiLop = khoiLopMapper.toKhoiLopEntity(khoiLop, khoiLopDTO);
		
		List<lop> listLop = new ArrayList<lop>();
		List<String> listTenLop = khoiLopDTO.getListLop();
		for (String tenLop : listTenLop) {
			listLop.add(lopRepository.findByTenLop(tenLop));
		}
		khoiLop.setListLop(listLop);
		khoiLop = khoiLopRepository.save(khoiLop);
		apiResponse<khoiLopDTO> apiResponse = new apiResponse<khoiLopDTO>();
		apiResponse.setResult(khoiLopMapper.toKhoiLopDTO(khoiLop));
		return apiResponse;
	}

	@Override
	public apiResponse<List<khoiLopDTO>> findAll(Pageable pageable) {
		List<khoiLopDTO> listKhoiLopDTO = new ArrayList<khoiLopDTO>();
		List<khoiLop> listKhoiLop = khoiLopRepository.findAll(pageable).getContent();
		for (khoiLop khoiLop : listKhoiLop) {
			listKhoiLopDTO.add(khoiLopMapper.toKhoiLopDTO(khoiLop));
		}
		apiResponse<List<khoiLopDTO>> apiResponse = new apiResponse<List<khoiLopDTO>>();
		apiResponse.setResult(listKhoiLopDTO);
		return apiResponse;
	}

	@Override
	public void delete(int[] ids) {
		for (int id : ids) {
			khoiLopRepository.deleteById(id);;
		}
		
	}

	@Override
	public int totalItem() {
		
		return (int) khoiLopRepository.count();
	}

	
}
