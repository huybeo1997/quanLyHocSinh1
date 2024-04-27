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
@Table(name = "hocsinh")
public class hocSinh extends base{


	@Column(name = "mahs",unique = true)
	@NotBlank
	private String maHocSinh;
	
	@Column(name = "tenhocsinh")
	@NotBlank
	private String tenHocSinh;
	
	@Column(name = "gioitinh")
	private String gioiTinh;
	
	@Column(name = "ngaysinh")
	private LocalDate ngaySinh;
	
	@Column(name = "diachi")
	private String diaChi;
	
	@Column(name = "dantoc")
	private String danToc;
	
	@Column(name = "tongiao")
	private String tonGiao;

	@Column(name = "phonenumber")
	@Pattern(regexp = "^[0-9]{10,11}$", message = "PHONE_INVALID")
	private String phoneNumber;
	
	@Column(unique = true)
	@Email(message = "EMAIL_INVALID")
	@NotBlank(message = "EMAIL_INVALID_NOTBANK")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id",referencedColumnName = "id")
	private account account;
	
	@ManyToMany(fetch = FetchType.EAGER  , cascade = CascadeType.PERSIST)
	@JoinTable(name = "hocsinh_role",
			joinColumns = @JoinColumn(name="hocsinh_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<role> roles;
	
	@OneToMany(mappedBy = "hocSinh")
	private List<phanLop> listPhanLop;
	
	@OneToMany(mappedBy = "hocSinh")
	private List<diemThiMonHoc> listDiemThiMonHoc;
	
	@OneToMany(mappedBy = "hocSinh")
	private List<KQ_HS_HocKy> listKQHK;
	
	@OneToMany(mappedBy = "hocSinh")
	private List<KQ_HS_CaNam> listKQCaNam;
	
}
