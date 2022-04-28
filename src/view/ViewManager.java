package view;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import model.KButton;

public class ViewManager {
	private static final int HEIGHT = 500;
	private static final int WIDTH = 700;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	private Credit credit;
	private Tutorial tutorial;
	private ScorePopup scorePopup;
	private ArrayList<Popup> allPopup = new ArrayList<Popup>();

	private final static int MENU_BUTTON_X = 80;
	private final static int MENU_BUTTON_Y = 100;

	ArrayList<KButton> menuButtons;

	public ViewManager() {
		menuButtons = new ArrayList<KButton>();
		mainPane = new AnchorPane();
		mainStage = new Stage();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage.setScene(mainScene);
		this.createButtons();
		this.createBackground();

	}

	public Stage getMainStage() {
		return mainStage;
	}

	private void addMenuButton(KButton button) {

		button.setLayoutX(MENU_BUTTON_X);
		button.setLayoutY(MENU_BUTTON_Y + menuButtons.size() * 80);
		menuButtons.add(button);
		mainPane.getChildren().add(button);

	}

	private void createButtons() {
		createStartButton();
		createTutorialButton();
		createScoreButton();
		createCreditButton();
		createExitButton();
		createLogo();
	}

	private void createStartButton() {
		KButton startButton = new KButton("Play");

		addMenuButton(startButton);
		startButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				GameViewManager gameViewManager = new GameViewManager();
				gameViewManager.createNewGame(mainStage);
				
				
 			}
			
		});
	}

	private void createTutorialButton() {
		KButton tutorialButton = new KButton("Tutorial");
		tutorial = new Tutorial();
		createPopup(tutorial);
		tutorialButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
//				tutorial.getInnerPane().setVisible(true);
				// TODO Auto-generated method stub
				hideAllPopup();
				tutorial.popupAppear();

			}

		});
		addMenuButton(tutorialButton);
	}

	private void createScoreButton() {
		KButton scoreButton = new KButton("Score");
		scorePopup = new ScorePopup();
		createPopup(scorePopup);
		scoreButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
//				tutorial.getInnerPane().setVisible(true);
				// TODO Auto-generated method stub
				hideAllPopup();
				scorePopup.popupAppear();

			}

		});
		addMenuButton(scoreButton);
	}

	private void createCreditButton() {
		KButton creditButton = new KButton("Credit");
		addMenuButton(creditButton);
		credit = new Credit();
		createPopup(credit);
		creditButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				hideAllPopup();
//				Credit credit = new Credit();
//				createPopup(credit);
//				credit.getInnerPane().setVisible(true);
				credit.popupAppear();
				// TODO Auto-generated method stub

			}

		});
	}

	private void createExitButton() {
		KButton exitButton = new KButton("Exit");
		addMenuButton(exitButton);
		exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainStage.close();
			}
			
		});
		
		
	}

	private void createLogo() {
		ImageView logo = new ImageView("/view/add_gray.png");
		logo.setFitWidth(50);
		logo.setFitHeight(50);
		logo.setLayoutX(200);
		logo.setLayoutY(40);

		logo.setOnMouseDragEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				logo.setEffect(new DropShadow());
				// TODO Auto-generated method stub

			}

		});
		logo.setOnMouseDragExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				logo.setEffect(null);
			}
		});
		mainPane.getChildren().add(logo);
	}

	private void createBackground() {
		Image backgroundImage = new Image("/view/bg2.png", 256, 256, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}

	private void createPopup(Popup popup) {
		mainPane.getChildren().add(popup.getInnerPane());
		popup.getInnerPane().setVisible(false);
		popup.getInnerPane().setLayoutX(350);
		popup.getInnerPane().setLayoutY(140);
		allPopup.add(popup);
		connectBackButtonPopup(popup);

	}

	public void connectBackButtonPopup(Popup popup) {

		popup.getBackButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
//				popup.getInnerPane().setVisible(false);
				popup.popupHide();
				System.out.println("clicledd");
				// TODO Auto-generated method stub

			}

		});
	}

	public AnchorPane getMainPane() {
		return mainPane;
	}

	private void hideAllPopup() {
		for (int i = 0; i < allPopup.size(); i++) {
			allPopup.get(i).popupHide();
		}
	}
}
