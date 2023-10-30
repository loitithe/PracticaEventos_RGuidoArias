package Clase_Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
    private JButton btn_dibujaCuadrado, btn_dibujaCirculo, btn_dibujaTriangulo, btn_limpiar;
    private JPanel panel_dibujo, panel_botones, panel_coordenadas;
    private JLabel lblCoordenadaX, lblCoordenadaY, lblAlto, lblAncho, lblColor;
    private JTextField txtCoordenadaX, txtCoordenadaY, txtAlto, txtAncho, txtColor;
    private Graphics graphics;
    private int[] datosDibujo = new int[4];
    private String nombre_figura;

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
        // panel de dibujo, aqui se trabaja la clase graphics
        panel_dibujo = new PanelDibujo();

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
        setLocation(200, 200);
        setSize(1200, 800);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn_pulsado = (JButton) e.getSource();
        String[] rgb = txtColor.getText().split(",");

        int r = Integer.parseInt(rgb[0].trim());
        int g = Integer.parseInt(rgb[1].trim());
        int b = Integer.parseInt(rgb[2].trim());
        Color colorDibujo = new Color(r, g, b);
        graphics = panel_dibujo.getGraphics();
        datosDibujo();
        nombre_figura = btn_pulsado.getText();
        if (btn_pulsado.equals(btn_dibujaCirculo)) {
            graphics.setColor(colorDibujo);
            graphics.drawString("datos CIRCULO" + datosDibujo[0] + "," + datosDibujo[1] + "," + datosDibujo[2] + ","
                    + datosDibujo[3], 10, 10);
            graphics.setColor(colorDibujo);
            graphics.fillOval(datosDibujo[0], datosDibujo[1], datosDibujo[2], datosDibujo[3]);

        }
        if (btn_pulsado.equals(btn_dibujaCuadrado)) {
            graphics.setColor(colorDibujo);
            graphics.drawString("datos CUADRADO" + datosDibujo[0] + "," + datosDibujo[1] + "," + datosDibujo[2] + ","
                    + datosDibujo[3], 10, 10);
            graphics = panel_dibujo.getGraphics();
            graphics.drawString("datos figura" + datosDibujo[0] + "," + datosDibujo[1] + "," + datosDibujo[2] + ","
                    + datosDibujo[3], 10, 10);
            graphics.setColor(colorDibujo);
            graphics.fillRect(datosDibujo[0], datosDibujo[1], datosDibujo[2], datosDibujo[3]);
        }
        if (btn_pulsado.equals(btn_dibujaTriangulo)) {

        }
        if (btn_pulsado.equals(btn_limpiar)) {
            graphics.setColor(Color.LIGHT_GRAY);
            graphics.fillRect(0, 0, panel_dibujo.getWidth(), panel_dibujo.getHeight());
        }

    }

    public int[] datosDibujo() {
        try {
            datosDibujo[0] = Integer.parseInt(txtCoordenadaX.getText());
            datosDibujo[1] = Integer.parseInt(txtCoordenadaY.getText());
            datosDibujo[2] = Integer.parseInt(txtAncho.getText());
            datosDibujo[3] = Integer.parseInt(txtAlto.getText());
        } catch (Exception e) {
            // TODO: handle exception
        }

        return datosDibujo;
    }

    class PanelDibujo extends JPanel {

        PanelDibujo() {
            setBackground(Color.LIGHT_GRAY);
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

        }
    }
}
