package com.huyBui.quanLyHocSinh.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class phanCongGVBoMonDTO extends AbstractDTO{

	private String namHoc;

	private String lop;

	private String monHoc;

	private String giaoVien;
}
