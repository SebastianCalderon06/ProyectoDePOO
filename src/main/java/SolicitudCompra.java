public class SolicitudCompra extends Documento {
    private Producto producto;
    private EstadoSolicitud estado;

    public SolicitudCompra(int id, Producto producto, EstadoSolicitud estado) {
        super(id);
        this.producto = producto;
        this.estado = estado;
    }

    @Override
    public double calcularCostoTotal() {
        return producto.calcularCostoTotal();
    }

    public void aprobar() {
        this.estado = EstadoSolicitud.APROBADA;
    }

    public void rechazar() {
        this.estado = EstadoSolicitud.RECHAZADA;
    }


    public void solicitar(){
        this.estado = EstadoSolicitud.SOLICITADA;
    }

    public void enRevision(){
        this.estado = EstadoSolicitud.EN_REVISION;
    }


    @Override
    public String toString() {
        return "SolicitudCompra{id=" + getId() + ", producto=" + producto + ", estado=" + estado+"}";}
}
