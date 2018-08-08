package musai;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.*;

public class Mainframe extends JFrame {

	private JPanel contentPane = new JPanel();
	private JTextField textField;

	// Launch the application.
	public static void main(String[] args) throws IOException, InterruptedException {
		Mainframe frame = new Mainframe();
		frame.setVisible(true);
		///알람
		File alarm = new File("alarmtime.dt");
		int month = 0, date = 0, hour = 0, counter = 0;
		while (true) {
			FileReader alarmdt = new FileReader(alarm);
			Calendar cal = Calendar.getInstance();
			// 월 구하기
			for (int i = 0; i < 3; i++) {
				int alstd = alarmdt.read();
				if (alstd == 9) {
					break;
				}
				alstd -= 48;
				month *= 10;
				month += alstd;
			}
			
			// 일 구하기
			for (int i = 0; i < 3; i++) {
				int alstd = alarmdt.read();
				if (alstd == 9) {
					break;
				}
				alstd -= 48;
				date *= 10;
				date += alstd;
			}
			
			// 시 구하기
			for (int i = 0; i < 3; i++) {
				int alstd = alarmdt.read();
				if (alstd == 10) {
					break;
				}
				if (alstd == 13) {
					break;
				}
				alstd -= 48;
				hour *= 10;
				hour += alstd;
			}
			
			int mon = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int ho = cal.get(Calendar.HOUR_OF_DAY);
			int min = cal.get(Calendar.MINUTE);
			mon += 1;
			if (month == mon && date == day && hour == ho && min < 5) {
				Alarm alarm1 = new Alarm();
				alarm1.setVisible(true);
				Thread.sleep(300*1000);
			}
			month = 0;
			date = 0;
			hour = 0;
		}
	}

	// Create the frame.
	public Mainframe() throws IOException {
		
		// 전체 프레임
		super("Mousai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		/////////////////////////////////////// 과목 패널
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 240));
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(5, 58, 380, 260);
		panel.setLayout(null);
		contentPane.add(panel);

		// 과목 제목 레이블
		JLabel lblNewLabel = new JLabel("\uACFC\uBAA9 List");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblNewLabel.setBounds(132, 12, 116, 39);
		panel.add(lblNewLabel);

		// 과목 추가 버튼
		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191838807.png"));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(297, 12, 39, 39);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {// 버튼 클릭시 수행 동작
			public void actionPerformed(ActionEvent e) {
				NewLecture nl = new NewLecture();// 과목 추가 생성
				nl.setVisible(true);
				dispose();
			}
		});

		///////////// 과목 표시
		// 패널
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 61, 356, 189);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1));
		panel_3.setForeground(new Color(255, 255, 240));
		panel_3.setBackground(new Color(255, 255, 240));
		panel_3.setBorder(new LineBorder(Color.black));

		// 파일 읽고 출력
		File data = new File("data.dt");
		BufferedReader in = new BufferedReader(new FileReader(data));
		String s;
		while ((s = in.readLine()) != null) {
			s = s.replaceAll(" ", "");
			JButton cont = new JButton(s);
			cont.setBounds(0, 0, 356, 50);
			cont.setForeground(new Color(0, 0, 0));
			cont.setBorder(new LineBorder(Color.black));
			panel_3.add(cont);
			cont.addMouseListener(new MyMouseListener2() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						DelLecture DL = null;
						DL = new DelLecture(cont.getText());
						DL.setVisible(true);
						dispose();
					}
				}
			});
		}
		in.close();

		// 과목 길어질 때 스크롤 추가
		JScrollPane sp = new JScrollPane(panel_3, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(12, 61, 356, 189);
		panel.add(sp);

		///////////////////////////////////////// 세부사항 패널
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(new Color(255, 255, 240));
		panel_2.setBackground(new Color(255, 255, 240));
		panel_2.setBounds(5, 325, 770, 225);
		contentPane.add(panel_2);

		// 세부사항 제목 레이블
		JLabel lblTodolist_2 = new JLabel("TodoList \uC138\uBD80\uC0AC\uD56D");
		lblTodolist_2.setForeground(new Color(128, 128, 128));
		lblTodolist_2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblTodolist_2.setBounds(263, 12, 244, 39);
		panel_2.add(lblTodolist_2);

		///////////// 할일 세부사항 표시
		// 패널
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(12, 61, 746, 154);
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1));
		panel_5.setForeground(new Color(255, 255, 240));
		panel_5.setBackground(new Color(255, 255, 240));
		panel_5.setBorder(new LineBorder(Color.black));

		JLabel jl = new JLabel();
		panel_5.add(jl);

		// 과목 길어질 때 스크롤 추가

		JScrollPane sptddt = new JScrollPane(panel_5, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sptddt.setBounds(12, 61, 746, 154);
		panel_2.add(sptddt);

		//////////////////////////////////////// to do 패널
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(new Color(255, 255, 240));
		panel_1.setBackground(new Color(255, 255, 240));
		panel_1.setBounds(395, 58, 380, 260);
		// panel_1.setBorder(new LineBorder(Color.gray));
		contentPane.add(panel_1);

		// to do 제목 라벨
		JLabel lblTodolist_1 = new JLabel("ToDoList");
		lblTodolist_1.setForeground(new Color(128, 128, 128));
		lblTodolist_1.setBackground(new Color(30, 144, 255));
		lblTodolist_1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblTodolist_1.setBounds(75, 12, 112, 39);
		panel_1.add(lblTodolist_1);

		// to do 추가 버튼
		JButton button = new JButton();
		button.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191838807.png"));// 아이콘
																					// 이미지
																					// 위치
		button.setBackground(Color.white);
		button.setBounds(185, 12, 39, 39);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {// 버튼 누를시 수행 동작
			public void actionPerformed(ActionEvent arg0) {
				NewToDo rf = null;
				try {
					rf = new NewToDo();
				} catch (IOException e) {
					e.printStackTrace();
				} // NewToDo생성
				rf.setVisible(true);
				dispose();
			}
		});

		JCheckBox checkBox = new JCheckBox("\uC644\uB8CC\uD45C\uC2DC");
		checkBox.setBounds(257, 43, 90, 15);
		panel_1.add(checkBox);

		
		// to do 정렬기능 박스
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(230, 10, 65, 30);
		comboBox_1.addItem("전체");
		comboBox_1.addItem("진행중");
		comboBox_1.addItem("이름");
		comboBox_1.addItem("마감일");
		comboBox_1.addItem("완료");
		comboBox_1.addItem("끝낸일");
		panel_1.add(comboBox_1);

		///////////// 할일 표시
		// 패널
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 61, 356, 189);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1));
		panel_4.setForeground(new Color(255, 255, 240));
		panel_4.setBackground(new Color(255, 255, 240));
		panel_4.setBorder(new LineBorder(Color.black));

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String std;
		File datatd = new File("datatd.dt");
		String std1 = "";
		String str1[] = new String[1000];
		int k = 0;
		BufferedReader intd = new BufferedReader(new FileReader(datatd));
		while ((std = intd.readLine()) != null) {
			for (int i = 0; !(std.charAt(i) == ':' && std.charAt(i + 1) == ':' && std.charAt(i + 2) == ':'); i++) {
				std1 = std1 + std.charAt(i);
			}
			std1 = std1 + "</html>";
			if(!(checkBox.isSelected())){
				int countindex=0,goingindex=0;
				for (int i = 0; i < std1.length(); i++) {
					if (std1.charAt(i) == ':' && std1.charAt(i + 1) == ':') {
						countindex++;
					}
					if (countindex == 3) {
						goingindex = i;
						countindex = 0;
						break;
					}
				}
				if (std1.charAt(goingindex + 2) == '완') {
					std1 = std1.replaceFirst(" ", "a");
				}
			}
			str1[k] = std1;
			std1 = "";
			k++;
		}
		for (int a = 0; a < k; a++) {// 패널 버튼추가
			if(str1[a].charAt(0)=='a'){
				continue;
			}
			str1[a] = str1[a].replaceAll(" ", "");
			JButton conttd = new JButton(str1[a]);
			conttd.setBounds(0, 0, 356, 50);
			conttd.setForeground(new Color(0, 0, 0));
			conttd.setBorder(new LineBorder(Color.black));
	         conttd.addMouseListener(new MyMouseListener(){
	       	  public void mouseClicked(MouseEvent e){
	    		  if(e.getClickCount() == 2){
	    	           DelToDo DT = null;
	    	            try {
	    					DT = new DelToDo(conttd.getText());
	    				} catch (IOException e1) {
	    					// TODO Auto-generated catch block
	    					e1.printStackTrace();
	    				}
	    	            DT.setVisible(true);
	    	    		dispose();
	    		  }

	    	  }
	         });
			for(int i = 0; i<str1[a].length();i++){
				if(str1[a].charAt(i+1)=='<'&&str1[a].charAt(i+2)=='/'&&str1[a].charAt(i+3)=='h'&&str1[a].charAt(i+4)=='t'&&str1[a].charAt(i+5)=='m'&&str1[a].charAt(i+6)=='l'&&str1[a].charAt(i+7)=='>'){
					if(str1[a].charAt(i-2)=='우'&&str1[a].charAt(i)=='요'){
						conttd.setBackground(Color.RED);
						break;
					}
					else if(str1[a].charAt(i)=='요'){
						conttd.setBackground(Color.BLUE);
						break;
					}
					else{
						break;
					}
				}
			}
			conttd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String std, std1, std2;
					File datatd = new File("datatd.dt");
					try {
						std1 = " " + conttd.getText();
						BufferedReader intd = new BufferedReader(new FileReader(datatd));
						while ((std = intd.readLine()) != null) {
							int count = 0;
							int i = 0;
							for (i = 0; !(std1.charAt(i) == ':' && std1.charAt(i + 1) == ':'); i++) {
								if (std.charAt(i) == std1.charAt(i)) {
									count++;
								}
							}
							std2 = "";
							if (count == i) {
								count = 0;
								for (i = 3; i < std.length() - 7; i++) {
									if (std.charAt(i - 3) == ':' && std.charAt(i - 2) == ':'&& std.charAt(i - 1) == ':') {
										count++;
									}
									if (count > 0) {
										std2 = std2 + std.charAt(i);
									}
								}
								jl.setText(std2);
								panel_5.updateUI();
							}
						}
						intd.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			panel_4.add(conttd);
		}

		// 정렬버튼
		JButton btnSort = new JButton("SORT");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_4.removeAll();
				panel_4.updateUI();
				
				try {
					// 파일 읽고 출력
					File datatd = new File("datatd.dt");
					BufferedReader intd = new BufferedReader(new FileReader(datatd));
					String std;
					String std1 = "";
					String std2 = "";
					String str1[] = new String[1000];
					String str2[] = new String[1000];
					String temp[] = new String[1000];
					int counter = 0;
					int countindex = 0;
					int goingindex = 0;
					int k = 0;
					int comboindex = 0;
					while ((std = intd.readLine()) != null) {
						for (int i = 0; !(std.charAt(i) == ':' && std.charAt(i + 1) == ':'&& std.charAt(i + 2) == ':'); i++) {
							std1 = std1 + std.charAt(i);
						}
						if(!(checkBox.isSelected())){
							countindex=0;goingindex=0;
							for (int i = 0; i < std1.length(); i++) {
								if (std1.charAt(i) == ':' && std1.charAt(i + 1) == ':') {
									countindex++;
								}
								if (countindex == 3) {
									goingindex = i;
									countindex = 0;
									break;
								}
							}
							if (std1.charAt(goingindex + 2) == '완') {
								std1 = std1.replaceFirst(" ", "a");
							}
						}
						std1 = std1 + "</html>";
						str1[k] = std1;
						std1 = "";
						k++;
					}
					if (comboBox_1.getSelectedItem() == "전체") {
						comboindex = 0;
					} else if (comboBox_1.getSelectedItem() == "진행중") {
						comboindex = 1;
					} else if (comboBox_1.getSelectedItem() == "이름") {
						comboindex = 2;
					} else if (comboBox_1.getSelectedItem() == "마감일") {
						comboindex = 3;
					} else if (comboBox_1.getSelectedItem() == "완료") {
						comboindex = 4;
					} else if (comboBox_1.getSelectedItem() == "끝낸일") {
						comboindex = 5;
					}
					switch (comboindex) {
						case 0:// 전체
							for (counter = 0; counter < k; counter++) {
								str2[counter] = str1[counter];
							}
							break;
							
						case 1:// 진행중
							for (int j = 0; j < k; j++) {
								for (int i = 0; i < str1[j].length(); i++) {
									if (str1[j].charAt(i) == ':' && str1[j].charAt(i + 1) == ':') {
										countindex++;
									}
									if (countindex == 3) {
										goingindex = i;
										countindex = 0;
										break;
									}
								}
								if (str1[j].charAt(goingindex + 2) == '진') {
									str2[counter] = str1[j];
									counter++;
								}
							}
							break;

						case 2:// 이름순
							for (int j = 0; j < k; j++) {
								temp[j] = "";
								for (int i = 0; !(str1[j].charAt(i) == ':' && str1[j].charAt(i + 1) == ':'); i++) {
									temp[j] = temp[j] + str1[j].charAt(i);
								}
							}
							for (counter = 0; counter < k; counter++) {
								int j = 0;
								int acount = 0;
								for (int x = 0; x < k; x++) {
									if (temp[x].charAt(0) == 'a') {
										acount++;
										continue;
									}
									if (temp[j].compareTo(temp[x]) > 0) {
										j = x;
									}
									
								}
								if(acount==k){
									break;
								}
								str2[counter] = str1[j];
								temp[j] = temp[j].replaceFirst(" ", "a");
							}	
							break;

						case 3:// 마감일
							for (int j = 0; j < k; j++) {
								temp[j] = " ";
								for (int i = 0; countindex < 2; i++) {
									if (str1[j].charAt(i) == ':' && str1[j].charAt(i + 1) == ':') {
										countindex++;
									}
									if (str1[j].charAt(i) == '<' && str1[j].charAt(i + 1) == 'b'&& str1[j].charAt(i + 2) == 'r' && str1[j].charAt(i + 3) == '>') {
										temp[j] = temp[j] + str1[j].charAt(i);
									}
								}
							}
							for (counter = 0; counter < k; counter++) {
								int j = 0;
								while (temp[j].charAt(0) == 'a') {
									j++;
									if (j == k) {
										break;
									}
								}
								for (int x = 0; x < k; x++) {
									if (temp[x].charAt(0) == 'a') {
										continue;
									}
									if (temp[j].compareTo(temp[x]) < 0) {
										j = x;
									}
								}
								str2[counter] = str1[j];
								temp[j] = temp[j].replaceFirst(" ", "a");
							}	
							break;

						case 4: // 완료
							for (int j = 0; j < k; j++) {
								for (int i = 0; i < str1[j].length(); i++) {
									if (str1[j].charAt(i) == ':' && str1[j].charAt(i + 1) == ':') {
										countindex++;
									}
									if (countindex == 3) {
										goingindex = i;
										countindex = 0;
										break;
									}
								}
								if (str1[j].charAt(goingindex + 2) == '완') {
									str1[j] = str1[j].replaceFirst("a", " ");
									str2[counter] = str1[j];
									counter++;
								}
							}
							break;

						case 5: // 실제마감일
							for (int j = 0; j < k; j++) {
								temp[j] = " ";
								goingindex = 0;
								countindex = 0;
								for (int i = 0; goingindex < 2; i++) {

									if (str1[j].charAt(i) == ':' && str1[j].charAt(i + 1) == ':') {
										countindex++;
									}
									if (str1[j].charAt(i) == '<' && str1[j].charAt(i + 1) == 'b'&& str1[j].charAt(i + 2) == 'r' && str1[j].charAt(i + 3) == '>') {
										goingindex++;
									}
									if (countindex == 2) {
										temp[j] = temp[j] + str1[j].charAt(i);
									}
								}
							}
							for (counter = 0; counter < k; counter++) {
								int j = 0;
								for (int x = 0; x < k; x++) {
									if (temp[x].charAt(0) == 'a') {
										continue;
									}
									if (temp[j].compareTo(temp[x]) > 0) {
										j = x;
									}
								}
								str2[counter] = str1[j];
								temp[j] = temp[j].replaceFirst(" ", "a");
							}
							break;
						}
						for (int a = 0; a < counter; a++) {// 패널 버튼추가
							if(str2[a].charAt(0)=='a'){
								continue;
							}
							str2[a] = str2[a].replaceAll(" ", "");
							JButton conttd = new JButton(str2[a]);
							conttd.setBounds(0, 0, 356, 50);
							conttd.setForeground(new Color(0, 0, 0));
							conttd.setBorder(new LineBorder(Color.black));
							for(int i = 0; i<str1[a].length();i++){
								if(str2[a].charAt(i+1)=='<'&&str2[a].charAt(i+2)=='/'&&str2[a].charAt(i+3)=='h'&&str2[a].charAt(i+4)=='t'&&str2[a].charAt(i+5)=='m'&&str2[a].charAt(i+6)=='l'&&str2[a].charAt(i+7)=='>'){
									if(str2[a].charAt(i-2)=='우'&&str2[a].charAt(i)=='요'){
										conttd.setBackground(Color.RED);
										break;
									}
									else if(str2[a].charAt(i)=='요'){
										conttd.setBackground(Color.BLUE);
										break;
									}
									else{
										break;
									}
								}
							}
							conttd.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									String std, std1, std2;
									File datatd = new File("datatd.dt");
									try {
										std1 = " " + conttd.getText();
										BufferedReader intd = new BufferedReader(new FileReader(datatd));
										while ((std = intd.readLine()) != null) {
											int count = 0;
											int i = 0;
											for (i = 0; !(std1.charAt(i) == ':' && std1.charAt(i + 1) == ':'); i++) {
												if (std.charAt(i) == std1.charAt(i)) {
													count++;
												}	
											}
											std2 = "";
											if (count == i) {
												count = 0;
												for (i = 3; i < std.length() - 7; i++) {
													if (std.charAt(i - 3) == ':' && std.charAt(i - 2) == ':'&& std.charAt(i - 1) == ':') {
														count++;
													}
													if (count > 0) {
														std2 = std2 + std.charAt(i);
													}
												}
												jl.setText(std2);
												panel_5.updateUI();
											}
										}
										intd.close();
									} catch (FileNotFoundException e) {
										e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						});
					         conttd.addMouseListener(new MyMouseListener(){
						       	  public void mouseClicked(MouseEvent e){
						    		  if(e.getClickCount() == 2){
						    	           DelToDo DT = null;
						    	            try {
						    					DT = new DelToDo(conttd.getText());
						    				} catch (IOException e1) {
						    					// TODO Auto-generated catch block
						    					e1.printStackTrace();
						    				}
						    	            DT.setVisible(true);
						    	    		dispose();
						    		  }

						    	  }
						         });
						panel_4.add(conttd);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSort.setBounds(303, 10, 70, 30);
		panel_1.add(btnSort);

		// 과목 길어질 때 스크롤 추가
		JScrollPane sptd = new JScrollPane(panel_4, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sptd.setBounds(12, 61, 356, 189);
		panel_1.add(sptd);
		

		///////////////////////////////////// 기타 메인 창

		// 검색창
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(109, 6, 536, 45);
		contentPane.add(textField);
		textField.setColumns(10);// 기능 구현하기

		// 검색 종류 선택 박스
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(14, 10, 81, 37);
		comboBox.addItem("과목");
		comboBox.addItem("할일");
		contentPane.add(comboBox);// 기능 구현 하기

		// 검색 버튼
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setBounds(659, 6, 36, 45);
		btnNewButton_1.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191846026.png"));
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// 검색 기능 구현 하기
				if (comboBox.getSelectedItem() == "과목") {
					if (textField.getText().equals("")) {
						panel_3.removeAll();
						File data = new File("data.dt");
						BufferedReader in;
						try {
							in = new BufferedReader(new FileReader(data));
							String s;
							while ((s = in.readLine()) != null) {
								s = s.replace(" ", "");
								JButton cont = new JButton(s);
								cont.setBounds(0, 0, 356, 50);
								cont.setForeground(new Color(0, 0, 0));
								cont.setBorder(new LineBorder(Color.black));
								panel_3.add(cont);
							}
							panel_3.updateUI();
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						panel_3.removeAll();
						panel_3.updateUI();
						File data = new File("data.dt");
						BufferedReader in;
						try {
							in = new BufferedReader(new FileReader(data));
							String s, s2 = "";
							int count = 0;
							while ((s = in.readLine()) != null) {
								for (int i = 7; !(s.charAt(i) == '<' && s.charAt(i + 1) == 'b' && s.charAt(i + 2) == 'r'
										&& s.charAt(i + 3) == '>'); i++) {
									s2 = s2 + s.charAt(i);
								}
								if (s2.equals(textField.getText())) {
									count++;
									s = s.replaceAll(" ", "");
									JButton cont = new JButton(s);
									cont.setBounds(0, 0, 356, 50);
									cont.setForeground(new Color(0, 0, 0));
									cont.setBorder(new LineBorder(Color.black));
									panel_3.add(cont);
								} else {
									s2 = "";
								}
							}
							if (count == 0) {
								JLabel nothere = new JLabel("찾는 정보가 없습니다.");
								panel_3.add(nothere);
							} else {
								count = 0;
							}
							panel_3.updateUI();
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					if (textField.getText().equals("")) {
						panel_4.removeAll();
						panel_4.updateUI();
						File data = new File("datatd.dt");
						BufferedReader in;
						try {
							in = new BufferedReader(new FileReader(data));
							String s, s2 = "";
							while ((s = in.readLine()) != null) {
								s2 = "";
								for (int i = 0; !(s.charAt(i) == ':' && s.charAt(i + 1) == ':'
										&& s.charAt(i + 2) == ':'); i++) {
									s2 = s2 + s.charAt(i);
								}
								s2 = s2.replace(" ", "");
								JButton cont = new JButton(s2);
								cont.setBounds(0, 0, 356, 50);
								cont.setForeground(new Color(0, 0, 0));
								cont.setBorder(new LineBorder(Color.black));

								cont.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										String std, std1, std2;
										File datatd = new File("datatd.dt");
										try {
											std1 = " " + cont.getText();
											BufferedReader intd = new BufferedReader(new FileReader(datatd));
											while ((std = intd.readLine()) != null) {
												int count = 0;
												int i = 0;
												for (i = 0; !(std1.charAt(i) == ':'
														&& std1.charAt(i + 1) == ':'); i++) {
													if (std.charAt(i) == std1.charAt(i)) {
														count++;
													}
												}
												std2 = "";
												if (count == i) {
													count = 0;
													for (i = 3; i < std.length() - 7; i++) {
														if (std.charAt(i - 3) == ':' && std.charAt(i - 2) == ':'
																&& std.charAt(i - 1) == ':') {
															count++;
														}
														if (count > 0) {
															std2 = std2 + std.charAt(i);
														}
													}
													jl.setText(std2);
													panel_5.updateUI();
												}
											}
											intd.close();
										} catch (FileNotFoundException e) {
											e.printStackTrace();
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								});

								panel_4.add(cont);
							}
							panel_4.updateUI();
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						panel_4.removeAll();
						panel_4.updateUI();
						File data = new File("datatd.dt");
						BufferedReader in;
						try {
							in = new BufferedReader(new FileReader(data));
							String s, s2 = "";
							int count = 0;
							while ((s = in.readLine()) != null) {
								for (int i = 7; !(s.charAt(i) == ':' && s.charAt(i + 1) == ':'); i++) {
									s2 = s2 + s.charAt(i);
								}
								if (s2.equals(textField.getText())) {
									s2 = "";
									count++;
									s = s.replaceAll(" ", "");
									for (int i = 0; !(s.charAt(i) == ':' && s.charAt(i + 1) == ':'
											&& s.charAt(i + 2) == ':'); i++) {
										s2 = s2 + s.charAt(i);
									}
									s2 = s2 + "</html>";
									JButton cont = new JButton(s2);
									cont.setBounds(0, 0, 356, 50);
									cont.setForeground(new Color(0, 0, 0));
									cont.setBorder(new LineBorder(Color.black));

									cont.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											String std, std1, std2;
											File datatd = new File("datatd.dt");
											try {
												std1 = " " + cont.getText();
												BufferedReader intd = new BufferedReader(new FileReader(datatd));
												while ((std = intd.readLine()) != null) {
													int count = 0;
													int i = 0;
													for (i = 0; !(std1.charAt(i) == ':'
															&& std1.charAt(i + 1) == ':'); i++) {
														if (std.charAt(i) == std1.charAt(i)) {
															count++;
														}
													}
													std2 = "";
													if (count == i) {
														count = 0;
														for (i = 3; i < std.length() - 7; i++) {
															if (std.charAt(i - 3) == ':' && std.charAt(i - 2) == ':'
																	&& std.charAt(i - 1) == ':') {
																count++;
															}
															if (count > 0) {
																std2 = std2 + std.charAt(i);
															}
														}
														jl.setText(std2);
														panel_5.updateUI();
													}
												}
												intd.close();
											} catch (FileNotFoundException e) {
												e.printStackTrace();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									});

									panel_4.add(cont);
								}
							}
							if (count == 0) {
								JLabel nothere = new JLabel("찾는 정보가 없습니다.");
								panel_4.add(nothere);
							}
							panel_4.updateUI();
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});

		// 할일 추천 버튼
		JButton btnNewButton = new JButton();
		btnNewButton.setBounds(709, 5, 59, 47);
		btnNewButton.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191848907.png"));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// RandomFrame 호출
				RandomFrame rf = new RandomFrame();
				rf.setVisible(true);
			}
		});
	}
}

class MyMouseListener extends MouseAdapter {

}

class MyMouseListener2 extends MouseAdapter {

}