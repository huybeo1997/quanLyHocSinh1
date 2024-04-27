package com.huyBui.quanLyHocSinh.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ketQua {

	LEN_LOP("Lên lớp"),
	THI_LAI("Thi lại"),
	REN_LUYEN("Rèn luyện hè"),
	O_LAI("Ở lại lớp");
	
	private String kqua;
}
