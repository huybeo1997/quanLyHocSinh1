package com.huyBui.quanLyHocSinh.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KQ_HS_CaNamDTO extends AbstractDTO{

	private String tenHocSinh;

	private String tenLop;

	private String namHoc;

	private float diemTBHK1;

	private float diemTBHK2;

	private float diemTBCaNam;

	private String hanhKiem;

	private String ketQua;
}
