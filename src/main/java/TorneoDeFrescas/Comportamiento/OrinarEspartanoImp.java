package TorneoDeFrescas.Comportamiento;

import TorneoDeFrescas.Interfaces.Orinar;

import java.util.Random;

public class OrinarEspartanoImp implements Orinar {
    @Override
    public Integer orinar() {
        return new Random().nextInt(10);
    }
}
