package tc.cornhub.psmc;
import java.awt.Graphics;
import java.util.Random;


public class Noise {
	static int rand;
	
	public void tick(Main main){
		Random ran = new Random();
		rand = ran.nextInt();
	}
	public void render(Graphics g) {
		
	}

}
