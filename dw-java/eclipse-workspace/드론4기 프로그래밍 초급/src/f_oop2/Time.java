package f_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;

//	public int hour;
//	public int minute;
//	public int second;
	
	String getTime() {
		return hour + ":" + getMinute() + ":" + second;
	}
	
	// hour
	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		if (hour > 0 && hour < 24) {
			this.hour = hour;
		} else if (hour >= 24) {
			this.hour = hour - 24;
		}
	}
	
	// minute
	public int getMinute() {
		return minute;
	}
	
	public void setMinute(int minute) {
		if (minute >= 0 && minute <= 59) {
			this.minute = minute;
		} else if (minute >= 60) {
			this.hour += (minute / 60);
			this.minute = minute - 60;
		}
	}

	// second
	public int getSecond() {
		return second;
	}
	
	public void setSecond(int second) {
		if (second >= 0 && second <= 59) {
			this.second = second;
		} else if (second >= 60) {
			this.minute += (second / 60);
			this.second = second - 60;
		}
	}
	
	// 시계
	void clock() {
		while(true) {
			System.out.println(getTime());
			stop(1000);
			setSecond(second + 1);
		}
	}
	
	private void stop(int interval) {
		try {
			Thread.sleep(interval); // 1/1000 milliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}