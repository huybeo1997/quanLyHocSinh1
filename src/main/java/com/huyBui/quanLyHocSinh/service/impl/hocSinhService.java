package com.huyBui.quanLyHocSinh.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.hocSinhDTO;
import com.huyBui.quanLyHocSinh.Entity.account;
import com.huyBui.quanLyHocSinh.Entity.hocSinh;
import com.huyBui.quanLyHocSinh.Entity.role;
import com.huyBui.quanLyHocSinh.enums.errorCode;
import com.huyBui.quanLyHocSinh.exception.AppException;
import com.huyBui.quanLyHocSinh.mapper.hocSinhMapper;
import com.huyBui.quanLyHocSinh.repository.accountRepository;
import com.huyBui.quanLyHocSinh.repository.hocSinhRepository;
import com.huyBui.quanLyHocSinh.repository.roleRepository;
import com.huyBui.quanLyHocSinh.service.IHocSinhService;

@Service
public class hocSinhService implements IHocSinhService{

	@Autowired
	private hocSinhRepository hocSinhRepository;
	@Autowired
	private hocSinhMapper hocSinhMapper;
	@Autowired
	private roleRepository roleRepository;
	@Autowired
	private accountRepository accountRepository;
	
	@Override
	public apiResponse<hocSinhDTO> createHocSinh(hocSinhDTO hocSinhDTO) {
		hocSinh hocSinh = hocSinhRepository.findByEmail(hocSinhDTO.getEmail());
		if(hocSinh == null) throw new AppException(errorCode.EMAIL_EXISTED);
		
		hocSinh = hocSinhMapper.toHocSinhEntity(hocSinhDTO);
		Set<role> listRole= new HashSet<role>();
		List<String> listRoleName = hocSinhDTO.getListRoleName();
		for (String string : listRoleName) {
			listRole.add(roleRepository.findByRoleName(string));
		}
		hocSinh.setRoles(listRole);
		hocSinh = hocSinhRepository.save(hocSinh);
		
		account account = accountRepository.findByEmail(hocSinhDTO.getEmail());
		
		hocSinh.setAccount(account);
		hocSinh = hocSinhRepository.save(hocSinh);
		
		apiResponse<hocSinhDTO> apiResponse = new apiResponse<hocSinhDTO>();
		apiResponse.setResult(hocSinhDTO);
		return apiResponse;
	}

	@Override
	public apiResponse<hocSinhDTO> updateHocSinh(hocSinhDTO hocSinhDTO) {
		hocSinh hocSinh = hocSinhRepository.findById(hocSinhDTO.getId());
		
		if(hocSinh == null) {
			throw new AppException(errorCode.HS_NOT_EXISTED);
		}else if (hocSinh.getEmail().equals(hocSinhDTO.getEmail()) || hocSinh.getEmail().equals(hocSinhDTO.getEmail()) == false &
				hocSinhRepository.findByEmail(hocSinhDTO.getEmail()) == null){
			hocSinh = hocSinhMapper.toHocSinhEntity(hocSinh, hocSinhDTO);
		}
		Set<role> listRole= new HashSet<role>();
		List<String> listRoleName = hocSinhDTO.getListRoleName();
		for (String string : listRoleName) {
			listRole.add(roleRepository.findByRoleName(string));
		}
		hocSinh.setRoles(listRole);
		hocSinh = hocSinhRepository.save(hocSinh);
		
		account account = accountRepository.findByEmail(hocSinhDTO.getEmail());
		
		hocSinh.setAccount(account);
		hocSinh = hocSinhRepository.save(hocSinh);
		
		apiResponse<hocSinhDTO> apiResponse = new apiResponse<hocSinhDTO>();
		apiResponse.setResult(hocSinhDTO);
		return apiResponse;
	}

	@Override
	public apiResponse<List<hocSinhDTO>> findAll(Pageable pageable) {
		List<hocSinh> listHocSinh = hocSinhRepository.findAll(pageable).getContent();
		List<hocSinhDTO> listHocSinhDTO = new ArrayList<hocSinhDTO>();
		
		for (hocSinh hocSinh : listHocSinh) {
			listHocSinhDTO.add(hocSinhMapper.toHocSinhDTO(hocSinh));
		}
		
		apiResponse<List<hocSinhDTO>> apiResponse = new apiResponse<List<hocSinhDTO>>();
		apiResponse.setResult(listHocSinhDTO);
		return apiResponse;
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			hocSinhRepository.deleteById(id);
		}
		
	}

	@Override
	public int totalItem() {
		
		return (int) hocSinhRepository.count();
	}

	
}
