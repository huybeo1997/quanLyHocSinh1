package com.huyBui.quanLyHocSinh.DTO;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class giaoVienDTO extends AbstractDTO{

	private String maGiaoVien;
	
	private String tenGiaoVien;

	private String gioiTinh;

	private LocalDate ngaySinh;

	private String diaChi;

	private String bangCap;

	private String totNghiepTruong;

	private String chuyenMon;

	private String email;

	private String phoneNumber;

	private List<String> ListRoleName;

	private String monGiangDay;

	private List<String> listLopChuNhiem;

	private List<String> listLopGiangDay;
}
