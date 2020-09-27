package RoundRobin;

public class Process {
	private int idOfProcessing;
	private int timeArrival;
	private int timeProcessing;

	public Process(int idOfProcessing, int timeArrival, int timeProcessing) {
		super();
		this.idOfProcessing = idOfProcessing;
		this.timeArrival = timeArrival;
		this.timeProcessing = timeProcessing;
	}

	public int getIdOfProcessing() {
		return idOfProcessing;
	}

	public void setIdOfProcessing(int idOfProcessing) {
		this.idOfProcessing = idOfProcessing;
	}

	public int getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(int timeArrival) {
		this.timeArrival = timeArrival;
	}

	public int getTimeProcessing() {
		return timeProcessing;
	}

	public void setTimeProcessing(int timeProcessing) {
		this.timeProcessing = timeProcessing;
	}
	
	public void outputProcess() {
		System.out.println(idOfProcessing+" "+timeArrival+" "+timeProcessing);
	}

}