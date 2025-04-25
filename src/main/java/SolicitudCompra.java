public class SolicitudCompra extends InformacionSolicitud {

    private Producto producto;
    private EstadoSolicitud estado;

    public SolicitudCompra(int id, Producto producto, EstadoSolicitud estado) {
        super(id);
        this.producto = producto;
        this.estado = estado;
    }
    @Override
    public double calcularCostoSolicitud() {

        return producto.calcularCostoTotal();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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



