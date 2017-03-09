import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;



public class Frame {
	BufferedImage ima;
	
	
	public BufferedImage[] getimages(){
		BufferedImage splite[] = new BufferedImage[4];
		for(int n =1;n<=4;n++){
			try{
				String framename = "mario_animation_frame";
				File url = new File("src/image/Mario Frames/running/"+framename+n+".png");
				ima = ImageIO.read(url);
				splite[n-1] = ima;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("No image");
			}
		}
		
		return splite;
	}

}
