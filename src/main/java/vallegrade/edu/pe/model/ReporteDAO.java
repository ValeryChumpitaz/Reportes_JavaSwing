package vallegrade.edu.pe.model;

import vallegrade.edu.pe.database.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {

    private final ConexionBD conexion = new ConexionBD();

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT id_cliente, nombre, correo, telefono FROM clientes";


        try (Connection cn = conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("telefono")
                );
                lista.add(c);
            }


        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return lista;
    }

}