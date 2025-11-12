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

    private void initComponents() {
        // 🎨 Configuración general
        setTitle("📋 Reporte de Clientes - Sistema Valery");
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);


        // 🟦 Panel superior (encabezado)
        JPanel panelHeader = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0,
                        new Color(33, 150, 243),
                        getWidth(), getHeight(),
                        new Color(3, 169, 244));
                g2.setPaint(gradient);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelHeader.setPreferredSize(new Dimension(850, 70));
        panelHeader.setLayout(new BorderLayout());
        JLabel lblTitulo = new JLabel("📊 Reporte de Clientes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        panelHeader.add(lblTitulo, BorderLayout.CENTER);


        JLabel lblSubtitulo = new JLabel("Instituto Valle Grande | Desarrollado por Valery", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(240, 240, 240));
        panelHeader.add(lblSubtitulo, BorderLayout.SOUTH);


        add(panelHeader, BorderLayout.NORTH);


        // 📋 Tabla
        String[] columnas = {"Código", "Nombre", "Correo", "Teléfono"};
        Object[][] datos = {
                {"C001", "Ana Torres", "ana@gmail.com", "987654321"},
                {"C002", "Luis Pérez", "luis@gmail.com", "976543210"},
                {"C003", "Valery López", "valery@gmail.com", "955667788"},
                {"C004", "Carlos Vega", "carlos@gmail.com", "943221177"}
        };


        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tablaClientes = new JTable(modelo);
        tablaClientes.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tablaClientes.setRowHeight(28);
        tablaClientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tablaClientes.getTableHeader().setBackground(new Color(33, 150, 243));
        tablaClientes.getTableHeader().setForeground(Color.WHITE);
        tablaClientes.setSelectionBackground(new Color(187, 222, 251));
        tablaClientes.setGridColor(new Color(220, 220, 220));


        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        add(scrollPane, BorderLayout.CENTER);


        // 🧮 Panel inferior (botones)
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.WHITE);
        panelBotones.setBorder(new EmptyBorder(15, 0, 20, 0));


        btnPDF = crearBoton("Exportar a PDF", new Color(244, 67, 54));
        btnExcel = crearBoton("Exportar a Excel", new Color(76, 175, 80));


        panelBotones.add(btnPDF);
        panelBotones.add(Box.createHorizontalStrut(20));
        panelBotones.add(btnExcel);


        add(panelBotones, BorderLayout.SOUTH);


        // ⚙️ Acciones
        btnPDF.addActionListener(e -> controller.generarPDF(tablaClientes));
        btnExcel.addActionListener(e -> controller.generarExcel(tablaClientes));


    }


    // ✨ Método para crear botones con estilo
    private JButton crearBoton(String texto, Color colorBase) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setForeground(Color.WHITE);
        boton.setBackground(colorBase);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(170, 40));
        boton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));


        // 🎨 efecto hover
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorBase.darker());
            }


            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorBase);
            }
        });
        return boton;
    }


    public JTable getTablaClientes() {
        return tablaClientes;
    }

}
