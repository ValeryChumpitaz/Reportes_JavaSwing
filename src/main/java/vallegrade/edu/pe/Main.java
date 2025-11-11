package vallegrade.edu.pe;

import vallegrade.edu.pe.controller.ReporteController;
import vallegrade.edu.pe.service.ReporteService;
import vallegrade.edu.pe.view.ReporteView;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ReporteView view = new ReporteView();
            ReporteService service = new ReporteService();
            new ReporteController(service, view);
            view.setVisible(true);
        });
    }
}
