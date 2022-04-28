package view;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.BackButton;

public class Tutorial extends Popup{

	public Tutorial() {
		super("Tutorial");
		addInnerContent();
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void addInnerContent() {
		AnchorPane tutorialContent = new AnchorPane();
		
		
		//for adding tutorial
		
		
		
		this.getInnerPane().getChildren().add(tutorialContent);
		// TODO Auto-generated method stub
		
	}
	
//	
}
