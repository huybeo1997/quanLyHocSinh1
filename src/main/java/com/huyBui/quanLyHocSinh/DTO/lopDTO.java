package com.huyBui.quanLyHocSinh.DTO;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class lopDTO extends AbstractDTO {

	private String tenLop;

	private int siSo;

	private String tenKhoi;

	private String namHoc;

	private String hocKy;

	private String giaoVienChuNhiem;

	private List<String> listHocSinh;

	private List<String> listGVBoMon;

	private List<String> listDiemHS;

	private List<String> listKQHKHocSinh;

	private List<String> listKq_MonHoc_Lop;

	private List<String> listkKq_LopHoc_HocKy;
	

}
