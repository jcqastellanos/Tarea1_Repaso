/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_repaso;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author General
 */
public class Recursividad {

    static String binario = "";

    public String Binarios(int decimal) {

        binario += Integer.toString(decimal % 2);

        if (decimal < 2) {
            int index = binario.length() - 1;
            String binarioreal = "";
            for (int i = 0; i < binario.length(); i++) {

                binarioreal += binario.charAt(index);
                index--;
            }
            binario = "";
            return binarioreal;
        } else {
            return Binarios(decimal / 2);
        }

    }

    public int ComunDivisor(int x, int y) {
        int residuo = x % y;

        if (residuo == 0) {
            return y;
        } else {
            int nuevoy = residuo;
            int nuevox = y;
            return ComunDivisor(nuevox, nuevoy);
        }

    }

    public int Fibonacci(int repeticiones, int x, int y) {

        int resultado = x + y;
        System.out.println(x + " + " + y + " = " + resultado);
        if (repeticiones == 1) {
            return resultado;
        } else {
            int nuevox = y;
            int nuevoy = resultado;
            return Fibonacci(repeticiones = repeticiones - 1, nuevox, nuevoy);
        }
    }

    public boolean BusquedaBinaria(int[] Arreglo, int numero) {
        ImprimirArreglo(Arreglo);
        int referencia = Arreglo.length / 2;
        if (Arreglo.length == 2 || Arreglo.length == 1) {
            if (Arreglo[1] == numero) {
                return true;
            } else if (Arreglo[0] == numero) {
                return true;
            } else {
                return false;
            }
        }

        if (Arreglo[referencia] > numero) {
            int[] Nuevo = new int[referencia];

            for (int i = 0; i < referencia; i++) {
                Nuevo[i] = Arreglo[i];
            }
            return BusquedaBinaria(Nuevo, numero);
        } else if (Arreglo[referencia] < numero) {
            int[] Nuevo2 = new int[referencia];
            int cont = 0;
            for (int i = Arreglo.length - 1; i > referencia; i--) {
                Nuevo2[cont] = Arreglo[i];
                cont++;
            }
            return BusquedaBinaria(Nuevo2, numero);
        }
        else if (Arreglo[referencia]==numero){
            return true;
        }
        return false;

    }

    public static void ImprimirArreglo(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " | ");
        }
        System.out.println("");
    }

    public int[] OrdenarArreglo(int[] x) {
        int[] temporal = new int[x.length];
        temporal = x;

        for (int i = 0; i < temporal.length - 1; i++) {
            for (int j = 0; j < temporal.length - 1 - i; j++) {
                if (temporal[j] > temporal[j + 1]) {
                    int posicion = temporal[j];
                    temporal[j] = temporal[j + 1];
                    temporal[j + 1] = posicion;
                }
            }
        }

        return temporal;
    }

}
