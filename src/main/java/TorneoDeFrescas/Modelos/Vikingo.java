package TorneoDeFrescas.Modelos;

import TorneoDeFrescas.Interfaces.Beber;
import TorneoDeFrescas.Interfaces.Orinar;

public class Vikingo extends Humano{
    private Integer bebedorProfesional;

    public Vikingo(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber, Integer nivel) {
        super(nombre, edad, peso, orinar, beber);
        this.bebedorProfesional = nivel;
    }

    public Integer getBebedorProfesional() {
        return bebedorProfesional;
    }

    @Override
    public String toString() {
        return super.toString() +
                "bebedorProfesional=" + bebedorProfesional + '\n';
    }
}
