package heesung;

import java.io.PrintWriter;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {
	// 페이지를 실행했을때의 시간을 담는 변수이다.
	private static long startTime = System.currentTimeMillis();
	
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        
    	// 호출될때의 시간을 담고있다.
    	long currentTime = System.currentTimeMillis();
    	
    	// 호출될 때의 시간 - 페이지 시작 시간 = (밀리세컨드 / 1000) + 1
        long elapsedTime = (currentTime - startTime) / 1000 + 1;
        System.out.println("홈페이지 접속 후 " + elapsedTime + "초 경과하였습니다.");
        
    }
}