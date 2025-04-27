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
    //este es el metodo que queremos implementa en solicitud de compra
    public abstract double calcularCostoSolicitud();

    @Override
    public String toString() {
        return "InformacionSolicitud{" +
                "id=" + id +
                '}';
    }
}


