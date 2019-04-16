package TorneoDeFrescas;

import TorneoDeFrescas.BD.Consultas;
import TorneoDeFrescas.Comportamiento.BeberEspartanoImp;
import TorneoDeFrescas.Comportamiento.BeberVikingoImp;
import TorneoDeFrescas.Comportamiento.OrinarEspartanoImp;
import TorneoDeFrescas.Comportamiento.OrinarVikingImp;
import TorneoDeFrescas.Modelos.Espartano;
import TorneoDeFrescas.Modelos.Humano;
import TorneoDeFrescas.Modelos.Vikingo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Boolean finDelJuego = false;

        //cantidad de litros bebidas por equipo
        int litrosVikingos = 0;
        int litrosEspartanos = 0;

        //creamos lista de vikingos
        List<Vikingo> listaVikingos = Arrays.asList(
                new Vikingo("Vikingo1", 33, 80, new OrinarVikingImp(), new BeberVikingoImp(), new Random().nextInt(10)),
                new Vikingo("Vikingo2", 32, 81, new OrinarVikingImp(), new BeberVikingoImp(), new Random().nextInt(10)),
                new Vikingo("Vikingo3", 31, 83, new OrinarVikingImp(), new BeberVikingoImp(), new Random().nextInt(10)),
                new Vikingo("Vikingo4", 36, 84, new OrinarVikingImp(), new BeberVikingoImp(), new Random().nextInt(10)),
                new Vikingo("Vikingo5", 34, 85, new OrinarVikingImp(), new BeberVikingoImp(), new Random().nextInt(10))
        );

        //creamos lista de espartanos
        List<Espartano> listaEspartanos = Arrays.asList(
                new Espartano("Espartano1", 35, 82, new OrinarEspartanoImp(), new BeberEspartanoImp(), new Random().nextInt(10)),
                new Espartano("Espartano2", 33, 83, new OrinarEspartanoImp(), new BeberEspartanoImp(), new Random().nextInt(10)),
                new Espartano("Espartano3", 32, 82, new OrinarEspartanoImp(), new BeberEspartanoImp(), new Random().nextInt(10)),
                new Espartano("Espartano4", 34, 85, new OrinarEspartanoImp(), new BeberEspartanoImp(), new Random().nextInt(10)),
                new Espartano("Espartano5", 36, 86, new OrinarEspartanoImp(), new BeberEspartanoImp(), new Random().nextInt(10))
        );

        //en la clase batalla vamos a llamar metodos para

        //box
        System.out.println("###########################################################");
        System.out.println("#                       Vikingos                          #");
        System.out.println("###########################################################");

        //ordenamos por edad y presentamos los vikingos
        System.out.println(
                listaVikingos.stream()
                        .sorted(Comparator.comparing(Humano::getEdad))
                        .collect(Collectors.toList()));


        //box
        System.out.println("###########################################################");
        System.out.println("#                       Espartanos                        #");
        System.out.println("###########################################################");

        //ordenamos por edad y presentamos los espartanos
        System.out.println(
                listaEspartanos.stream()
                        .sorted(Comparator.comparing(Humano::getEdad))
                        .collect(Collectors.toList()));

        System.out.println("\n\nComienza la batalla ...\n\n");

        //elegimos de forma aleatoria uno de cada lista mientras las dos listas tengan participantes
        while (!finDelJuego){
            //vikingo al azar
            int vikPosicion = new Random().nextInt(listaVikingos.size());
            Vikingo vk = listaVikingos.get(vikPosicion);

            //espartano al azar
            int espPosicion = new Random().nextInt(listaEspartanos.size());
            Espartano esp = listaEspartanos.get(espPosicion);

            System.out.println(vk.getNombre() + " VS " + esp.getNombre());

            //obtenemos los random para determinar el ganador
            //utilizamos bebedor profesional y tolerancia extra como retencion de liquido
            //si se bebe mas de lo que se puede orinar pierde
            Integer vkBebe = vk.getBeber();
            Integer vkOrina = vk.getOrinar() + vk.getBebedorProfesional();
            Integer espBebe = esp.getBeber();
            Integer espOrina = esp.getOrinar() + esp.getToleranciaExtra();

            //acumulamos los litros bebidos
            litrosVikingos = litrosVikingos + vkBebe;
            litrosEspartanos = litrosEspartanos + espBebe;

            System.out.println("El vikingo comienza a beber ... Bebe " + vkBebe + " litros de cerveza.");

            if (vkBebe > vkOrina){
                System.out.println("El vikingo solo puede beber " + vkOrina + " litros. Bebe mas de su capacidad. Corre al baño !! Es descalificado.");
                System.out.println("--------------------");
                //lo eliminamos de la lista
                listaVikingos = listaVikingos.stream()
                        .filter(vikingo -> !vikingo.getNombre().startsWith(vk.getNombre()))
                        .collect(Collectors.toList());

            } else {
                System.out.println("El vikingo bebe de forma inteligente. Sigue en juego.");
                System.out.println("--------------------");
            }

            System.out.println("El espartano comienza a beber ... Bebe " + espBebe + " litros de cerveza.");

            if (espBebe > espOrina){
                System.out.println("El espartano solo puede beber " + espOrina + " litros. Bebe mas de su capacidad. Corre al baño !! Es descalificado.\n");
                //lo eliminamos de la lista
                listaEspartanos = listaEspartanos.stream()
                        .filter(espartano -> !espartano.getNombre().startsWith(esp.getNombre()))
                        .collect(Collectors.toList());
            } else {
                System.out.println("El espartano bebe de forma inteligente. Sigue en juego.\n\n");
            }

            //verificamos si hay equipo ganador y persistimos los datos
            if (!listaEspartanos.isEmpty() && listaVikingos.isEmpty()){
                System.out.println("--> Los Espartanos resultan vencedores <--");
                finDelJuego = true;
                Consultas consulta = new Consultas();
                consulta.guardarBatalla("Espartanos",litrosEspartanos);
            }

            if (listaEspartanos.isEmpty() && !listaVikingos.isEmpty()){
                System.out.println("--> Los Vikingos resultan vencedores <--");
                finDelJuego = true;
                Consultas consulta = new Consultas();
                consulta.guardarBatalla("Vikingos",litrosVikingos);
            }

        }
    }
}
