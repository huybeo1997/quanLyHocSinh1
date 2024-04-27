package com.huyBui.quanLyHocSinh.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.DTO.adminDTO;
import com.huyBui.quanLyHocSinh.Entity.account;
import com.huyBui.quanLyHocSinh.Entity.admin;
import com.huyBui.quanLyHocSinh.Entity.role;
import com.huyBui.quanLyHocSinh.enums.errorCode;
import com.huyBui.quanLyHocSinh.exception.AppException;
import com.huyBui.quanLyHocSinh.mapper.adminMapper;
import com.huyBui.quanLyHocSinh.repository.accountRepository;
import com.huyBui.quanLyHocSinh.repository.adminRepository;
import com.huyBui.quanLyHocSinh.repository.roleRepository;
import com.huyBui.quanLyHocSinh.service.IAdminService;

@Service
public class adminService implements IAdminService {

	@Autowired
	private adminRepository adminRepository;

	@Autowired
	private adminMapper adminMapper;

	@Autowired
	private accountRepository accountRepository;
	
	@Autowired
	private roleRepository roleRepository;

	@Override
	public List<adminDTO> findAll() {
		List<admin> listAdmin = adminRepository.findAll();
		List<adminDTO> listAdminDTO = new ArrayList<adminDTO>();
		for (admin admin : listAdmin) {
			listAdminDTO.add(adminMapper.toAdminDTO(admin));
		}
		return listAdminDTO;
	}

	@Override
	public apiResponse<adminDTO> createAdmin(adminDTO adminDTO) {
		admin admin = adminRepository.findByEmail(adminDTO.getEmail());
		Set<role> listRole = new HashSet<role>();
		if (admin != null) {
			throw new AppException(errorCode.USER_EXISTED);
		}
		admin = adminMapper.toAdminEntity(adminDTO);

		Set<String> listRoleName = Set.copyOf(adminDTO.getListRoleName());

		// them Set<role> vao admin
		for (String roleName : listRoleName) {
			listRole.add(roleRepository.findByRoleName(roleName));
		}
		admin.setRoles(listRole);
		admin = adminRepository.save(admin);

		account account = accountRepository.findByEmail(adminDTO.getEmail());
		admin.setAccount(account);
		
		admin = adminRepository.save(admin);
		
		apiResponse<adminDTO> apiResponse = new apiResponse<adminDTO>();
		apiResponse.setResult(adminMapper.toAdminDTO(admin));

		return apiResponse;
	}

}
