package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.GameTimer;

public class TopPane extends AnchorPane {
	private Text text;
	private GameTimer timer;
	
	
	public TopPane() {
		this.setPrefHeight(100);
		this.setPrefWidth(800);
		timer = new GameTimer();
		this.getChildren().add(timer);
	}


	public GameTimer getTimer() {
		return timer;
	}


	public void setTimer(GameTimer timer) {
		this.timer = timer;
	}

}
