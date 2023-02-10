import java.util.Random;

public class Tablero {
    private String[] tablero = new String[6];

    public Tablero(Baraja mazo, Random random) {
        rellenarIslas(mazo, random);
    }

    private void rellenarIslas(Baraja mazo, Random random) {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] == null) {
                tablero[i] = mazo.darCarta(random.nextInt(0, mazo.size()));
            }
        }
    }

    public void imprimir(){
        for (int i = 0; i < tablero.length; i++) {
            System.out.println("Isla " + (i+1) + ": " + tablero[i]);
        }
    }
}
