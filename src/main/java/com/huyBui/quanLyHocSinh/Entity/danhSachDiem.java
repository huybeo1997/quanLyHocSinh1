package com.huyBui.quanLyHocSinh.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "loaidiem")
public class danhSachDiem{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ktramieng")
	@Min(0)
	@Max(10)
	private float kTraMieng;
	
	@Column(name = "ktra15p")
	@Min(0)
	@Max(10)
	private float kTra15p;
	
	@Column(name = "ktra1tiet")
	@Min(0)
	@Max(10)
	private float kTra1Tiet;
	
	@Column(name = "ktrahocky")
	@Min(0)
	@Max(10)
	private float kTraHocKy;
	
	@Column(name = "tbmon")
	@Min(0)
	@Max(10)
	private float TBMon;
	
	@OneToOne(mappedBy = "danhSachDiem")
	private diemThiMonHoc diemThiMonHoc;
	
	
}
