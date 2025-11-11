package vallegrade.edu.pe.view;

import vallegrade.edu.pe.controller.ReporteController;
import vallegrade.edu.pe.service.ReporteService;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ReporteView extends JFrame {

    private JTable tablaClientes;
    private JButton btnPDF, btnExcel;
    private ReporteController controller;

    public ReporteView() {
        initComponents();
        ReporteService service = new ReporteService();
        controller = new ReporteController(service, this);
    }


}
