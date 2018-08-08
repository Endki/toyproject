package musai;

import musai.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.*;


public class NewLecture extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea textArea;

	//Launch the application.
	public static void main(String[] args) {
		NewLecture frame = new NewLecture();
		frame.setVisible(true);
	}
	
	 //Create the frame.
	 public NewLecture() {
		 
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

		 
		////////////////////////////////////과목추가창 전체 프레임
		setBackground(Color.WHITE);
		setBounds(100, 100, 435, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		
		
		
		
		//과목명 레이블
		JLabel label = new JLabel("\uACFC\uBAA9 \uBA85");
		label.setForeground(new Color(128, 128, 128));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label.setBounds(40, 35, 112, 32);
		contentPane.add(label);
		
		//과목명 텍스트 상자
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		textField.setBounds(219, 32, 155, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
		
		//담당교수 레이블
		JLabel lblNewLabel = new JLabel("\uB2F4\uB2F9 \uAD50\uC218");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel.setBounds(40, 130, 112, 32);
		contentPane.add(lblNewLabel);
		
		//담당교수 텍스트 상자
		textField_1 = new JTextField();
		textField_1.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(219, 127, 155, 46);
		contentPane.add(textField_1);
		
		
		
		
		
		//요일/시간 레이블
		JLabel lblNewLabel_1 = new JLabel("\uC694\uC77C/\uC2DC\uAC04");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel_1.setBounds(40, 225, 112, 32);
		contentPane.add(lblNewLabel_1);
		
		//요일/시간 텍스트 상자
		textField_2 = new JTextField();
		textField_2.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(219, 222, 155, 46);
		contentPane.add(textField_2);
		
		
		
		
		
		//년도/학기 레이블
		JLabel label_1 = new JLabel("\uB144\uB3C4/\uD559\uAE30");
		label_1.setForeground(new Color(128, 128, 128));
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label_1.setBounds(40, 320, 112, 32);
		contentPane.add(label_1);
		
		//년도/학기 텍스트 상자
		textField_3 = new JTextField();
		textField_3.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(219, 317, 155, 46);
		contentPane.add(textField_3);
		
		
		
		
		
		//세부사항 레이블
		JLabel label_2 = new JLabel("\uC138\uBD80 \uC0AC\uD56D");
		label_2.setForeground(new Color(128, 128, 128));
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		label_2.setBounds(40, 415, 112, 32);
		contentPane.add(label_2);
		
		//세부사항 텍스트 상자
		textField_4 = new JTextField();
		textField_4.setFont(new Font("HY중고딕", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(219, 411, 155, 46);
		contentPane.add(textField_4);
		
		
		
		

		//저장 버튼
		JButton btnNewButton = new JButton();
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191838663.png"));
		btnNewButton.setBounds(179, 475, 59, 38);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = 0;
				try {
					File data = new File("data.dt");
					FileWriter fw = new FileWriter(data, true);
					if(!(textField.getText().equals(""))){
						fw.write(" <html>");
						count++;
						fw.write(textField.getText());
					}
					if(!(textField_1.getText().equals(""))){
						fw.write("<br>");
						count++;
						fw.write(textField_1.getText());
					}
					if(!(textField_2.getText().equals(""))){
						fw.write("::");
						count++;
						fw.write(textField_2.getText());
					}
					if(!(textField_3.getText().equals(""))){
						fw.write(":::");
						count++;
						fw.write(textField_3.getText());
						fw.write("::::");
					}
					if(!(textField_4.getText().equals(""))){
						fw.write(textField_4.getText());
						fw.write("</html>");
						fw.write("\n");
						fw.flush();
					}
					else if(count==4){
						fw.write("</html>");
						fw.write("\n");
						fw.flush();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count!=4){
					Warning warn = new Warning();
					warn.setVisible(true);
					count = 0;					
				}
				else{
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
	}



}
