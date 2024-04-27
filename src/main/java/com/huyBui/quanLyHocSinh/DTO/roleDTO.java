package com.huyBui.quanLyHocSinh.DTO;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class roleDTO {

	private int id;
	private String roleName;
	private List<hocSinhDTO> listHocSinh;
	private List<giaoVienDTO> listGiaoVien;
	private List<adminDTO>	listAdmin;
}
