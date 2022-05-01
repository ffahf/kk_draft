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
	private final String P1_IMG_PATH = "/model/portal_orange.png";
	private final String IMG_STYLE = "-fx-background-color:transparent;";
	private final String P2_IMG_PATH = "/model/portal_yellow.png";
	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	private Stage menuStage;
	private Player player1;
	private Player player2;
	private TopPane topPane;
	private boolean isPause;
	

	public GameViewManager() {
		this.isPause = false;
		initializeStage();
		createPlayer();

		createKeyListener();
		createTopPane();
	}

	private void createKeyListener() {
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				switch (e.getCode()) {
				case UP: {
					player2.moveUp();
					break;
				}
				case DOWN:
					player2.moveDown();
					break;
				case LEFT:
				case W:
					player1.moveUp();
					break;
				case S:
					player1.moveDown();
					break;
				case D:
				case SPACE:
					if(isPause==false) {
					topPane.getTimer().timerPause();
					isPause = true;
					}
					else{
						topPane.getTimer().perform();
						isPause = false;
						

					}
					break;
				}

			}
		});
		// TODO Auto-generated method stub

	}

	private void initializeStage() {
		this.gamePane = new AnchorPane();
		this.gameScene = new Scene(gamePane, WIDTH, HEIGHT);
		this.gameStage = new Stage();
		//System.out.println("initia;izeStage work");
		this.gameStage.setScene(gameScene);

	}

	public void createNewGame(Stage menuStage) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		this.gameStage.show();
		//System.out.println("creatnewGame");

	}

	public void createPlayer() {
//		Players players = new Players();
		// this.gamePane.getChildren().addAll(players.getP1Image(),players.getP2Image());
		player1 = new Player(1);
		player2 = new Player(2);
		this.gamePane.getChildren().addAll(player1.getPlayerImage(), player2.getPlayerImage());

	}
	public void createTopPane() {
		topPane = new TopPane();
		this.gamePane.getChildren().add(topPane);
	}

}
