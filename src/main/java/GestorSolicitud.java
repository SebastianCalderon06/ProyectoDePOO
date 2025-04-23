// Estaba haciendo las clases bro :) ya no me llames

import java.util.ArrayList;
import java.util.List;
public class GestorSolicitud {

    private List<SolicitudCompra> solicitudes = new ArrayList<>();
    public void agregarSolicitud(SolicitudCompra solicitud) {
        solicitudes.add(solicitud);
    }
    public void listarSolicitudes() {
        for (SolicitudCompra solicitud : solicitudes) {
            System.out.println(solicitud);
        }
    }
    public SolicitudCompra buscarSolicitudPorId(int id) {
        for (SolicitudCompra solicitud : solicitudes) {
            if (solicitud.getId() == id) {
                return solicitud;
            }
        }
        return null;
    }
}
