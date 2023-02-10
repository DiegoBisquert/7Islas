import java.lang.reflect.Array;
import java.util.ArrayList;

public class Baraja {
    //Mazo de cartas
    private ArrayList<String> mazo = new ArrayList<>();

    //Constructor
    public Baraja() {
        String[] tres = {"cáliz","rubí","diamante"};
        String[] cuatro = {"collar","mapa","corona"};
        String[] seis = {"revólver","espada","barril"};

        for (int i = 0; i < 15; i++) {
            mazo.add("doblón");
        }

        for (int i = 0; i < tres.length; i++) {
            for (int j = 0; j < 3; j++) {
                mazo.add(tres[i]);
            }
        }

        for (int i = 0; i < cuatro.length; i++) {
            for (int j = 0; j < 4; j++) {
                mazo.add(cuatro[i]);
            }
        }

        for (int i = 0; i < seis.length; i++) {
            for (int j = 0; j < 6; j++) {
                mazo.add(seis[i]);
            }
        }
    }

    //Elimina y da una carta
    public String darCarta(int num){
        return mazo.remove(num);
    }

    //Devuelve la cantidad de cartas en el mazo
    public int size(){
        return mazo.size();
    }
}
