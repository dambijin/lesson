package swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


// awt
// swing
// javaFX

public class SwingExam {

	public static void main(String[] args) {
		System.out.println("Good Bye World");
		draw();
	}
	
	static void draw() {
	
		// 윈도우창 생성
		JFrame frame = new JFrame();
		// 윈도우 초기 크기/가로 800, 세로 500
		frame.setSize(800, 500);
		
		// 창 떨어뜨리는 위치
		// 화면 왼쪽 위를 기준으로 위치 설정
		frame.setLocation(100, 50);
		
		// 버튼 생성
		JButton btn1 = new JButton("동쪽진태");
		JButton btn2 = new JButton("서쪽진태");
		JButton btn3 = new JButton("남쪽진태");
		JButton btn4 = new JButton("북쪽진태");
		
		// 레이아웃 매니저 설정
		frame.setLayout(new BorderLayout());
		// 버튼 추가 하면서 위치 지정
		frame.add(btn1, BorderLayout.EAST);
		frame.add(btn2, BorderLayout.WEST);
		frame.add(btn3, BorderLayout.SOUTH);
		frame.add(btn4, BorderLayout.NORTH);
		
		// 윈도우를 보이게 표시
		frame.setVisible(true);
		
		
		
	}
	
	
}
