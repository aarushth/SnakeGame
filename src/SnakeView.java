import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class SnakeView {
	public void paint(Graphics g, ArrayList<Integer> XList, ArrayList<Integer> YList) {
			g.setColor(Color.black);
		for(int i = 0; i < XList.size(); i++) {
			g.fillRect(XList.get(i)*30, YList.get(i)*30, 30, 30);
		}
		
	}
}
