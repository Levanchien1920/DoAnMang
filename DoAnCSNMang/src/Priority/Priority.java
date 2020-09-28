package Priority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import RoundRobin.Process;
import RoundRobin.TimeLine;

public class Priority {
	int totaOfPrcess;
	List<ProcessPriority> listProcess;
	List<ProcessPriority> readyListProcesses = new ArrayList<ProcessPriority>();
	List<TimeLine> timeLine = new ArrayList<TimeLine>();
	
	public Priority(int totalofprocess, List<ProcessPriority> listprocess) {
		super();
		this.totaOfPrcess = totalofprocess;
		this.listProcess = listprocess;
		this.listProcess.sort(Comparator.comparing(ProcessPriority::getTimeArrival));
	}
	
	
	
	public void outputListProcess() {
		System.out.println("Id\tArrival time\tExecute time\tPriority");
		for (ProcessPriority process : listProcess) {
			System.out.println(process.getIdOfProcessing()+"\t"+process.getTimeArrival()+"\t\t"+process.getTimeProcessing()+"\t\t"+process.getPriorityProcessing());
		}
	}
	
	public void outputListTimeLine() {
		System.out.println("Time line:");
		for (TimeLine tl : timeLine) {
			tl.outputTimeLine();
		}
	}
	
	public void toReadyList(int start, int end) {
		if(start > end)
			return;
		else {
			for (ProcessPriority process : listProcess) {
				if(process.getTimeArrival() > start && process.getTimeArrival()<=end) {
					readyListProcesses.add(process);
				}
			}
		}
		Collections.sort(this.readyListProcesses, new Comparator<ProcessPriority>() {
		      @Override
		      public int compare(final ProcessPriority object1, final ProcessPriority object2) {
		          if(object1.getPriorityProcessing() > object2.getPriorityProcessing()) {
		        	  return 1;
		          }
		          if(object1.getPriorityProcessing() == object2.getPriorityProcessing() && object1.getTimeArrival() > object2.getTimeArrival()) {
		        	  return 1;
		          }
		          return -1;
		      }
		  });
	}
	
	public void SchedulingPreemptive() {
		int countProcess = totaOfPrcess;
		int start = listProcess.get(0).getTimeArrival();
		toReadyList(-1,  listProcess.get(0).getTimeArrival());
		for (Process process : readyListProcesses) {
			System.out.print(process.getIdOfProcessing()+" ");
		}
		System.out.println();
		while(countProcess != 0) {
			if(readyListProcesses.isEmpty()) {
				return;
			}
			Process temp = readyListProcesses.get(0);
			int indexTime = temp.getTimeProcessing();
			readyListProcesses.remove(0);
			countProcess--;
			toReadyList(start, start+indexTime);
			
			
			TimeLine tl = new TimeLine(Integer.toString(temp.getIdOfProcessing()), start, start+indexTime);
			this.timeLine.add(tl);
			start= start+indexTime;	
			
			for (Process process : readyListProcesses) {
				System.out.print(process.getIdOfProcessing()+" ");
			}
			System.out.println();
		}
	}
}
