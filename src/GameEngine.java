import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameEngine implements Window.EventListener{
	
	Board board = new Board();
	Window frame; 
	Graphics graphics;
	Timer t;
	private int tempDirection = 3;
	private int counter = 0;
	public GameEngine() {
		frame = new Window(this);
		board.initializeBoard();
			int delay = 15; //milliseconds
			ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(frame.checkIsEnterPressed() && board.getIsGameOver()) {
					board.initializeBoard();
					counter = 0;
				}
				if(!board.getIsGameOver()) {
					if(counter < board.getCompare()) {
						counter++;
					}else {
						board.setDirection(tempDirection);
						frame.updateFrame();
						counter = 0;
					}
				}else{
					graphics.setFont(new Font("Areil", Font.PLAIN, 50));
					graphics.drawString("Game Over", 200, 350);
					graphics.setFont(new Font("Areil", Font.PLAIN, 30));
					graphics.drawString("Final Score: " + board.getScore(), 220, 385);
					graphics.setFont(new Font("Areil", Font.PLAIN, 30));
					graphics.drawString("Relaunch to continue", 190, 420);
				}
				
			}
		};
		t = new Timer(delay, taskPerformer);
		t.start();
	}
	
	@Override
	public void onPaintEvent(Graphics g) {
		graphics = g;
		board.updateBoard(g);
	}
	@Override
	public void onKeyEvent(int direction) {
		tempDirection = direction;	
	}
}
