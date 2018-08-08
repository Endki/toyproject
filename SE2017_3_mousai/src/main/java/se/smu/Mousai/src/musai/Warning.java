package musai;

import musai.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class Warning extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warning frame = new Warning();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Warning() {
		
		
		
		
		setBounds(100, 100, 426, 140);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("  \uC785\uB825\uB418\uC9C0 \uC54A\uC740 \uC0AC\uD56D\uC774 \uC788\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setForeground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon("buttons/KakaoTalk_20170518_191832453.png"));
		lblNewLabel.setBounds(27, 27, 353, 43);
		contentPane.add(lblNewLabel);
	}

}
