package dandd;

import java.util.EmptyStackException;
import java.util.Scanner;

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
        int seleccio = (int) preguntarNumero(1, personatges.length);

        clearScreen();
        System.out.println("Heu seleccionat el personatge " + personatges[seleccio - 1].getNom());
        pause();


        

    }

    public static double preguntarNumero(int min, int max) {
        double number = 0;
        try {
            Scanner sc = new Scanner(System.in);
            number = sc.nextDouble();
            if (number < min || number > max) {
                throw new EmptyStackException();
            }
        } catch (Exception e) {
            System.out.println("Input invalid");
            number = preguntarNumero(min, max);
        }
        return number;
    }

    public static void pause() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Prem la tecla Enter per continuar . . . ");
        scan.nextLine();
        scan.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
