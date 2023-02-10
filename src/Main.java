import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static Baraja mazo = new Baraja();
    static Tablero tablero;
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    public static void main(String[] args) {
        //variables
        int numJugadores = 0;

        //Inicio al juego
        System.out.println("¡Bienvenido pirata!");
        System.out.println("Es hora de jugar a las 7 islas");
        System.out.println();

        //Cantidad de jugadores y su creación
        numJugadores = cantidadJugadores();
        sc.nextLine();
        for (int i = 0; i < numJugadores; i++) {
            jugadores.add(crearJugador(i));
        }
    }

    private static Jugador crearJugador(int i) {
        String nombre;
        boolean repe, parecido;
        int opcion = 0;
        do {
            repe = false;
            parecido = false;
            System.out.println("Nombre del jugador " + i + ":");
            nombre = sc.nextLine();
            for (int j = 0; j < jugadores.size(); j++) {
                if (jugadores.get(j).getNombre().equals(nombre)){
                    repe = true;
                } else if (jugadores.get(j).getNombre().equalsIgnoreCase(nombre)){
                    parecido = true;
                }
            }
            if (repe) {
                System.out.println("Este nombre ya ha sido escogido, escoge otro diferente.");
            }

            if (!repe && parecido){
                do {
                    try {
                        System.out.println("Hay un nombre parecido a este que puede causar confusión, ¿Quieres escoger otro? 1-Sí 2-No");
                        opcion = sc.nextInt();
                    }catch (Exception e){
                        sc.nextLine();
                    }
                    if (opcion<1 || opcion>2) {
                        opcion = -1;
                        System.out.println("opción inválida, intentalo de nuevo");
                    }
                    sc.nextLine();
                }while (opcion<0);
                if (opcion == 1){
                    repe = true;
                }
            }
        }while (repe);
        return new Jugador(nombre);
    }

    private static int cantidadJugadores() {
        int jugadores = 0;
        do {
            try {
                System.out.println("Primero que nada... ¿Cuántos piratas sois?(2-4 jugadores)");
                jugadores = sc.nextInt();
            }catch (Exception e){
                System.out.println("Error al escoger el número de jugadores, vuelve a intentarlo");
                sc.nextLine();
                jugadores = -1;
            }
            if (jugadores!=-1 && jugadores<2 || jugadores>4) {
                jugadores = -1;
                System.out.println("Solo entre 2 y 4 jugadores");
            }
        }while (jugadores<0);
        return jugadores;
    }
}