/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Carlos Sivori
 */
public class ProductoConGrupo implements Serializable {
  
//    private Producto producto;
//    private Grupo grupo;
//    
    private int id;
    private int grupoId;
    private String grupoDesc;
    private String descripcion;
    private String foto;
    private int stock;

//    public ProductoConGrupo(Producto producto, Grupo grupo) {
//        this.producto = producto;
//        this.grupo = grupo;
//    }

    public ProductoConGrupo(Producto p, Grupo g) {
        this.id = p.getId();
        this.grupoId = p.getGrupo();
        this.grupoDesc = g.getDescGrupo();
        this.descripcion = p.getDescripcion();
        this.foto = p.getFoto();
        this.stock = p.getStock();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public String getGrupoDesc() {
        return grupoDesc;
    }

    public void setGrupoDesc(String grupoDesc) {
        this.grupoDesc = grupoDesc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

   
    

    public ProductoConGrupo() {
    }
//
    @Override
    public String toString() {
//        return "Prod{id=" + id + '}'; 
        return "ProductoConGrupo{id=" + id + ", grupoId=" + grupoId + ", grupoDescripcion=" + grupoDesc + ", descripcion=" + descripcion + ", foto=" + foto + ", stock=" + stock + '}'; 
//        return "ProductoConGrupo{id=" + id + '}'; 
    }
}