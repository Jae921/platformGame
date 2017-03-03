import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {
	private List<Mover> movers;
	Image backgroundImage;
	
	public GameMap() {
		movers = new ArrayList();
		openBackgroundImage();
	}
	
	public List<Mover> movers(){
		return movers;
	}
	
	public void addGameObject(GameObject go) {
		movers.add(go);
	}
	public abstract void openBackgroundImage();


}
