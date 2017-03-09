import java.awt.Graphics;
import java.awt.Image;

public abstract class GameObject implements Mover {
	public final static double GRAVITY = 9.8;
	private double health, width, height, x, y, speed, power, direction;
	private Image img;
	private int level;

	public GameObject(double direction, double health, double width,
			double height, double speed, int level, double x, double y) {
		this.health = health;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.level = level;
		this.direction = direction;
		this.x = x;
		this.y = y;
	}

	// Accessor----------------------------------
	// health
	public double health() {
		return health;
	}

	// width
	public double width() {
		return width;
	}

	// height
	public double height() {
		return height;
	}

	// speed
	public double speed() {
		return speed;
	}

	// level
	public int level() {
		return level;
	}

	// image
	public Image img() {
		return img;
	}

	public void set_img(Image i) {
		this.img = i;
	}

	// x&y
	public double x() {
		return x;
	}
	
	public double y() {
		return y;
	}

	public void set_x(double x) {
		this.x = x;
	}

	public void set_y(double y) {
		this.y = y;
	}

	// direction
	public double direction() {
		return direction;
	}

	public void set_direction(double d) {
		this.direction = d;
	}

	// ------------------------------------------

	public void move() {
		x += speed * Math.cos(Math.toRadians(direction));
		check_location();
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, (int) x, (int) y, (int) width, (int) height, null);
	}

	public abstract void set_image();

	public abstract void check_location();

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

}
