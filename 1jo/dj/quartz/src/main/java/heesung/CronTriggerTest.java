package heesung;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerTest {
	private SchedulerFactory schedFact;
	private Scheduler sched;
	
	public CronTriggerTest() {
		try {
			
//		ㅡ 스케줄러 팩토리의 인스턴스를 통해 스케줄러를 생성할 수 있다.ㅡ 
			schedFact = new StdSchedulerFactory();
			sched = schedFact.getScheduler();
			
//=================================첫번째 스케줄러=================================
	    	
//	    	ㅡ job1은 CronTestJob1.class의 내용을 실행한다.ㅡ
			JobDetail job1 = JobBuilder.newJob(CronTestJob1.class)
					.withIdentity("cJob1", Scheduler.DEFAULT_GROUP)
					.build();
			Trigger tg1 = (Trigger) TriggerBuilder.newTrigger()
					.withIdentity("CronTrigger1", "c_group1")
					.startNow()
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 10 10-11 * * ?"))
//																		ㄴ 0/5가 속한 위치는 "초" 필드이며, 0부터 시작하여 5초 간격으로 실행됨을 의미한다.
//																		ㄴ 0이 속한 위치는 "분" 필드이며, 매 시각 0분에 실행됨을 의미한다.
//																		ㄴ 10-11이 속한 위치는 "시" 필드이며, 10시부터 11시까지 실행됨을 의미한다.
//																		ㄴ 첫번째 * 이 속한 위치는 "일" 필드이며, * 이므로 해당 월의 모든 날에 실행된다.
//																		ㄴ 두번째 * 이 속한 위치는 "월" 필드이며, * 이므로 모든 월에 작업이 실행된다.
//																		ㄴ ?가 속한 위치는 "요일" 필드이며, 지정되지 않았다.
//					.modifiedByCalendar("test")
					.build();
			sched.scheduleJob(job1, tg1);
//						ㄴ 첫번째 스케줄러의 작업 내용과 실행 시점을 담고 있다.
			

//=================================두번째 스케줄러=================================
	    	
//	    	ㅡ job1은 CronTestJob2.class의 내용을 실행한다.ㅡ
			JobDetail job2 = JobBuilder.newJob(CronTestJob2.class)
					.withIdentity("cJob2", Scheduler.DEFAULT_GROUP)
					.build();
			Trigger tg2 = (Trigger) TriggerBuilder.newTrigger()
					.withIdentity("CronTrigger2", "c_group2")
					.startNow()
					.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * 10-11 * * ?"))
					.build();
					
			sched.scheduleJob(job2, tg2);
//			ㄴ 두번째 스케줄러의 작업 내용과 실행 시점을 담고 있다.
			
			sched.start();
//				ㄴ 하나의 스케줄러에 등록된 두개의 job을 실행한다.
//					ㄴ SimpleTriggerJob1, SimpleTriggerJob2는 각각 다른 동작시간과 정지시간을 갖고 있다.
//						ㄴ 즉, 별도로 분리해서 실행할 수 있다는것이다.
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
//	ㅡ 아래와 같이 따로 클래스에 만들어서 메서드를 호출하여 실행하는 방법도 있다.ㅡ
	public static void main(String[] args) {
		new CronTriggerTest();
	}
}
