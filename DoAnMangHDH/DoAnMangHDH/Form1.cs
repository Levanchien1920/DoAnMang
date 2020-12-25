using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DoAnMangHDH
{
    public partial class Scheduling : Form
    {
        List<Process> Processes = new List<Process>();
        Boolean isDoubleClick = false;
        int indexDoubleClick = -1;
        Point starPoint = new Point(15, 230);
        int height = 50;
        int width = 900;
        Graphics dc;
        List<Color> colors = new List<Color>() { Color.Red, Color.Orange, Color.Yellow, Color.Green, Color.Blue, Color.Brown, Color.Black, Color.Purple };
        public Scheduling()
        {
            InitializeComponent();
            //Graphics dc = this.CreateGraphics();
            //this.Show();
            //Pen BluePen = new Pen(Color.Blue, 3);
            //SolidBrush blueBrush = new SolidBrush(Color.Blue);
            //dc.FillRectangle(blueBrush, 15,230, 1000, 50);
            //Pen RedPen = new Pen(Color.Red, 2);
            //dc.DrawEllipse(RedPen, 0, 50, 80, 60);
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            dc = this.CreateGraphics();
            disableTextBox(1);
            btnRun.Enabled = false;

            for(int i = 0; i< 4; i++)
            {
                lvInputData.Columns[i].Width = 150;
            }
            for(int i=0; i< 6; i++)
            {
                lvOutputData.Columns[i].Width = 100;
            }
            for(int i=0; i< 2; i++)
            {
                lvNote.Columns[i].Width = 70;
            }
        }

        private void btnRun_Click(object sender, EventArgs e)
        {
            String timeQuantum = txtTimeQuantum.Text;
            if (cbScheduling.Text == "RR" && !timeQuantum.Equals("") && Int16.Parse(timeQuantum)>0)
            {
                SetLvNote(Processes);
                RoundRobin rb = new RoundRobin(Processes.Count(), Int16.Parse(txtTimeQuantum.Text), Processes);
                rb.Scheduling();
                rb.Cal();
                List<TimeLine> timeLines = rb.getTimeLines();
                String a = "";
                foreach (TimeLine tl in timeLines)
                {
                    a += tl.toString();
                }
                MessageBox.Show(a);
                lvOutputData.Items.Clear();
                SetLvOutput(Processes);

                int final = timeLines[timeLines.Count() - 1].EndTimeLine;
                int donvi = (int)width / final;
                int startx = 0;
                int starty = 0;
                int wi = 0;
                dc.FillRectangle(new SolidBrush(Color.White), starPoint.X - 10, starPoint.Y - 16, 1000 + 20, 50 + 20);
                foreach (TimeLine tl in timeLines)
                {
                    startx = starPoint.X + tl.StartTimeLine * donvi;
                    starty = starPoint.Y;
                    wi = (tl.EndTimeLine - tl.StartTimeLine) * donvi;
                    SolidBrush Brush = new SolidBrush(colors[Processes.FindIndex(s => s.Id.Equals(tl.NameTimeLine))]);
                    dc.FillRectangle(Brush, startx, starty, wi, 50);


                    Font f = new Font("Courier New", 10);
                    PointF pf = new PointF(startx - 5, starty - 15);
                    SolidBrush BrushBlack = new SolidBrush(colors[6]);
                    dc.DrawString(tl.StartTimeLine.ToString(), f, BrushBlack, pf);
                }

                dc.DrawString("0", new Font("Courier New", 10), new SolidBrush(colors[6]), new Point(starPoint.X - 5, starPoint.Y - 15));
                dc.DrawString(timeLines[timeLines.Count() - 1].EndTimeLine.ToString(), new Font("Courier New", 10), new SolidBrush(colors[6]), new Point(starPoint.X - 5 + timeLines[timeLines.Count() - 1].EndTimeLine*donvi, starPoint.Y - 15));
                dc.DrawRectangle(new Pen(Color.Black), starPoint.X, starPoint.Y, 1000, 50);

            }
            else if(cbScheduling.Text == "Priority")
            {
                SetLvNote(Processes);
                Priority pr = new Priority(Processes.Count(), Processes);
                pr.SchedulingPreemptive();
                pr.Cal();
                MessageBox.Show(pr.toString());
                lvOutputData.Items.Clear();
                SetLvOutput(Processes);
                List<TimeLine> timeLines = pr.getTimeLines();
                int final = timeLines[timeLines.Count() - 1].EndTimeLine;
                int donvi = (int)width / final;
                int startx = 0;
                int starty = 0;
                int wi = 0;
                dc.FillRectangle(new SolidBrush(Color.White), starPoint.X - 10, starPoint.Y - 16, 1000 + 20, 50 + 20);

                foreach (TimeLine tl in timeLines)
                {
                    startx = starPoint.X + tl.StartTimeLine * donvi;
                    starty = starPoint.Y;
                    wi = (tl.EndTimeLine - tl.StartTimeLine) * donvi;
                    SolidBrush Brush = new SolidBrush(colors[Processes.FindIndex(s => s.Id.Equals(tl.NameTimeLine))]);
                    dc.FillRectangle(Brush, startx, starty, wi, 50);


                    Font f = new Font("Courier New", 10);
                    PointF pf = new PointF(startx - 5, starty - 15);
                    SolidBrush BrushBlack = new SolidBrush(colors[6]);
                    dc.DrawString(tl.StartTimeLine.ToString(), f, BrushBlack, pf);
                }

                dc.DrawString("0", new Font("Courier New", 10), new SolidBrush(colors[6]), new Point(starPoint.X - 5, starPoint.Y - 15));
                dc.DrawString(timeLines[timeLines.Count() - 1].EndTimeLine.ToString(), new Font("Courier New", 10), new SolidBrush(colors[6]), new Point(starPoint.X - 5 + timeLines[timeLines.Count() - 1].EndTimeLine * donvi, starPoint.Y - 15));
                dc.DrawRectangle(new Pen(Color.Black), starPoint.X, starPoint.Y, 1000, 50);

            }
            else if(cbScheduling.Text == "FIFO" && Processes.Count()>0)
            {
                SetLvNote(Processes);
                Fifo fifo = new Fifo(Processes.Count(), Processes);
                fifo.Cal();
                MessageBox.Show(fifo.toString());
                lvOutputData.Items.Clear();
                SetLvOutput(Processes);
                List<TimeLine> timeLines = fifo.getTimeLines();
                int final = timeLines[timeLines.Count() - 1].EndTimeLine;
                int donvi = (int)width / final;
                int startx = 0;
                int starty = 0;
                int wi = 0;
                dc.FillRectangle(new SolidBrush(Color.White), starPoint.X - 10, starPoint.Y - 16, 1000 + 20, 50 + 20);

                foreach (TimeLine tl in timeLines)
                {
                    startx = starPoint.X + tl.StartTimeLine * donvi;
                    starty = starPoint.Y;
                    wi = (tl.EndTimeLine - tl.StartTimeLine) * donvi;
                    SolidBrush Brush = new SolidBrush(colors[Processes.FindIndex(s => s.Id.Equals(tl.NameTimeLine))]);
                    dc.FillRectangle(Brush, startx, starty, wi, 50);


                    Font f = new Font("Courier New", 10);
                    PointF pf = new PointF(startx - 5, starty - 15);
                    SolidBrush BrushBlack = new SolidBrush(colors[6]);
                    dc.DrawString(tl.StartTimeLine.ToString(), f, BrushBlack, pf);
                }

                dc.DrawString("0", new Font("Courier New", 10), new SolidBrush(colors[6]), new Point(starPoint.X - 5, starPoint.Y - 15));
                dc.DrawString(timeLines[timeLines.Count() - 1].EndTimeLine.ToString(), new Font("Courier New", 10), new SolidBrush(colors[6]), new Point(starPoint.X - 5 + timeLines[timeLines.Count() - 1].EndTimeLine * donvi, starPoint.Y - 15));
                dc.DrawRectangle(new Pen(Color.Black), starPoint.X, starPoint.Y, 1000, 50);

            }
            else if(cbScheduling.Text == "SJF")
            {
                SetLvNote(Processes);
                this.Processes = Processes.OrderBy(o => o.TimeExe).ToList(); //tang dan process
                int value = 1;
                Processes[Processes.Count() - 1].Priority = 0;
                for(int i =Processes.Count()-2; i>=0; i--)
                {
                    if(Processes[i] == Processes[i + 1])
                    {
                        Processes[i].Priority = value;
                    }
                    else
                    {
                        value++;
                        Processes[i].Priority = value;
                    }
                }
                Priority pr = new Priority(Processes.Count(), Processes);
                pr.SchedulingPreemptive();
                pr.Cal();
                MessageBox.Show(pr.toString());
                lvOutputData.Items.Clear();
                SetLvOutput(Processes);
                List<TimeLine> timeLines = pr.getTimeLines();
                int final = timeLines[timeLines.Count() - 1].EndTimeLine;
                int donvi = (int)width / final;
                int startx = 0;
                int starty = 0;
                int wi = 0;
                dc.FillRectangle(new SolidBrush(Color.White), starPoint.X - 10, starPoint.Y - 16, 1000 + 20, 50 + 20);

                foreach (TimeLine tl in timeLines)
                {
                    startx = starPoint.X + tl.StartTimeLine * donvi;
                    starty = starPoint.Y;
                    wi = (tl.EndTimeLine - tl.StartTimeLine) * donvi;
                    SolidBrush Brush = new SolidBrush(colors[Processes.FindIndex(s => s.Id.Equals(tl.NameTimeLine))]);
                    dc.FillRectangle(Brush, startx, starty, wi, 50);


                    Font f = new Font("Courier New", 10);
                    PointF pf = new PointF(startx - 5, starty - 15);
                    SolidBrush BrushBlack = new SolidBrush(colors[6]);
                    dc.DrawString(tl.StartTimeLine.ToString(), f, BrushBlack, pf);
                }

                dc.DrawString("0", new Font("Courier New", 10), new SolidBrush(colors[6]), new Point(starPoint.X - 5, starPoint.Y - 15));
                dc.DrawString(timeLines[timeLines.Count() - 1].EndTimeLine.ToString(), new Font("Courier New", 10), new SolidBrush(colors[6]), new Point(starPoint.X - 5 + timeLines[timeLines.Count() - 1].EndTimeLine * donvi, starPoint.Y - 15));
                dc.DrawRectangle(new Pen(Color.Black), starPoint.X, starPoint.Y, 1000, 50);
            }
        }

        private void btnResetProcess_Click(object sender, EventArgs e)
        {
            txtProcessname.Enabled = true;
            txtProcessname.Text = "";
            txtStartTime.Text = "";
            txtPriority.Text = "";
            txtTimeQuantum.Text = "";
            txtExecuteTime.Text = "";
        }

        public void SetLvNote(List<Process> processes)
        {
            lvNote.Items.Clear();
            int index = 0;
            foreach (Process item in processes)
            {
                String[] s = new String[]{ item.Id, "" };
                ListViewItem lvi = new ListViewItem(s);
                lvNote.Items.Add(lvi);
                lvNote.Items[index].UseItemStyleForSubItems = false;
                lvNote.Items[index].SubItems[1].BackColor = colors[index];
                index++;
            }
        }

        public void SetlvInput(List<Process> processes)
        {
            foreach(Process item in processes)
            {
                lvInputData.Items.Add(new ListViewItem(item.getString().ToArray()));

            }
        }

        public void SetLvOutput(List<Process> processes)
        {
            foreach (Process item in processes)
            {
                lvOutputData.Items.Add(new ListViewItem(item.getString().ToArray()));
            }
        }

        public void disableTextBox(int value)
        {

            switch (value)
            {
                case 1: //all
                    {
                        txtProcessname.ReadOnly = true;
                        txtStartTime.ReadOnly = true;
                        txtExecuteTime.ReadOnly = true;
                        txtPriority.ReadOnly = true;
                        txtTimeQuantum.ReadOnly = true;
                    }
                    break;

                case 2: //RR
                    {
                        txtProcessname.ReadOnly = false;
                        txtStartTime.ReadOnly = false;
                        txtExecuteTime.ReadOnly = false;
                        txtPriority.ReadOnly = true;
                        txtTimeQuantum.ReadOnly = false;
                    }
                    break;
                case 3: // FIFO, SJF
                    {
                        txtProcessname.ReadOnly = false;
                        txtStartTime.ReadOnly = false;
                        txtExecuteTime.ReadOnly = false;
                        txtPriority.ReadOnly = true;
                        txtTimeQuantum.ReadOnly = true;
                    }
                    break;
                case 4: //priority
                    {
                        txtProcessname.ReadOnly = false;
                        txtStartTime.ReadOnly = false;
                        txtExecuteTime.ReadOnly = false;
                        txtPriority.ReadOnly = false;
                        txtTimeQuantum.ReadOnly = true;
                    }
                    break;
            }
        }

        private void btnAddProcess_Click(object sender, EventArgs e)
        {
            int start = 0, execute = 0, priority = 0, id = 0;
            bool isNumeric = int.TryParse(txtStartTime.Text, out start);
            isNumeric = int.TryParse(txtExecuteTime.Text, out execute);
            isNumeric = int.TryParse(txtPriority.Text, out priority);
            isNumeric = int.TryParse(txtProcessname.Text, out id);
            if (id >0 && execute != 0 && start >=0 && priority >=0)
            {
                Boolean check = false;
                foreach(Process index in Processes)
                {
                    if (index.Id.Equals(id.ToString()))
                    {
                        check = true;
                    }
                }
                if(check == false)
                {
                    Process p = new Process(id.ToString(), start, execute, priority);
                    Processes.Add(p);
                    lvInputData.Items.Clear();
                    SetlvInput(Processes);
                }
            }
            txtProcessname.Text = "";
            txtStartTime.Text = "";
            txtPriority.Text = "";
            txtTimeQuantum.Text = "";
            txtExecuteTime.Text = "";

        }

        private void cbScheduling_SelectionChangeCommitted(object sender, EventArgs e)
        {
            btnRun.Enabled = true;
            string sh = cbScheduling.Text;
            if(sh == "FIFO" || sh == "SJF")
            {
                disableTextBox(3);
                txtPriority.Text = "0";
                txtTimeQuantum.Text = "0";
            }
            else if(sh == "RR")
            {
                disableTextBox(2);
                txtPriority.Text = "0";
                txtTimeQuantum.Clear();
            }
            else
            {
                disableTextBox(4);
                txtTimeQuantum.Text = "0";
                txtPriority.Clear();
            }
            cbScheduling.Enabled = false;
        }

        private void btnNew_Click(object sender, EventArgs e)
        {
            Processes.Clear();
            cbScheduling.Enabled = true;
            lvInputData.Items.Clear();
            lvOutputData.Items.Clear();
            txtProcessname.Text = "";
            txtStartTime.Text = "";
            txtPriority.Text = "";
            txtTimeQuantum.Text = "";
            txtExecuteTime.Text = "";
            dc.FillRectangle(new SolidBrush(Color.White), starPoint.X - 10, starPoint.Y - 16, 1000 + 20, 50 + 20);
        }

        private void lvInputData_DoubleClick(object sender, EventArgs e)
        {
            txtProcessname.Enabled = false;
            btnUpdateProcess.Enabled = true;
            btnDeleteProcess.Enabled = true; 
            isDoubleClick = true;
            indexDoubleClick =  lvInputData.SelectedIndices[0];
            btnResetProcess.Enabled = false;
            btnAddProcess.Enabled = false;
            txtProcessname.Text = lvInputData.SelectedItems[0].SubItems[0].Text;
            txtStartTime.Text = lvInputData.SelectedItems[0].SubItems[1].Text;
            txtExecuteTime.Text = lvInputData.SelectedItems[0].SubItems[2].Text;
            txtPriority.Text = lvInputData.SelectedItems[0].SubItems[3].Text;
        }

        private void btnUpdateProcess_Click(object sender, EventArgs e)
        {
            txtProcessname.Enabled = true;
            btnAddProcess.Enabled = true;
            btnResetProcess.Enabled = true;
            if (isDoubleClick)
            { 
                int start = 0, execute = 0, priority = 0,id=0 ;
                bool isNumeric = isNumeric = int.TryParse(txtStartTime.Text, out start);
                isNumeric = int.TryParse(txtExecuteTime.Text, out execute);
                isNumeric = int.TryParse(txtPriority.Text, out priority);
                isNumeric = int.TryParse(txtProcessname.Text, out id);
                if (id > 0 && execute != 0 && start >= 0 && priority >= 0)
                {
                    Process p = new Process(id.ToString(), start, execute, priority);
                    Processes[indexDoubleClick] = p;
                    lvInputData.Items.Clear();
                    SetlvInput(Processes);
                }
            }
            isDoubleClick = false;
            btnResetProcess.Enabled = true;
            btnAddProcess.Enabled = true;
            btnUpdateProcess.Enabled = false;
            btnDeleteProcess.Enabled = false;
            txtProcessname.Text = "";
            txtStartTime.Text = "";
            txtPriority.Text = "";
            txtTimeQuantum.Text = "";
            txtExecuteTime.Text = "";
        }

        private void btnDeleteProcess_Click(object sender, EventArgs e)
        {
            txtProcessname.Enabled = true;
            if (isDoubleClick)
            {
                Processes.RemoveAt(indexDoubleClick);
                lvInputData.Items.Clear();
                SetlvInput(Processes);
            }
            isDoubleClick = false;
            btnResetProcess.Enabled = true;
            btnAddProcess.Enabled = true;
            btnUpdateProcess.Enabled = false;
            btnDeleteProcess.Enabled = false;
        }

        private void lvNote_ColumnWidthChanging(object sender, ColumnWidthChangingEventArgs e)
        {
            e.Cancel = true;
            e.NewWidth = lvInputData.Columns[e.ColumnIndex].Width;
        }
        private void lvInputData_ColumnWidthChanging(object sender, ColumnWidthChangingEventArgs e)
        {
            e.Cancel = true;
            e.NewWidth = lvInputData.Columns[e.ColumnIndex].Width;
        }

        private void lvOutputData_ColumnWidthChanging(object sender, ColumnWidthChangingEventArgs e)
        {
            e.Cancel = true;
            e.NewWidth = lvOutputData.Columns[e.ColumnIndex].Width;
        }
    }
}
