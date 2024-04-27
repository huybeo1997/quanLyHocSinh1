package com.huyBui.quanLyHocSinh.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.giaoVienDTO;
import com.huyBui.quanLyHocSinh.Entity.account;
import com.huyBui.quanLyHocSinh.Entity.giaoVien;
import com.huyBui.quanLyHocSinh.Entity.monHoc;
import com.huyBui.quanLyHocSinh.Entity.role;
import com.huyBui.quanLyHocSinh.enums.errorCode;
import com.huyBui.quanLyHocSinh.exception.AppException;
import com.huyBui.quanLyHocSinh.mapper.giaoVienMapper;
import com.huyBui.quanLyHocSinh.repository.accountRepository;
import com.huyBui.quanLyHocSinh.repository.giaoVienRepository;
import com.huyBui.quanLyHocSinh.repository.monHocRepository;
import com.huyBui.quanLyHocSinh.repository.roleRepository;
import com.huyBui.quanLyHocSinh.service.IGiaoVienService;

@Service
public class giaoVienService implements IGiaoVienService{

	@Autowired
	private giaoVienRepository giaoVienRepository;
	@Autowired
	private giaoVienMapper giaoVienMapper;
	@Autowired
	private roleRepository roleRepository;
	@Autowired
	private monHocRepository monHocRepository;
	@Autowired
	private accountRepository accountRepository;
	@Override
	public apiResponse<giaoVienDTO> createGiaoVien(giaoVienDTO giaoVienDTO) {
		giaoVien giaoVien = giaoVienRepository.findByEmail(giaoVienDTO.getEmail());
		if(giaoVien != null) throw new AppException(errorCode.EMAIL_EXISTED);
		giaoVien = giaoVienMapper.toGiaoVienEntity(giaoVienDTO);
		
		monHoc monHoc = monHocRepository.findByTenMonHoc(giaoVienDTO.getMonGiangDay());
		Set<role> listRole= new HashSet<role>();
		List<String> listRoleName = giaoVienDTO.getListRoleName();
		for (String string : listRoleName) {
			listRole.add(roleRepository.findByRoleName(string));
		}
		
		giaoVien.setMonHoc(monHoc);
		giaoVien.setRoles(listRole);
		
		giaoVien = giaoVienRepository.save(giaoVien);
		
		account account = accountRepository.findByEmail(giaoVienDTO.getEmail());
		
		giaoVien.setAccount(account);
		giaoVien = giaoVienRepository.save(giaoVien);
		
		apiResponse<giaoVienDTO> apiResponse = new apiResponse<giaoVienDTO>();
		apiResponse.setResult(giaoVienDTO);
		
		return apiResponse;
	}

	@Override
	public apiResponse<giaoVienDTO> updateGiaoVien(giaoVienDTO giaoVienDTO) {
		giaoVien giaoVien = giaoVienRepository.findById(giaoVienDTO.getId());
		if(giaoVien == null) {
			 throw new AppException(errorCode.GV_NOT_EXISTED);
		}else if (giaoVien.getEmail().equals(giaoVienDTO.getEmail()) || giaoVien.getEmail().equals(giaoVienDTO.getEmail()) == false &
					giaoVienRepository.findByEmail(giaoVienDTO.getEmail()) == null) {
			giaoVien = giaoVienMapper.toGiaoVienEntity(giaoVien, giaoVienDTO);
		} else throw new AppException(errorCode.EMAIL_EXISTED);
		
		monHoc monHoc = monHocRepository.findByTenMonHoc(giaoVienDTO.getMonGiangDay());
		Set<role> listRole= new HashSet<role>();
		List<String> listRoleName = giaoVienDTO.getListRoleName();
		for (String string : listRoleName) {
			listRole.add(roleRepository.findByRoleName(string));
		}
		
		giaoVien.setMonHoc(monHoc);
		giaoVien.setRoles(listRole);
		
		giaoVien = giaoVienRepository.save(giaoVien);
		
		account account = accountRepository.findByEmail(giaoVienDTO.getEmail());
		
		giaoVien.setAccount(account);
		giaoVien = giaoVienRepository.save(giaoVien);
		
		apiResponse<giaoVienDTO> apiResponse = new apiResponse<giaoVienDTO>();
		apiResponse.setResult(giaoVienDTO);
		
		return apiResponse;
	}

	@Override
	public apiResponse<List<giaoVienDTO>> findAll(Pageable pageable) {
		List<giaoVien> listGiaoVien = giaoVienRepository.findAll(pageable).getContent();
		List<giaoVienDTO> listGiaoVienDTO = new ArrayList<giaoVienDTO>();
		
		for (giaoVien giaoVien : listGiaoVien) {
			listGiaoVienDTO.add(giaoVienMapper.toGiaoVienDTO(giaoVien));
		}
		
		apiResponse<List<giaoVienDTO>> apiResponse = new apiResponse<List<giaoVienDTO>>();
		apiResponse.setResult(listGiaoVienDTO);
		return apiResponse;
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			giaoVienRepository.deleteById(id);
		}
		
	}

	@Override
	public int totalItem() {
		
		return (int) giaoVienRepository.count();
	}

	
}
