public abstract class InformacionSolicitud {

    private int id;

    public InformacionSolicitud() {
    }

    public InformacionSolicitud(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double calcularCostoSolicitud();
}


