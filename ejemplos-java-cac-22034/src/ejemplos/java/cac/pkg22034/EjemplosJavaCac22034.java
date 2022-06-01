/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplos.java.cac.pkg22034;

import java.util.Scanner;

/**
 *
 * @author Fer
 */
public class EjemplosJavaCac22034 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//      System.out.println("Hola Mundo");
//      System.out.println(2+3);
//      System.out.println("2" + 3);
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese su Nombre: ");
        String nombre = s.nextLine();
        System.out.print("Hola " + nombre + " tu Año de Nacimiento: ");
        int anioNac = Integer.parseInt(s.nextLine());
        System.out.println(nombre + " tu edad es : " + (2022 - anioNac));
        int x = 5;
//        byte = 250;
//        short s = 123456;
//        long l = 1234567890123456;
        
        double precio = 14.20;
//        float temperatura = 36.5;
        
        boolean esDeDia = true;
        char elArroba = '@';
    }    
}
