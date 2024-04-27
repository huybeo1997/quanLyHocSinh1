package com.huyBui.quanLyHocSinh.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KQ_LopHoc_HocKyDTO extends AbstractDTO{

	private String tenLop;

	private String namHoc;

	private String hocKy;

	private int soLuongDat;

	private String tiLe;
}
