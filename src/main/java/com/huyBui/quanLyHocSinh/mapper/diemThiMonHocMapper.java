package com.huyBui.quanLyHocSinh.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.huyBui.quanLyHocSinh.DTO.danhSachDiemDTO;
import com.huyBui.quanLyHocSinh.DTO.diemThiMonHocDTO;
import com.huyBui.quanLyHocSinh.Entity.NamHoc;
import com.huyBui.quanLyHocSinh.Entity.danhSachDiem;
import com.huyBui.quanLyHocSinh.Entity.diemThiMonHoc;
import com.huyBui.quanLyHocSinh.Entity.hocKy;
import com.huyBui.quanLyHocSinh.Entity.hocSinh;
import com.huyBui.quanLyHocSinh.Entity.lop;
import com.huyBui.quanLyHocSinh.Entity.monHoc;

@Mapper(componentModel = "spring")
public abstract class diemThiMonHocMapper {
	
	@Autowired
	private danhSachDiemMapper danhSachDiemMapper;

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "hocSinh", ignore = true)
	@Mapping(target = "monHoc", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "hocKy", ignore = true)
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "danhSachDiem", source = "danhSachDiemDTO")
	public abstract diemThiMonHoc toDiemThiMonHocEntity(diemThiMonHocDTO diemThiMonHocDTO);
	
	@Mapping(target = "hocSinh", ignore = true)
	@Mapping(target = "monHoc", ignore = true)
	@Mapping(target = "namHoc", ignore = true)
	@Mapping(target = "hocKy", ignore = true)
	@Mapping(target = "lop", ignore = true)
	@Mapping(target = "danhSachDiem", source = "danhSachDiemDTO")
	public abstract diemThiMonHoc toDiemThiMonHocEntity(@MappingTarget diemThiMonHoc diemThiMonHoc,diemThiMonHocDTO diemThiMonHocDTO);
	
	@Mapping(target = "tenHocSinh", source = "hocSinh")
	@Mapping(target = "tenMonHoc", source = "monHoc")
	@Mapping(target = "namHoc", source = "namHoc")
	@Mapping(target = "tenHocKy", source = "hocKy")
	@Mapping(target = "tenLop", source = "lop")
	@Mapping(target = "danhSachDiemDTO", source = "danhSachDiem")
	public abstract diemThiMonHocDTO toDiemThiMonHocDTO(diemThiMonHoc diemThiMonHoc);
	
	
	public String fromHocSinh(hocSinh hocSinh) {
		return hocSinh.getTenHocSinh();
	}

	public String fromMonHoc(monHoc monHoc) {
		return monHoc.getTenMonHoc();
	}

	public String fromNamHoc(NamHoc namHoc) {
		return namHoc.getNamHoc();
	}

	public String fromHocKy(hocKy hocKy) {
		return hocKy.getTenHocKy();
	}

	public String fromLop(lop lop) {
		return lop.getTenLop();
	}

	public danhSachDiem fromDanhSachDiemDTO(danhSachDiemDTO danhSachDiemDTO) {
		return danhSachDiemMapper.toDanhSachDiemEntity(danhSachDiemDTO);
	}
	
	public danhSachDiemDTO fromDanhSachDiem(danhSachDiem danhSachDiem) {
		return danhSachDiemMapper.toDanhSachDiemDTO(danhSachDiem);
	}
}
