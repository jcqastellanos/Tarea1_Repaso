/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_repaso;

import javax.swing.JOptionPane;

/**
 *
 * @author General
 */
public class Inventario {

    private String Matricula;
    private String Marca;
    private String Modelo;
    private String Color;
    private int Anio;
    private int Precio;

    public Inventario(String Matricula, String Marca, String Modelo, String Color, int Anio, int Precio) {
        this.Matricula = Matricula;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Color = Color;
        this.Anio = Anio;
        this.Precio = Precio;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    @Override
    
    public String toString() {
        return this.Matricula + " | " + this.Marca + " | " + this.Modelo + " | " + this.Color + " | " + this.Anio + " | " + this.Precio;
    }

}
