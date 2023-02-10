import java.util.Random;

public class Tablero {
    //Las islas
    private String[] tablero = new String[6];

    //Constructor
    public Tablero(Baraja mazo, Random random) {
        rellenarIslas(mazo, random);
    }

    //Rellena las islas vacías
    public void rellenarIslas(Baraja mazo, Random random) {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] == null) {
                tablero[i] = mazo.darCarta(random.nextInt(0, mazo.size()));
            }
        }
    }

    //imprime en pantalla las islas y su contenido
    public void imprimir(int isla){
        for (int i = 0; i < tablero.length; i++) {
            if (isla == i+1){
                System.out.println(">Isla " + (i+1) + ": " + tablero[i]);
            } else {
                System.out.println("Isla " + (i + 1) + ": " + tablero[i]);
            }
        }
    }

    //elmina y da una carta
    public String darCarta(int i){
        String tesoro = tablero[i];
        tablero[i] = null;
        return tesoro;
    }
}
