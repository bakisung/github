package kr.or.dw.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AttachVO {

	private int ano;
	private String uploadPath;
	private String fileName;
	private String fileType;
	private int pno;
	private String attacher;
	private Date regdate;
	
}
