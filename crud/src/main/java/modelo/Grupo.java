/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

public class Grupo implements Serializable {
    
    private int idGrupo;
    private String descGrupo;
    
    public Grupo(){}

    public Grupo(int idGrupo, String descGrupo) {
        this.idGrupo = idGrupo;
        this.descGrupo = descGrupo;
    }
      public Grupo(Grupo g) {
        this.idGrupo = g.idGrupo;
        this.descGrupo = g.descGrupo;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        if (idGrupo < 0) {throw new RuntimeException("Valor para ID Grupo inconsistente");}
        this.idGrupo = idGrupo;
    }

    public String getDescGrupo() {
        return descGrupo;
    }

    public void setDescGrupo(String descGrupo) {
         if (descGrupo == null || descGrupo.trim().isEmpty()) {
            throw new RuntimeException("No se ha provisto una Descripción");
        }
        this.descGrupo = descGrupo.trim();
    }
    // OVERRIDES
    @Override
    public String toString(){
        return "Grupo{" + "id=" + idGrupo + ", descripcion=" + descGrupo;}

    
}
