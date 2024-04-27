package com.huyBui.quanLyHocSinh.Entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "giaovien")
public class giaoVien extends base {

	@Column(name = "maGV",unique = true)
	@NotBlank
	private String maGiaoVien;
	
	@Column(name = "tengiaovien")
	@NotBlank
	private String tenGiaoVien;
	
	@Column(name = "gioitinh")
	private String gioiTinh;
	
	@Column(name = "ngaysinh")
	private LocalDate ngaySinh;
	
	@Column(name = "diachi")
	private String diaChi;
	
	@Column(name = "bangcap")
	private String bangCap;
	
	@Column(name = "totnghieptruong")
	private String totNghiepTruong;
	
	@Column(name = "chuyenmon")
	private String chuyenMon;
	
	@Column
	@Email(message = "EMAIL_INVALID")
	@NotBlank(message = "EMAIL_INVALID_NOTBANK")
	private String email;
	
	@Column(name = "phonenumber")
	@Pattern(regexp = "^[0-9]{10}$", message = "PHONE_INVALID")
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id",referencedColumnName = "id")
	private account account;
	
	@ManyToMany(fetch = FetchType.EAGER  , cascade = CascadeType.PERSIST)
	@JoinTable(name = "giaovien_role",
			joinColumns = @JoinColumn(name="giaovien_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<role> roles;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_monhoc")
	private monHoc monHoc;
	
	@OneToMany(mappedBy = "giaoVienChuNhiem")
	private List<lop> listLop;
	
	@OneToMany(mappedBy = "giaoVien")
	private List<phanCongGVBomon> lisPhanCongGVBomon;
}
