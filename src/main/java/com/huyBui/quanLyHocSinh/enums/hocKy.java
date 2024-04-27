package com.huyBui.quanLyHocSinh.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum hocKy {
	
	HK1("học kỳ 1", 1),
	HK2("học kỳ 2", 2);

	private String tenHocKy;
	private int heSo;

	
}
