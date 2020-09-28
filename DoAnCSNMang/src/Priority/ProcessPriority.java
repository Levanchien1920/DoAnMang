package Priority;

import RoundRobin.Process;

class ProcessPriority extends Process{
	protected int  priorityProcessing;
	
	public ProcessPriority(int idOfProcessing, int timeArrival, int timeProcessing, int priorityProcessing) {
		super(idOfProcessing, timeArrival, timeProcessing);
		this.priorityProcessing = priorityProcessing;
	}
	
	@Override
	public void outputProcess() {
		System.out.println(idOfProcessing+" "+timeArrival+" "+timeProcessing +" "+priorityProcessing);
	}
	
	public int getPriorityProcessing() {
		return this.priorityProcessing;
	}
	
}
