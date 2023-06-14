package kr.or.dw.basic.upload;

// Upload된 파일 정보가 저장될 Class
public class UploadDetail {
	private long fileSize;			// 파일 용량
	private String fileName;		// 파일 이름
	private String uploadStatus;	// 업로드 성공 여부
	
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	
	
}
