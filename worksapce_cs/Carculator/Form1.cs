using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Carculator
{
    public partial class Form1 : Form
    {
        string op = null;
        bool isNew = false;
        int first = 0;

        public Form1()
        {
            InitializeComponent();
        }
        
        private void setText(string str)
        {
            display.Text = str;
        }

        private void addText(string str)
        {
            if (!isNew)
            {
                display.Text += str;
                int num = Int32.Parse(display.Text);
                display.Text = num.ToString();
            }
            else
            {
                setText(str);
                isNew = false;
            }
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            addText("8");
            //display.Text += "8";
            //int num = Int32.Parse(display.Text);
            //display.Text = num.ToString();
        }

    

        private void btn7_Click(object sender, EventArgs e)
        {
            addText("7");
            //display.Text += "7";
            //int num = Int32.Parse(display.Text);
            //display.Text = num.ToString();
        }

        private void btn_point_Click(object sender, EventArgs e)
        {
            setText("0");
        }

        private void btn9_Click(object sender, EventArgs e)
        {
            addText("9");
        }

        private void btn4_Click(object sender, EventArgs e)
        {
            addText("4");
        }

        private void btn5_Click(object sender, EventArgs e)
        {
            addText("5");
        }

        private void btn6_Click(object sender, EventArgs e)
        {
            addText("6");
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            addText("1");
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            addText("2");
        }

        private void btn3_Click(object sender, EventArgs e)
        {
            addText("3");
        }

        private void btn0_Click(object sender, EventArgs e)
        {
            addText("0");
        }

        private void btn_p_Click(object sender, EventArgs e)
        {
            // "더하기" 선택했다는 걸 저장
            op = "합";
            isNew = true;
            first = Int32.Parse(display.Text);
        }

        private void button15_Click(object sender, EventArgs e)
        {
            int second = Int32.Parse(display.Text);
            switch (op)
            {
                case "합":
                    int result = first + second;
                    setText("" + result);
                    isNew = true;
                    break;

                case "빼기":
                    result = first - second;
                    setText("" + result);
                    isNew = true;
                    break;

                case "곱":
                    result = first * second;
                    setText("" + result);
                    isNew = true;
                    break;

                case "나누기":
                    if (display.Text == "0")
                    {
                        setText("0으로 나누어지지 않습니다.");
                        break;
                    }
                    else {
                        result = first / second;
                        setText("" + result);
                        isNew = true;
                        break;
                    }
                    
            }
        }

        private void btn_m_Click(object sender, EventArgs e)
        {
            // "빼기" 선택했다는 걸 저장
            op = "빼기";
            isNew = true;
            first = Int32.Parse(display.Text);
        }

        private void btn_t_Click(object sender, EventArgs e)
        {
            // "곱하기" 선택했다는 걸 저장
            op = "곱";
            isNew = true;
            first = Int32.Parse(display.Text);
        }

        private void btn_e_Click(object sender, EventArgs e)
        {
            // "나누기" 선택했다는 걸 저장
            op = "나누기";
            isNew = true;
            first = Int32.Parse(display.Text);
        }
    }
}
