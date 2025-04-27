// Estaba haciendo las clases bro :) ya no me llames

import java.util.ArrayList;
import java.util.List;
public class GestorSolicitud {

    private List<SolicitudCompra> solicitudes = new ArrayList<>();

    public List<SolicitudCompra> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<SolicitudCompra> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public void agregarSolicitud(SolicitudCompra solicitud) {

        solicitudes.add(solicitud);
    }

    public void listarSolicitudes() {
        for (SolicitudCompra solicitud : solicitudes) {
            System.out.println(solicitud);
        }
    }
    // cambiamos para que el metodo muestre un mensaje en caso de no encontrar lo que buscamos

    public String buscarSolicitudPorId(int id) {
        for (SolicitudCompra solicitud : solicitudes) {
            if (solicitud.getId() == id) {
                return "Su solicitud " + solicitud;
            }
        }
        return "No existe la solicitud buscada";
    }
}
