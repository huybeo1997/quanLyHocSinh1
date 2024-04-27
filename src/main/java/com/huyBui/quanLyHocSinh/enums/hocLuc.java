package com.huyBui.quanLyHocSinh.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum hocLuc {

	KHA("khá"),
	TB("trung bình"),
	GIOI("Giỏi"),
	YEU("yếu");
	
	private String tenHocLuc;
}
