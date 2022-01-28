import java.awt.Color;
import java.awt.Graphics;

public class PelletView {
	
	public void paint(Graphics g, int x, int y) {
		g.setColor(Color.red);
		g.fillRect(x*30, y*30, 30, 30);
	}

}
