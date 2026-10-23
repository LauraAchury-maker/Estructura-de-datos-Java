package preParcial;

public class Carro {
    private String marca;
    private String modelo;
    private String placa;
    private double precio;
    private String tipo;
    private int anio;

    public Carro(String marca, String modelo, String placa, double precio, String tipo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.precio = precio;
        this.tipo = tipo;
        this.anio = anio;
    }
    
    @Override
    public String toString() {
        return "\nInfo del Carro:" +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nPlaca: " + placa +
                "\nPrecio: " + precio +
                "\nTipo: " + tipo +
                "\nAnio: " + anio +
                '\n';
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    
}
