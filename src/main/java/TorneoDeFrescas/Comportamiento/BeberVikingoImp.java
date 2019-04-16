package TorneoDeFrescas.Comportamiento;

import TorneoDeFrescas.Interfaces.Beber;

import java.util.Random;

public class BeberVikingoImp implements Beber {
    @Override
    public Integer beber() {
        return new Random().nextInt(20);
    }


}
