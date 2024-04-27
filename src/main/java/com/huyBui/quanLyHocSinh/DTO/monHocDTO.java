package com.huyBui.quanLyHocSinh.DTO;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class monHocDTO {

	private int id;

	private String maMonHoc;

	private String tenMonHoc;

	private int soTiet;

	private int heSo;

	private List<String> listGiaoVien;

	private List<String> listPhanCongGVBomon;

	private List<String> listDiemHS;

	private List<String> listKq_MonHoc_Lop;
}
