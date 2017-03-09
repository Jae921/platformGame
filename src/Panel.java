import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Panel extends JPanel {
	final Dimension defaultDim;
	GameMap gm;
	GameObject player;
	private Timer t;

	public Panel() {
		this(new Dimension(800, 600));
	}

	public Panel(Dimension dim) {
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		makeGameMap();
		t.start();
	}

	private void makeGameMap() {
		gm = new PlatformMap();
		player = (GameObject) gm.getGameObjects().get(0);// player tank
		// timer
		t = new Timer(10, new ActionListener() {// fires off every 10 ms
					@Override
					public void actionPerformed(ActionEvent arg0) {
						setUpKeyMappings();
						repaint();// naturally, we want to see the new view
					}
				});

		gm.addGameObject(new PlatformHurdle());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(gm.backgroundImage, 0, 0, this.getWidth(),
				this.getHeight(), null);
		
		player.draw(g);

		for (int i = 0; i < gm.getGameObjects().size(); i++) {
			GameObject go = gm.getGameObjects().get(i);
			go.draw(g);
		}

	}

	private void setUpKeyMappings() {

		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "attack");
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "move_right");
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "move_left");
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "Jump");

		this.getActionMap().put("Jump", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// jump
			}
		});
		// right
		this.getActionMap().put("move_right", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// turn right
				player.set_direction(0);
				player.set_image();
				player.move();
			}
		});
		// left
		this.getActionMap().put("move_left", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// turn left
				player.set_direction(180);
				player.set_image();
				player.move();
			}
		});

		this.getActionMap().put("Jump", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		// Diagonal movement

		this.requestFocusInWindow();
	}

}
