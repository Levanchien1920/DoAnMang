using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DoAnMangHDH
{
    public class Process
    {
        private string id;
        private int timeArrival;
        private int timeExe;
        private int timeArround;
        private int timeWait;
        private int priority;

        public Process() { }

        public Process(string id, int timeArrival, int timeExe)
        {
            Id = id;
            TimeArrival = timeArrival;
            TimeExe = timeExe;
            TimeArround = 0;
            TimeWait = 0;
            Priority = 0;
        }

        public Process(string id, int timeArrival, int timeExe, int priority)
        {
            Id = id;
            TimeArrival = timeArrival;
            TimeExe = timeExe;
            TimeArround = 0;
            TimeWait = 0;
            Priority =priority;
        }

        public void show()
        {
            Console.WriteLine();
            MessageBox.Show(Id + "\t" + timeArrival + "\t" + timeExe + "\t" + TimeArround + "\t" + TimeWait + "\t" + Priority);
        }

        public String toString()
        {
            return Id + "\t" + timeArrival + "\t" + timeExe + "\t" + TimeArround + "\t" + TimeWait + "\t" + Priority;
        }

        public List<string> getString()
        {
            List<string> listItem = new List<string>();
            listItem.Add(Id);
            listItem.Add(TimeArrival.ToString());
            listItem.Add(TimeExe.ToString());
            listItem.Add(Priority.ToString());
            listItem.Add(TimeArround.ToString());
            listItem.Add(TimeWait.ToString());
            return listItem;
        }

        public string Id { get => id; set => id = value; }
        public int TimeArrival { get => timeArrival; set => timeArrival = value; }
        public int TimeExe { get => timeExe; set => timeExe = value; }
        public int TimeArround { get => timeArround; set => timeArround = value; }
        public int TimeWait { get => timeWait; set => timeWait = value; }
        public int Priority { get => priority; set => priority = value; }
    }
}
