package kr.or.dw.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int rno;
	private int bno;
	private String replyer;
	private String replytext;
	private Date regdate;
	private Date updatedate;

	public ReplyVO() {}

	public ReplyVO(int rno, int bno, String replyer, String replytext, Date regdate, Date updatedate) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.replyer = replyer;
		this.replytext = replytext;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}
}
