package model;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameTimer extends VBox{
	private int minute = 0;
	private int seconds = 0;
	private int ms = 0;
	private boolean isActive;
	private Text time;
	private Text header;
	private Thread t;
	
	
	public GameTimer() {
		isActive = false;
		time = new Text(String.format("%02d  :  %02d", minute,seconds));
		header = new Text("Timer");
		this.setPrefWidth(150);
		this.setPrefHeight(440);
		this.getChildren().add(header);
		this.getChildren().add(time);
		perform();
		
//		Button start = new Button("start");
//		this.getChildren().add(start);
//		start.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				perform();
//				
//			}
//			
//		});
		
//		Button pause = new Button("pause");
//		this.getChildren().add(pause);
//		pause.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				timerPause();
//				
//			}
//			
//		});
	}

	public void timerPause() {
		isActive = false;
	}
	public void timerRun() {
		isActive = true;
	}
	public void perform() {
		isActive = true;
		
		t = new Thread(new Runnable() {

			@Override
			public void run() {
				
				// TODO Auto-generated method stub
				while(minute != 2) {
					if(isActive == true) {
						try {
							Thread.sleep(1000);
							seconds++;
							
							if(seconds > 60) {
								seconds=0;
								minute++;
							}
							
							Platform.runLater(()->{
								time.setText(String.format("%02d  :  %02d", minute,seconds));
							});
							}catch(InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				isActive = false;
			}
			
		});
		
		t.start();
		
		
	}
}