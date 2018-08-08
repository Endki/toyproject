package musai;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Delete extends JFrame {

	private JPanel contentPane;

	// Launch the application.
	public static void main(String[] args) {
		Delete frame = new Delete();
		frame.setVisible(true);
	}

	public Delete() {
		

	}

	// Create the frame.
	public Delete(String cont) {
		
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
		/////////////////////////////// 삭제 확인창 전체 프레임
		setBounds(100, 100, 426, 165);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// 삭제하시겠습니까 레이블
		JLabel lblNewLabel = new JLabel("삭제하시겠습니까?");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel.setBounds(105, 12, 197, 39);
		contentPane.add(lblNewLabel);

		// 확인버튼
		JButton button = new JButton("확인");
		button.setForeground(new Color(128, 128, 128));
		button.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		button.setBounds(66, 63, 105, 41);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// 삭제 기능 구현 하기
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
				try {
					Mainframe ma = new Mainframe();
					ma.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});

		
		// 취소 버튼
		JButton btnNewButton = new JButton("취소");
		btnNewButton.setForeground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		btnNewButton.setBounds(237, 63, 105, 41);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	          	 try {
							Mainframe ma = new Mainframe();
							ma.setVisible(true);
							dispose();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
				dispose();
			}
		});
	}
}
