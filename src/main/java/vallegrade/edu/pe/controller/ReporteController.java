package vallegrade.edu.pe.controller;

import vallegrade.edu.pe.service.ReporteService;
import vallegrade.edu.pe.view.ReporteView;
import javax.swing.JTable;

public class ReporteController {

    this.service = service;
    this.view = view;
}
    public void generarPDF(JTable tabla){
        service.exportarPDF(tabla);
    }

    public void generarExcel(JTable tabla){
        service.exportarExcel(tabla);
    }

