package com.huyBui.quanLyHocSinh.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KQ_MonHoc_LopDTO extends AbstractDTO{

	private String tenLop;

	private String namHoc;

	private String hocKy;

	private String tenMonHoc;

	private int soLuongDat;

	private float tiLe;
}
