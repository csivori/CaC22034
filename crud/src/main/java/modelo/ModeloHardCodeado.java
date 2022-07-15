package modelo;

import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.List;

public class ModeloHardCodeado implements Modelo {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
    private List<Producto> productos;
    private List<Grupo> grupos;

// CONSTRUCTORES
    public ModeloHardCodeado() {
        this.grupos = new ArrayList<>();
        this.productos = new ArrayList<>();
        crearGrupoYProductosFake();
    }

// GETTERs & SETTERs
// OVERRIDES
    @Override
    public List<Producto> getProductos() {

        return new ArrayList(this.productos); // Copia de la lista original
    }
    
    @Override
    public List<ProductoConGrupo> getProductosConGrupo(String buscar) {
        List<ProductoConGrupo> prodYgrupo = new ArrayList<>();
       for (int i = 0; i < this.productos.size(); i++) {
           Producto producto = new Producto(this.productos.get(i));
           Grupo grupo = new Grupo(getGrupo(producto.getGrupo()));
           prodYgrupo.add(new ProductoConGrupo(producto,grupo));
        }
//        return prodYgrupo; // Copia de la lista original
        return new ArrayList(prodYgrupo); // Copia de la lista original
    }
        
    @Override
    public Producto getProducto(int id) {
        int i = 0;
        Producto encontrado = null;
        while (i < this.productos.size() && encontrado == null) {
            Producto p = this.productos.get(i);
            if (p.getId() == id) {
                encontrado = p;
            } else {
                i++;
            }
        }
        if (encontrado == null) {
            throw new RuntimeException("No se encontró un Producto con ID " + id);
        }
        return encontrado;
    }

    @Override
    public int addProducto(Producto p) {
        p.setId(getNewIDProducto());
        this.productos.add(p);
        return 0;
    }

    @Override
    public int updProducto(Producto p) {
        Producto target = getProducto(p.getId());
        int idx = this.productos.indexOf(target);
        this.productos.set(idx, p);
        return 0;
    }

    @Override
    public int delProducto(int id) {
        Producto target = getProducto(id);
        this.productos.remove(target);
        return 0;
    }

    @Override
    public List<Grupo> getGrupos() {
        return new ArrayList(this.grupos); // Copia de la lista original
    }

    @Override
    public Grupo getGrupo(int id) {
        int i = 0;
        Grupo encontrado = null;
        while (i < this.grupos.size() && encontrado == null) {
            Grupo g = this.grupos.get(i);
            if (g.getIdGrupo() == id) {
                encontrado = g;
            } else {
                i++;
            }
        }
        if (encontrado == null) {
            throw new RuntimeException("No se encontró un Grupo con ID " + id);
        }
        return encontrado;
    }

    @Override
    public int addGrupo(Grupo g) {
        if (!existeDescGrupo(g.getDescGrupo())) {
            g.setIdGrupo(getNewIDGrupo());
            this.grupos.add(g);
            return 1;
        }
        return 0;
    }

    @Override
    public int updGrupo(Grupo g) {
        Grupo target = getGrupo(g.getIdGrupo());
        int idx = this.grupos.indexOf(target);
        this.grupos.set(idx, g);
        return 0;
    }

    @Override
    public int delGrupo(int id
    ) {
        Grupo target = getGrupo(id);
        this.grupos.remove(target);
        return 0;
    }
    // METODOS PUBLICOS
    // METODOS PRIVADOS

    private void crearGrupoYProductosFake() {
        this.grupos.add(new Grupo(1, "Cafe"));
        this.grupos.add(new Grupo(2, "Harinas"));
        this.grupos.add(new Grupo(3, "Aceites"));
        this.grupos.add(new Grupo(4, "Lacteos"));
        this.grupos.add(new Grupo(5, "Galletitas"));
        this.productos.add(new Producto(1, 1, "Cafe", "", 2));
        this.productos.add(new Producto(2, 2, "Harina Comun", "", 6));
        this.productos.add(new Producto(3, 2, "Harina Integral", "", 7));
        this.productos.add(new Producto(4, 2, "Harina Pizza", "", 8));
        this.productos.add(new Producto(5, 3, "Aceite de Maiz", "", 2));
        this.productos.add(new Producto(6, 3, "Aceite de Oliva", "", 4));
        this.productos.add(new Producto(7, 3, "Aceite de Girasol", "", 6));
        this.productos.add(new Producto(8, 3, "Aceite en Aerosol", "", 1));
    }

    private int getNewIDProducto() {
        int new_id = 0;
        for (int i = 0; i < this.productos.size(); i++) {
            new_id = max(new_id, this.productos.get(i).getId());
        }
        return new_id + 1;
    }

    private int getNewIDGrupo() {
        int new_id = 0;
        for (int i = 0; i < this.grupos.size(); i++) {
            new_id = max(new_id, this.grupos.get(i).getIdGrupo());
        }
        return new_id + 1;
    }

    private boolean existeDescGrupo(String desc) {

        for (int i = 0; i < this.grupos.size(); i++) {
            if (this.grupos.get(i).getDescGrupo().equals(desc)) {
                return true;
            }
        }
        return false;
    }
    
}

    

