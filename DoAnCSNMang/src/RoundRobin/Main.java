package RoundRobin;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Process> listprocess = new ArrayList<Process>();
		Process p1 = new Process(1, 5, 5);
		Process p2 = new Process(2, 4, 6);
		Process p3 = new Process(3, 3, 7);
		Process p4 = new Process(4, 1, 9);
		Process p5 = new Process(5, 2, 2);
		Process p6 = new Process(6, 6, 3);
		
		
		listprocess.add(p1);
		listprocess.add(p2);
		listprocess.add(p3);
		listprocess.add(p4);
		listprocess.add(p5);
		listprocess.add(p6);
		//listprocess.sort(Comparator.comparing(Process::getTimeArrival));
		
		int totalofprocess = 6;
		int timequantum = 3;
		
		RoundRobin rb = new RoundRobin(totalofprocess, timequantum, listprocess);
		rb.outputListProcess();
		
		rb.Scheduling();
		rb.outputListTimeLine();
//		TimeLine t1 = new TimeLine("P1", 0, 4);
//		TimeLine t2 = new TimeLine("P2", 4, 5);
//		t1.outputTimeLine();
//		t2.outputTimeLine();
//		
//		System.out.println();
//		Queue<Process> readyProcesses = new LinkedList<>();
//		readyProcesses.offer(p1);
//		readyProcesses.offer(p2);
//		readyProcesses.offer(p3);
//		Process temp = readyProcesses.remove();
//		temp = readyProcesses.remove();
//		temp.outputProcess();
//		readyProcesses.offer(p1);
//		for (Process process : readyProcesses) {
//			System.out.println(process.getIdOfProcessing()+"\t"+process.getTimeArrival()+"\t\t"+process.getTimeProcessing());
//		}
	}

}
