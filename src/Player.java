import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends GameObject {
	protected Frame f = new Frame();
	protected BufferedImage fra[] = f.getimages();

	private int frames = 0;

	Player(double direction, double health, double width, double height,
			double speed, int level, double x, double y) {
		super(direction, health, width, height, speed, level, x, y);
		set_image();
		super.set_x(500);
		super.set_y(580);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void set_image() {
		// TODO Auto-generated method stub
		frames++;
		if (frames == 4) {
			frames = 0;
		}
		super.set_img(fra[frames]);
	}

	@Override
	public void check_location() {
		// TODO Auto-generated method stub
		if (super.y() > 580 || super.y() < 0) {
			super.set_y(580);
		}
	}

}
