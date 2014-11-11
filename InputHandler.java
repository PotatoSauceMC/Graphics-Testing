package tc.cornhub.psmc;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class InputHandler extends MouseAdapter implements KeyListener, MouseMotionListener  {
	// Key Stuff
	static int Ajust = 10;
	static int Ajusttwo = 10;
	
	// Mouse Stuff
	static boolean clicked = false;
	
	static int xn, yn;
	static int click = 0;

	
	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == e.VK_W) {
			Boxy.goingUp = true;
			Boxy.goingDown = false;
			Boxy.goingLeft = false;
			Boxy.goingRight = false;
		}
		if(keyCode == e.VK_S) {
			Boxy.goingUp = false;
			Boxy.goingDown = true;
			Boxy.goingLeft = false;
			Boxy.goingRight = false;
		}
		if(keyCode == e.VK_A) {
			Boxy.goingUp = false;
			Boxy.goingDown = false;
			Boxy.goingLeft = true;
			Boxy.goingRight = false;
		}
		if(keyCode == e.VK_D) {
			Boxy.goingUp = false;
			Boxy.goingDown = false;
			Boxy.goingLeft = false;
			Boxy.goingRight = true;
		}
		
		if(keyCode == e.VK_ESCAPE) {
			Main.stop();
		}
		if(keyCode == e.VK_UP){
			Ajusttwo -= 100;
			
		}
		if(keyCode == e.VK_DOWN){
			Ajusttwo += 100;
		}
		if(keyCode == e.VK_LEFT){
			Ajust -= 100;
			
		}
		if(keyCode == e.VK_RIGHT){
			Ajust += 100;
		}
		
	}

	
	@SuppressWarnings("static-access")
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == e.VK_W) {
			Boxy.goingUp = false;
			Boxy.goingDown = false;
			Boxy.goingLeft = false;
			Boxy.goingRight = false;
		}
		if(keyCode == e.VK_S) {
			Boxy.goingUp = false;
			Boxy.goingDown = false;
			Boxy.goingLeft = false;
			Boxy.goingRight = false;
		}
		if(keyCode == e.VK_A) {
			Boxy.goingUp = false;
			Boxy.goingDown = false;
			Boxy.goingLeft = false;
			Boxy.goingRight = false;
		}
		if(keyCode == e.VK_D) {
			Boxy.goingUp = false;
			Boxy.goingDown = false;
			Boxy.goingLeft = false;
			Boxy.goingRight = false;
		}
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	// End Of Key Stuff---------------------------------------------------------
	
	
	
	
	// Mouse Stuff -------------------------------------------------------------
	
	public void mousePressed(MouseEvent f) {
		// Left Id = 1 | Middle Id = 2 | Right Id = 3
		
		click = f.getClickCount();
		if(f.getButton() == 1) {
			clicked = true;
		}

	}

	public void mouseDragged(MouseEvent f) {
		xn = f.getX();
		yn = f.getY();
	}

	public void mouseMoved(MouseEvent f) {
		xn = f.getX();
		yn = f.getY();
		
	}

	public void mouseReleased(MouseEvent f) {
		if(f.getButton() == 1) {
			clicked = false;
		}
	}
	public static void render(Graphics g) {
		if(clicked == true) {
			// Draw
			g.setColor(Color.WHITE);
			g.draw3DRect(Main.WIDTH / 2 - 50, Main.HEIGHT / 2 - 50, 100, 100, true);
		}
	}
}

