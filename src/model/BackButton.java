package model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class BackButton extends Button{
	private final String BACKIMG_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/blue_boxCross.png');";
	
	public BackButton() {
		setPrefSize(37, 37);
		setStyle(BACKIMG_STYLE);
		initializeButtonListener();
		
		
	}
	private void setButtonPressedStyle() {
		
		setLayoutY(getLayoutY()+4);
		
	}
	private void setButtonReleasedStyle() {
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
