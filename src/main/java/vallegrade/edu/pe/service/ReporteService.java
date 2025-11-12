package vallegrade.edu.pe.service;

import com.lowagie.text.pdf.PdfTable;
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

    public void exportarPDF(JTable tabla) {
        String ruta = "Reportes/Reporte_Clientes_Profesional.pdf";
        new File("Reportes").mkdirs();


        try (FileOutputStream archivo = new FileOutputStream(ruta)) {
            Document doc = new Document(PageSize.A4.rotate(), 36, 36, 54, 36);
            PdfWriter writer = PdfWriter.getInstance(doc, archivo);
            doc.open();


            // --- ENCABEZADO ---
            PdfPTable header = new PdfPTable(2);
            header.setWidthPercentage(100);
            header.setWidths(new int[]{1, 3});


            // Logo (opcional)
            try {
                Image logo = Image.getInstance("src/main/resources/logo.png"); // pon tu logo aquí
                logo.scaleToFit(80, 80);
                PdfPCell cellLogo = new PdfPCell(logo, false);
                cellLogo.setBorder(Rectangle.NO_BORDER);
                cellLogo.setHorizontalAlignment(Element.ALIGN_LEFT);
                header.addCell(cellLogo);
            } catch (Exception e) {
                PdfPCell empty = new PdfPCell(new Phrase(""));
                empty.setBorder(Rectangle.NO_BORDER);
                header.addCell(empty);
            }


            // Título
            PdfPCell cellTitle = new PdfPCell();
            Paragraph titulo = new Paragraph("REPORTE DE CLIENTES\n",
        }
    }
}
