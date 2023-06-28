package kr.or.dw.vo;

import java.util.Date;	// util로 임포트해야 시분초까지 나온다

import lombok.Data;

@Data	// <- 롬복에서 게터 세터를 생성해준다. 롬복으로 인해 게터세터를 따로 추가해줄 필요가 없어졌다.
public class BoardVO {
	
	private int bno         ;
	private String title       ;
	private String writer      ;
	private String content     ;
	private Date regdate     ;
	private int viewcnt     ;
	private Date updatedate  ;
	private int replycnt;	// 댓글수
	
	public BoardVO() {}

	public BoardVO(int bno, String title, String writer, String content, Date regdate, int viewcnt, Date updatedate) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.updatedate = updatedate;
	}

}
