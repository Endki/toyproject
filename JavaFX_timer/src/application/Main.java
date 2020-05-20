package application;
	
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application implements Runnable {
	private long sec; // start ~ stop ������ ��(sec) ���庯�� 
	private Thread t;
	private Main mainClass; // �ش� Ŭ������ �ν��Ͻ��� �����ϴ� ���� 
	private Scene main; // Ÿ�̸Ӱ� �ִ� ȭ�� 
	private Font textFont; // ���� ��Ʈ 
	private Font timeFont; // ���� ��Ʈ 
	private boolean start; // ���� ���� 
	@FXML Text flow_time; // �ð� 
	@FXML ImageView background; // ��� 
	@FXML Button start_btn; // ���۹�ư
	@FXML Button stop_btn; // ������ư 
	@FXML Button pause_btn;
	
	@Override
	public void start(Stage primaryStage) {
		mainClass = this; // �ڽ� ��ü�� ���� 
		try {
			Scene loading = new Scene(new Pane(), 500, 400); // ũ��� ���� 500, ���� 400 �ȼ� 
			primaryStage.setScene(loading); //�� ȭ������ ȭ�� ���� 
			primaryStage.setResizable(false); // â ũ�� ���� �Ұ��� 
			primaryStage.sizeToScene(); // Scene�� ũ�⿡ �˸°� â ũ�� ������ 
			primaryStage.setTitle("Timer"); // Ÿ��Ʋ ���� ���� 
			primaryStage.show(); // â ���̱� 
			
			
			// �̹��� �ε� �� �۾��� �Ϸ����� ������ ��� ���α׷� ���� 
			if (!Init()) {
				System.exit(0);
			}
			
			// ���������� �Ϸ�Ǿ����� Ÿ�̸� ȭ�� ��� 
			primaryStage.setScene(main);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	// �̹���, ��Ʈ �� �ʱ� �۾� 
	private boolean Init() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("design.fxml")); // fxml ������ �ε� 
			loader.setController(this); // ��Ʈ�ѷ��� �ڽ����� ���� 
			Parent root = (Parent) loader.load(); 
			main = new Scene(root, 500, 400); // ũ�� 500, 400
			pause_btn.setDisable(true);
			
			start_btn.setOnAction(new EventHandler<ActionEvent>() { // ���۹�ư�� ������ �� 
				@Override
				public void handle(ActionEvent event) {
					start = true; // �ݺ� ���� true 
					start_btn.setDisable(true); // ���۹�ư ��Ȱ��ȭ
					pause_btn.setDisable(false);
					t = new Thread(mainClass); // Ÿ�̸� ������ ���� 
					t.setDaemon(true); 
					t.start(); // ������ ���� 
				}
			});
			
			pause_btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					
					if(pause_btn.getText().equals("pause")) {
						t.suspend();
						pause_btn.setText("return");
					}else {
						t.resume();
						pause_btn.setText("pause");
					}
					
					
				}
			});
			
			stop_btn.setOnAction(new EventHandler<ActionEvent>() { // ������ư�� ������ �� 
				@Override
				public void handle(ActionEvent event) {
					flow_time.setText("00 : 00 : 00");
					start_btn.setDisable(false);
					pause_btn.setText("pause");
					pause_btn.setDisable(true);
					if(t != null) {
						t.interrupt(); // �����忡 ���ͷ�Ʈ (����)
					}
				}
			});
			return true; // ��� �۾��� �������� true 
		} catch (Exception e) {
			return false; // ������ ������ false 
		}
	}

	@Override
	public void run() {
		sec = 0; // ���� �� 0�ʺ��� ī��Ʈ ���� 
		while (start) {
			try {
				TimeUnit.SECONDS.sleep(1); // 1�� ��� 
				sec++; // 1���� 
				flow_time.setText(getTime(sec)); // ������ �ʸ� ��:��:�� �� ��� 
			} catch (InterruptedException e) {
				start_btn.setDisable(false);
				start = false; // ���ͷ�Ʈ �߻� �� �ݺ� ����
			}
		}
	}

	// �ʸ� ��, ��, �ʷ� ��ȯ 
	private String getTime(long time) {
		int hour = (int) (time / 3600);
		int min = (int) (time % 3600 / 60);
		int sec = (int) (time % 60);
		return String.format("%02d : %02d : %02d", hour, min, sec);
	}

	// ���� 
	public static void main(String[] args) {
		launch(args);
	}
}
