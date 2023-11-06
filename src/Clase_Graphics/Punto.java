package Clase_Graphics;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double calcularDistancia(Punto punto) {
        double distancia_x, distancia_y;
        distancia_x = punto.getX() - x;
        distancia_y = punto.getY() - y;
        return (Math.sqrt(distancia_x * distancia_x + distancia_y * distancia_y));
    }

}
