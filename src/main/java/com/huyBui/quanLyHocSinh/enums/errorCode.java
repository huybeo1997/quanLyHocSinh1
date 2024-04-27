package com.huyBui.quanLyHocSinh.enums;

public enum errorCode {
	
	UNCATEGORYZED_EXCEPTION(100,"UNCATEGORYZED"),
	USER_EXISTED(101,"ten dang nhap đã tồn tại"),
	EMAIL_INVALID_NOTBANK(102,"nhập email"),
	EMAIL_INVALID(103,"Email không hợp lệ"),
	PASSWORD_INVALID_NOTBLACK(104,"Nhập password"),
	PASSWORD_INVALID(105,"password phai co it nhat 1 ky tu thuong,1 ky tu viet hoa,/br"
			+ "1 chu so, 1 ky tu dac biet va co do dai tu 8-30"),
	CLASSNAME_INVALID_NOTBLANK(106, "Nhập tên lớp"),
	PHONE_INVALID(107,"số điện thoại không đúng"),
	USER_NOT_EXISTED(108,"tai khoan k ton tai"),
	UNAUTHENTICATED(109,"Unauthenticated"),
	CLASS_EXISTED(110,"Lớp học đã tồn tại"),
	CLASS_NOT_EXISTED(111,"Lớp học không tồn tại"),
	HOMEROOM_CLASS_NOT_EXISTED(112,"Không tìm thấy tên lớp chủ nhiệm"),
	DIEM_EXISTED(113, "điểm không tồn tại"),
	EMAIL_EXISTED(114, "email đã tồn tại"),
	HOCKY_NOT_EXISTED(115,"Học kỳ không tồn tại"),
	HS_NOT_EXISTED(116,"học sinh không tồn tại"),
	GV_NOT_EXISTED(117,"Giáo viên không tồn tại"),
	EMAIL_NOT_EXISTED(118, "email không tồn tại"),
	HS_EXISTED(119,"Hoc sinh đã tồn tại"),
	KHOI_LOP_EXISTED(120, "khối đã tồn tại"),
	KHOI_LOP_NOT_EXISTED(121,"Khối không tồn tại"),
	LOP_NOT_EXISTED(122,"lóp không tồn tại"),
	NAM_HOC_EXISTED(123,"Năm học đã tồn tại"),
	NAM_HOC_NOT_EXISTED(124,"Năm học không tồn tại")
	;
	
	private int code;
	private String message;

	private errorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
}
