package com.vilarinhojp.grafico;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

//Classe GraficoJava que herda de Canvas (elemento gráfico)
public class GraficoJava extends Canvas {
	
 // Variável estática que representa a janela do programa
	public static JFrame frame;
	
	// Constantes para largura, altura e escala da janela
	private final int WIDTH = 400;
	private final int HEIGHT = 400;
	private final int SCALE = 2;
	
	// Construtor da classe GraficoJava
	public GraficoJava() {
		// Define o tamanho preferencial do Canvas (elemento gráfico)
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		// Criação da janela (frame)
		frame = new JFrame();
		frame.add(this); // Adiciona o Canvas à janela
		frame.setResizable(false); // Impede redimensionamento da janela
		frame.setVisible(true); // Torna a janela visível
		frame.setLocationRelativeTo(null); // Centraliza a janela na tela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela
		frame.pack(); // Redimensiona a janela para se ajustar ao tamanho do Canvas
	}
	
	// Método main (ponto de entrada do programa)
	public static void main(String[] args) {
		// Criação de um objeto GraficoJava
		GraficoJava graficoJava = new GraficoJava();
	}
}