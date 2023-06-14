package heesung;



import java.sql.Date;
import java.sql.Timestamp;

import org.quartz.Calendar;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.BaseCalendar;
import org.quartz.impl.calendar.HolidayCalendar;

public class CronModifiedTest {

	public static void main(String[] args) throws SchedulerException {

		SchedulerFactory schedFact = new StdSchedulerFactory(); 
//							ㄴ 스케줄러 팩토리의 객체를 생성한다.
		Scheduler sched = schedFact.getScheduler();		
//										ㄴ 스케줄러 팩토리를 통해 스케줄러를 가져올 수 있다.
		
		HolidayCalendar hc = new HolidayCalendar();
//						ㄴ 휴일을 의미하는 객체이다.
		Date date = Date.valueOf("2023-05-16");
//		Date date = Date.valueOf("2023-05-15");
		hc.addExcludedDate(date);	// 지정한 데이트의 일정을 HolidayCalendar에 담는다.
		
		sched.addCalendar("MyCalendar", hc, false, true);
//			 ㄴ addCalendar(캘린더명, 생성한 캘린더 객체, 캘린더에 지정된 일정을 공개 비공개 할지 여부, 스케줄러가 캘린더의 일정을 활성화 여부)
//									ㄴ HolidayCalendar (스케줄러가 지정된 일정에는 동작하지 않는다.)
//		ㅡ job이 실행할 작업의 정보를 담는다.ㅡ
		JobDetail job = JobBuilder.newJob(CronTestJob1.class)
				.withIdentity("mjob", Scheduler.DEFAULT_GROUP)
				.build();
		
//		ㅡ cron 표현식을 사용한 Trigger이다.ㅡ
		Trigger tg = (Trigger) TriggerBuilder.newTrigger()
				.withIdentity("newTrigger", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
//																ㄴ cron 표현식을 사용하면 아주 유연하게 스케줄을 지정할 수 있다.
//																				(ex:매일 지정한 시각에 Job을 반복하여 실행할 수 있다.)
				.modifiedByCalendar("MyCalendar")
				.build();
		
//		ㅡ 지정한 일정에 지정한 작업을 시작한다.ㅡ
		sched.scheduleJob(job, tg);
		sched.start();	
	}

}
