package heesung;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {
	// 페이지를 실행했을때의 시간을 담는 변수이다.
	private static long startTime = System.currentTimeMillis();
	
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        
    	long currentTime = System.currentTimeMillis();	// 최초 브라우저가 켜졌을때의 시간을 담고있다.
        long elapsedTime = (currentTime - startTime) / 1000 + 1;	// 호출될 때의 시간 - 브라우저 시작 시간 = (밀리세컨드 / 1000) + 1
        System.out.println("관리자 로그인 후 " + elapsedTime + "초 경과하였습니다."); 	// 10초 단위 홈페이지 접속 경과시간을 콘솔창으로 알려준다.
        
    }
}