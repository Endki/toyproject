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

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class DelLecture extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

	public DelLecture() {

	}

	public DelLecture(String cont) {
		
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
		
		
		String cont1 = " " + cont;
		setBounds(100, 100, 435, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// 과목명
		textField = new JTextField();
		textField.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(219, 32, 155, 46);
		contentPane.add(textField);

		// 담당교수
		textField_1 = new JTextField();
		textField_1.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(219, 127, 155, 46);
		contentPane.add(textField_1);

		// 요일&시간
		textField_2 = new JTextField();
		textField_2.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(219, 222, 155, 46);
		contentPane.add(textField_2);

		// 연도&학기
		textField_3 = new JTextField();
		textField_3.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(219, 317, 155, 46);
		contentPane.add(textField_3);

		// 세부사항
		textField_4 = new JTextField();
		textField_4.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(219, 411, 155, 46);
		contentPane.add(textField_4);

		// 과목명
		JLabel label = new JLabel("\uACFC\uBAA9 \uBA85");
		label.setToolTipText(" ");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label.setBounds(40, 35, 112, 32);
		contentPane.add(label);

		// 담당 교수
		JLabel label_1 = new JLabel("\uB2F4\uB2F9 \uAD50\uC218");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label_1.setBounds(40, 130, 112, 32);
		contentPane.add(label_1);

		// 요일&시간
		JLabel label_2 = new JLabel("\uC694\uC77C/\uC2DC\uAC04");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label_2.setBounds(40, 225, 112, 32);
		contentPane.add(label_2);

		// 연도&학기
		JLabel label_3 = new JLabel("\uB144\uB3C4/\uD559\uAE30");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label_3.setBounds(40, 320, 112, 32);
		contentPane.add(label_3);

		// 세부 사항
		JLabel label_4 = new JLabel("\uC138\uBD80 \uC0AC\uD56D");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label_4.setBounds(40, 415, 112, 32);
		contentPane.add(label_4);

		// 확인 버튼 누르면
		JButton savebutton = new JButton("");
		savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] map = new String[1000];
				BufferedReader bw = null;
				FileWriter fw = null;
				try {
					bw = new BufferedReader(new FileReader("data.dt"));
					int i = 0;
					while ((map[i] = bw.readLine()) != null) {
						i++;
					}
					bw.close();
					for (int j = 0; j < i; j++) {
						if (cont1.equals(map[j])) {
							map[j] = "";
						}
					}
					fw = new FileWriter("data.dt");
					fw.flush();
					for (int j = 0; j < i; j++) {
						if (!("".equals(map[j]))) {
							fw.write(map[j] + "\n");
						}
					}
					fw.flush();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (bw != null)
						try {
							bw.close();
						} catch (IOException e) {
						}
				}

				int count = 0;
				try {
					File data = new File("data.dt");
					FileWriter fw2 = new FileWriter(data, true);
					if (!(textField.getText().equals(""))) {
						fw2.write(" <html>");
						count++;
						fw2.write(textField.getText());
					}
					if (!(textField_1.getText().equals(""))) {
						fw2.write("<br>");
						count++;
						fw2.write(textField_1.getText());
					}
					if (!(textField_2.getText().equals(""))) {
						fw2.write("::");
						count++;
						fw2.write(textField_2.getText());
					}
					if (!(textField_3.getText().equals(""))) {
						fw2.write(":::");
						count++;
						fw2.write(textField_3.getText());
						fw2.write("::::");
					}
					if (!(textField_4.getText().equals(""))) {
						fw2.write(textField_4.getText());
						fw2.write("</html>");
						fw2.write("\n");
						fw2.flush();
					} else {
						fw2.write("</html>");
						fw2.write("\n");
						fw2.flush();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (count != 4) {
					Warning warn = new Warning();
					warn.setVisible(true);
					count = 0;
				} else {
					try {
						Mainframe ma = new Mainframe();
						ma.setVisible(true);
						dispose();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		savebutton.setForeground(Color.BLACK);
		savebutton.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191838663.png"));
		savebutton.setBackground(Color.WHITE);
		savebutton.setBounds(99, 474, 59, 38);
		contentPane.add(savebutton);

		JButton Delbutton = new JButton("");
		Delbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delete dl = new Delete(cont);
				dl.setVisible(true);
				dispose();
			}
		});
		Delbutton.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191824909.png"));
		Delbutton.setForeground(Color.BLACK);
		Delbutton.setBackground(Color.WHITE);
		Delbutton.setBounds(257, 474, 59, 38);
		contentPane.add(Delbutton);


		String str1 = "";
		String str2 = "";
		String str3 = "";
		String str4 = "";
		String str5 = "";

		for (int i = 6; !(cont.charAt(i) == ':' && cont.charAt(i + 1) == ':') && !(cont.charAt(i) == '<'); i++) {
			str1 = str1 + cont.charAt(i);
			textField.setText(str1);
		}
		for (int i = cont.indexOf("<br>") + 4; !(cont.charAt(i) == ':' && cont.charAt(i + 1) == ':'); i++) {
			str2 = str2 + cont.charAt(i);
			textField_1.setText(str2);

		}
		for (int i = cont.indexOf("::") + 2; !(cont.charAt(i) == ':' && cont.charAt(i + 1) == ':'); i++) {
			str3 = str3 + cont.charAt(i);
			textField_2.setText(str3);
		}
		for (int i = cont.indexOf(":::") + 3; !(cont.charAt(i) == ':' && cont.charAt(i + 1) == ':'); i++) {
			str4 = str4 + cont.charAt(i);
			textField_3.setText(str4);
		}
		for (int i = cont.indexOf("::::") + 4; !(cont.charAt(i) == '<'); i++) {
			str5 = str5 + cont.charAt(i);
			textField_4.setText(str5);

		}

	}
}