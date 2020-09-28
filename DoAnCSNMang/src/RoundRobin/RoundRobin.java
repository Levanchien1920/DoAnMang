package RoundRobin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RoundRobin {
	int totaOfPrcess;
	int  timeQuantum;
	List<Process> listProcess;
	List<Process> readyListProcesses = new ArrayList<Process>();
	List<TimeLine> timeLine = new ArrayList<TimeLine>();

	public RoundRobin(int totalofprocess, int timequantum, List<Process> listprocess) {
		super();
		this.totaOfPrcess = totalofprocess;
		this.timeQuantum = timequantum;
		this.listProcess = listprocess;
		this.listProcess.sort(Comparator.comparing(Process::getTimeArrival)); //sort list process by time arrival
	}
	
	public void outputListProcess() {
		System.out.println("Id\tArrival time\tExecute time");
		for (Process process : listProcess) {
			System.out.println(process.getIdOfProcessing()+"\t"+process.getTimeArrival()+"\t\t"+process.getTimeProcessing());
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
			for (Process process : listProcess) {
				if(process.getTimeArrival() > start && process.getTimeArrival()<=end) {
					readyListProcesses.add(process);
				}
			}
		}
	}
	
	public void Scheduling() {
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
			int indexTime;
			//get from readyList and calculate timeIndex of time line
			if(temp.getTimeProcessing() > timeQuantum) {
				int t = temp.getTimeProcessing();
				temp.setTimeProcessing(t-timeQuantum);
				toReadyList(start, start+timeQuantum);
				readyListProcesses.remove(0);
				readyListProcesses.add(temp);
				indexTime = timeQuantum;
			}else {
				toReadyList(start, start+temp.getTimeProcessing());
				readyListProcesses.remove(0);
				indexTime = temp.getTimeProcessing();
				countProcess--;
			}
			
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
