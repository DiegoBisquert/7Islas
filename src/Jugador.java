public class Jugador {
    //Info del jugador
    private final String nombre;
    private int doblones;

    //Array int con la cantidad de cada tesoro
    //0:calices 1:rubies 2:diamantes 3:collares 4:mapas 5:coronas 6:revolveres 7:espadas 8:barriles
    private int[] tesoros = new int[9];

    public Jugador(String nombre) {
        this.nombre = nombre;
        doblones = 3;
        //Cantidad de tesoros
        for (int i = 0; i < tesoros.length; i++) {
            tesoros[i] = 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarTesoros(){
        System.out.println("Doblones: " + doblones);
        for (int i = 0; i < tesoros.length; i++) {
            switch (i){
                case 0:
                    System.out.println("Calices: " + tesoros[i]);
                    break;
                case 1:
                    System.out.println("Rubies: " + tesoros[i]);
                    break;
                case 2:
                    System.out.println("Diamantes: " + tesoros[i]);
                    break;
                case 3:
                    System.out.println("Collares: " + tesoros[i]);
                    break;
                case 4:
                    System.out.println("Mapas: " + tesoros[i]);
                    break;
                case 5:
                    System.out.println("Coronas: " + tesoros[i]);
                    break;
                case 6:
                    System.out.println("Revolveres: " + tesoros[i]);
                    break;
                case 7:
                    System.out.println("Espadas: " + tesoros[i]);
                    break;
                case 8:
                    System.out.println("Barriles: " + tesoros[i]);
                    break;
            }
        }
    }
}
