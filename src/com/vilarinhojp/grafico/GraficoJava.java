package com.vilarinhojp.grafico;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GraficoJava extends Canvas implements Runnable{
	
	private JFrame frame;
	
	private final int WIDTH=800;
	private final int HEIGHT=600;
	private final int SCALE=1;
	private boolean isRunning=false;
	
	private Thread thread;
	
	public void initFrame() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		frame.add(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public synchronized void start() {
		thread=new Thread(this);
		isRunning=true;
		thread.start();
	}
	public synchronized void stop() {
		
	}
	public void tick() {
		
	}
	public void render() {
		
	}
	public void run() {
		
		long lastTime=System.nanoTime();
		double amountOfTicks=60;
		double ns=1000000000/amountOfTicks;
		double delta=0;
		

		double timer=System.currentTimeMillis();
		int frames=0;
		
		while(isRunning) {
			long now=System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime=now;
			
			if(delta>=1) {
				tick();
				render();			
				delta--;
				frames++;
				
			}
			if(System.currentTimeMillis()-timer>=1000) {
				System.out.println("FRAMES: "+frames);
				frames=0;
				timer+=1000;
			}
		}
	}
	public GraficoJava() {
		frame=new JFrame();
		initFrame();
		
	}
	
	public static void main(String[] args) {
		
		GraficoJava graficoJava = new GraficoJava();
		graficoJava.start();
	}
}