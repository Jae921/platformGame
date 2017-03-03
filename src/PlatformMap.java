import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class PlatformMap extends GameMap{

	
	public PlatformMap(){
		addplayer();
		openBackgroundImage();
	}
	
	private void addplayer() {
		this.addGameObject(new player(1,50, 62.5, 105, 10, 1));
		
	}
	
	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub
		try {
			String mapName = "mario_background";
			File u = new File("src/image/"+ mapName + ".png");
			super.backgroundImage = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Cannot read image...");
			e.printStackTrace();
		}
	}

}
