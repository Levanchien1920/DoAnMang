package Priority;

import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		List<ProcessPriority> listprocess = new ArrayList<ProcessPriority>();
		ProcessPriority p1 = new ProcessPriority(1, 0, 4, 1);
		ProcessPriority p2 = new ProcessPriority(2, 0, 3, 2);
		ProcessPriority p3 = new ProcessPriority(3, 6, 7, 1);
		ProcessPriority p4 = new ProcessPriority(4, 11, 4, 3);
		ProcessPriority p5 = new ProcessPriority(5, 12, 2, 2);
		
		
		listprocess.add(p1);
		listprocess.add(p2);
		listprocess.add(p3);
		listprocess.add(p4);
		listprocess.add(p5);
		
		int totalofprocess = 5;
		
		Priority pr = new Priority(totalofprocess, listprocess);
		
		pr.outputListProcess();
		System.out.println();
		System.out.println("Ready List Process:");
		pr.SchedulingPreemptive();
		pr.outputListTimeLine();
	}

}
