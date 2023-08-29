package com.vilarinhojp.grafico;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class GraficoJava extends Canvas{

	public static JFrame frame;

	public GraficoJava() {
		this.setPreferredSize(new Dimension(500,500));
		frame=new JFrame();
		frame.add(this);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	public static void main(String[]args) {

		GraficoJava graficoJava=new GraficoJava();


	}
}
