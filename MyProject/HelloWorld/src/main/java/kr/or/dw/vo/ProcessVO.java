package kr.or.dw.vo;

import lombok.Data;

@Data
public class ProcessVO {
	private String pc_no;
	private String pc_code;
	private String pc_name;
	private String pc_order;

	public ProcessVO() {}
	
	public ProcessVO(String pc_no, String pc_code, String pc_name, String pc_order) {
		this.pc_no = pc_no;
		this.pc_code = pc_code;
		this.pc_name = pc_name;
		this.pc_order = pc_order;
	}
}
