package pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);
		int menu = 0;
		while (menu != 2) {
			
			System.out.println();
			System.out.println("*************************");
			System.out.println(" 🂡 EL JUEGO DE LA BARAJA 🂡 ");
			System.out.println("*************************");
			System.out.println("1. Jugar");
			System.out.println("2. Salir");
			System.out.println();
			System.out.print("Seleccione una opción: ");

			try {
				menu = entrada.nextInt();
				switch (menu) {
				case 1:

					// Creamos la baraja entera de cartas, baraja española de 40 cartas llamando al
					// método crear baraja que guarda toda la baraja en un arraylist de cartas
					// llamado baraja
					ArrayList<Carta> baraja = crearBaraja();

					// Creamos un ArrayList para poner las cartas que vamos a usar en la partida y
					// que se van a coger de forma aleatoria del array de cartas llamado baraja
					// llamando al metodo crearMano
					ArrayList<Carta> manoPartida = crearMano(baraja);

					System.out.println("Esta es tu mano: ");
					System.out.println(manoPartida);
					System.out.println();

					// Imprimimos la puntuacion total segun las cartas en la mano, llamando al
					// metodo calcular puntuacion y enviando como parametro la mano
					
					System.out.println("Esta es tu puntuación: ");
					System.out.println(calcularPuntuacion(manoPartida));
					System.out.println();

					System.out.println();
					System.out.println("*************************");
					System.out.println("GRACIAS POR JUGAR");
					System.out.println("*************************");
					System.out.println();

					break;
				case 2:
					System.out.println("Hasta luego...");
					break;
				default:
					System.out.println("Debes seleccionar un número.");
				}
			} catch (Exception e) {
				System.out.println("Error, Debes ingresar un número entero.");
				entrada.nextLine(); // soluciona errores en el escaner
			}
		}

	} // FIN MAIN

	// -------------METODOS---------------

	
	
	
	public static ArrayList<Carta> crearBaraja() {
		ArrayList<Carta> baraja = new ArrayList<>();
		// aqui creamos dos array, uno con los valores de la figura y otro con los palos
		String[] figuras = { "as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey" };
		Carta.Palo[] palos = { Carta.Palo.oros, Carta.Palo.copas, Carta.Palo.espadas, Carta.Palo.bastos };

		// aqui hacemos un bucle forEach anidado para generar las cartas, por cada
		// figura recorremos los 4 palos generando una carta cada vez que se añade a la
		// baraja.
		for (String figura1 : figuras) {
			for (Carta.Palo palo1 : palos) {
				baraja.add(new Carta(figura1, palo1));
			}
		}

		return baraja;
	}

	public static ArrayList<Carta> crearMano(ArrayList<Carta> baraja) {
		// Este metodo recibe el arraylist con todas las cartas y elige 10 al azar

		Random random = new Random();
		ArrayList<Carta> mano = new ArrayList<>();

		// en este bucle, creamos un objeto carta con un numero aleatorio entre 0 y la
		// longitud del array baraja y usamos el get con esa posicion para coger la
		// carta y meterla en el array mano.
		// Si la carta elegida no está en la mano, la introduce, y si está en la mano,
		// añade una vuelta al bucle para que lo intente de nuevo.
		for (int i = 0; i < 10; i++) {
			Carta cartaElegida = baraja.get(random.nextInt(baraja.size()));
			if (!mano.contains(cartaElegida)) {
				mano.add(cartaElegida);
			} else {
				i--;
			}
		}

		return mano;

	}

	public static int calcularPuntuacion(ArrayList<Carta> manoPartida) {
		int puntuacion = 0;

		// Creamos un HashMap con los valores que tiene cada figura segun el enunciado
		HashMap<String, Integer> valorCartas = new HashMap<>();

		valorCartas.put("as", 11);
		valorCartas.put("tres", 10);
		valorCartas.put("sota", 2);
		valorCartas.put("caballo", 3);
		valorCartas.put("rey", 4);

		// En el bucle sacamos el valor de la figura de la carta en cada vuelta, si está
		// en el HasMap de valores se suma la puntuaciopn a la variable puntuacion
		for (Carta cartaBucle : manoPartida) {
			String figura = cartaBucle.getFigura();
			if (valorCartas.containsKey(figura)) {
				puntuacion += valorCartas.get(figura);
			}
		}

		return puntuacion;
	}

}
