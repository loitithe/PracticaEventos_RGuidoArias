package Clase_Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Marco2 marco = new Marco2();

    }
}

class Marco extends JFrame implements ActionListener {
    private JButton btn_dibujaCuadrado, btn_dibujaCirculo, btn_dibujaTriangulo, btn_limpiar;
    private JPanel panel_dibujo, panel_botones, panel_coordenadas, panelCentral;
    private JLabel lblCoordenadaX, lblCoordenadaY, lblAlto, lblAncho, lblColor;
    private JTextField txtCoordenadaX, txtCoordenadaY, txtAlto, txtAncho, txtColor;
    private Graphics graphics;
    private JList jList;
    private DefaultListModel model;
    private JScrollPane scrollPane;
    private int[] datosDibujo = new int[4];
    private int r, g, b;
    private Color colorDibujo;

    public Marco() {
        setLayout(new BorderLayout());
        initComponents();
        setTitle("marcoooo");
        add(panel_coordenadas, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        // add(panelJList, BorderLayout.CENTER);
        // add(panel_dibujo, BorderLayout.CENTER);
        add(panel_botones, BorderLayout.SOUTH);
    }

    void dibujarCuadrado(Graphics g, Color colorDibujo) {
        graphics.setColor(colorDibujo);
        graphics = panel_dibujo.getGraphics();
        graphics.setColor(colorDibujo);
        graphics.fillRect(datosDibujo[0], datosDibujo[1], datosDibujo[2], datosDibujo[3]);
        graphics.drawString("Cuadrado", datosDibujo[0] - 50, datosDibujo[1] - 50);
    }

    void dibujarCirculo(Graphics g, Color colorDibujo) {
        graphics.setColor(colorDibujo);
        graphics.setColor(colorDibujo);
        graphics.fillOval(datosDibujo[0], datosDibujo[1], datosDibujo[2], datosDibujo[3]);
        graphics.drawString("Circulo", datosDibujo[0] - 50, datosDibujo[1] - 50);
    }

    void dibujarTriangulo(Graphics g, Color colorDibujo) {

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
        // JTextArea
        jList = new JList();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 120, 220, 80);
        scrollPane.setViewportView(jList);
        model = new DefaultListModel();
        jList.setModel(model);

        // JLabels
        lblCoordenadaX = new JLabel("Coordenada X");
        lblCoordenadaY = new JLabel("Coordenada Y");
        lblAlto = new JLabel("Alto");
        lblAncho = new JLabel("Ancho");
        lblColor = new JLabel("Color");

        // JTextFields
        txtCoordenadaX = new JTextField("200");

        txtCoordenadaY = new JTextField("200");
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

        panelCentral = new JPanel(new GridLayout(1, 2));
        panelCentral.add(jList);
        panelCentral.add(panel_dibujo);

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

        graphics = panel_dibujo.getGraphics();
        if (btn_pulsado.equals(btn_limpiar)) {
            graphics.setColor(Color.LIGHT_GRAY);
            graphics.fillRect(0, 0, panel_dibujo.getWidth(), panel_dibujo.getHeight());
        }
        datosDibujo();
        if (btn_pulsado.equals(btn_dibujaCirculo)) {
            dibujarCirculo(graphics, colorDibujo);
        }
        if (btn_pulsado.equals(btn_dibujaCuadrado)) {
            dibujarCuadrado(graphics, colorDibujo);
        }
        if (btn_pulsado.equals(btn_dibujaTriangulo)) {
            dibujarTriangulo(graphics, colorDibujo);
        }

    }

    public int[] datosDibujo() {
        try {
            if (!txtCoordenadaX.getText().equals("") && !txtCoordenadaY.getText().equals("") &&
                    !txtAncho.getText().equals("") && !txtAlto.getText().equals("") && !txtColor.getText().equals("")) {

                datosDibujo[0] = Integer.parseInt(txtCoordenadaX.getText());
                datosDibujo[1] = Integer.parseInt(txtCoordenadaY.getText());
                datosDibujo[2] = Integer.parseInt(txtAncho.getText());
                datosDibujo[3] = Integer.parseInt(txtAlto.getText());

                String[] rgb = txtColor.getText().split(",");

                r = Integer.parseInt(rgb[0].trim());
                g = Integer.parseInt(rgb[1].trim());
                b = Integer.parseInt(rgb[2].trim());
                colorDibujo = new Color(r, g, b);

            } else {
                JOptionPane.showMessageDialog(this, "Faltan datos para crear el dibujo", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }

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
