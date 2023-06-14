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
		Scheduler sched = schedFact.getScheduler();
		
		HolidayCalendar hc = new HolidayCalendar();

		Date d = Date.valueOf("2023-05-12");
//		Timestamp t = Timestamp.valueOf("2023-05-12 01:33:00");
//		hc.addExcludedDate(new Date(3000));
		hc.addExcludedDate(d);
//		hc.addExcludedDate(t);
		
		
		// 파라미터(캘린더이름, 생성한 달력객체, 중복허용 안함, 등록된 트리거를 업데이트해야함 재시작시에도 유지함)
		sched.addCalendar("MyCalendar", hc, false, true);
		
		JobDetail job = JobBuilder.newJob(CronTestJob1.class)
				.withIdentity("mjob", Scheduler.DEFAULT_GROUP)
				.build();
		
		Trigger tg = (Trigger) TriggerBuilder.newTrigger()
				.withIdentity("newTrigger", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
				.modifiedByCalendar("MyCalendar")
				.build();
		
		sched.scheduleJob(job, tg);
		
		sched.start();
	}

}
