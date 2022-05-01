package model;

import javafx.scene.image.ImageView;

public class Player {
	private final String P1_IMG_PATH  = "/model/portal_orange.png";
	private final String IMG_STYLE = "-fx-background-color:transparent;";
	private final String P2_IMG_PATH  = "/model/portal_yellow.png";
	private ImageView p1Image;
	private ImageView p2Image;
	private ImageView playerImage;
	private int xPos;
	private int yPos;
	private final int YPOSSTART = 120;
	
	public ImageView getPlayerImage() {
		return playerImage;
	}



	public void setPlayerImage(ImageView playerImage) {
		this.playerImage = playerImage;
	}



	private int row;
	
	public Player(int n) {
		if(n == 1) {
			playerImage = new ImageView(P1_IMG_PATH);
			playerImage.setFitWidth(60);
			playerImage.setLayoutX(30);
			playerImage.setLayoutY(YPOSSTART);
			this.xPos = 30;
			this.yPos = YPOSSTART;
			this.setRow(0);
			
		}else {
			playerImage = new ImageView(P2_IMG_PATH);
			playerImage.setFitWidth(60);
			playerImage.setLayoutX(720);
			playerImage.setLayoutY(YPOSSTART);
			this.xPos = 670;
			this.yPos = YPOSSTART;
			this.setRow(0);
		}
		
//		p1Image = new ImageView(P1_IMG_PATH);
//		p1Image.setFitHeight(HEIGHT);
//		p1Image.setFitWidth(WIDTH);
		
		//p2Image = new ImageView(P2_IMG_PATH);
//		p2Image.setFitHeight(HEIGHT);
//		p2Image.setFitWidth(WIDTH);
		
		
		
	}
	
	public int moveUp() {
		this.setRow(this.getRow()-1);
		//this.move();
		this.setyPos( YPOSSTART+ (this.getRow()*75));
		this.playerImage.setLayoutY(this.getyPos());
		
		
		return this.getRow();
		
	}
	public int moveDown() {
		this.setRow(this.getRow()+1);
		//this.move();
		this.setyPos( YPOSSTART+ (this.getRow()*75));
		this.playerImage.setLayoutY(this.getyPos());
		
		return this.getRow();
	}
	public int getRow() {
		return row;
	}



	public void setRow(int row) {
		this.row = Math.max(row,0);
		this.row = Math.min(this.row,5);
		
		
		System.out.println(this.getRow());
	}
//	public void move() {
//		this.setyPos(YPOSSTART+ (this.getRow()*75));
//		this.playerImage.setLayoutY(this.getyPos());
//		//System.out.println(this.getyPos()+"  "+ this.getRow());
//	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}



	public int getyPos() {
		return yPos;
	}



	public void setyPos(int yPos) {
		this.yPos = yPos;
	}



//	
	
	

}
