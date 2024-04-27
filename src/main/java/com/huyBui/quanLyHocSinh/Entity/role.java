package com.huyBui.quanLyHocSinh.Entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "rolename")
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	private Set<admin> listAdmin;
	
	@ManyToMany(mappedBy = "roles")
	private Set<giaoVien> listGiaoVien;
	
	@ManyToMany(mappedBy = "roles")
	private Set<hocSinh> listHocSinh;
}
