
package view;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.BackButton;

public abstract class Popup{
	private final String BACKGROUND = "/view/grey_panel.png";
	private final String HEADER = "";
	private final int HEIGHT = 350;
	private final int WIDTH = 350;
	private AnchorPane innerPane;
	private BackButton backButton;
	public Popup(String header) {
		innerPane = new AnchorPane();
		innerPane.setPrefWidth(WIDTH);
		innerPane.setPrefHeight(HEIGHT);
		
		setBackground();
		Text t = new Text(header);
		t.setFont(Font.font(24));
		t.setLayoutX(WIDTH-200);
		t.setLayoutY(50);
		innerPane.getChildren().add(t);
		createBackButton();
		
		
		
		
	}
	
	
	
	public AnchorPane getInnerPane() {
		return innerPane;
	}
	
	public void createBackButton() {
		backButton = new BackButton();
		this.innerPane.getChildren().add(backButton);
		backButton.setLayoutY(20);
		backButton.setLayoutX(295);
		
		backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
//				Group group = (Group) innerPane.getParent();
//				group.getChildren().remove(innerPane);
				
			}
		});
	}

	public void setInnerPane(AnchorPane innerPane) {
		this.innerPane = innerPane;
	}



	private void setBackground() {
		Image background = new Image(BACKGROUND);

		BackgroundImage bg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0,1.0,true,true,false,false));
		innerPane.setBackground(new Background(bg));
	}
	public abstract void addInnerContent();
	public BackButton getBackButton() {
		return backButton;
	}
	public void popupAppear() {
		innerPane.setLayoutX(330);
		innerPane.setLayoutY(HEIGHT/2 -50 );
		this.getInnerPane().setVisible(true);
		
	}
	public void popupHide() {
		this.getInnerPane().setVisible(false);
		
	}
}
