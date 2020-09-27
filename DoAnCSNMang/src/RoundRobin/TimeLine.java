package RoundRobin;

public class TimeLine {
	int startTimeLine;
	int endTimeLine;
	String nameTimeLine;
	
	public TimeLine(String name, int start, int end) {
		this.nameTimeLine = name;
		this.startTimeLine = start;
		this.endTimeLine = end;
	}
	
	public void outputTimeLine() {
		System.out.print("|"+ startTimeLine + "-"+ nameTimeLine +"-" + endTimeLine + "|");
	}
	
	public int getRunTime() {
		return endTimeLine - startTimeLine;
	}
}
