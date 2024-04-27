package com.huyBui.quanLyHocSinh.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class danhSachDiemDTO {

	private int id;

	private float kTraMieng;

	private float kTra15p;

	private float kTra1Tiet;

	private float kTraHocKy;

	private float TBMon;

	private long id_diemThiMonHocDTO;
}
