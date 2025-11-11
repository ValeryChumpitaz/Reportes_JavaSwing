package vallegrade.edu.pe.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_tienda";
    private static final String USUARIO = "root";
    private static final String CLAVE = "valery2025";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection conectar() {
        Connection cn = null;
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (Exception e) {
            System.err.println("Error en la conexión: " + e.getMessage());
        }
        return cn;
    }
}
