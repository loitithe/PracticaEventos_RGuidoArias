package Clase_Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Marco marco = new Marco();

    }
}

class Marco extends JFrame implements ActionListener {
    JButton btn_dibujaCuadrado, btn_dibujaCirculo, btn_dibujaTriangulo, btn_limpiar;
    JPanel panel_dibujo, panel_botones, panel_coordenadas;
    JLabel lblCoordenadaX, lblCoordenadaY, lblAlto, lblAncho, lblColor;
    JTextField txtCoordenadaX, txtCoordenadaY, txtAlto, txtAncho, txtColor;

    public Marco() {
        setLayout(new BorderLayout());
        initComponents();

        add(panel_coordenadas, BorderLayout.NORTH);
        add(panel_dibujo, BorderLayout.CENTER);
        add(panel_botones, BorderLayout.SOUTH);
    }

    void dibujarCuadrado() {

    }

    void dibujarCirculo() {

    }

    void dibujgarTriangulo() {

    }

    private void initComponents() {

        // Paneles
        GridLayout gl = new GridLayout(3, 4);
        gl.setHgap(15);
        gl.setVgap(5);

        panel_coordenadas = new JPanel();
        panel_coordenadas.setLayout(gl);

        panel_dibujo = new JPanel();
        panel_dibujo.setBackground(Color.lightGray);

        panel_botones = new JPanel();

        // JLabels
        lblCoordenadaX = new JLabel("Coordenada X");
        lblCoordenadaY = new JLabel("Coordenada Y");
        lblAlto = new JLabel("Alto");
        lblAncho = new JLabel("Ancho");
        lblColor = new JLabel("Color");

        // JTextFields
        txtCoordenadaX = new JTextField();

        txtCoordenadaY = new JTextField();
        txtAlto = new JTextField();
        txtAncho = new JTextField();
        txtColor = new JTextField();

        // JButtons
        btn_dibujaCuadrado = new JButton("Cuadrado");
        btn_dibujaCirculo = new JButton("Circulo");
        btn_dibujaTriangulo = new JButton("Triangulo");
        btn_limpiar = new JButton("Limpiar");

        // Listeners
        btn_limpiar.addActionListener(this);
        btn_dibujaCuadrado.addActionListener(this);
        btn_dibujaCirculo.addActionListener(this);
        btn_dibujaTriangulo.addActionListener(this);

        panel_coordenadas.add(lblCoordenadaX);
        panel_coordenadas.add(txtCoordenadaX);

        panel_coordenadas.add(lblCoordenadaY);
        panel_coordenadas.add(txtCoordenadaY);

        panel_coordenadas.add(lblAlto);
        panel_coordenadas.add(txtAlto);

        panel_coordenadas.add(lblAncho);
        panel_coordenadas.add(txtAncho);

        panel_coordenadas.add(lblColor);
        panel_coordenadas.add(txtColor);

        panel_botones.add(btn_dibujaCuadrado);
        panel_botones.add(btn_dibujaCirculo);
        panel_botones.add(btn_dibujaTriangulo);
        panel_botones.add(btn_limpiar);

        // Configuracion de la ventanna
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setResizable(false);
        setLocation(500, 300);
        setSize(600, 500);
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn_pulsado = (JButton) e.getSource();
        if (btn_pulsado.equals(btn_dibujaCirculo)) {

        }
        if (btn_pulsado.equals(btn_dibujaCuadrado)) {

        }
        if (btn_pulsado.equals(btn_dibujaTriangulo)) {

        }
        if (btn_pulsado.equals(btn_limpiar)) {

        }

    }
}
