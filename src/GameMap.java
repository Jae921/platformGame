import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {
	private List<GameObject> gameObjects;
	Image backgroundImage;
	
	public GameMap() {
		this.gameObjects = new ArrayList<GameObject>();
		openBackgroundImage();
	}
	
	public List<GameObject> getGameObjects(){
		return this.gameObjects;
	}
	
	public void addGameObject(GameObject go) {
		this.gameObjects.add(go);
	}
	public abstract void openBackgroundImage();


}
