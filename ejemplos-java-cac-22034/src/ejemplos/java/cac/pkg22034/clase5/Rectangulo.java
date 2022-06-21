/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ejemplos.java.cac.pkg22034.clase5;

/**
 *
 * @author Fer
 */
public class Rectangulo {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
    private int base;
    private int altura;
    
// CONSTRUCTORES
    public Rectangulo(int base, int altura){
            this.base = base;
            this.altura = altura;
    }

// GETTERs & SETTERs
// OVERRIDES
    @Override
    public String toString() {
        return "Rectangulo (base: " + base + "  altura: " + altura + ")";
    }

//    @Override
    public boolean equals(Rectangulo objeto){
        return this.base == objeto.base && this.base == objeto.base;
    }

// METODOS PUBLICOS

// METODOS PRIVADOS

}
