package vallegrade.edu.pe.controller;

import vallegrade.edu.pe.service.ReporteService;
import vallegrade.edu.pe.view.ReporteView;

import javax.swing.*;

public class ReporteController {
    private final ReporteService service;
    private final ReporteView view;


    public ReporteController(ReporteService service, ReporteView view) {
        this.service = service;
        this.view = view;
    }


    // ✅ Métodos correctos
    public void generarPDF(JTable tabla) {
        service.exportarPDF(tabla);
    }


    public void generarExcel(JTable tabla) {
        service.exportarExcel(tabla);
    }

}
