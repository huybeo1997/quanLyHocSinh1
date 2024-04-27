package com.huyBui.quanLyHocSinh.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class diemThiMonHocDTO extends AbstractDTO{

	private String tenHocSinh;

	private String tenMonHoc;

	private String tenHocKy;

	private String namHoc;

	private String tenLop;

	private danhSachDiemDTO danhSachDiemDTO;
}
