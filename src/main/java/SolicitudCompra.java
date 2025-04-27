import java.util.ArrayList;
import java.util.List;

public class SolicitudCompra extends InformacionSolicitud {

    private List<Producto> productos;
    private EstadoSolicitud estado;

    public SolicitudCompra(int id, EstadoSolicitud estado) {
        super(id);
        this.productos = new ArrayList<>();
        this.estado = estado;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public double calcularCostoSolicitud() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularCostoTotal();
        }
        return total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public void aprobar() {
        this.estado = EstadoSolicitud.APROBADA;
    }

    public void rechazar() {
        this.estado = EstadoSolicitud.RECHAZADA;
    }

    public void solicitar() {
        this.estado = EstadoSolicitud.SOLICITADA;
    }

    public void enRevision() {
        this.estado = EstadoSolicitud.EN_REVISION;
    }

    @Override
    public String toString() {
        String resultado = "SolicitudCompra{id=" + getId() + ",\nEstado=" + estado + "\nProductos:\n";

        for (Producto producto : productos) {
            resultado += producto.toString() + "\n";
        }

        resultado += "Costo total: " + calcularCostoSolicitud() + "\n}";
        return resultado;
    }
}

