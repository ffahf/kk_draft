package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KButton extends Button{
	private final String FONT_PATH = "src/model.res/ Kenney Mini.ttf";
	private final String BUTTON_PRESSED_STYLE = 
			"-fx-background-color: transparent; "
			+ "-fx-background-image: url('/model/blue_button05.png');";
	private final String BUTTON_FREE_STYLE = 
			"-fx-background-color: transparent;"
			 +"-fx-background-image: url('/model/blue_button04.png');";
	private Stage menuStage;
	//private Image
	
	public KButton(String text) {
		setText(text);
		setFont(Font.font("Verdana", BASELINE_OFFSET_SAME_AS_HEIGHT));
		setTextFill(Color.WHITE);
		setButtonFont();
		setPrefHeight(49);
		setPrefWidth(190);
		setStyle(BUTTON_FREE_STYLE);
		initializeButtonListener();
		
		
	}
	
	private void setButtonFont() {
		try{
			setFont(Font.loadFont(new FileInputStream(FONT_PATH),20));
		}catch(FileNotFoundException e) {
			setFont(Font.font("Verdana",20)); 
		}
	}
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(40);
		setLayoutY(getLayoutY()+4);
		
	}
	private void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(40);
		setLayoutY(getLayoutY()-3);
		
		
	}
	private void initializeButtonListener() {
		this.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				if(e.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
					
				}
			}
		});
		this.setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				if(e.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
					
				}
			}
		});
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				setEffect(new DropShadow());
				System.out.println("enet");
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				setEffect(null);
			}
		});
		
	}
}
