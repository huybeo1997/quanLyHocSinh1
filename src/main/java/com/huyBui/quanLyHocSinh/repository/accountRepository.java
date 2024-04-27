package com.huyBui.quanLyHocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyBui.quanLyHocSinh.Entity.account;

public interface accountRepository extends JpaRepository<account, Long>{

	account findByEmail(String email);
}
