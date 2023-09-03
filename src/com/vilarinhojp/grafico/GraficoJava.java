package com.vilarinhojp.grafico;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GraficoJava extends Canvas implements Runnable{
	
	private JFrame frame;
	
	private final int WIDTH=800;
	private final int HEIGHT=600;
	private final int SCALE=1;
	private boolean isRunning=false;
	
	private Thread threadRun;
	
	private BufferedImage image;
	
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
		threadRun=new Thread(this);
		isRunning=true;
		threadRun.start();
	}
	public synchronized void stop() {
		
	}
	public void tick() {
		
	}
	public void render() {
		BufferStrategy bs=this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g =image.getGraphics();
		g=bs.getDrawGraphics();
		g.drawImage(image,0,0,WIDTH*SCALE,HEIGHT*SCALE,null);
		bs.show();
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
				frames++;
				delta--;
				
				
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
		image=new BufferedImage(WIDTH*SCALE,HEIGHT*SCALE,BufferedImage.TYPE_INT_RGB);
	}
	
	public static void main(String[] args) {
		
		GraficoJava graficoJava = new GraficoJava();
		graficoJava.start();
	}
}