package view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Credit extends Popup {

	public Credit() {
		super("Credit");
		addInnerContent();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInnerContent() {
		//AnchorPane creditContent = new AnchorPane();
		Text name1 = new Text("Napat Nitiwattananon 6431324021");
		name1.setFont(Font.font(18));
		Text name2 = new Text("Papanin Kittawisinpoon 6431327021");
		name2.setFont(Font.font(18));
		name1.setLayoutX(30);
		name1.setLayoutY(160);
		name2.setLayoutX(30);
		name2.setLayoutY(200);
		
		
		//confusing asf
		//creditContent.getChildren().addAll(name1,name2);
		//this.getInnerPane().getChildren().add(creditContent);
		this.getInnerPane().getChildren().addAll(name1,name2);
		// TODO Auto-generated method stub
		
	}

}
