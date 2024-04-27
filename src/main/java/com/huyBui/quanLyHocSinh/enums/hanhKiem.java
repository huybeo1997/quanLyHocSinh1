package com.huyBui.quanLyHocSinh.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum hanhKiem {

	HKT("Hạnh kiểm tốt"),
	HKK("Hạnh kiểm khá"),
	HKTB("Hạnh kiểm Tb"),
	HKY("Hạnh kiểm yếu");
	
	private String tenHanhKiem;
}
