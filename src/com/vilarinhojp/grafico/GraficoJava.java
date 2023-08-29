package com.vilarinhojp.grafico;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GraficoJava extends Canvas {

    public static JLabel label;
    public static JLabel label2;
    public static JFrame frame;
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private final int SCALE = 1;

    public GraficoJava() {
    	 frame = new JFrame("Grafico");
         frame.setLayout(new BorderLayout()); // Configura o layout como BorderLayout
         label = new JLabel();
         label.setText("OLÁ");
         frame.add(label, BorderLayout.WEST); // Adiciona a JLabel na parte superior
         frame.add(this, BorderLayout.CENTER); // Adiciona o Canvas no centro

         frame.setSize(WIDTH, HEIGHT); // Define um tamanho fixo para a janela
         frame.setResizable(false);
         frame.setVisible(true);
         frame.setLocationRelativeTo(null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
       
    }

    public static void main(String[] args) {
        GraficoJava graficoJava = new GraficoJava();
    }
}