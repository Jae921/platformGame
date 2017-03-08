import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class player extends GameObject{
	protected frame f = new frame();
	protected BufferedImage fra[] = f.getimages();
	

	
	private int frames = 0;
	
	player(double direction, double health, double width, double height, double speed, int level) {
		super(direction, health, width, height, speed, level);
		set_image();
		super.set_x(500);
		super.set_y(580);
		// TODO Auto-generated constructor stub
	}
	
	


	@Override
	public void set_image() {
		// TODO Auto-generated method stub
		frames +=1;
		if (frames == 4){
			frames =0;
		}
		super.set_img(fra[frames]);
	}

	@Override
	public boolean check_location() {
		// TODO Auto-generated method stub
		if(super.y()>580||super.y()<0){
			super.set_y(580);
			return true;
		}
		return false;
	}

//	public void move(){
//		super.move();
//		calcY();
//	}
//	
	public void calcY(double start) {
		// TODO Auto-generated method stub
//		if(check_location()){
//			int t = 0;
//			while(y()<580){
//				set_y(y() + 0.5*super.gravity*t + super.initial_speed*t);
//				t+=1;
//			}
//		}
//	}
		if (!super.in_Air()){
			set_y(580);
		}
		else{
			 double t = (System.currentTimeMillis() - start)/1000.0;
			 set_y(y()+super.initial_speed*t + 0.8*super.gravity*Math.pow(t, 2));
			 System.out.println(super.y());
		}
			

		
	}	

}
