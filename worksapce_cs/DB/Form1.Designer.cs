namespace DB
{
    partial class Form1
    {
        /// <summary>
        /// 필수 디자이너 변수입니다.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 사용 중인 모든 리소스를 정리합니다.
        /// </summary>
        /// <param name="disposing">관리되는 리소스를 삭제해야 하면 true이고, 그렇지 않으면 false입니다.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form 디자이너에서 생성한 코드

        /// <summary>
        /// 디자이너 지원에 필요한 메서드입니다. 
        /// 이 메서드의 내용을 코드 편집기로 수정하지 마세요.
        /// </summary>
        private void InitializeComponent()
        {
            this.viewBtn = new System.Windows.Forms.Button();
            this.listView = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // viewBtn
            // 
            this.viewBtn.Font = new System.Drawing.Font("맑은 고딕", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.viewBtn.Location = new System.Drawing.Point(12, 12);
            this.viewBtn.Name = "viewBtn";
            this.viewBtn.Size = new System.Drawing.Size(117, 37);
            this.viewBtn.TabIndex = 0;
            this.viewBtn.Text = "목록조회";
            this.viewBtn.UseVisualStyleBackColor = true;
            this.viewBtn.Click += new System.EventHandler(this.viewBtn_Click);
            // 
            // listView
            // 
            this.listView.FormattingEnabled = true;
            this.listView.ItemHeight = 12;
            this.listView.Location = new System.Drawing.Point(12, 55);
            this.listView.Name = "listView";
            this.listView.Size = new System.Drawing.Size(596, 472);
            this.listView.TabIndex = 1;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(620, 542);
            this.Controls.Add(this.listView);
            this.Controls.Add(this.viewBtn);
            this.Name = "Form1";
            this.Text = "데이터 조회";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button viewBtn;
        private System.Windows.Forms.ListBox listView;
    }
}

