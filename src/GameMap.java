import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {
	private List<GameObject> gameObjects;
	Image backgroundImage;
	
	public GameMap() {
		gameObjects = new ArrayList();
		openBackgroundImage();
	}
	
	public List<GameObject> gameObjects(){
		return gameObjects;
	}
	
	public void addGameObject(GameObject go) {
		gameObjects.add(go);
	}
	
	public abstract void openBackgroundImage();
	public abstract void tick();


}
