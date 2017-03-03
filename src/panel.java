import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class panel extends JPanel {
	final Dimension defaultDim;
	GameMap gm;
	GameObject T;
	private Timer t;
	
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
		T = (GameObject) gm.movers().get(0);//player tank
		//timer
		t = new Timer(10, new ActionListener() {// fires off every 10 ms
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setUpKeyMappings();
				repaint();// naturally, we want to see the new view
			}
				
		});
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(gm.backgroundImage, 0, 0,this.getWidth(),this.getHeight() ,null);
		g.drawImage(T.img(), (int)T.x(), (int)T.y(),(int)T.width(),(int)T.height() ,null);//fix
	}
	
	private void setUpKeyMappings() {

		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"attack");
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "move_right");
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "move_left");
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "Jump");
		
			
		this.getActionMap().put("Jump",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//jump
			}
		});
		//right
		this.getActionMap().put("move_right",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//turn right
				T.set_direction(0);
				T.set_image();
				T.move();	
			}
		});
		//left
		this.getActionMap().put("move_left",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//turn left
				T.set_direction(180);
				T.set_image();
				T.move();
				}
		});
		
		this.getActionMap().put("Jump", new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e){
				
			}
		});
		//Diagonal movement
		
		

		
		
	
		this.requestFocusInWindow();		
	}

	

}
