package com.huyBui.quanLyHocSinh.DTO;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class khoiLopDTO {

	private int id;

	private String tenKhoi;

	private List<String> listLop;
	
}
