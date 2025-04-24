public abstract class Documento {
        private int id;


        public Documento (){}
    public Documento(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double calcularCostoTotal();
    }


