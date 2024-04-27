package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.huyBui.quanLyHocSinh.DTO.KQ_MonHoc_LopDTO;
import com.huyBui.quanLyHocSinh.Entity.KQ_MonHoc_Lop;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.hocKy;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.Entity.monHoc;

@Mapper(componentModel = "spring")
public abstract class KQ_MonHoc_LopMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "hocKy", ignore = true)
	@Mapping(target = "monHoc", ignore = true)
	public abstract KQ_MonHoc_Lop toKQ_MonHoc_LopEntity(KQ_MonHoc_LopDTO kq_MonHoc_LopDTO);
	
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "hocKy", ignore = true)
	@Mapping(target = "monHoc", ignore = true)
	public abstract KQ_MonHoc_Lop toKQ_MonHoc_LopEntity(@MappingTarget KQ_MonHoc_Lop kq_MonHoc_Lop,KQ_MonHoc_LopDTO kq_MonHoc_LopDTO);
	
	@Mapping(target = "tenLop", source = "lop")
	@Mapping(target = "namHoc", source = "namHoc")
	@Mapping(target = "hocKy", source = "hocKy")
	@Mapping(target = "tenMonHoc", source = "monHoc")
	public abstract KQ_MonHoc_LopDTO toKQ_MonHocLopDTO(KQ_MonHoc_Lop kq_MonHoc_Lop);
	
	public String fromLop(lop lop) {
		return lop.getTenLop();
	}
	
	public String fromNamHoc(NamHoc namHoc) {
		return namHoc.getNamHoc();
	}
	
	public String fromHocKy(hocKy hocKy) {
		return hocKy.getTenHocKy();
	}
	
	public String fromMonHoc(monHoc monHoc) {
		return monHoc.getMaMonHoc();
	}
}
