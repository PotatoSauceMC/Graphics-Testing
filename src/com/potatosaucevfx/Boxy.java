package com.potatosaucevfx;
import java.awt.Color;
import java.awt.Graphics;


public class Boxy {
	static int x;
	static int y;
	int size = 10;
	int speedMod = 2;
	
	
	static boolean goingLeft = false;
	static boolean goingRight = false;
	static boolean goingUp = false;
	static boolean goingDown = false;
	
	@SuppressWarnings("static-access")
	public Boxy(int x, int y){
		this.x = x * speedMod;
		this.y = y * speedMod;
		
	}
	
	public void tick(Main main) {
		
		
		if(goingUp && y > 0){
			y--;
		}
		if(goingDown && y < Main.HEIGHT){
			y++;
		}
		if(goingRight && x < Main.WIDTH) {
			x++;
		}
		if(goingLeft && x > 0){
			x--;
			
		}
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(Main.fx, Main.fy, size, size);
	}
}
