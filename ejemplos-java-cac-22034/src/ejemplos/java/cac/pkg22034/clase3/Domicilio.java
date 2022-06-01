/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ejemplos.java.cac.pkg22034.clase3;

/**
 * @author Fer
 */
public class Domicilio {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
    private String calle;
    private int numero;
    private String piso;
    private String departamento;
    private String barrio;

// CONSTRUCTORES
    public Domicilio(String calle, int numero, String piso, String departamento, String barrio){
            this(calle, numero, barrio);
            this.piso = piso;
            this.departamento = departamento;
    }

    public Domicilio(String calle, int numero, String barrio){
            this.calle = calle;
            this.numero = numero;
            this.barrio = barrio;
            this.piso = "";
            this.departamento = "";
    }

// GETTERs & SETTERs

// OVERRIDES
    @Override
    public String toString() {
        String str;
        str = "Calle: " + calle + " " + numero + getValor("Piso", piso, true) + getValor("Dpto", departamento, true) + ", Barrio: " + barrio;
        return ("Domicilio (" + str + ")");
    }

    public String toStringCorto() {
        String str;
        str = "Calle: " + calle + " " + numero + (piso == "" ? "" : " " + piso) + (departamento == "" ? "" : " " + departamento) + ", " + barrio;
        return ("Domicilio (" + str + ")");
    }

//    @Override
//    public boolean equals(Domicilio objeto){
//        Codificar !!
//        return this == objeto;}

// METODOS PUBLICOS

// METODOS PRIVADOS
    private String getValor(String label, String valor, boolean agregaUnEspacioAlInicio){
        return ((valor == "") ? (agregaUnEspacioAlInicio ? " " : "") : label + ": " + valor);
    }
}
