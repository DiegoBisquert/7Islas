public class Jugador {
    //Info del jugador
    private final String nombre;
    private int isla;
    private int puntuacion;
    private int doblones;

    //Array int con la cantidad de cada tesoro
    //0:calices 1:rubies 2:diamantes 3:collares 4:mapas 5:coronas 6:revolveres 7:espadas 8:barriles
    private int[] tesoros = new int[9];

    public Jugador(String nombre) {
        this.nombre = nombre;
        isla = 1;
        puntuacion = 0;
        doblones = 3;
        //Cantidad de tesoros
        for (int i = 0; i < tesoros.length; i++) {
            tesoros[i] = 0;
        }
    }

    public int getIsla() {
        return isla;
    }

    public void setIsla(int isla) {
        this.isla = isla;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarTesoros(){
        System.out.println("1- Doblones: " + doblones);
        for (int i = 0; i < tesoros.length; i++) {
            tesoros(i);
        }
    }

    public void sumarTesoro(String tesoro){
        switch (tesoro){
            case "cáliz":
                tesoros[0]++;
                break;
            case "rubí":
                tesoros[1]++;
                break;
            case "diamante":
                tesoros[2]++;
                break;
            case "collar":
                tesoros[3]++;
                break;
            case "mapa":
                tesoros[4]++;
                break;
            case "corona":
                tesoros[5]++;
                break;
            case "revólver":
                tesoros[6]++;
                break;
            case "espada":
                tesoros[7]++;
                break;
            case "barril":
                tesoros[8]++;
                break;
        }
    }

    public int totalTesoro(){
        int sum = doblones;

        for (int i = 0; i < tesoros.length; i++) {
            sum += tesoros[i];
        }

        return sum;
    }

    public boolean restarTesoro(int i){
        if (tesoros[i]>=0) {
            tesoros[i]--;
            return true;
        }
        return false;
    }

    private void tesoros(int i) {
        switch (i) {
            case 0:
                System.out.println("2-Calices: " + tesoros[i]);
                break;
            case 1:
                System.out.println("3-Rubies: " + tesoros[i]);
                break;
            case 2:
                System.out.println("4-Diamantes: " + tesoros[i]);
                break;
            case 3:
                System.out.println("5-Collares: " + tesoros[i]);
                break;
            case 4:
                System.out.println("6-Mapas: " + tesoros[i]);
                break;
            case 5:
                System.out.println("7-Coronas: " + tesoros[i]);
                break;
            case 6:
                System.out.println("8-Revolveres: " + tesoros[i]);
                break;
            case 7:
                System.out.println("9-Espadas: " + tesoros[i]);
                break;
            case 8:
                System.out.println("10-Barriles: " + tesoros[i]);
                break;
        }
    }

    public boolean restarDoblon(){
        if (doblones>0) {
            doblones--;
            return true;
        }
        return false;
    }
}
