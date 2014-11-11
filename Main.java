package tc.cornhub.psmc;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class Main extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args){
		@SuppressWarnings("unused")
		Main main = new Main();
	}
	
	JFrame frame;
	public final static int WIDTH = 1500;
	public final static int HEIGHT = WIDTH / 16 * 9;
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
	public final String TITLE = "Boxy's Adventures - Version Alpha 1.0 - Debug";
	int numoftime = 0;
	int framesrendered = 0;
	

	
	static int fps = 0;
	static int ups = 0;
	int ffps;
	int fups;
	
	//JButton mouseControl;
	int buttonWidth = 100;
	int buttonHeight = 150;
	
	static boolean collin = false;
	
	static int fx, fy;
	long timer = System.currentTimeMillis();
	long timer2 = System.currentTimeMillis();
	int seconds, min, hours, timef;
		
	
	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private Boxy boxy;
	private Noise noise;
	
	static boolean gameRunning = false;
	
	
	public void run() {
		
		while (gameRunning) {
			tick();
			render();
			
			ups++;
			fps++;
			if(System.currentTimeMillis() - timer >= 1000) {
				ffps = fps;
				fups = ups;
				timer = System.currentTimeMillis();
				ups = 0;
				fps = 0;
			}
		}
	}

	public synchronized void start() {
		gameRunning = true;
		new Thread(this).start();
	}
	public synchronized static void stop() {
		gameRunning = false;
		System.exit(0);
	}
	
	public Main() {
		frame = new JFrame();
		
		setMinimumSize(gameSize);
		setPreferredSize(gameSize);
		setMaximumSize(gameSize);
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null);
		
		
		InputHandler IH = new InputHandler();
		frame.addKeyListener(IH);
		addMouseListener(IH);
	    addMouseMotionListener(IH);
	    
		
		
		
		boxy = new Boxy(61, 91);
		noise = new Noise();
		
		
		start();
		
	}

	public void tick() {
		boxy.tick(this);
		noise.tick(this);
		fx = Boxy.x;
		fy = Boxy.y;
		frame.requestFocus();
		
		if(System.currentTimeMillis() - timer2 >= 1000) {
			seconds++; // Seconds
			
			timef = seconds;
			timer2 = System.currentTimeMillis();
			
		}
		if(seconds >= 60) {
			min += 1;
			seconds = 0;
		} else if (min >= 60){
			hours += 1;
		}
		
		
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		framesrendered++;
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setFont(getFont().deriveFont(10.0f));
		
		
		// End Of Background Draw ----------------------------------------------------
		
		// Crap Goes Here
		boxy.render(g);
		InputHandler.render(g);
		
		g.setColor(Color.CYAN);
		g.fillRect(InputHandler.xn, 0, 1, HEIGHT);
		g.fillRect(0, InputHandler.yn, WIDTH, 1);
		
		// ---------------------Words-------------------------------
		g.setFont(getFont().deriveFont(15.0f));
		g.drawString("FPS: " + ffps, 10, 80);
		g.drawString("UPS: " + fups, 10, 94);
		
		g.setFont(new Font("Segoe UI", Font.PLAIN,40));
		g.drawString("", InputHandler.Ajust, InputHandler.Ajusttwo);
		
		g.setFont(new Font("Segoe UI", Font.PLAIN,10));
		g.setColor(Color.BLUE);
		g.drawString("Mouse Pos X: " + InputHandler.xn, 10, 33);
		g.drawString("Mouse Pos Y: " + InputHandler.yn, 10, 44);
		g.drawString("Boxy PosX: " + fx, 10, 55);
		g.drawString("Boxy PosY: " + fy, 10, 65);
		g.setColor(Color.yellow);
		g.drawString("Press Esc to Exit", WIDTH - 100, 10);
		g.setColor(Color.MAGENTA);
		g.drawString("W, A, S, D To move", WIDTH - 120, 24);
		g.drawString("Hold Down K To Use The Mouse", WIDTH - 185, 38);
		
		g.setColor(Color.RED);
		g.drawString("Ajust: " + InputHandler.Ajust, WIDTH - 185, 48);
		g.drawString("Ajust 2: " + InputHandler.Ajusttwo, WIDTH - 185, 58);
		
		g.setFont(new Font("Segoe UI", Font.PLAIN,40));
		g.drawString("Time Elapsed: " + hours + " : " + min + " : " + seconds, 10, 810);
				
		// -----------------------End of Words--------------------------
		
		
		
		
		 
		
		// End Of Render -------------------------------------------------------------
		
		g.dispose();
		bs.show();
		
		// No, Seriously Now This Is The End
	}	
}
