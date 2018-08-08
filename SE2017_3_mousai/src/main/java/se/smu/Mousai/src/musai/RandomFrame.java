package musai;

import musai.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class RandomFrame extends JFrame {
	
	private JPanel contentPane;
 
	public static void main(String[] args) {
		RandomFrame frame = new RandomFrame();
		frame.setVisible(true);
	}

	public RandomFrame() {
		
		////////////////////////////////할일 추천창 전체 프레임
		setBounds(100, 100, 475, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//할일추천창 제목 레이블
		JLabel lblNewLabel_1 = new JLabel("\uC624\uB298\uC758 \uD560 \uC77C");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_1.setBounds(139, 17, 178, 70);
		contentPane.add(lblNewLabel_1);
		
		//포춘쿠키 사진
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191828007.png"));
		lblNewLabel.setBounds(0, 99, 457, 336);
		contentPane.add(lblNewLabel);
		
		//할일 추천 버튼
		JButton btnNewButton = new JButton("\uACB0\uACFC\uD655\uC778");
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.setBounds(164, 447, 129, 47);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {//버튼 클릭시 수행 동작
			public void actionPerformed(ActionEvent e) {
				RandomResult nl;
				try {
					nl = new RandomResult();
					nl.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//할일 추천 확인창 생성		
			}
		});
	}
	
}
