import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


public class Board {
	ArrayList<Integer> boardX = new ArrayList<Integer>();
	ArrayList<Integer> boardY = new ArrayList<Integer>();
	private int score;
	private int currentY;
	private int currentX;
	private int pelletX;
	private int pelletY;
	private int direction;
	private int compare;
	private SnakeView snake = new SnakeView();
	private PelletView pellet = new PelletView();
	private Random random = new Random();
	private boolean isGameOver;
	
	public boolean getIsGameOver() {
		return isGameOver;
	}
	public int getCompare() {
		return compare;
	}
	public void setDirection(int direct) {
		if(!((direction == 1 && direct == 3)||(direction == 2 && direct == 4)||(direction == 3 && direct == 1)||(direction == 4 && direct == 2))) {
			direction = direct;
		}
	}
	public void initializeBoard() {
		boardX.clear();
		boardY.clear();
		boardX.add(1);
		boardY.add(1);
		direction = 2;
		compare = 10;
		score = 0;
		currentY = 2;
		currentX = 1;
		pelletX = random.nextInt(20);
		pelletY = random.nextInt(20);
		isGameOver = false;
	}
	public void updateBoard(Graphics g) {
		
		if(currentX == pelletX && currentY == pelletY) {
			if(compare > 4){
				compare-=1;
			}
			score+=1;
			boolean shouldExitTemp = false;
			while(!shouldExitTemp) {
				pelletX = random.nextInt(20);
				pelletY = random.nextInt(20);
				for(int i = 0; i < boardX.size();i++) {
					if(!(boardX.get(i) == pelletX && boardY.get(i) == pelletY)) {
						shouldExitTemp = true;
					}
				}
			}
		}else{
			boardX.remove(0);
			boardY.remove(0);
		}

		switch(direction) {
		case 1:
			currentY--;
			break;
		case 2:
			currentX++;
			break;
		case 3:
			currentY++;
			break;
		case 4:
			currentX--;
			break;
		}
		if(currentX < 0 || currentY < 0 || currentX > 21 || currentY > 21) {
			pellet.paint(g, pelletX, pelletY);
			snake.paint(g,  boardX, boardY);
			g.setColor(Color.blue);
			g.setFont(new Font("Areil", Font.PLAIN, 50));
			g.drawString("Game Over", 200, 350);
			g.setFont(new Font("Areil", Font.PLAIN, 30));
			g.drawString("Final Score: " + score, 220, 385);
			g.setFont(new Font("Areil", Font.PLAIN, 30));
			g.drawString("Press Enter to replay", 190, 420);
			isGameOver = true;
			return;
		}
		for(int i = 0; i < boardX.size();i++) {
			if(boardX.get(i) == currentX && boardY.get(i) == currentY) {
				pellet.paint(g, pelletX, pelletY);
				snake.paint(g,  boardX, boardY);
				g.setColor(Color.blue);
				g.setFont(new Font("Areil", Font.PLAIN, 50));
				g.drawString("Game Over", 200, 350);
				g.setFont(new Font("Areil", Font.PLAIN, 30));
				g.drawString("Final Score: " + score, 220, 385);
				g.setFont(new Font("Areil", Font.PLAIN, 30));
				g.drawString("Press Enter to replay", 190, 420);
				isGameOver = true;
				return;
			}
		}
		boardX.add(currentX);
		boardY.add(currentY);
		pellet.paint(g, pelletX, pelletY);
		snake.paint(g, boardX, boardY);
		g.setColor(Color.blue);
		g.setFont(new Font("Areil", Font.PLAIN, 15));
		g.drawString("Score: " + score, 580, 20);
	}
}
