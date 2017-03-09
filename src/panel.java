import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class panel extends JPanel {
	final Dimension defaultDim;
	GameMap gm;
	GameObject T;//player
	private Timer t;
	double startTime = 0;
	
	public panel() {
		this( new Dimension(800,600));
	}
	
	public panel(Dimension dim) {
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		makeGameMap();
		t.start();
	}
	

	private void makeGameMap() {
		gm = new PlatformMap();
		T = gm.gameObjects().get(0);//player tank
		//timer
		t = new Timer(10, new ActionListener() {// fires off every 10 ms
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setUpKeyMappings();
				gm.tick();
				repaint();// naturally, we want to see the new view
			}
				
		});
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(gm.backgroundImage, 0, 0,this.getWidth(),this.getHeight() ,null);
		for (GameObject go : gm.gameObjects()) {
			go.draw(g);
		}
	}
	
	private void setUpKeyMappings() {

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0,false),"attack");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,true), "stop");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,false), "move_right");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,true), "stop");
		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,false), "move_left");


		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "Jump");
		
			
		this.getActionMap().put("Jump",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//jump
				startTime = System.currentTimeMillis();
				T.setStartTime(startTime);
				T.set_inAir(true);
				System.out.println("jump");
			}
		});
		this.getActionMap().put("stop",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//stop
				T.set_speed(0);
			}
		});
		//right
		this.getActionMap().put("move_right",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//turn right
				T.set_direction(0);
				T.set_speed(10);
				T.set_image();	
				System.out.println(T.x());
			}
		});
		//left
		this.getActionMap().put("move_left",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//turn left
				T.set_direction(180);
				T.set_speed(10);
				T.set_image();
				}
		});
		
		//Diagonal movement
		
		

		
		
	
		this.requestFocusInWindow();		
	}

	

}
