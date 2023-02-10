import java.lang.reflect.Array;
import java.util.ArrayList;

public class Baraja {
    private ArrayList<String> mazo = new ArrayList<>();

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

    public void imprimir(){
        for (String carta:mazo) {
            System.out.println(carta);
        }
    }

    public String darCarta(int num){
        return mazo.remove(num);
    }

    public int size(){
        return mazo.size();
    }
}
