using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DoAnMangHDH
{
    public class RoundRobin
    {
        int totaOfPrcess;
        int timeQuantum;
        List<Process> listProcess;
        List<Process> readyListProcesses = new List<Process>();
        List<TimeLine> timeLine = new List<TimeLine>();

        public RoundRobin(int totalofprocess, int timequantum, List<Process> listprocess)
        {
            this.totaOfPrcess = totalofprocess;
            this.timeQuantum = timequantum;
            this.listProcess = listprocess;
            //this.listProcess.Sort(Comparator.comparing(Process::getTimeArrival)); //sort list process by time arrival
            //List<Order> SortedList = objListOrder.OrderBy(o => o.OrderDate).ToList();
            this.listProcess = listProcess.OrderBy(o => o.TimeArrival).ToList();
        }

        public List<TimeLine> getTimeLines()
        {
            return this.timeLine;
        }

        public void outputListProcess()
        {
            //System.out.println("Id\tArrival time\tExecute time\tAround time\tWaitting time\tPriority");
            //for (Process process : listProcess)
            //{
            //    process.show();
            //}
        }

        public void Cal()
        {
            for (int i = 0; i < listProcess.Count(); i++)
            {
                Process p = listProcess[i];
                int id = Int16.Parse(listProcess[i].Id);
                for (int j = timeLine.Count() - 1; j >= 0; j--)
                {
                    if (id == Int16.Parse(timeLine[j].NameTimeLine))
                    {
                        p.TimeArround = timeLine[j].EndTimeLine - p.TimeArrival;
                        break;
                    }
                }
                for (int j = 0; j < timeLine.Count(); j++)
                {
                    if (id == Int16.Parse(timeLine[j].NameTimeLine)) ;
                    {
                        p.TimeWait = p.TimeArround - p.TimeExe;
                        break;
                    }
                }
                listProcess[i] = p;
            }
        }

        public Process copyProcess(Process input)
        {
            Process result = new Process();
            result.Id = input.Id;
            result.TimeArrival = input.TimeArrival;
            result.TimeExe = input.TimeExe;
            result.TimeArround = input.TimeArround;
            result.TimeWait = input.TimeWait;
            return result;
        }

        public String toString()
        {
            String a = "";
            foreach(TimeLine tl in timeLine)
            {
                a += tl.toString();
            }
            return a;
        }

        public List<TimeLine> toTimeLine()
        {
            //can call after SchedulingPreemptive() and Cal()
            return this.timeLine;

        }

        public void toReadyList(int start, int end)
        {
            if (start > end)
                return;
            else
            {
                foreach (Process process in listProcess)
                {
                    if (process.TimeArrival > start && process.TimeArrival <= end)
                    {

                        Process temp = copyProcess(process);
                        readyListProcesses.Add(temp);
                    }
                }
            }
        }

        public void Scheduling()
        {
            int countProcess = totaOfPrcess;
            int start = listProcess[0].TimeArrival;
            toReadyList(-1, start);
            //foreach (Process process in readyListProcesses)
            //{
            //    System.out.print(process.getIdOfProcessing() + " ");
            //}
            //System.out.println();
            while (countProcess != 0)
            {
                if (readyListProcesses.Count() == 0)
                {
                    toReadyList(start, start + 1);
                    start = start + 1;
                    continue;
                }
                Process temp = readyListProcesses[0];
                int indexTime;
                //get from readyList and calculate timeIndex of time line
                if (temp.TimeExe > timeQuantum)
                {
                    int t = temp.TimeExe;
                    temp.TimeExe = t - timeQuantum;
                    toReadyList(start, start + timeQuantum);
                    readyListProcesses.RemoveAt(0);
                    readyListProcesses.Add(temp);
                    indexTime = timeQuantum;
                }
                else
                {
                    toReadyList(start, start + temp.TimeExe);
                    readyListProcesses.RemoveAt(0);
                    indexTime = temp.TimeExe;
                    countProcess--;
                }

                TimeLine tl = new TimeLine(temp.Id.ToString(), start, start + indexTime);
                this.timeLine.Add(tl);
                start = start + indexTime;

                //for (Process process : readyListProcesses)
                //{
                //    System.out.print(process.getIdOfProcessing() + " ");
                //}
                //System.out.println();
            }
        }
    }
}
