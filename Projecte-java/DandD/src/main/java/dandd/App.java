package dandd;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.Scanner;
import java.lang.reflect.*;

public class App 
{
    public static void main(String[] args){
        
        Personatge[] personatges = {
            new Personatge("Guerrer", 1),
            new Personatge("Mag", 2),
            new Personatge("Elfling", 3)
        };

        System.out.println("Selecciona un personatge");
        for(int i = 0; i < personatges.length; i++)  {
            System.out.println((i+1) + " - " + personatges[i].getNom());
        }
        System.out.println("Premeu 0 per seleccionar aleatoriament");
        int seleccio = (int) preguntarNumero(0, personatges.length);
        if (seleccio == 0) {
            seleccio = getRandomNumberInRange(0,2);
        }

        clearScreen();
        Personatge personatge = new Personatge(personatges[seleccio].getNom(), personatges[seleccio].getArquetip());
        System.out.println("Heu seleccionat el personatge " + personatges[seleccio - 1].getNom());
        pause();

        if (personatge.getArquetip() == 1 || personatge.getArquetip() == 2) {
            System.out.println("Seleccioneu un genere");
            System.out.println("1 - Mascle");
            System.out.println("2 - Femella");
            System.out.println("Premeu 0 per seleccionar aleatoriament");
            seleccio = (int) preguntarNumero(0, 2);
            if (seleccio == 0) {
                seleccio = getRandomNumberInRange(1,2);
            }
            personatge.setGenere(seleccio);
        }
        
        personatge.setVelocitat(preguntarStat("Velocitat"));
        personatge.setVelocitat(preguntarStat("Atac"));
        personatge.setVelocitat(preguntarStat("Defensa"));
        personatge.setVelocitat(preguntarStat("Agaunt"));
        personatge.setVelocitat(preguntarStat("Coneixement"));
        personatge.setVelocitat(preguntarStat("Voluntat"));
        personatge.setVelocitat(preguntarStat("Persepcio"));

        clearScreen();
        System.out.println("Seleccioneu la vida [5 - 20]");
        System.out.println("Premeu 0 per seleccionar aleatoriament");
        seleccio = (int) preguntarNumero(5, 20);
        if (seleccio == 0) {
            seleccio = getRandomNumberInRange(5, 20);
        }
        personatge.setVida(seleccio);

    }

    public static double preguntarNumero(int min, int max) {
        double number = 0;
        boolean error = true;
        while (error) {
            try {
                Scanner sc = new Scanner(System.in);
                number = sc.nextDouble();
                if (number < min || number > max) {
                    throw new EmptyStackException();
                }
                error = false;
            } catch (Exception e) {
                System.out.println("Input invalid");
                error = true;
            }
        }
        return number;
    }

    public static double preguntarStat(String nom) {
            double seleccio;
            clearScreen();
            System.out.println("Seleccioneu "+nom+" [1 - 4]");
            System.out.println("Premeu 0 per seleccionar aleatoriament");
            seleccio = (int) preguntarNumero(0, 4);
            if (seleccio == 0) {
                seleccio = getRandomNumberInRange(1,4);
            }
            return seleccio;
    }

    public static void pause() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Prem la tecla Enter per continuar . . . ");
        scan.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
