package com.huyBui.quanLyHocSinh.DTO;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class namHocDTO extends AbstractDTO{

	private String namHoc;

	private List<String> listHocKy ; 
	
	private List<String> listLop; 

	private List<String> listHSLop;

	private List<String> listPhanCongGVBomon; 

	private List<String> listDiemHS;

	private List<String> listKQHK;

	private List<String> listKq_MonHoc_Lop;

	private List<String> listKq_LopHoc_HocKy;
}
