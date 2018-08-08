package musai;

import musai.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class DelToDo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	// Launch the application.
	public static void main(String[] args) throws IOException {
		DelToDo frame = new DelToDo();
		frame.setVisible(true);
	}

	public DelToDo() {
	}

	// Create the frame.
	public DelToDo(String conttd) throws IOException {

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		 this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) { 
           	 try {
						Mainframe ma = new Mainframe();
						ma.setVisible(true);
						dispose();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
            }
		 });
		
		
		
		
		///////////////////////////////////// 할일 추가창 전체 프레임
		setBounds(100, 100, 435, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// 할일 명 레이블
		JLabel lblTodo = new JLabel("TODO\uBA85");
		lblTodo.setForeground(new Color(128, 128, 128));
		lblTodo.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		lblTodo.setBounds(14, 10, 112, 32);
		contentPane.add(lblTodo);

		// 할일 명 텍스트 필드
		textField_1 = new JTextField();
		textField_1.setBounds(133, 10, 116, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		// 과목 선택 레이블
		JLabel label = new JLabel("\uACFC\uBAA9 \uC120\uD0DD");
		label.setForeground(new Color(128, 128, 128));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label.setBounds(14, 60, 112, 32);
		contentPane.add(label);

		// 과목 선택 콤보 박스
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(133, 60, 119, 32);
		contentPane.add(comboBox);

		// 파일 읽고 콤보 박스에 출력
		File data = new File("data.dt");
		BufferedReader in = new BufferedReader(new FileReader(data));
		String s;
		String s1;
		while ((s = in.readLine()) != null) {
			s1 = "";
			for (int i = 6; i < s.length(); i++) {
				if (s.charAt(i + 1) == '<' && s.charAt(i + 2) == 'b' && s.charAt(i + 3) == 'r'
						&& s.charAt(i + 4) == '>') {
					break;
				}
				s1 = s1 + s.charAt(i + 1);
			}
			comboBox.addItem(s1);
		}
		in.close();

		// 마감 기한 레이블
		JLabel label_1 = new JLabel("\uB9C8\uAC10 \uAE30\uD55C");
		label_1.setForeground(new Color(128, 128, 128));
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label_1.setBounds(14, 120, 112, 32);
		contentPane.add(label_1);

		// 마감기한 1번 콤보박스(번호 대신에 무엇이 들어가는지 알아서 주석 수정 할 것)
		JComboBox comboBox_1 = new JComboBox();
		for (int i = 1; i < 13; i++) {
			comboBox_1.addItem(i);
		}
		comboBox_1.setBounds(133, 120, 59, 31);
		contentPane.add(comboBox_1);

		// 월
		JLabel month = new JLabel("\uC6D4");
		month.setForeground(new Color(128, 128, 128));
		month.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		month.setBounds(195, 120, 30, 30);
		contentPane.add(month);

		// 마감 기한 2번 콤보박스
		JComboBox comboBox_2 = new JComboBox();
		GregorianCalendar cal = new GregorianCalendar();
		for (int i = 1; i <= cal.getActualMaximum(cal.DAY_OF_MONTH); i++) {
			comboBox_2.addItem(i);
		}
		comboBox_2.setBounds(222, 120, 59, 31);
		contentPane.add(comboBox_2);

		// 일
		JLabel day = new JLabel("\uC77C");
		day.setForeground(new Color(128, 128, 128));
		day.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		day.setBounds(284, 120, 30, 30);
		contentPane.add(day);

		// 마감 기한 3번 콤보박스
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(311, 120, 59, 31);
		for (int i = 0; i < 24; i++) {
			comboBox_7.addItem(i);
		}
		contentPane.add(comboBox_7);

		// 시
		JLabel hour = new JLabel("\uC2DC");
		hour.setForeground(new Color(128, 128, 128));
		hour.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		hour.setBounds(373, 120, 30, 30);
		contentPane.add(hour);

		// 실제 마감일 레이블
		JLabel label_2 = new JLabel("\uC2E4\uC81C\uB9C8\uAC10\uC77C");
		label_2.setForeground(new Color(128, 128, 128));
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label_2.setBounds(14, 190, 125, 32);
		contentPane.add(label_2);

		// 실제마감일 1번 콤보박스(번호 대신에 무엇이 들어가는지 알아서 주석 수정 할 것)
		JComboBox comboBox_3 = new JComboBox();
		for (int i = 1; i < 13; i++) {
			comboBox_3.addItem(i);
		}
		comboBox_3.setBounds(133, 190, 59, 31);
		contentPane.add(comboBox_3);

		// 월
		JLabel month1 = new JLabel("\uC6D4");
		month1.setForeground(new Color(128, 128, 128));
		month1.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		month1.setBounds(195, 190, 30, 30);
		contentPane.add(month1);

		// 실제 마감일 2번 콤보박스
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(222, 190, 59, 31);
		for (int i = 1; i <= cal.getActualMaximum(cal.DAY_OF_MONTH); i++) {
			comboBox_4.addItem(i);
		}
		contentPane.add(comboBox_4);

		// 일
		JLabel day1 = new JLabel("\uC77C");
		day1.setForeground(new Color(128, 128, 128));
		day1.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		day1.setBounds(284, 190, 30, 30);
		contentPane.add(day1);

		// 실제 마감일 3번 콤보박스
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(311, 190, 59, 31);
		for (int i = 0; i < 24; i++) {
			comboBox_8.addItem(i);
		}
		contentPane.add(comboBox_8);

		// 시
		JLabel hour1 = new JLabel("\uC2DC");
		hour1.setForeground(new Color(128, 128, 128));
		hour1.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		hour1.setBounds(373, 190, 30, 30);
		contentPane.add(hour1);

		// 알림 기능 레이블
		JLabel label_3 = new JLabel("\uC54C\uB9BC \uAE30\uB2A5");
		label_3.setForeground(new Color(128, 128, 128));
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label_3.setBounds(14, 260, 112, 32);
		contentPane.add(label_3);

		// 알림기능 1번 콤보박스(번호 대신에 무엇이 들어가는지 알아서 주석 수정 할 것)
		JComboBox comboBox_5 = new JComboBox();
		for (int i = 0; i < 13; i++) {
			comboBox_5.addItem(i);
		}
		comboBox_5.setBounds(133, 260, 59, 31);
		contentPane.add(comboBox_5);

		// 월
		JLabel month2 = new JLabel("\uC6D4");
		month2.setForeground(new Color(128, 128, 128));
		month2.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		month2.setBounds(195, 260, 30, 30);
		contentPane.add(month2);

		// 알림기능 2번 콤보박스
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(222, 260, 59, 31);
		for (int i = 0; i <= cal.getActualMaximum(cal.DAY_OF_MONTH); i++) {
			comboBox_6.addItem(i);
		}
		contentPane.add(comboBox_6);

		// 일
		JLabel day2 = new JLabel("\uC77C");
		day2.setForeground(new Color(128, 128, 128));
		day2.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		day2.setBounds(284, 260, 30, 30);
		contentPane.add(day2);

		// 알림기능 3번 콤보박스
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(311, 260, 59, 31);
		for (int i = 0; i < 24; i++) {
			comboBox_9.addItem(i);
		}
		contentPane.add(comboBox_9);

		// 시
		JLabel hour2 = new JLabel("\uC2DC");
		hour2.setForeground(new Color(128, 128, 128));
		hour2.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		hour2.setBounds(373, 260, 30, 30);
		contentPane.add(hour2);

		// 세부 사항 레이블
		JLabel label_4 = new JLabel("\uC138\uBD80 \uC0AC\uD56D");
		label_4.setForeground(new Color(128, 128, 128));
		label_4.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label_4.setBounds(14, 333, 112, 32);
		contentPane.add(label_4);

		// 세부사항 텍스트 입력창
		textField = new JTextField();
		textField.setBounds(133, 325, 270, 54);
		contentPane.add(textField);
		textField.setColumns(10);

		// 완료여부 레이블
		JLabel label_5 = new JLabel("\uC644\uB8CC \uC5EC\uBD80");
		label_5.setForeground(new Color(128, 128, 128));
		label_5.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label_5.setBounds(14, 406, 112, 32);
		contentPane.add(label_5);

		// 완료여부 체크박스
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setForeground(new Color(240, 255, 240));
		chckbxNewCheckBox.setBounds(133, 406, 25, 27);
		contentPane.add(chckbxNewCheckBox);

		// 중요여부 레이블
		JLabel label_6 = new JLabel("\uC911\uC694 \uC5EC\uBD80");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		label_6.setBounds(186, 406, 96, 32);
		contentPane.add(label_6);


		// 확인 버튼
		JButton button = new JButton();
		button.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191838663.png"));
		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
		button.setBounds(80, 463, 59, 38);
		contentPane.add(button);

		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(295, 409, 80, 32);
		comboBox_10.addItem("보통");
		comboBox_10.addItem("중요");
		comboBox_10.addItem("매우 중요");
		contentPane.add(comboBox_10);

		button.addActionListener(new ActionListener() {// 버튼 클릭시 수행 동작
			public void actionPerformed(ActionEvent e) {
				String[] map2 = new String[1000];
				String[] map3 = new String[1000];
				String[] time = new String[1000];
				String temp = "";
				String conttdtemp = "";
				BufferedReader bw = null;
				FileWriter al = null;
				FileWriter fw = null;
				
				
				try {
					bw = new BufferedReader(new FileReader("datatd.dt"));
					int i = 0;
					int tempindex = 0;
					int timeindex = 0;
					int conttdtempindex = 0;
					
					
					
					while ((map2[i] = bw.readLine()) != null) {
						map3[i]="";
						for(int k=0; k<map2[i].length()-2;k++){
							if(map2[i].charAt(k)==':'&&map2[i].charAt(k+1)==':'&&map2[i].charAt(k+2)==':'){
								break;
							}
							map3[i] = map3[i] + map2[i].charAt(k); 
						}
						map3[i]=map3[i] + "</html>";
						
						
						map3[i] = map3[i].replaceAll(" ", "");
						
						
						
						tempindex = map3[i].toString().indexOf("알림시간");
						if(tempindex!=-1){
							for(int tt = tempindex+5; !(map3[i].charAt(tt)==':'&&map3[i].charAt(tt+1)==':');tt++){
								temp = temp+map3[i].charAt(tt);
							}
							temp = temp.replaceAll("월", "\t");
							temp = temp.replaceAll("일", "\t");
							temp = temp.replaceAll("시", "\t");
							time[timeindex] = temp;
							timeindex++;
							temp="";
						}
						
						
						i++;
					}
					
					bw.close();
					
					
					
					conttdtempindex = conttd.toString().indexOf("알림시간");
					if(conttdtempindex!=-1){
						for(int tt = conttdtempindex+5; !(conttd.charAt(tt)==':'&&conttd.charAt(tt+1)==':');tt++){
							conttdtemp = conttdtemp+conttd.charAt(tt);
						}
						conttdtemp = conttdtemp.replaceAll("월", "\t");
						conttdtemp = conttdtemp.replaceAll("일", "\t");
						conttdtemp = conttdtemp.replaceAll("시", "\t");
					}
					
					
					
					
					
					
					
					
					for(int j=0;j<timeindex;j++){
						if(conttdtemp.equals(time[j])){
							time[j]="";
						}
					}
					al = new FileWriter("alarmtime.dt");
					al.flush();
					for(int j=0; j<timeindex;j++){
						if(!("".equals(time[j]))){
							al.write(time[j]+"\n");
						}
					}
					al.flush();
					al.close();
					
					for (int j = 0; j < i; j++) {
						if (conttd.equals(map3[j])) {
							map2[j] = "";
							
						}
					}
					fw = new FileWriter("datatd.dt");
					fw.flush();
					for (int j = 0; j < i; j++) {
						if (!("".equals(map2[j]))) {
							fw.write(map2[j] + "\n");
						}
					}
					fw.flush();
					fw.close();
					
				} catch (IOException c) {
					c.printStackTrace();
				} finally {
					if (bw != null)
						try {
							bw.close();
						} catch (IOException s) {
						}
				}
				//dispose();
			
				int count = 0;
				try {
					File data = new File("datatd.dt");
					File alarm = new File("alarmtime.dt");
					FileWriter fw1 = new FileWriter(alarm,true);
					FileWriter fw2 = new FileWriter(data, true);
					if (!(textField_1.getText().equals(""))) {
						fw2.write(" <html>");
						fw2.write(textField_1.getText());
						fw2.write("::");
						count++;
					}
					if (count == 1) {
						fw2.write(comboBox.getSelectedItem().toString());
					}
					if (count == 1) {
						fw2.write("<br>마감기한 : ");
						fw2.write(comboBox_1.getSelectedItem().toString());
					}
					if (count == 1) {
						fw2.write("월 ");
						fw2.write(comboBox_2.getSelectedItem().toString());
					}
					if (count == 1) {
						fw2.write("일 ");
						fw2.write(comboBox_7.getSelectedItem().toString());
						fw2.write("시::");
					}
					if (count == 1) {
						fw2.write("실제 마감일 : ");
						fw2.write(comboBox_3.getSelectedItem().toString());
					}
					if (count == 1) {
						fw2.write("월 ");
						fw2.write(comboBox_4.getSelectedItem().toString());
					}
					if (count == 1) {
						fw2.write("일 ");
						fw2.write(comboBox_8.getSelectedItem().toString());
						fw2.write("시<br>");
					}
					if (comboBox_5.getSelectedItem().toString().equals("0")&&comboBox_6.getSelectedItem().toString().equals("0")) {
						fw2.write("알림 꺼짐::");
					} else {
						if (count == 1) {
							fw2.write("알림 시간 : ");
							fw2.write(comboBox_5.getSelectedItem().toString());
							fw1.write(comboBox_5.getSelectedItem().toString()+"\t");
						}
						if (count == 1) {
							fw2.write("월 ");
							fw2.write(comboBox_6.getSelectedItem().toString());
							fw1.write(comboBox_6.getSelectedItem().toString()+"\t");
						}
						if (count == 1) {
							fw2.write("일 ");
							fw2.write(comboBox_9.getSelectedItem().toString());
							fw1.write(comboBox_9.getSelectedItem().toString()+"\n");
							fw2.write("시::");
						}
					}
					if ((chckbxNewCheckBox.isSelected()) && count == 1) {
						fw2.write("완료::");
						fw2.write(comboBox_10.getSelectedItem().toString());
						fw2.write(":::");
						fw2.write(textField.getText());

					} else {
						fw2.write("진행중::");
						fw2.write(comboBox_10.getSelectedItem().toString());
						fw2.write(":::");
						fw2.write(textField.getText());
					}
					if (count == 1) {
						fw2.write("</html>");
						fw2.write("\n");
						fw2.flush();
						fw1.flush();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (count != 1) {
					Warning warn = new Warning();
					warn.setVisible(true);
					count = 0;
				} else {
					try {
						Mainframe ma = new Mainframe();
						ma.setVisible(true);
						dispose();// 창닫기
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		String str = "";
		String str1 = "";
		for (int i = 6; !(conttd.charAt(i) == ':' && conttd.charAt(i + 1) == ':'); i++) {
			str1 = str1 + conttd.charAt(i);
			textField_1.setText(str1);
		}

		File data1 = new File("datatd.dt");
		BufferedReader bw = new BufferedReader(new FileReader(data1));
		String[] map2=new String [1000];
		String[] map3=new String [1000];
		int i = 0;
		while ((map2[i] = bw.readLine()) != null) {
			map3[i]="";
			for(int k=0; k<map2[i].length()-2;k++){
				if(map2[i].charAt(k)==':'&&map2[i].charAt(k+1)==':'&&map2[i].charAt(k+2)==':'){
					break;
				}
				map3[i] = map3[i] + map2[i].charAt(k); 
			}
			map3[i]=map3[i] + "</html>";
			
			
			map3[i] = map3[i].replaceAll(" ", "");
					
					
					
			if(map3[i].equals(conttd)){
				for (int x = map2[i].indexOf(":::")+3; !(map2[i].charAt(x) == '<'); x++) {
					str = str + map2[i].charAt(x);
					textField.setText(str);
				}
			}
					
					
					
			i++;
		}
		bw.close();

		
		
		

		JButton delbutton_1 = new JButton("");
		delbutton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteTo dll = new DeleteTo(conttd);
				dll.setVisible(true);
				dispose();
			}
		});
		delbutton_1.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191824909.png"));
		delbutton_1.setForeground(Color.BLACK);
		delbutton_1.setBackground(Color.WHITE);
		delbutton_1.setBounds(255, 463, 59, 38);
		contentPane.add(delbutton_1);
		
	}
}
