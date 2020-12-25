using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DoAnMangHDH
{
    public class Priority
    {
        int totaOfPrcess;
        List<Process> listProcess;
        List<Process> readyListProcesses = new List<Process>();
        List<TimeLine> timeLine = new List<TimeLine>();

        public Priority(int totalofprocess, List<Process> listprocess)
        {
            this.totaOfPrcess = totalofprocess;
            this.listProcess = listprocess;
            this.listProcess = listProcess.OrderBy(o => o.TimeArrival).ToList();
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
            //readyListProcesses.OrderBy(s => s.Priority);
            for (int i = 0; i <= readyListProcesses.Count() - 2; i++)
            {
                for (int j = 0; j <= readyListProcesses.Count() - 2; j++)
                {
                    if (readyListProcesses[j].Priority < readyListProcesses[j + 1].Priority)
                    {
                        Process temp = readyListProcesses[j + 1];
                        readyListProcesses[j + 1] = readyListProcesses[j];
                        readyListProcesses[j] = temp;
                    }
                    else if (readyListProcesses[j].Priority == readyListProcesses[j + 1].Priority)
                    {
                        if (readyListProcesses[j].TimeArrival > readyListProcesses[j + 1].TimeArrival)
                        {
                            Process temp = readyListProcesses[j + 1];
                            readyListProcesses[j + 1] = readyListProcesses[j];
                            readyListProcesses[j] = temp;
                        }
                    }
                }
            }
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
                    if (id == Int16.Parse(timeLine[j].NameTimeLine))
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
            result.Priority = input.Priority;
            return result;
        }

        public void SchedulingPreemptive()
        {
            int countProcess = totaOfPrcess;
            int start = listProcess[0].TimeArrival;
            toReadyList(-1, start);

            while (countProcess != 0)
            {
                if (readyListProcesses.Count == 0)
                {
                    toReadyList(start, start + 1);
                    start = start + 1;
                    continue;
                }
                Process temp = readyListProcesses[0];
                int indexTime = temp.TimeExe;
                readyListProcesses.RemoveAt(0);
                countProcess--;
                toReadyList(start, start + indexTime);

                TimeLine tl = new TimeLine(temp.Id.ToString(), start, start + indexTime);
                this.timeLine.Add(tl);
                start = start + indexTime;
            }
        }
    }
}
