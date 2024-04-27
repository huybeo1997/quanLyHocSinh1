package com.huyBui.quanLyHocSinh.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table
public class account extends base{
	
	@Column(unique = true)
	@Email(message = "EMAIL_INVALID")
	@NotBlank(message = "EMAIL_INVALID_NOTBANK")
	private String email;
	
	@Column(name = "password")
	@NotBlank(message = "PASSWORD_INVALID_NOTBLACK")
	//check password phai co it nhat 1 ky tu thuong,1 ky tu viet hoa,
	//1 chu so, 1 ky tu dac biet va co do dai tu 8-30
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_+,?-]).{8,50}$",
			message = "PASSWORD_INVALID")
	private String passWord;
	
	@OneToOne(mappedBy = "account")
	private hocSinh hocSinh;
	
	@OneToOne(mappedBy = "account")
	private giaoVien giaoVien;
	
	@OneToOne(mappedBy = "account")
	private admin admin;
}
