/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1_repaso;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author General
 */
public class Tarea1_Repaso {

    static Random random = new Random();
    static Scanner leer = new Scanner(System.in);
    static Recursividad recu = new Recursividad();
    static ArrayList<Inventario> Vehiculos = new ArrayList<>();
    static int autos = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean salida = false;
        String[] opciones = {"Inventario", "Recursividad", "Salir"};
        while (!salida) {

            int menu = JOptionPane.showOptionDialog(null, "Ingrese su opcion", "Menu", 0, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (menu) {
                case 0: {
                    String[] MetodosRecursivos = {"Agregar", "Listar", "Modificar", "Eliminar", "Vehiculo Antiguo", "Vehiculos Rojos", "Diferencia Edad", "Salir"};
                    int MenuVehiculos = JOptionPane.showOptionDialog(null, "Seleccione un metodo", "Inventario", 0, JOptionPane.INFORMATION_MESSAGE, null, MetodosRecursivos, 0);
                    switch (MenuVehiculos) {
                        case 0: {
                            while (autos < 50) {
                                System.out.println("Ingrese la Matricula del Auto");
                                String Matricula = leer.next();
                                System.out.println("Ingrese la Marca del Auto");
                                String Marca = leer.next();
                                System.out.println("Ingrese el Modelo del Auto");
                                String Modelo = leer.next();
                                System.out.println("Ingrese el Color del Auto");
                                String Color = leer.next();
                                System.out.println("Ingrese el Anio del Auto");
                                int Anio = leer.nextInt();
                                System.out.println("Ingrese el Precio del Auto");
                                int Precio = leer.nextInt();
                                Inventario temporal = new Inventario(Matricula, Marca, Modelo, Color, Anio, Precio);
                                Vehiculos.add(temporal);
                                JOptionPane.showMessageDialog(null, "Agregado Correctamente");
                                int Salir = JOptionPane.showOptionDialog(null, "Desea agregar otro auto?", "Inventario", 0, JOptionPane.INFORMATION_MESSAGE, null, null, 0);
                                if (Salir == 1) {
                                    break;
                                }
                            }

                            if (autos > 50) {
                                JOptionPane.showMessageDialog(null, "No pueden haber mas de 50 autos");
                            }

                        }
                        break;

                        case 1: {
                            ListarVehiculos();
                        }
                        break;
                        case 2: {
                            ModificarPorMatricula();
                        }
                        break;
                        case 3: {
                            EliminarPorMatricula();
                        }
                        break;
                        case 4: {
                            AutoMasViejo();
                        }
                        break;
                        case 5: {
                            ColorRojo();
                        }
                        break;
                        case 6: {
                            DiferenciaEdad();
                        }
                        break;
                        case 7: {
                            salida = true;
                            JOptionPane.showMessageDialog(null, "saliendo...");
                        }
                        break;
                    }
                }
                break;

                case 1: {
                    String[] MetodosRecursivos = {"Decimal a Binario", "Maximo Divisor", "Serie fibonacci", "Busqueda Binaria"};
                    int menu1 = JOptionPane.showOptionDialog(null, "Seleccione un metodo", "Recursividad", 0, JOptionPane.INFORMATION_MESSAGE, null, MetodosRecursivos, salida);
                    switch (menu1) {
                        case 0: {
                            TraducirNumeros();
                        }
                        break;
                        case 1: {
                            MaximoComunDivisor();
                        }
                        break;
                        case 2: {
                            SerieFibonacci();
                        }
                        break;
                        case 3: {
                            BusquedaBinaria();
                        }
                        break;
                    }
                }
                break;
                case 2: {
                    salida = true;
                    JOptionPane.showMessageDialog(null, "saliendo...");
                }
                break;
            }
        }
    }

    public static int[] LLenarRandom(int[] x) {
        int[] temporal = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            temporal[i] = random.nextInt(1, 10);
        }
        return temporal;
    }

    public static void ImprimirArreglo(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " | ");
        }
        System.out.println("");
    }

    public static void TraducirNumeros() {
        int decimal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero decimal"));
        String nuevo = recu.Binarios(decimal);
        JOptionPane.showMessageDialog(null, "Su decimal a Binario es: " + nuevo);
    }

    public static void MaximoComunDivisor() {
        int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
        int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
        int resultado = recu.ComunDivisor(numero1, numero2);
        JOptionPane.showMessageDialog(null, "Su Maximo Comun Divisor es: " + resultado);
    }

    public static void SerieFibonacci() {
        int repeticiones = Integer.parseInt(JOptionPane.showInputDialog("Que numero de la serie desea ver?"));
        int numero = recu.Fibonacci(repeticiones, 0, 1);
        JOptionPane.showMessageDialog(null, "el numero " + repeticiones + " de la secuencia es: " + numero);
    }

    public static void BusquedaBinaria() {
        int Tamanio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamanio del arreglo (Se llenara con numeros Random)"));
        int[] Arreglo = new int[Tamanio];
        Arreglo = LLenarRandom(Arreglo);
        int Numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero a buscar"));
        Arreglo = recu.OrdenarArreglo(Arreglo);
        boolean encontrado = recu.BusquedaBinaria(Arreglo, Numero);

        if (!encontrado) {
            System.out.println("no encontrado");
            JOptionPane.showMessageDialog(null, "Su numero no fue encontrado en el arreglo");

        } else {
            System.out.println(Numero + "!!");
            JOptionPane.showMessageDialog(null, "Su numero si se encuentra en el arreglo");

        }
        System.out.println("--------------------");
    }

    public static void ListarVehiculos() {
        String Lista = "";
        for (int i = 0; i < Vehiculos.size(); i++) {
            Lista += Vehiculos.get(i);
            Lista += "\n";
        }
        JOptionPane.showMessageDialog(null, Lista);
    }

    public static void ModificarPorMatricula() {
        System.out.println("MATRICULAS");
        for (int i = 0; i < Vehiculos.size(); i++) {
            System.out.println(Vehiculos.get(i));
        }

        int indice = 0;
        String MatriculaBuscar = JOptionPane.showInputDialog("Ingrese la Matricula del Auto a Modificar");
        boolean encontrada = false;
        for (int i = 0; i < Vehiculos.size(); i++) {
            if (Vehiculos.get(i).getMatricula().equalsIgnoreCase(MatriculaBuscar));
            indice = i;
            encontrada = true;
            break;
        }

        if (encontrada = false) {
            return;
        }

        String[] Modificaciones = {"Marca", "Modelo", "Color", "Anio", "Precio"};
        int Modificar = JOptionPane.showOptionDialog(null, "Que desea modificar?", "Recursividad", 0, JOptionPane.INFORMATION_MESSAGE, null, Modificaciones, 0);

        switch (Modificar) {
            case 0: {
                String ModificarMarca = JOptionPane.showInputDialog("Ingrese la nueva marca del auto");
                Vehiculos.get(indice).setMarca(ModificarMarca);
            }
            break;
            case 1: {
                String ModificarModelo = JOptionPane.showInputDialog("Ingrese la nueva marca del auto");
                Vehiculos.get(indice).setModelo(ModificarModelo);
            }
            break;
            case 2: {
                String ModificarColor = JOptionPane.showInputDialog("Ingrese la nueva marca del auto");
                Vehiculos.get(indice).setColor(ModificarColor);
            }
            break;
            case 3: {
                int ModificarAnio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo anio del Auto"));
                Vehiculos.get(indice).setAnio(ModificarAnio);
            }
            break;
            case 4: {
                int ModificarPrecio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio del Auto"));
                Vehiculos.get(indice).setPrecio(ModificarPrecio);
            }
            break;

        }
        JOptionPane.showMessageDialog(null, "Modificado Correctamente");

    }

    public static void EliminarPorMatricula() {
        System.out.println("MATRICULAS");
        for (int i = 0; i < Vehiculos.size(); i++) {
            System.out.println(Vehiculos.get(i));
        }

        int indice = 0;
        String MatriculaBuscar = JOptionPane.showInputDialog("Ingrese la Matricula del Auto a Eliminar");
        boolean encontrada = false;
        for (int i = 0; i < Vehiculos.size(); i++) {
            if (Vehiculos.get(i).getMatricula().equalsIgnoreCase(MatriculaBuscar));
            indice = i;
            encontrada = true;
            break;
        }

        if (encontrada = false) {
            JOptionPane.showMessageDialog(null, "No se encontro la matricula");
        } else {
            Vehiculos.remove(indice);
            JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
        }

    }

    public static void AutoMasViejo() {

        int menor = 0;
        int nuevo = 0;

        for (int i = 0; i < Vehiculos.size(); i++) {
            if (i == 0) {
                menor = Vehiculos.get(i).getAnio();
            } else {
                nuevo = Vehiculos.get(i).getAnio();

                if (nuevo < menor) {
                    menor = nuevo;
                }
            }

        }
        int indice = 0;
        for (int i = 0; i < Vehiculos.size(); i++) {
            if (Vehiculos.get(i).getAnio() == menor) {
                indice = i;
            }
        }

        JOptionPane.showMessageDialog(null, "el auto mas viejo es " + Vehiculos.get(indice));

    }

    public static void ColorRojo() {
        String AutosRojos = "";
        boolean HayRojos = false;
        for (int i = 0; i < Vehiculos.size(); i++) {
            if (Vehiculos.get(i).getColor().equalsIgnoreCase("rojo")) {
                AutosRojos += Vehiculos.get(i) + "\n";
                HayRojos = true;
            }
        }

        if (!HayRojos) {
            JOptionPane.showMessageDialog(null, "No hay autos rojos!");
        } else {
            JOptionPane.showMessageDialog(null, AutosRojos);
        }

    }

    public static void DiferenciaEdad() {
        System.out.println("MATRICULAS");
        for (int i = 0; i < Vehiculos.size(); i++) {
            System.out.println(Vehiculos.get(i));
        }
        String Matricula1 = JOptionPane.showInputDialog("Ingrese la Matricula del primer Auto");
        String Matricula2 = JOptionPane.showInputDialog("Ingrese la Matricula del Segundo Auto");
        int Carro1 = 0;
        int Carro2 = 0;
        boolean encontrada = false;
        boolean encontrada2 = false;
        for (int i = 0; i < Vehiculos.size(); i++) {
            if (Vehiculos.get(i).getMatricula().equalsIgnoreCase(Matricula1)) {
                Carro1 = Vehiculos.get(i).getAnio();
                encontrada = true;
            } else if (Vehiculos.get(i).getMatricula().equalsIgnoreCase(Matricula2)) {
                Carro2 = Vehiculos.get(i).getAnio();
                encontrada2 = true;
            }

        }

        if (!encontrada || !encontrada2) {
            JOptionPane.showMessageDialog(null, "Una o las dos matriculas no han sido encontradas");
        }

        int diferencia = Math.abs(Carro1 - Carro2);

        JOptionPane.showMessageDialog(null, "Los autos tienen " + diferencia + " anios de diferencia");

    }

}
