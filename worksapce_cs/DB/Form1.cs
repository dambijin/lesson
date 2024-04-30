using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DB
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void viewBtn_Click(object sender, EventArgs e)
        {
            // 오라클 연결
            string strConnInfo = "Data Source=112.148.46.134:51521; User Id=scott4_12; Password=tiger; ";
            OracleConnection con = new OracleConnection(strConnInfo);
            con.Open();

            // SQL 실행 준비
            string sql = "select * from emp3";


            //OracleCommand cmd = new OracleCommand(sql, con);
            OracleCommand cmd = new OracleCommand();
            cmd.Connection = con;
            cmd.CommandText = sql;
            //cmd.Parameters.Add(new OracleParameter("eno", 7800));

            // SQL 실행
            // select 말고 다른 것들 업데이트 같은거
            // int result = cmd.ExecuteNonQuery();
            // select인 경우
            OracleDataReader odr =cmd.ExecuteReader();
            int count = 0;
            
            // 한줄 가져오기
            while(odr.Read())
            {
                // 컬럼 하나 읽기
                Object empno = odr["EMPNO"];
                Object ename = odr["ename"];

                // 화면 listbox에 표시
                listView.Items.Add(empno);
                listView.Items.Add(ename);
            }
            odr.Close();
        }
    }
}
