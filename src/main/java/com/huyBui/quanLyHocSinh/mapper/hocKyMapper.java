package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.hocKyDTO;
import com.huyBui.quanLyHocSinh.Entity.KQ_HS_HocKy;
import com.huyBui.quanLyHocSinh.Entity.KQ_LopHoc_HocKy;
import com.huyBui.quanLyHocSinh.Entity.KQ_MonHoc_Lop;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;
import com.huyBui.quanLyHocSinh.Entity.hocKy;
import com.huyBui.quanLyHocSinh.Entity.lop;

@Mapper(componentModel = "spring")
public abstract class hocKyMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "listDiem", ignore = true)
	@Mapping(target = "listKQHK", ignore = true)
	@Mapping(target = "listkKq_MonHoc_Lop", ignore = true)
	@Mapping(target = "listKq_LopHoc_HocKy", ignore = true)
	@Mapping(target = "listLop", ignore = true)
	public abstract hocKy toHocKyEntity(hocKyDTO hocKyDTO);
	
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "listDiem", ignore = true)
	@Mapping(target = "listKQHK", ignore = true)
	@Mapping(target = "listkKq_MonHoc_Lop", ignore = true)
	@Mapping(target = "listKq_LopHoc_HocKy", ignore = true)
	@Mapping(target = "listLop", ignore = true)
	public abstract hocKy toHocKyEntity(@MappingTarget hocKy hocKy,hocKyDTO hocKyDTO);
	
	@Mapping(target = "namHoc", source = "namHoc")
	@Mapping(target = "listDiemHSMonHoc", source = "listDiem")
	@Mapping(target = "listKQHKHocSinh", source = "listKQHK")
	@Mapping(target = "listKq_MonHoc_Lop", source = "listkKq_MonHoc_Lop")
	@Mapping(target = "listKq_LopHoc_HocKy", source = "listKq_LopHoc_HocKy")
	@Mapping(target = "listLop", source = "listLop")
	public abstract hocKyDTO toHocKyDTO(hocKy hocKy);
	
	public String fromDiemThiMonHoc(diemThiMonHoc diemThiMonHoc) {
		return diemThiMonHoc.getMonHoc().getMaMonHoc();
	}

	public String fromKQHSHocKy(KQ_HS_HocKy kq_HS_HocKy) {
		return kq_HS_HocKy.getHocSinh().getTenHocSinh();
	}

	public String fromKQMonHocLop(KQ_MonHoc_Lop kq_MonHoc_Lop) {
		return kq_MonHoc_Lop.getMonHoc().getMaMonHoc();
	}

	public String fromKQLopHocHocKy(KQ_LopHoc_HocKy kq_LopHoc_HocKy) {
		return kq_LopHoc_HocKy.getLop().getTenLop();
	}

	public String fromLop(lop lop) {
		return lop.getTenLop();
	}
	
	public String fromNamHoc(NamHoc namHoc) {
		return namHoc.getNamHoc();
	}
}
