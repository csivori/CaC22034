/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.List;

/**
 * @author Carlos Sivori
 */
public interface Modelo {
    /**
     * Devuelve una lista de productos existentes
     * @return 
     */
    public List<Producto> getProductos();

    /**
     * Devuelve una lista de productos existentes incluyendo la descripcion del Grupo
     * @param buscar los Productos seleccionados en buscar 
     * @return 
     */
    public List<ProductoConGrupo> getProductosConGrupo(String buscar);
        
    /**
     * Retorna un Producto por ID
     * @param id el id del Producto a retornar
     * @return El Producto encontrado por ID o null si no existe
     */
    public Producto getProducto(int id);
    
    /**
     * Agrega un Producto al modelo
     * @param Producto El Producto a agregar
     * @return La cantidad de registros modificados
     */
    public int addProducto(Producto producto);
    
    /**
     * Modifica un Producto del modelo
     * @param Producto El Producto que contiene los datos para modificar
     * @return La cantidad de registros modificados
     */
    public int updProducto(Producto producto);
    
    /**
     * Borra un Producto por ID
     * @param id el id del Producto a borrar
     * @return La cantidad de registros modificados
     */
    public int delProducto(int id); 
    
    public List<Grupo> getGrupos();

    public Grupo getGrupo(int id);

    public int addGrupo(Grupo grupo);
    
    public int updGrupo(Grupo grupo);
 
    public int delGrupo(int id); 
}
