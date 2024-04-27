package com.huyBui.quanLyHocSinh.DTO;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class hocKyDTO extends AbstractDTO{

	private String tenHocKy;
	
	private String NamHoc;
	
	private List<String> listDiemHSMonHoc;

	private List<String> listKQHKHocSinh;

	private List<String> listKq_MonHoc_Lop;

	private List<String> listKq_LopHoc_HocKy ;

	private List<String> listLop;
}
