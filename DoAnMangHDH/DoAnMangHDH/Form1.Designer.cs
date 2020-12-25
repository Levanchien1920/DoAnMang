namespace DoAnMangHDH
{
    partial class Scheduling
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnNew = new System.Windows.Forms.Button();
            this.btnRun = new System.Windows.Forms.Button();
            this.cbScheduling = new System.Windows.Forms.ComboBox();
            this.lvInputData = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.lvOutputData = new System.Windows.Forms.ListView();
            this.columnHeader5 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader6 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader7 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader8 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader9 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader10 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.txtProcessname = new System.Windows.Forms.TextBox();
            this.txtStartTime = new System.Windows.Forms.TextBox();
            this.txtExecuteTime = new System.Windows.Forms.TextBox();
            this.txtPriority = new System.Windows.Forms.TextBox();
            this.btnResetProcess = new System.Windows.Forms.Button();
            this.btnAddProcess = new System.Windows.Forms.Button();
            this.txtTimeQuantum = new System.Windows.Forms.TextBox();
            this.btnUpdateProcess = new System.Windows.Forms.Button();
            this.btnDeleteProcess = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
            this.lvNote = new System.Windows.Forms.ListView();
            this.columnHeader11 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader12 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.label14 = new System.Windows.Forms.Label();
            this.label15 = new System.Windows.Forms.Label();
            this.label16 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnNew
            // 
            this.btnNew.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnNew.Location = new System.Drawing.Point(8, 10);
            this.btnNew.Name = "btnNew";
            this.btnNew.Size = new System.Drawing.Size(87, 29);
            this.btnNew.TabIndex = 0;
            this.btnNew.Text = "New Test";
            this.btnNew.UseVisualStyleBackColor = true;
            this.btnNew.Click += new System.EventHandler(this.btnNew_Click);
            // 
            // btnRun
            // 
            this.btnRun.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnRun.Location = new System.Drawing.Point(101, 11);
            this.btnRun.Name = "btnRun";
            this.btnRun.Size = new System.Drawing.Size(87, 27);
            this.btnRun.TabIndex = 1;
            this.btnRun.Text = "Run";
            this.btnRun.UseVisualStyleBackColor = true;
            this.btnRun.Click += new System.EventHandler(this.btnRun_Click);
            // 
            // cbScheduling
            // 
            this.cbScheduling.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbScheduling.FormattingEnabled = true;
            this.cbScheduling.Items.AddRange(new object[] {
            "FIFO",
            "SJF",
            "RR",
            "Priority"});
            this.cbScheduling.Location = new System.Drawing.Point(282, 15);
            this.cbScheduling.Name = "cbScheduling";
            this.cbScheduling.Size = new System.Drawing.Size(171, 21);
            this.cbScheduling.TabIndex = 2;
            this.cbScheduling.SelectionChangeCommitted += new System.EventHandler(this.cbScheduling_SelectionChangeCommitted);
            // 
            // lvInputData
            // 
            this.lvInputData.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4});
            this.lvInputData.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lvInputData.FullRowSelect = true;
            this.lvInputData.GridLines = true;
            this.lvInputData.HideSelection = false;
            this.lvInputData.LabelWrap = false;
            this.lvInputData.Location = new System.Drawing.Point(8, 56);
            this.lvInputData.Name = "lvInputData";
            this.lvInputData.Size = new System.Drawing.Size(627, 148);
            this.lvInputData.TabIndex = 4;
            this.lvInputData.UseCompatibleStateImageBehavior = false;
            this.lvInputData.View = System.Windows.Forms.View.Details;
            this.lvInputData.ColumnWidthChanging += new System.Windows.Forms.ColumnWidthChangingEventHandler(this.lvInputData_ColumnWidthChanging);
            this.lvInputData.DoubleClick += new System.EventHandler(this.lvInputData_DoubleClick);
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "Process Name";
            this.columnHeader1.Width = 156;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "Start Time";
            this.columnHeader2.Width = 148;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "Execute Time";
            this.columnHeader3.Width = 142;
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "Priority";
            this.columnHeader4.Width = 154;
            // 
            // lvOutputData
            // 
            this.lvOutputData.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader5,
            this.columnHeader6,
            this.columnHeader7,
            this.columnHeader8,
            this.columnHeader9,
            this.columnHeader10});
            this.lvOutputData.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lvOutputData.GridLines = true;
            this.lvOutputData.HideSelection = false;
            this.lvOutputData.Location = new System.Drawing.Point(8, 309);
            this.lvOutputData.Name = "lvOutputData";
            this.lvOutputData.Size = new System.Drawing.Size(627, 138);
            this.lvOutputData.TabIndex = 5;
            this.lvOutputData.UseCompatibleStateImageBehavior = false;
            this.lvOutputData.View = System.Windows.Forms.View.Details;
            this.lvOutputData.ColumnWidthChanging += new System.Windows.Forms.ColumnWidthChangingEventHandler(this.lvOutputData_ColumnWidthChanging);
            // 
            // columnHeader5
            // 
            this.columnHeader5.Text = "Process Name";
            this.columnHeader5.Width = 105;
            // 
            // columnHeader6
            // 
            this.columnHeader6.Text = "Start Time";
            this.columnHeader6.Width = 77;
            // 
            // columnHeader7
            // 
            this.columnHeader7.Text = "Execute Time";
            this.columnHeader7.Width = 120;
            // 
            // columnHeader8
            // 
            this.columnHeader8.Text = "Priority";
            this.columnHeader8.Width = 91;
            // 
            // columnHeader9
            // 
            this.columnHeader9.Text = "Around Time";
            this.columnHeader9.Width = 99;
            // 
            // columnHeader10
            // 
            this.columnHeader10.Text = "Time Waitting";
            this.columnHeader10.Width = 99;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(657, 17);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(88, 15);
            this.label1.TabIndex = 6;
            this.label1.Text = "Process Name";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(689, 57);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(63, 15);
            this.label2.TabIndex = 7;
            this.label2.Text = "Start Time";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(667, 93);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(82, 15);
            this.label3.TabIndex = 8;
            this.label3.Text = "Execute Time";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(475, 19);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(89, 15);
            this.label4.TabIndex = 9;
            this.label4.Text = "Time Quantum";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(711, 130);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(44, 15);
            this.label5.TabIndex = 10;
            this.label5.Text = "Priority";
            // 
            // txtProcessname
            // 
            this.txtProcessname.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtProcessname.Location = new System.Drawing.Point(771, 19);
            this.txtProcessname.Name = "txtProcessname";
            this.txtProcessname.Size = new System.Drawing.Size(262, 22);
            this.txtProcessname.TabIndex = 11;
            // 
            // txtStartTime
            // 
            this.txtStartTime.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtStartTime.Location = new System.Drawing.Point(771, 56);
            this.txtStartTime.Name = "txtStartTime";
            this.txtStartTime.Size = new System.Drawing.Size(262, 22);
            this.txtStartTime.TabIndex = 12;
            // 
            // txtExecuteTime
            // 
            this.txtExecuteTime.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtExecuteTime.Location = new System.Drawing.Point(771, 92);
            this.txtExecuteTime.Name = "txtExecuteTime";
            this.txtExecuteTime.Size = new System.Drawing.Size(262, 22);
            this.txtExecuteTime.TabIndex = 13;
            // 
            // txtPriority
            // 
            this.txtPriority.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtPriority.Location = new System.Drawing.Point(771, 132);
            this.txtPriority.Name = "txtPriority";
            this.txtPriority.Size = new System.Drawing.Size(262, 22);
            this.txtPriority.TabIndex = 14;
            // 
            // btnResetProcess
            // 
            this.btnResetProcess.Location = new System.Drawing.Point(641, 168);
            this.btnResetProcess.Name = "btnResetProcess";
            this.btnResetProcess.Size = new System.Drawing.Size(105, 29);
            this.btnResetProcess.TabIndex = 15;
            this.btnResetProcess.Text = "Reset Process";
            this.btnResetProcess.UseVisualStyleBackColor = true;
            this.btnResetProcess.Click += new System.EventHandler(this.btnResetProcess_Click);
            // 
            // btnAddProcess
            // 
            this.btnAddProcess.Location = new System.Drawing.Point(960, 168);
            this.btnAddProcess.Name = "btnAddProcess";
            this.btnAddProcess.Size = new System.Drawing.Size(82, 29);
            this.btnAddProcess.TabIndex = 16;
            this.btnAddProcess.Text = "Add Process";
            this.btnAddProcess.UseVisualStyleBackColor = true;
            this.btnAddProcess.Click += new System.EventHandler(this.btnAddProcess_Click);
            // 
            // txtTimeQuantum
            // 
            this.txtTimeQuantum.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtTimeQuantum.Location = new System.Drawing.Point(570, 16);
            this.txtTimeQuantum.Name = "txtTimeQuantum";
            this.txtTimeQuantum.Size = new System.Drawing.Size(60, 22);
            this.txtTimeQuantum.TabIndex = 17;
            // 
            // btnUpdateProcess
            // 
            this.btnUpdateProcess.Location = new System.Drawing.Point(752, 168);
            this.btnUpdateProcess.Name = "btnUpdateProcess";
            this.btnUpdateProcess.Size = new System.Drawing.Size(94, 29);
            this.btnUpdateProcess.TabIndex = 18;
            this.btnUpdateProcess.Text = "Update Process";
            this.btnUpdateProcess.UseVisualStyleBackColor = true;
            this.btnUpdateProcess.Click += new System.EventHandler(this.btnUpdateProcess_Click);
            // 
            // btnDeleteProcess
            // 
            this.btnDeleteProcess.Location = new System.Drawing.Point(853, 168);
            this.btnDeleteProcess.Name = "btnDeleteProcess";
            this.btnDeleteProcess.Size = new System.Drawing.Size(101, 29);
            this.btnDeleteProcess.TabIndex = 19;
            this.btnDeleteProcess.Text = "Delete Process";
            this.btnDeleteProcess.UseVisualStyleBackColor = true;
            this.btnDeleteProcess.Click += new System.EventHandler(this.btnDeleteProcess_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(207, 16);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(69, 15);
            this.label6.TabIndex = 20;
            this.label6.Text = "Scheduling";
            // 
            // lvNote
            // 
            this.lvNote.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader11,
            this.columnHeader12});
            this.lvNote.GridLines = true;
            this.lvNote.HideSelection = false;
            this.lvNote.Location = new System.Drawing.Point(641, 309);
            this.lvNote.Name = "lvNote";
            this.lvNote.Size = new System.Drawing.Size(150, 138);
            this.lvNote.TabIndex = 21;
            this.lvNote.UseCompatibleStateImageBehavior = false;
            this.lvNote.View = System.Windows.Forms.View.Details;
            this.lvNote.ColumnWidthChanging += new System.Windows.Forms.ColumnWidthChangingEventHandler(this.lvNote_ColumnWidthChanging);
            // 
            // columnHeader11
            // 
            this.columnHeader11.Text = "Name";
            this.columnHeader11.Width = 77;
            // 
            // columnHeader12
            // 
            this.columnHeader12.Text = "Color";
            this.columnHeader12.Width = 59;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(802, 300);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(231, 14);
            this.label7.TabIndex = 22;
            this.label7.Text = "Mô phỏng các giải thuật lập lịch";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.Location = new System.Drawing.Point(814, 322);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(42, 14);
            this.label8.TabIndex = 23;
            this.label8.Text = "-FIFO";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label9.Location = new System.Drawing.Point(868, 346);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(70, 14);
            this.label9.TabIndex = 24;
            this.label9.Text = "-Priority";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label10.Location = new System.Drawing.Point(868, 322);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(91, 14);
            this.label10.TabIndex = 25;
            this.label10.Text = "-Round Robin";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label11.Location = new System.Drawing.Point(814, 345);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(35, 14);
            this.label11.TabIndex = 26;
            this.label11.Text = "-SJF";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label12.Location = new System.Drawing.Point(826, 394);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(112, 14);
            this.label12.TabIndex = 27;
            this.label12.Text = "Cao Quảng Trọng";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label13.Location = new System.Drawing.Point(802, 370);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(56, 14);
            this.label13.TabIndex = 28;
            this.label13.Text = "Tác giả";
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label14.Location = new System.Drawing.Point(826, 418);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(91, 14);
            this.label14.TabIndex = 29;
            this.label14.Text = "Lê Văn Chiến";
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label15.Location = new System.Drawing.Point(5, 292);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(49, 14);
            this.label15.TabIndex = 30;
            this.label15.Text = "Output";
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.Font = new System.Drawing.Font("Consolas", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label16.Location = new System.Drawing.Point(5, 42);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(42, 14);
            this.label16.TabIndex = 31;
            this.label16.Text = "Input";
            // 
            // Scheduling
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1045, 459);
            this.Controls.Add(this.label16);
            this.Controls.Add(this.label15);
            this.Controls.Add(this.label14);
            this.Controls.Add(this.label13);
            this.Controls.Add(this.label12);
            this.Controls.Add(this.label11);
            this.Controls.Add(this.label10);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.lvNote);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.btnDeleteProcess);
            this.Controls.Add(this.btnUpdateProcess);
            this.Controls.Add(this.txtTimeQuantum);
            this.Controls.Add(this.btnAddProcess);
            this.Controls.Add(this.btnResetProcess);
            this.Controls.Add(this.txtPriority);
            this.Controls.Add(this.txtExecuteTime);
            this.Controls.Add(this.txtStartTime);
            this.Controls.Add(this.txtProcessname);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lvOutputData);
            this.Controls.Add(this.lvInputData);
            this.Controls.Add(this.cbScheduling);
            this.Controls.Add(this.btnRun);
            this.Controls.Add(this.btnNew);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.Name = "Scheduling";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnNew;
        private System.Windows.Forms.Button btnRun;
        private System.Windows.Forms.ComboBox cbScheduling;
        private System.Windows.Forms.ListView lvInputData;
        private System.Windows.Forms.ListView lvOutputData;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txtProcessname;
        private System.Windows.Forms.TextBox txtStartTime;
        private System.Windows.Forms.TextBox txtExecuteTime;
        private System.Windows.Forms.TextBox txtPriority;
        private System.Windows.Forms.Button btnResetProcess;
        private System.Windows.Forms.Button btnAddProcess;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.TextBox txtTimeQuantum;
        private System.Windows.Forms.Button btnUpdateProcess;
        private System.Windows.Forms.Button btnDeleteProcess;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.ColumnHeader columnHeader5;
        private System.Windows.Forms.ColumnHeader columnHeader6;
        private System.Windows.Forms.ColumnHeader columnHeader7;
        private System.Windows.Forms.ColumnHeader columnHeader8;
        private System.Windows.Forms.ColumnHeader columnHeader9;
        private System.Windows.Forms.ColumnHeader columnHeader10;
        private System.Windows.Forms.ListView lvNote;
        private System.Windows.Forms.ColumnHeader columnHeader11;
        private System.Windows.Forms.ColumnHeader columnHeader12;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.Label label16;
    }
}

