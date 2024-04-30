// 한줄주석
/*
 * 여러줄 주석
 */

using System;

// namespace - JAVA 패키지 개념(폴더x 영역개념)
//             클래스를 모아 놓는 역할
//             클래스 명이 namespace별로 겹치지만 않으면 됨.
namespace sec01.ex01
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello world!!");

            int i = 4;
            int i2 = 0b0100; // 2진수
            int i16 = 0x04; // 16진수

            Console.WriteLine(i16 >> 1); // 2
            Console.WriteLine(i16 >> 1); // 2

            if ((i16 & 0b0001) == 0b0001)
            {
                Console.WriteLine("첫번째 bit가 1");
            }
            else
            {
                Console.WriteLine("첫번째 bit가 1이 아님");
            }

            if((i16 & 0b0100) == 0b0100)
            {
                Console.WriteLine("세번째 bit가 1");
            }

            Console.WriteLine(i16 | 0b1000);
        }
    }
}