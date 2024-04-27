package com.huyBui.quanLyHocSinh.DTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AbstractDTO{

	private long id;
	
	private LocalDate createdDate;
	
	private LocalDate modifiedDate;
	
	private String createdBy;
	
	private String modifiedBy;
}
