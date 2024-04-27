package com.huyBui.quanLyHocSinh.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KQ_HS_HocKyDTO extends AbstractDTO{

	private String tenHocSinh;

	private String tenLop;

	private String tenHocKy;

	private String namHoc;

	private float diemTBHK;

	private String hanhKiem;

	private String hocLuc;
}
