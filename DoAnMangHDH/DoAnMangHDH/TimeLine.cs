using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DoAnMangHDH
{
    public class TimeLine
    {
        int startTimeLine;
        int endTimeLine;
        String nameTimeLine;

        public int StartTimeLine { get => startTimeLine; set => startTimeLine = value; }
        public int EndTimeLine { get => endTimeLine; set => endTimeLine = value; }
        public string NameTimeLine { get => nameTimeLine; set => nameTimeLine = value; }

        public TimeLine(String name, int start, int end)
        {
            this.nameTimeLine = name;
            this.startTimeLine = start;
            this.endTimeLine = end;
        }

        public String toString()
        {
            return "|" + startTimeLine + "-" + nameTimeLine + "-" + endTimeLine + "|" + "\n";
        }

        public void outputTimeLine()
        {
            //System.out.print("|" + startTimeLine + "-" + nameTimeLine + "-" + endTimeLine + "|");
        }
    }

}
