/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Sivori
 */
public class ModeloMySql implements Modelo {

//    private static final String GET_ALL_QUERY_PROD = "SELECT * FROM producto";
    private static final String GET_ALL_QUERY_PROD = "SELECT p.id, g.idGrupo, g.descGrupo, p.descripcion, p.foto, p.stock FROM producto p, grupo g WHERE p.grupo = g.idGrupo ORDER BY p.descripcion";
    private static final String GET_SOME_QUERY_PROD = "SELECT p.id, g.idGrupo, g.descGrupo, p.descripcion, p.foto, p.stock FROM producto p, grupo g WHERE p.grupo = g.idGrupo AND p.descripcion like ? ORDER BY p.descripcion";
    private static final String GET_BY_ID_QUERY_PROD = "SELECT * FROM producto WHERE id = ?";
    private static final String INS_PROD = "INSERT INTO producto (grupo,descripcion,foto,stock) VALUES (?,?,?,?)";
    private static final String UPD_PROD = "UPDATE producto SET grupo = ?, descripcion = ?,foto = ?,stock = ? WHERE id = ?";
    private static final String DEL_PROD = "DELETE  FROM producto WHERE id = ?";
    private static final String GET_ALL_QUERY_GRUPOS = "SELECT * FROM grupo ORDER BY descGrupo";
    private static final String GET_BY_ID_QUERY_GRUPO = "SELECT * FROM grupo WHERE idGrupo = ?";
    private static final String INS_GRUPO = "INSERT INTO grupo (descGrupo) VALUES (?)";
    private static final String UPD_GRUPO = "UPDATE grupo SET descGrupo = ? WHERE idGrupo = ?";
    private static final String DEL_GRUPO = "DELETE  FROM grupo WHERE idGrupo = ?";

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();

        try (
                 Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_ALL_QUERY_PROD);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                productos.add(rsToProducto(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error SQL al leer los productos", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al leer productos BD", ex);
        }
        return productos;
    }

    @Override
    public List<ProductoConGrupo> getProductosConGrupo(String buscar) {
        List<ProductoConGrupo> productosConGrupo = new ArrayList<>();

        try {
            try (Connection con = Conexion.getConnection()) {
                PreparedStatement ps;
                if (buscar != null && buscar.equals("")) {
                    ps = con.prepareStatement(GET_ALL_QUERY_PROD);
                } else {
                    ps = con.prepareStatement(GET_SOME_QUERY_PROD);
                    ps.setString(1, "%" + buscar + "%");
                }
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        productosConGrupo.add(rsToProductoGrupo(rs));
                    }
                }
                ps.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al leer productos BD", ex);
        }
        return productosConGrupo;
    }

    @Override
    public Producto getProducto(int id
    ) {

        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY_PROD);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rsToProducto(rs);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al obtener producto con ID" + id + " BD", ex);
        }
    }

    @Override
    public int addProducto(Producto producto
    ) {

        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(INS_PROD);) {
            fillPreparedStatement(ps, producto);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al agregar productos BD", ex);
        }
    }

    @Override
    public int updProducto(Producto producto
    ) {
        try (
                 Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(UPD_PROD);) {
            fillPreparedStatement(ps, producto);
            ps.setInt(5, producto.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error al modificar un producto ", ex);
        }
    }

    @Override
    public int delProducto(int id
    ) {

        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(DEL_PROD);) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error al borrar el producto", ex);
        }
    }

    @Override
    public List<Grupo> getGrupos() {
        List<Grupo> grupos = new ArrayList<>();

        try (
                 Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_ALL_QUERY_GRUPOS);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                grupos.add(rsToGrupo(rs));
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error al leer grupos BD", ex);
        }
        return grupos;
    }

    @Override
    public Grupo getGrupo(int id
    ) {
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY_GRUPO);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rsToGrupo(rs);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al obtener el grupo en BD", ex);
        }
    }

    @Override
    public int addGrupo(Grupo grupo
    ) {
        try (
                 Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(INS_GRUPO);) {
            ps.setString(1, grupo.getDescGrupo());
            return ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new RuntimeException("ERROR!!: Ya existe un grupo " + grupo.getDescGrupo(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException("ERROR!!: al Agregar el Grupo: " + grupo.getDescGrupo(), ex);
        }
    }

    @Override
    public int updGrupo(Grupo grupo
    ) {
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(UPD_GRUPO);) {
            ps.setString(1, grupo.getDescGrupo());
            ps.setInt(2, grupo.getIdGrupo());
            return ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new RuntimeException("ERROR!!: Ya existe el grupo " + grupo.getDescGrupo(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException("ERROR!!: al Modificar el Grupo: " + grupo.getDescGrupo(), ex);
        }
    }

    @Override
    public int delGrupo(int id
    ) {
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(DEL_GRUPO);) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new RuntimeException("NO SE PUEDE BORRAR!!: Existen Productos asociados al grupo: " + this.getGrupo(id).getDescGrupo(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException("ERROR!!: al Borrar el Grupo: " + this.getGrupo(id).getDescGrupo(), ex);
        }
    }

    private Producto rsToProducto(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int grupo = rs.getInt("grupo");
        String descripcion = rs.getString("descripcion");
        String foto = rs.getString("foto");
        int stock = rs.getInt("stock");
        return new Producto(id, grupo, descripcion, foto, stock);
    }

    private ProductoConGrupo rsToProductoGrupo(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");
        int idGrupo = rs.getInt("idGrupo");
        String descGrupo = rs.getString("descGrupo");
        String descripcion = rs.getString("descripcion");
        String foto = rs.getString("foto");
        int stock = rs.getInt("stock");

        return new ProductoConGrupo(new Producto(id, idGrupo, descripcion, foto, stock), new Grupo(idGrupo, descGrupo));
    }

    private Grupo rsToGrupo(ResultSet rs) throws SQLException {
        int idGrupo = rs.getInt("idGrupo");
        String descGrupo = rs.getString("descGrupo");

        return new Grupo(idGrupo, descGrupo);
    }

    private void fillPreparedStatement(PreparedStatement ps, Producto producto) throws SQLException {
        ps.setInt(1, producto.getGrupo());
        ps.setString(2, producto.getDescripcion());
        ps.setString(3, producto.getFoto());
        ps.setInt(4, producto.getStock());
    }

}
