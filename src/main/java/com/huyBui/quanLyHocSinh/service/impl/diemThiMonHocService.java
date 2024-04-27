package com.huyBui.quanLyHocSinh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.diemThiMonHocDTO;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.danhSachDiem;
import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;
import com.huyBui.quanLyHocSinh.Entity.hocKy;
import com.huyBui.quanLyHocSinh.Entity.hocSinh;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.Entity.monHoc;
import com.huyBui.quanLyHocSinh.enums.errorCode;
import com.huyBui.quanLyHocSinh.exception.AppException;
import com.huyBui.quanLyHocSinh.mapper.diemThiMonHocMapper;
import com.huyBui.quanLyHocSinh.repository.danhSachDiemRepository;
import com.huyBui.quanLyHocSinh.repository.diemThiMonHocRepository;
import com.huyBui.quanLyHocSinh.repository.hocKyRepository;
import com.huyBui.quanLyHocSinh.repository.hocSinhRepository;
import com.huyBui.quanLyHocSinh.repository.lopRepository;
import com.huyBui.quanLyHocSinh.repository.monHocRepository;
import com.huyBui.quanLyHocSinh.repository.namHocRepository;
import com.huyBui.quanLyHocSinh.service.IDiemThMonHocService;

public class diemThiMonHocService implements IDiemThMonHocService{
	
	@Autowired
	private diemThiMonHocRepository diemThiMonHocRepository;
	
	@Autowired
	private hocSinhRepository hocSinhRepository;
	
	@Autowired
	private monHocRepository monHocRepository;
	
	@Autowired
	private namHocRepository namHocRepository;
	
	@Autowired
	private lopRepository lopRepository;
	
	@Autowired 
	private hocKyRepository hocKyRepository;
	
	@Autowired
	private diemThiMonHocMapper diemThiMonHocMapper;
	
	@Autowired
	private danhSachDiemRepository danhSachDiemRepository;

	@Override
	public apiResponse<diemThiMonHocDTO> createDiemThiMonHoc(diemThiMonHocDTO diemThiMonHocDTO) {
		diemThiMonHoc diemMonHoc = diemThiMonHocMapper.toDiemThiMonHocEntity(diemThiMonHocDTO);
		
		hocSinh hocSinh = hocSinhRepository.findByTenHocSinh(diemThiMonHocDTO.getTenHocSinh());
		monHoc monHoc = monHocRepository.findByTenMonHoc(diemThiMonHocDTO.getTenMonHoc());
		NamHoc namHoc = namHocRepository.findByNamHoc(diemThiMonHocDTO.getNamHoc());
		hocKy hocKy = hocKyRepository.findByTenHocKy(diemThiMonHocDTO.getTenHocKy());
		lop lop = lopRepository.findByTenLop(diemThiMonHocDTO.getTenLop());
		
		diemMonHoc.setHocSinh(hocSinh);
		diemMonHoc.setMonHoc(monHoc);
		diemMonHoc.setNamHoc(namHoc);
		diemMonHoc.setHocKy(hocKy);
		diemMonHoc.setLop(lop);
		
		diemMonHoc = diemThiMonHocRepository.save(diemMonHoc);
		
		danhSachDiem danhSachDiem = danhSachDiemRepository.findById(diemMonHoc.getId());
		
		diemMonHoc.setDanhSachDiem(danhSachDiem);
		
		diemMonHoc = diemThiMonHocRepository.save(diemMonHoc);
		
		apiResponse<diemThiMonHocDTO> apiResponse = new apiResponse<diemThiMonHocDTO>();
		apiResponse.setResult(diemThiMonHocMapper.toDiemThiMonHocDTO(diemMonHoc));
		return apiResponse;
	}

	@Override
	public apiResponse<diemThiMonHocDTO> updateDiemthiMonHoc(diemThiMonHocDTO diemThiMonHocDTO) {
		diemThiMonHoc diemMonHoc = diemThiMonHocRepository.findById(diemThiMonHocDTO.getId());
		if(diemMonHoc == null) throw new AppException(errorCode.DIEM_EXISTED);
		
		diemMonHoc = diemThiMonHocMapper.toDiemThiMonHocEntity(diemMonHoc, diemThiMonHocDTO);
		
		hocSinh hocSinh = hocSinhRepository.findByTenHocSinh(diemThiMonHocDTO.getTenHocSinh());
		monHoc monHoc = monHocRepository.findByTenMonHoc(diemThiMonHocDTO.getTenMonHoc());
		NamHoc namHoc = namHocRepository.findByNamHoc(diemThiMonHocDTO.getNamHoc());
		hocKy hocKy = hocKyRepository.findByTenHocKy(diemThiMonHocDTO.getTenHocKy());
		lop lop = lopRepository.findByTenLop(diemThiMonHocDTO.getTenLop());
		danhSachDiem danhSachDiem = danhSachDiemRepository.findById(diemThiMonHocDTO.getId());
		diemMonHoc.setHocSinh(hocSinh);
		diemMonHoc.setMonHoc(monHoc);
		diemMonHoc.setNamHoc(namHoc);
		diemMonHoc.setHocKy(hocKy);
		diemMonHoc.setLop(lop);
		diemMonHoc.setDanhSachDiem(danhSachDiem);
		
		diemMonHoc = diemThiMonHocRepository.save(diemMonHoc);
		
		apiResponse<diemThiMonHocDTO> apiResponse = new apiResponse<diemThiMonHocDTO>();
		apiResponse.setResult(diemThiMonHocMapper.toDiemThiMonHocDTO(diemMonHoc));
		
		return apiResponse;
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			diemThiMonHocRepository.deleteById(id);
		}
	
	}

}
