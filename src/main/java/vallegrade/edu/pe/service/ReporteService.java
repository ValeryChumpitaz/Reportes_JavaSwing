package vallegrade.edu.pe.service;

import vallegrade.edu.pe.model.Cliente;
import vallegrade.edu.pe.model.ReporteDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

// Librerías PDF
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

// Librerías Excel
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReporteService {

    private final ReporteDAO dao = new ReporteDAO();

    public DefaultTableModel obtenerClientesDeBD() {
        String[] columnas = {"ID", "Nombre", "Correo", "Teléfono"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        List<Cliente> lista = dao.listarClientes();
        for (Cliente c : lista) {
            modelo.addRow(new Object[]{
                    c.getIdCliente(),
                    c.getNombre(),
                    c.getCorreo(),
                    c.getTelefono()
            });
        }
        return modelo;
    }


}
