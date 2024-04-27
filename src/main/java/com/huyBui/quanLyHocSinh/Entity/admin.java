package com.huyBui.quanLyHocSinh.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "adminname")
	private String adminName;

	@Column(unique = true)
	@Email(message = "email khong hop le")
	@NotBlank(message = "nhap email")
	private String email;
	
	@Column(name = "password")
	private String passWord;
	
	@ManyToMany(fetch = FetchType.EAGER  , cascade = CascadeType.PERSIST)
	@JoinTable(name = "admin_role",
			joinColumns = @JoinColumn(name="admin_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<role> roles;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id",referencedColumnName = "id")
	private account account;
}
