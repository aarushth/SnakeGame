import java.awt.Color;
import java.awt.Graphics;

public class PelletView {
	public void paint(Graphics g, int pelletX, int pelletY) {
		g.setColor(Color.red);
		g.fillRect(pelletX*30, pelletY*30, 30, 30);
	}
}
