package com.huyBui.quanLyHocSinh.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum loaiDiem {

	KT_MIENG("Kiểm tra miệng",1),
	KT_15P("Kiểm tra 15p",1),
	KT_1TIET("Kiểm tra 1 tiết",2),
	KT_HOC_KY("Kiểm tra học kỳ",1);
	
	private String tenBaiKiemTra;
	private int heSo;
	
}
