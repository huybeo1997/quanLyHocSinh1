package com.huyBui.quanLyHocSinh.DTO;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class adminDTO {

	private int id;
	
	private String adminName;
	
	private String email;
	
	private String passWord;
	
	private List<String> listRoleName;
}
