package heesung;



import org.quartz.DateBuilder;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerTest {

	public static void main(String[] args) throws SchedulerException {
		
//		ㅡ 스케줄러 팩토리의 인스턴스를 통해 스케줄러를 생성할 수 있다.ㅡ 
		SchedulerFactory sdf = new StdSchedulerFactory();
    	Scheduler sched = sdf.getScheduler();
    	
//=================================첫번째 스케줄러=================================
    	
//    	ㅡ job은 SimpleTriggerJob1.class의 내용을 실행한다.ㅡ
    	JobDetail job = JobBuilder.newJob(SimpleTriggerJob1.class)
    			.withIdentity("stjob", Scheduler.DEFAULT_GROUP)
    			.build();
//    	ㅡ trigger를 통해 job이 실행될 시점을 지정한다.ㅡ
    	Trigger trigger = TriggerBuilder.newTrigger()
    			.withIdentity("SimpleTrigger", "group1")
//    			.startNow()
    			.startAt(DateBuilder.futureDate(5, IntervalUnit.SECOND))
//    													ㄴ 해당하는 스케줄러가 실행 시점으로부터 5초뒤에 동작한다.
    			.endAt(DateBuilder.futureDate(6, IntervalUnit.SECOND))
//    													ㄴ 해당하는 스케줄러가 실행 시점으로부터 6초뒤에 정지한다.
    			.withSchedule(SimpleScheduleBuilder.simpleSchedule()
	    			.withIntervalInSeconds(1)
//		    		.withRepeatCount(5)
	    			.repeatForever())
					.build();
    	
    	sched.scheduleJob(job, trigger);
//			ㄴ 실행한 작업과 시점을 스케줄러에 담아준다.    	
    	
    	
//=================================두번째 스케줄러=================================
    	
    	JobDetail jod2 = JobBuilder.newJob(SimpleTriggerJob2.class)
    			.withIdentity("stjob1", Scheduler.DEFAULT_GROUP)
    			.build();
    	
    	Trigger trigger2 = TriggerBuilder.newTrigger()
    			.withIdentity("SimpleTrigger1", "group2")
//    			.startNow()
    			.startAt(DateBuilder.futureDate(1, IntervalUnit.SECOND))
//    													ㄴ 해당하는 스케줄러가 실행 시점으로부터 1초뒤에 동작한다.
    			.endAt(DateBuilder.futureDate(10, IntervalUnit.SECOND))
//    													ㄴ 해당하는 스케줄러가 실행 시점으로부터 10초뒤에 정지한다.
    			.withSchedule(SimpleScheduleBuilder.simpleSchedule()
		    			.withIntervalInSeconds(1)
//		    			.withRepeatCount(5)
		    			.repeatForever()
		    			)
    			.build();
    	sched.scheduleJob(jod2, trigger2);
    	
    	sched.start();
//    			ㄴ 하나의 스케줄러에 등록된 두개의 job을 실행한다.
//    				ㄴ SimpleTriggerJob1, SimpleTriggerJob2는 각각 다른 동작시간과 정지시간을 갖고 있다.
//    					ㄴ 즉, 별도로 분리해서 실행할 수 있다는것이다.
	}
}
