package musai;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class RandomResult extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) throws IOException {
		RandomResult frame = new RandomResult();
		frame.setVisible(true);
	}

	public RandomResult() throws IOException {
		
		//////////////////////////////////할일 추천 확인창 전체 프레임
		setBounds(100, 100, 475, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//할일 추천 확인창 제목 레이블
		JLabel label = new JLabel("\uC624\uB298\uC758 \uD560 \uC77C");
		label.setBackground(new Color(128, 128, 128));
		label.setForeground(new Color(128, 128, 128));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		label.setBounds(139, 17, 178, 70);
		contentPane.add(label);
		
		//할일 추천 확인창 포춘쿠키 사진
		JLabel lblNewLabel = new JLabel("\uC624\uB298\uC758 \uD560 \uC77C");
		lblNewLabel.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191828007.png"));
		lblNewLabel.setBounds(0, 99, 457, 336);
		contentPane.add(lblNewLabel);
		
		//할일 추천 확인창 나가기 버튼
		JButton btnNewButton = new JButton("\uB098\uAC00\uAE30");
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.setBounds(164, 447, 119, 47);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {//버튼 클릭시 수행 동작
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});	
		while(true){
			File data = new File("datatd.dt");
			BufferedReader in = new BufferedReader(new FileReader(data));
			int count=0;
			int ran=0;
			String temp;
			while ((temp = in.readLine()) != null) {
				count++;
			}
			in.close();

			
			
			Calendar random = Calendar.getInstance();
			int sec = random.get(Calendar.SECOND);
			ran = (sec % count)+1;
		
			File data1 = new File("datatd.dt");
			BufferedReader in1 = new BufferedReader(new FileReader(data));
			String s;
			count=0;
			while ((s = in1.readLine()) != null) {
				count++;
				if(count==ran){
					break;
				}
			}
			in1.close();
		
			
			int countindex=0;
			for(int i = 7; i<s.length();i++){
				if(s.charAt(i)==':'&&s.charAt(i+1)==':'){
					countindex++;
				}
				if(countindex==3&&s.charAt(i+2)=='완'){
					countindex=-1;
					break;
				}
				else if(countindex==3&&s.charAt(i+2)=='진'){
					break;
				}
			}
			if(countindex==-1){
				continue;
			}
			else{
				String s1="";
				for(int i = 7; !(s.charAt(i)==':'&&s.charAt(i+1)==':');i++){
					s1 = s1 + s.charAt(i);
				}
				
				JLabel tolabel = new JLabel(s1);
				tolabel.setBounds(0, 100, 457, 336);
				tolabel.setFont(new Font("맑은 고딕", Font.BOLD, 70));
				lblNewLabel.add(tolabel);
				break;
			}
		}
	}
}
