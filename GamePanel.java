package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	// SCREEN SETTINGS
	final int originalTileSize = 16; // 16 x 16 tile
	final int scale = 3;	
	
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this, keyH);
	
	//FPS
	int fps = 60;			
			
	/*
	 * Sets GamePanel preferences
	 * */
	public GamePanel () {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));		
		this.setBackground(Color.GRAY);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread () {
		gameThread = new Thread(this);
		gameThread.start();
	}

	/*
	 * "runs" the actual game
	 * */
	public void run() {		
		// this draws screen fps times per second
		double drawInterval = 1000000000 / fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += ((currentTime - lastTime) / drawInterval);
			lastTime = currentTime;
			if (delta >= 1) {
				update();
				repaint();	
				delta--;
			}
			
		}
	}
	
	/* 
	 * updates player positions
	 * */
	public void update() {
		player.update();
	}
	
	/*
	 * update actual drawings
	 * */ 
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);		
		Graphics2D g2 = (Graphics2D) g;
		// draw the background
		tileM.draw(g2);
		// draw the players
		player.draw(g2);		
		g2.dispose();
	}
	
}
