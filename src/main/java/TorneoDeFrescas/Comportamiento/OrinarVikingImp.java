package TorneoDeFrescas.Comportamiento;

import TorneoDeFrescas.Interfaces.Orinar;

import java.util.Random;

public class OrinarVikingImp implements Orinar {

    @Override
    public Integer orinar() {
        return new Random().nextInt(10);
    }
}
