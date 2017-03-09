import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JFrame;


public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame gameFrame = new JFrame();
		Map<String,String> environMap= System.getenv();
		System.out.println(environMap.keySet());
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Panel mop = new Panel(d);
		gameFrame.add(mop);
		gameFrame.pack();
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
	}

}
