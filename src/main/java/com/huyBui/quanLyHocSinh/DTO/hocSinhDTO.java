package com.huyBui.quanLyHocSinh.DTO;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class hocSinhDTO extends AbstractDTO{

	private String maHocSinh;
	
	private String tenHocSinh;

	private String gioiTinh;

	private LocalDate ngaySinh;

	private String diaChi;

	private String danToc;

	private String tonGiao;

	private String phoneNumber;

	private String email;

	private List<String> listRoleName;

	private List<String> listLop;

	private List<String> listDiemThiMonHoc;

	private List<String> listKQHocKy;
	
	private List<String> listKQCaNam;
}
