package TorneoDeFrescas.Modelos;

import TorneoDeFrescas.Interfaces.Beber;
import TorneoDeFrescas.Interfaces.Orinar;

public class Espartano extends Humano {
    private Integer toleranciaExtra;
    public Espartano(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber, Integer nivel) {
        super(nombre, edad, peso, orinar, beber);
        this.toleranciaExtra = nivel;
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

    @Override
    public String toString() {
        return super.toString() +
                "toleranciaExtra=" + toleranciaExtra + '\n';
    }
}
