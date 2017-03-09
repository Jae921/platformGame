import java.awt.Graphics;

public class PlatformHurdle extends GameObject {

	public PlatformHurdle() {
		// TODO Auto-generated constructor stub
		super(0, 10, 100, 100, 2, 2, 650, 645);
	}

	@Override
	public void set_image() {
		// TODO Auto-generated method stub

	}

	@Override
	public void check_location() {
		// TODO Auto-generated method stub

	}

	// temporary
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect((int) x(), (int) y(), (int) width(), (int) height());
	}

}
