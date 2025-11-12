package vallegrade.edu.pe.service;

import com.itextpdf.text.Font;
import com.lowagie.text.pdf.PdfCell;
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
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.DARK_GRAY));
            titulo.setAlignment(Element.ALIGN_CENTER);
            Paragraph fecha = new Paragraph("Generado: " + new java.util.Date(),
                    FontFactory.getFont(FontFactory.HELVETICA, 11, BaseColor.GRAY));
            fecha.setAlignment(Element.ALIGN_CENTER);
            cellTitle.addElement(titulo);
            cellTitle.addElement(fecha);
            cellTitle.setBorder(Rectangle.NO_BORDER);
            header.addCell(cellTitle);


            doc.add(header);
            doc.add(new Paragraph("\n"));


            // --- TABLA DE DATOS ---
            TableModel modelo = tabla.getModel();
            PdfPTable pdfTabla = new PdfPTable(modelo.getColumnCount());
            pdfTabla.setWidthPercentage(100);
            pdfTabla.setSpacingBefore(15);
            pdfTabla.setSpacingAfter(15);


            // Encabezados
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                PdfPCell celda = new PdfPCell(new Phrase(modelo.getColumnName(i),
                        FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE)));
                celda.setBackgroundColor(new BaseColor(52, 152, 219));
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setPadding(8);
                pdfTabla.addCell(celda);
            }


            // Filas
            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    String valor = modelo.getValueAt(i, j) != null ? modelo.getValueAt(i, j).toString() : "";
                    PdfPCell celda = new PdfPCell(new Phrase(valor, FontFactory.getFont(FontFactory.HELVETICA, 11)));
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setPadding(6);
                    if (i % 2 == 0)
                        celda.setBackgroundColor(new BaseColor(245, 245, 245));
                    pdfTabla.addCell(celda);
                }
            }


            doc.add(pdfTabla);


            // --- PIE DE PÁGINA ---
            Paragraph footer = new Paragraph(
                    "Instituto Valle Grande © 2025  |  Generado por: Valery",
                    FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10, BaseColor.GRAY)
            );
            footer.setAlignment(Element.ALIGN_RIGHT);
            doc.add(footer);


            doc.close();
            writer.close();


            JOptionPane.showMessageDialog(null, "✅ PDF profesional generado correctamente en la carpeta Reportes.");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error al generar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }




    public void exportarExcel(JTable tabla) {
        String ruta = "Reportes/Reporte_Clientes.xlsx";
        new File("Reportes").mkdirs();


        try (Workbook wb = new XSSFWorkbook(); FileOutputStream out = new FileOutputStream(ruta)) {
            Sheet hoja = wb.createSheet("Clientes");
            TableModel modelo = tabla.getModel();


            Row cab = hoja.createRow(0);
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                Cell c = cab.createCell(i);
                c.setCellValue(modelo.getColumnName(i));
            }


            for (int i = 0; i < modelo.getRowCount(); i++) {
                Row fila = hoja.createRow(i + 1);
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    Object valor = modelo.getValueAt(i, j);
                    fila.createCell(j).setCellValue(valor != null ? valor.toString() : "");
                }
            }


            for (int i = 0; i < modelo.getColumnCount(); i++) hoja.autoSizeColumn(i);
            wb.write(out);
            JOptionPane.showMessageDialog(null, "Excel generado correctamente.");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error Excel: " + e.getMessage());
        }
   }}