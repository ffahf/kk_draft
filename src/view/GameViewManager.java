package view;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Player;

public class GameViewManager {
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private final String P1_IMG_PATH  = "/model/portal_orange.png";
	private final String IMG_STYLE = "-fx-background-color:transparent;";
	private final String P2_IMG_PATH  = "/model/portal_yellow.png";
	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	private Stage menuStage;
	private Player player1; 
	private Player player2;
	
	public GameViewManager() {
		initializeStage();
		createPlayer();
		
		createKeyListener();
	}
	private void createKeyListener() {
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				switch(e.getCode()) {
				case UP: {
					player2.moveUp();
					System.out.println("upppppp");
				}
				case DOWN: player2.moveDown();
				case LEFT:
				case W:
				case S:
				case D:
				case SPACE:
				}
				
				
			}
		});
		// TODO Auto-generated method stub
		
	}
	private void initializeStage() {
		this.gamePane = new AnchorPane();
		this.gameScene = new Scene(gamePane,WIDTH,HEIGHT);
		this.gameStage= new Stage();
		System.out.println("initia;izeStage work");
		this.gameStage.setScene(gameScene);
		
	}
	public void createNewGame(Stage menuStage) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		this.gameStage.show();
		System.out.println("creatnewGame");
		
	}
	public void createPlayer() {
//		Players players = new Players();
		//this.gamePane.getChildren().addAll(players.getP1Image(),players.getP2Image());
		player1 = new Player(1);
		player2 = new Player(2);
		this.gamePane.getChildren().addAll(player1.getPlayerImage(),player2.getPlayerImage());
		
			
		
	}
	
	

}
