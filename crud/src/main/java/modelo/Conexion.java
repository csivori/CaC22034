/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static Connection con;
    private static BasicDataSource dataSource;

    private Conexion() {
        try {
            Class.forName("con.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Singleton
    public static DataSource getDataSource() {
        if (dataSource == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }

            try {
                String URL = "jdbc:mysql://rootBD:rootBD@localhost:3306/crud";
//                ?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
//                String URL = "jdbc:mysql://root:root@localhost:3306/cac_crud_bd_22034?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                dataSource = new BasicDataSource();
                dataSource.setUrl(URL);
                dataSource.setInitialSize(5);
            } catch (Exception ex) {
                throw new RuntimeException("Error al conectar BD", ex);
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            getDataSource();
        }
        if (dataSource != null) {
            try {
                return dataSource.getConnection();
            } catch (SQLException ex) {
                throw new RuntimeException("Error al obtener conexion del pool", ex);
            }
        }else {
            return null;
        }
        
    }
}
