package TorneoDeFrescas.Modelos;

import TorneoDeFrescas.Interfaces.Beber;
import TorneoDeFrescas.Interfaces.Orinar;

public class Humano {
    private String nombre;
    private Integer edad;
    private Integer peso;
    private Orinar orinar;
    private Beber beber;

    public Humano(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.orinar = orinar;
        this.beber = beber;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getOrinar() {
        return orinar.orinar();
    }

    public Integer getBeber() {
        return beber.beber();
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso + ' ';
    }
}
