package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler kh;	
	
	public Player(GamePanel gp, KeyHandler kh) {
		this.gp = gp;
		this.kh = kh;
		setDefaultValues();
		getPlayerImage();
	}
	
	/*
	 * sets original position of player
	 * */
	public void setDefaultValues () {
		xCord = 100;
		yCord = 100;
		speed = 4;
		direction = "down";
	}
	
	/*
	 * Gets player images from png files
	 * */
	public void getPlayerImage() {
		try {
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/gc_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/gc_left_2.png"));			
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/gc_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/gc_right_2.png"));						
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/gc_back.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/gc_back.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/gc_front.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/gc_front.png"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Updates player images if it moves (make player face left, right, etc)
	 * */
	public void update() {
		if (kh.upPressed || kh.downPressed || kh.leftPressed || kh.rightPressed) {		
			if (kh.upPressed) {
				direction = "up";
				yCord -= speed;			
			} else if (kh.downPressed) {
				direction = "down";
				yCord += speed;
			} else if (kh.leftPressed) {
				direction = "left";
				xCord -= speed;
			} else if (kh.rightPressed) {
				direction = "right";
				xCord += speed;
			}			
			spriteCounter++;
			if (spriteCounter > 20) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}
	
	/*
	 * Draws the actual image of the player
	 * */
	public void draw(Graphics2D g2) {	
		BufferedImage image = null;		
		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
			break;
		}		
		g2.drawImage(image, xCord, yCord, gp.tileSize, gp.tileSize, null);
	}
	
}
