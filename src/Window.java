import java.awt.Canvas;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	public interface EventListener{
		public void onPaintEvent(Graphics g);
		public void onKeyEvent(int direction);
	}
	
	private Canvas c;
	private EventListener listener;
	private boolean isEnterPressed = false;
	
	
	public Window(EventListener e) {
	    setBounds(1, 1, 700, 700);
		listener = e;
		setTitle("Snake Game");
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		c = new Canvas() {
			public void paint (Graphics g){
				listener.onPaintEvent(g);
			}
		};

		add(c);

		
		addKeyListener(new KeyListener());
	}
	private class KeyListener extends KeyAdapter{
		
		
		@Override
		public void keyPressed(KeyEvent event) {
			int keyCode = event.getKeyCode();
			
			if(keyCode == event.VK_UP || keyCode == event.VK_W) {
				keyCode = 1;
			}else if( keyCode == event.VK_RIGHT || keyCode == event.VK_D){
				keyCode = 2;
			}else if(keyCode == event.VK_DOWN || keyCode == event.VK_S){
				keyCode = 3;
			}else if(keyCode == event.VK_LEFT || keyCode == event.VK_A){
				keyCode = 4;
			}else if(keyCode == event.VK_ENTER){
				isEnterPressed = true;
				return;
			}else {
				return;
			}
			listener.onKeyEvent(keyCode);
			
		}
	}

	public void updateFrame() {
		c.repaint();
	}
	public boolean checkIsEnterPressed() {
		if(isEnterPressed) {
			isEnterPressed = false;
			return true;
		}else {
			return false;
		}
	}
}
	

