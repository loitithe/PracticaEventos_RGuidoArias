/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaeventos_rguidoarias;

/**
 *
 * @author a22rodrigodga
 */
public class Matematica {

    private int num1, num2;

    public Matematica() {

    }

    public Matematica(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int suma(int num1, int num2) {
        return num1 + num2;
    }

    public int multiplicacion(int num1, int num2) {
        return num1 * num2;
    }
}
