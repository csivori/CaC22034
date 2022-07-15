package modelo;

import java.io.Serializable;

public class Producto implements Serializable {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
    private int id;
    private int grupo;
    private String descripcion;
    private String foto;
    private int stock;

// CONSTRUCTORES
    public Producto(){}

    public Producto(int id, int grupo, String descripcion, String foto, int stock) {
        setId(id);
        setGrupo(grupo);
        setDescripcion(descripcion);
        setFoto(foto);
        setStock(stock);
    }
    public Producto(Producto p) {
        setId(p.id);
        setGrupo(p.grupo);
        setDescripcion(p.descripcion);
        setFoto(p.foto);
        setStock(p.stock);
    }

// GETTERs & SETTERs
    public int getId() {return id;}
    public void setId(int id) {
        if (id < 0) {throw new RuntimeException("Valor para ID inconsistente");}
        this.id = id;
    }
    public int getGrupo() {return grupo;}
    public void setGrupo(int grupo) {
        if (grupo < 0) {
            throw new RuntimeException("No se ha provisto un Grupo");}
        this.grupo = grupo;}
   
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new RuntimeException("No se ha provisto una Descripción");
        }
        this.descripcion = descripcion.trim();
    }
    public String getFoto() {return foto;}
    public void setFoto(String foto) {
        if (foto == null || foto.trim().isEmpty()) {
            foto = "img/productoGenerico.png";
        }
        if (!foto.contains("productoGenerico") || this.foto == null || this.foto.contains("productoGenerico")) {
            this.foto = foto.trim();
        }
    }
    public int getStock() {return stock;}
    public void setStock(int stock) {
        if (stock < 0) {throw new RuntimeException("El Stock no puede ser menor a 0");}        
        this.stock = stock;}

// OVERRIDES
    @Override
    public String toString(){
        return "Producto{" + "id=" + id + ", grupo=" + grupo + ", descripcion=" + descripcion + ", foto=" + foto + ", stock=" + stock + '}';}

// METODOS PUBLICOS
// METODOS PRIVADOS
}
