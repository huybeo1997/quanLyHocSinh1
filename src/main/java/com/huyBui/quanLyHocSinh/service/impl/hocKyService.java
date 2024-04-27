package com.huyBui.quanLyHocSinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.hocKyDTO;
import com.huyBui.quanLyHocSinh.Entity.KQ_HS_HocKy;
import com.huyBui.quanLyHocSinh.Entity.KQ_LopHoc_HocKy;
import com.huyBui.quanLyHocSinh.Entity.KQ_MonHoc_Lop;
import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;
import com.huyBui.quanLyHocSinh.Entity.hocKy;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.enums.errorCode;
import com.huyBui.quanLyHocSinh.exception.AppException;
import com.huyBui.quanLyHocSinh.mapper.hocKyMapper;
import com.huyBui.quanLyHocSinh.repository.KQ_HS_HocKyRepository;
import com.huyBui.quanLyHocSinh.repository.KQ_LopHoc_HocKyRepository;
import com.huyBui.quanLyHocSinh.repository.KQ_MonHoc_LopRepository;
import com.huyBui.quanLyHocSinh.repository.diemThiMonHocRepository;
import com.huyBui.quanLyHocSinh.repository.hocKyRepository;
import com.huyBui.quanLyHocSinh.repository.hocSinhRepository;
import com.huyBui.quanLyHocSinh.repository.lopRepository;
import com.huyBui.quanLyHocSinh.repository.monHocRepository;
import com.huyBui.quanLyHocSinh.service.IHocKyService;

@Service
public class hocKyService implements IHocKyService{

	@Autowired
	private hocKyRepository hocKyRepository;
	@Autowired
	private hocKyMapper hocKyMapper;
	@Autowired
	private lopRepository lopRepository;
	@Autowired
	private KQ_LopHoc_HocKyRepository kq_LopHoc_HocKyRepository;
	@Autowired
	private KQ_MonHoc_LopRepository kq_MonHoc_LopRepository;
	@Autowired
	private KQ_HS_HocKyRepository kq_HS_HocKyRepository;
	@Autowired
	private diemThiMonHocRepository diemThiMonHocRepository;
	@Autowired
	private hocSinhRepository hocSinhRepository;
	@Autowired
	private monHocRepository monHocRepository;
	
	@Override
	public apiResponse<hocKyDTO> createHocKy(hocKyDTO hocKyDTO) {
		hocKy hocKy = hocKyMapper.toHocKyEntity(hocKyDTO);
		apiResponse<hocKyDTO> apiResponse = new apiResponse<hocKyDTO>();
		apiResponse.setResult(hocKyMapper.toHocKyDTO(hocKy));
		return apiResponse;
	}

	@Override
	public apiResponse<hocKyDTO> updateHocKy(hocKyDTO hocKyDTO) {
		hocKy hocKy = hocKyRepository.findById(hocKyDTO.getId());
		if(hocKy == null) throw new AppException(errorCode.HOCKY_NOT_EXISTED);
		
		hocKy = hocKyMapper.toHocKyEntity(hocKy, hocKyDTO);
		
		List<diemThiMonHoc> listDiemMonHoc = new ArrayList<diemThiMonHoc>();
		List<KQ_HS_HocKy> listKQHs_HocKy = new ArrayList<KQ_HS_HocKy>();
		List<KQ_MonHoc_Lop> listKQKq_MonHoc_Lop = new ArrayList<KQ_MonHoc_Lop>();
		List<KQ_LopHoc_HocKy> listKQKqLopHocHocKy = new ArrayList<KQ_LopHoc_HocKy>();
		List<lop> listLops = new ArrayList<lop>();
		
		List<String> listDiemHSLop = hocKyDTO.getListDiemHSMonHoc();
		List<String> listKQHKHocSinh = hocKyDTO.getListKQHKHocSinh();
		List<String> listKq_MonHoc_Lop = hocKyDTO.getListKq_MonHoc_Lop();
		List<String> listKq_LopHoc_HocKy = hocKyDTO.getListKq_LopHoc_HocKy();
		List<String> listLop = hocKyDTO.getListLop();
		
		for (String tenLop : listLop) {
			listLops.add(lopRepository.findByTenLop(tenLop));
		}
		
		for (String tenLop : listKq_LopHoc_HocKy) {
			listKQKqLopHocHocKy.add(kq_LopHoc_HocKyRepository.findByLop(lopRepository.findByTenLop(tenLop)));
		}
		
		for(String tenLop : listKq_MonHoc_Lop) {
			listKQKq_MonHoc_Lop.add(kq_MonHoc_LopRepository.findByLop(lopRepository.findByTenLop(tenLop)));
		}
		
		for (String tenHocSinh : listKQHKHocSinh) {
			listKQHs_HocKy.add(kq_HS_HocKyRepository.findByHocSinh(hocSinhRepository.findByTenHocSinh(tenHocSinh)));
		}
		
		for (String maMonHoc : listDiemHSLop) {
			listDiemMonHoc.add(diemThiMonHocRepository.findByMonHoc(monHocRepository.findByMaMonHoc(maMonHoc)));
		}
		apiResponse<hocKyDTO> apiResponse = new apiResponse<hocKyDTO>();
		apiResponse.setResult(hocKyMapper.toHocKyDTO(hocKy));
		return apiResponse;
	}

	@Override
	public apiResponse<List<hocKyDTO>> findAll(Pageable pageable) {
		List<hocKy> listHocKy = hocKyRepository.findAll(pageable).getContent();
		List<hocKyDTO> listHocKyDTO = new ArrayList<hocKyDTO>();
		for (hocKy hocKy : listHocKy) {
			listHocKyDTO.add(hocKyMapper.toHocKyDTO(hocKy));
		}
		apiResponse<List<hocKyDTO>> apiResponse = new apiResponse<List<hocKyDTO>>();
		apiResponse.setResult(listHocKyDTO);
		return apiResponse;
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			hocKyRepository.deleteById(id);
		}
		
	}

	@Override
	public int totalItem() {

		return (int) hocKyRepository.count();
	}

	
}
