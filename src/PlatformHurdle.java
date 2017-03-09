import java.awt.Graphics;

public class PlatformHurdle extends GameObject {

	public PlatformHurdle() {
		// TODO Auto-generated constructor stub
		super(0, 10, 100, 100, 2, 2);
	}

	@Override
	public void set_image() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean check_location() {
		return false;
		// TODO Auto-generated method stub

	}

	// temporary
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect((int) x(), (int) y(), (int) width(), (int) height());
	}

	@Override
	public void calcY(double t) {
		// TODO Auto-generated method stub
		
	}

}
