import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static Baraja mazo = new Baraja();
    static Tablero tablero;
    static ArrayList<Jugador> jugadores = new ArrayList<>();
    static boolean nop;
    public static void main(String[] args) {
        //variables
        int numJugadores = 0;
        int opcionMenu;
        int jugadorInicial;
        int islaViajar;

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

        //creamos el tablero
        tablero = new Tablero(mazo,random);

        //Jugador inicial y su primer turno
        jugadorInicial = random.nextInt(0,jugadores.size());

        do {
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println("Cartas mazo: " + mazo.size());
                System.out.println("Turno de " + jugadores.get(i).getNombre());
                tirarDados(jugadores.get(i));
                do {
                    nop = false;
                    opcionMenu = menu(jugadores.get(i));
                    switch (opcionMenu){
                        case 1:
                            jugadores.get(i).sumarTesoro(tablero.darCarta((jugadores.get(i).getIsla()-1)));
                            break;
                        case 2:
                            islaViajar = preguntarViaje(jugadores.get(i));
                            if (islaViajar == 8){
                                nop = true;
                            } else {
                                viajarIsla(islaViajar, jugadores.get(i));
                            }
                            break;
                        case 3:
                            jugadores.get(i).mostrarTesoros();
                    }
                }while (opcionMenu==3 || nop);
                tablero.rellenarIslas(mazo,random);
            }
        }while (mazo.size()>0);
    }

    private static void viajarIsla(int islaViajar, Jugador jugador) {
        int isla = jugador.getIsla();
        int diferencia = islaViajar - isla;
        int opcion = 0;
        String carta;

        if (islaViajar == 7) {
            opcion = getOpcion(diferencia, opcion);
            if (opcion == 1) {
                pagarCartas(jugador,diferencia);
                carta = mazo.darCarta(random.nextInt(0, mazo.size()));
                System.out.println("Te ha tocado " + carta);
                jugador.sumarTesoro(carta);
            } else {
                nop = true;
            }
        } else {
            if (islaViajar > isla) {
                diferencia = islaViajar - isla;
                viaje(isla, jugador, islaViajar, opcion, diferencia);
            } else {
                diferencia = isla - islaViajar;
                viaje(islaViajar, jugador, isla, opcion, diferencia);
            }
        }
    }

    private static int getOpcion(int diferencia, int opcion) {
        do {
            try {
                System.out.println("Debes gastar " + diferencia + " cartas, ¿Quieres hacerlo? 1-si 2-no");
                opcion = sc.nextInt();
            }catch (Exception e){
                sc.nextLine();
            }

            if (opcion<1 || opcion>2) {
                opcion = -1;
                System.out.println("opción inválida, inténtalo de nuevo");
            }
        }while (opcion<0);
        return opcion;
    }

    private static void viaje(int islaViajar, Jugador jugador, int isla, int opcion, int diferencia) {
        opcion = getOpcion(diferencia, opcion);
        if (opcion == 1) {
                pagarCartas(jugador,diferencia);
                jugador.sumarTesoro(tablero.darCarta((islaViajar)));
         } else {
            nop = true;
        }
    }

    private static void pagarCartas(Jugador jugador, int diferencia) {
        int opcion = 0;
        boolean x = false;

        for (int i = 0; i < diferencia; i++) {
            do {
                x = false;
                do {
                    try {
                        System.out.println("Carta número " + (i+1) + " que quieres gastar:");
                        jugador.mostrarTesoros();
                        opcion = sc.nextInt();
                    }catch (Exception e){
                        sc.nextLine();
                    }

                    if (opcion<1 || opcion>10) {
                        opcion = -1;
                        System.out.println("opción inválida, inténtalo de nuevo");
                    }
                }while (opcion<0);
                if (opcion == 1){
                    if (!jugador.restarDoblon()){
                        System.out.println("No tienes suficientes");
                        x = true;
                    }
                } else {
                    if (!jugador.restarTesoro(opcion-2)){
                        System.out.println("No tienes suficientes");
                        x = true;
                    }
                }
            }while (x);
        }

    }

    private static int preguntarViaje(Jugador j) {
        int isla = 0;
        int diferencia = 0;

        do {
            try {
                System.out.println("¿A que isla quieres viajar?");
                tablero.imprimir(j.getIsla());
                System.out.println("Isla 7: mazo");
                System.out.println("8-Volver");
                isla = sc.nextInt();
            }catch (Exception e){
                sc.nextLine();
            }

            if (isla<1 || isla>8) {
                isla = 0;
                System.out.println("Opción inválida, inténtalo  de nuevo");
            }

            if (j.getIsla() == isla){
                System.out.println("ya estás en esta isla, escoge otra");
                isla = 0;
            }

            if (isla < 8) {
                if (j.getIsla() > isla) {
                    diferencia = j.getIsla() - isla;
                } else {
                    diferencia = isla - j.getIsla();
                }
                if (diferencia > j.totalTesoro()) {
                    System.out.println("No tienes suficientes cartas, escoge otra isla");
                    isla = 0;
                }
            }
        }while (isla<1);

        return isla;
    }

    private static int menu(Jugador j) {
        int opcion = 0;

        System.out.println("Islas:");
        tablero.imprimir(j.getIsla());
        System.out.println();

        do {
            try {
                System.out.println("¿Que deseas hacer?");
                System.out.println("1-Coger tesoro isla actual 2-Coger tesoro de otra isla 3-Resumen");
                opcion = sc.nextInt();
            }catch (Exception e){
                sc.nextLine();
            }

            if (opcion<1 || opcion>3) {
                opcion = 0;
                System.out.println("Opción inválida, inténtalo  de nuevo");
            }
        }while (opcion<1);

        return opcion;
    }

    private static void tirarDados(Jugador j) {
        int dado = random.nextInt(1,7);
        System.out.println("El dado ha sacado " + dado);
        j.setIsla(dado);
    }

    private static Jugador crearJugador(int i) {
        String nombre;
        boolean repe;
        boolean parecido;
        int opcion = 0;

        do {
            repe = false;
            parecido = false;
            System.out.println("Nombre del jugador " + (i+1) + ":");
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
                        System.out.println("opción inválida, inténtalo de nuevo");
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