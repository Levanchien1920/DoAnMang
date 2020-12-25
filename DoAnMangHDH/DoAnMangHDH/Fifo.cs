using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DoAnMangHDH
{
    class Fifo
    {
        int totaOfPrcess;
        List<Process> listProcess;
        List<TimeLine> timeLine = new List<TimeLine>();
        int[] wt;
        int[] tat;

        public Fifo(){ }

        public Fifo(int total, List<Process> processes)
        {
            this.totaOfPrcess = total;
            this.listProcess = processes;
            wt = new int[processes.Count()];
            tat = new int[processes.Count()];
        }

        public String toString()
        {
            String a = "";
            foreach (TimeLine tl in timeLine)
            {
                a += tl.toString();
            }
            return a;
        }

        public List<TimeLine> getTimeLines()
        {
            //can call after SchedulingPreemptive() and Cal()
            return this.timeLine;

        }

        public void Cal()
        {
            int size = listProcess.Count();
            int[] service_time = new int[size];
            service_time[0] = 0;
            wt[0] = 0;
            for (int i = 1; i < size; i++)
            {
                // Add burst time of previous processes
                service_time[i] = service_time[i - 1] + listProcess[i - 1].TimeExe;
                // Find waiting time for current process =
                // sum - at[i]
                wt[i] = service_time[i] - listProcess[i].TimeArrival;
                // If waiting time for a process is in negative
                // that means it is already in the ready queue
                // before CPU becomes idle so its waiting time is 0
                if (wt[i] < 0)
                    wt[i] = 0;
            }

            for (int i = 0; i < size; i++)
                tat[i] = listProcess[i].TimeExe+ wt[i];

            int total_wt = 0, total_tat = 0;
            for (int i = 0; i < size; i++)
            {
                total_wt = total_wt + wt[i];
                total_tat = total_tat + tat[i];
                int compl_time = tat[i] + listProcess[i].TimeArrival;
                int cpu_time = listProcess[i].TimeArrival + wt[i];
                this.timeLine.Add(new TimeLine(listProcess[i].Id, cpu_time, compl_time));
                listProcess[i].TimeWait = wt[i];
                listProcess[i].TimeArround = tat[i];
            }
        }
    }
}
