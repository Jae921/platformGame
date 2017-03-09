import java.awt.Graphics;
import java.awt.Image;

public abstract class GameObject implements Mover {
	public final static double gravity = 9.8;
	public final static double initial_speed = -10;
	private double health, width, height , x, y, speed, power, direction, startTime;
	private Image img;
	private int level;
	private boolean inAir;
	GameObject(double direction, double health, double width, double height , double speed, 
			int level){
		this.health = health;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.level = level;
		this.direction = direction;
		this.inAir = inAir;
		this.startTime = startTime;
	}
	
	//Accessor----------------------------------
	//health
	public void set_inAir(boolean a){
		this.inAir =a;
	}
	public boolean in_Air(){
		return inAir;
	}
	public void setStartTime(double s){
		startTime = s;
	}
	public double getStartTime(){
		return startTime;
	}
	
	public double health(){
		return health;
	}
	//width
	public double width(){
		return width;
	}
	//height
	public double height(){
		return height;
	}
	//speed
	public double speed(){
		return speed;
	}
	public void set_speed(double s){
		this.speed = s;
	}
	//level
	public int level(){
		return level;
	}
	//image
	public Image img(){
		return img;
	}
	public void set_img(Image i){
		this.img=i;
	}
	//x&y
	public double x(){
		return x;
	}
	public double y(){
		return y;
	}
	public void set_x(double x){
		this.x=x;
	}
	public void set_y(double y){
		this.y=y;
	}
	//direction
	public double direction(){
		return direction;
	}
	public void set_direction(double d){
		this.direction=d;
	}
	//------------------------------------------
	
	public void move(){
		x+= speed*Math.cos(Math.toRadians(direction));
		calcY(this.getStartTime());
		check_location();
	}
	
	public abstract void calcY(double t);//jump
	public abstract void set_image();
	public abstract boolean check_location();
	
	public void draw(Graphics g) {
		g.drawImage(img, (int) x, (int) y, (int) width, (int) height, null);
	}
	
}

