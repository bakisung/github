package kr.or.dw.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.dw.vo.PdsVO;
import lombok.Data;

@Data
public class PdsRegistCommand {

	private String title;
	private String content;
	private String writer;
	private List<MultipartFile> uploadFile;
	
	public PdsVO toPdsVO() {
		PdsVO pds = new PdsVO();
		pds.setContent(content);
		pds.setTitle(title);
		pds.setWriter(writer);
		
		return pds;
	}
}
