package dandd;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.reflect.*;

public class App 
{
    public static Personatge personatge;
    public static Enemic enemic;
    public static Objecte[] objectesAplicats = new Objecte[30];
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
        int seleccio = (int) preguntarNumero(1, personatges.length, true);
        if (seleccio == 0) {
            seleccio = getRandomNumberInRange(1, personatges.length);
        }
        seleccio--;

        clearScreen(); // Esborra la pantalla
        personatge = new Personatge(personatges[seleccio].getNom(), personatges[seleccio].getArquetip());
        System.out.println("Heu seleccionat el personatge " + personatges[seleccio].getNom());
        pause();

        if (personatge.getArquetip() == 1 || personatge.getArquetip() == 2) {
            System.out.println("Seleccioneu un genere");
            System.out.println("1 - Mascle");
            System.out.println("2 - Femella");
            System.out.println("Premeu 0 per seleccionar aleatoriament");
            seleccio = (int) preguntarNumero(1, 2, true);
            if (seleccio == 0) {
                seleccio = getRandomNumberInRange(1,2);
            }
            personatge.setGenere(seleccio);
        }
        
        personatge.setVelocitat(preguntarStat("la Velocitat"));
        personatge.setAtac(preguntarStat("l'Atac"));
        personatge.setDefensa(preguntarStat("la Defensa"));
        personatge.setAguant(preguntarStat("l'Aguant"));
        personatge.setConeixement(preguntarStat("el Coneixement"));
        personatge.setVoluntat(preguntarStat("la Voluntat"));
        personatge.setPercepcio(preguntarStat("la Percepcio"));

        clearScreen(); // Esborra la pantalla
        System.out.println("Seleccioneu la vida [5 - 20]");
        System.out.println("Premeu 0 per seleccionar aleatoriament");
        seleccio = (int) preguntarNumero(5, 20, true);
        if (seleccio == 0) {
            seleccio = getRandomNumberInRange(5, 20);
        }
        personatge.setVida(seleccio);

        mostarMenuPreBatalla();
        
    }

    private static void mostarMenuPreBatalla() {
        boolean menu = true;
        while (menu) {
            clearScreen(); // Esborra la pantalla
            System.out.println("Que voleu fer?");
            System.out.println("1 - Veure stats del jugador");
            System.out.println("2 - Lluitar amb el seguent enemic");
            int seleccio = (int) preguntarNumero(1, 2, false);
            switch (seleccio) {
                case 1:
                    mostrarStats();
                    break;
                case 2:
                    enemic = seleccionarEnemic();
                    batalla();
                    break;
            }
        }
    }

    private static void batalla() {
        boolean menu = true;
        while (menu) {
            clearScreen(); // Esborra la pantalla
            System.out.println("Que voleu fer?");
            System.out.println("1 - Veure stats del jugador");
            System.out.println("2 - veure stats del enemic");
            System.out.println("3 - Atacar");
            System.out.println("4 - Utilitzar objecte");
            System.out.println("5 - Escapar");
            int seleccio = (int) preguntarNumero(1, 5, false);
            switch (seleccio) {
                case 1:
                    mostrarStats();
                    break;
                case 2:
                    mostrarStatsEnemic();
                    break;
                case 3:
                    if (personatge.getVelocitat() == enemic.getVelocitat()) {
                        int prioritat = getRandomNumberInRange(0,1);
                        if (prioritat == 0) {
                            personatge.atacar(enemic);
                            enemic.atacar(personatge);
                        } else {
                            enemic.atacar(personatge);
                            personatge.atacar(enemic);
                        }
                    } else if (personatge.getVelocitat() > enemic.getVelocitat()) {
                        personatge.atacar(enemic);
                        enemic.atacar(personatge);
                    } else if (personatge.getVelocitat() < enemic.getVelocitat()) {
                        enemic.atacar(personatge);
                        personatge.atacar(enemic);
                    }
                    clearScreen(); // Esborra la pantalla
                    System.out.println("Vida actual del personatge: " + personatge.getVida());
                    System.out.println("Vida actual del enemic: " + enemic.getVida());
                    pause();
                    if (personatge.getVida() <= 0.0) {
                        System.out.println("Heu mort.");
                        pause();
                        System.exit(0);
                    }
                    if (enemic.getVida() <= 0.0) {
                        Objecte objecteGuanyat = generarObjecteAleatori();
                        personatge.AfeigirObjecte(objecteGuanyat);
                        System.out.println("L'enemic a mort.");
                        System.out.println("Heu guanyat " + objecteGuanyat.getNom());
                        pause();
                        menu = false;
                    }
                    break;
                case 4:
                    Objecte objecte = seleccionarObjecte();
                    if (objecte != null) {
                        objecte.utilitzar(personatge);
                        if (objecte.getTipus() == 2) {
                            AfeigirObjecteAplicat(objecte);
                        }
                        personatge.elmiminarObjecte(objecte);
                    }
                    break;
                case 5:
                    clearScreen(); // Esborra la pantalla
                    System.out.println("Heu escapat.");
                    pause();
                    menu = false;
                    break;
            }
        }
    }

    private static void mostrarStats() {
        clearScreen(); // Esborra la pantalla
        System.out.println("Vida: "+personatge.getVida());
        System.out.println("Velocitat: "+personatge.getVelocitat());
        System.out.println("Atac: "+personatge.getAtac());
        System.out.println("Defensa: "+personatge.getDefensa());
        System.out.println("Aguant: "+personatge.getAguant());
        System.out.println("Coneixement: "+personatge.getConeixement());
        System.out.println("Voluntat: "+personatge.getVoluntat());
        System.out.println("Percepcio: "+personatge.getPercepcio());
        pause();
    }

    private static void mostrarStatsEnemic() {
        clearScreen(); // Esborra la pantalla
        System.out.println("Vida: "+enemic.getVida());
        System.out.println("Velocitat: "+enemic.getVelocitat());
        System.out.println("Defensa: "+enemic.getDefensa());
        System.out.println("Atac: "+enemic.getAtac());
        pause();
    }

    public static Enemic seleccionarEnemic() {
        Enemic enemic = new Enemic(0, 0, 0, 0);
        double seleccio;
        seleccio = preguntarStat("la Velocitat");
        if (seleccio == 0) {
            seleccio = getRandomNumberInRange(1,4);
        }
        enemic.setVelocitat(seleccio);
        seleccio = preguntarStat("la Vida");
        if (seleccio == 0) {
            seleccio = getRandomNumberInRange(1,4);
        }
        enemic.setVida(seleccio);
        seleccio = preguntarStat("l'Atac");
        if (seleccio == 0) {
            seleccio = getRandomNumberInRange(1,4);
        }
        enemic.setAtac(seleccio);
        seleccio = preguntarStat("la Defensa");
        if (seleccio == 0) {
            seleccio = getRandomNumberInRange(1,4);
        }
        enemic.setDefensa(seleccio);
        return enemic;
    }

    public static Objecte seleccionarObjecte() {
        boolean menu = true; //variable centinella per sortir del menu
        while (menu) {
            
            Objecte[] objectes = personatge.getObjectes();

            clearScreen(); // Esborra la pantalla
            System.out.println("Quin objecte voleu fer servir?");
            for (int i = 0; i < objectes.length; i++) {
                if (objectes[i] != null && objectes[i].getTipus() > 1) {
                    System.out.println( (i + 1) + " - " + objectes[i].getNom());
                }
            }
            System.out.println("0 - Tornar");
            int seleccio = (int) preguntarNumero(1, objectes.length, true);
            if (seleccio == 0) {
                return null;
            } else if (seleccio > 0 && seleccio <= objectes.length) {
                return objectes[seleccio];
            } else {
                menu = true;
            }
        }
        return null;
    }

    public static double preguntarNumero(int min, int max, boolean zero) {
        double number = 0;
        boolean error = true;
        while (error) {
            try {
                Scanner sc = new Scanner(System.in);
                number = sc.nextDouble();
                if (zero && number == 0) {
                    return number;
                }
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
            clearScreen(); // Esborra la pantalla
            System.out.println("Seleccioneu "+nom+" [1 - 4]");
            System.out.println("Premeu 0 per seleccionar aleatoriament");
            seleccio = (int) preguntarNumero(1, 4, true);
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

    public static Objecte generarObjecteAleatori() {
        int tipus = getRandomNumberInRange(0, 3);
        Objecte objecte = null;
        switch (tipus) {
            case 0: // arma/armadura
                objecte = new Arma(); //inizialitza l'objecte com a arma
                int tipusArma = getRandomNumberInRange(0, 1); //defineix si sera un arma o un escut
                if (tipusArma == 0) {
                    objecte.setNom("Espada"); //estableix el nom del objecte a espada
                    ((Arma) objecte).setAtac(getRandomNumberInRange(1, 4)); //estableix un atac aleatori
                } else {
                    objecte.setNom("Escut"); //estableix el nom del objecte a escut
                    ((Arma) objecte).setDefensa(getRandomNumberInRange(1, 4));//estableix una defensa aleatori
                }
                ((Arma) objecte).setVelocitat(getRandomNumberInRange(-4, 4));//estableix una velocitat aleatori
                break;
            case 1: // encanteri
                objecte = new Encanteri();//inizialitza l'objecte com a encanteri
                int stat = getRandomNumberInRange(0, 2); //defineix quin stat modificara l'encanteri
                String statText = "";
                if (stat == 0) {
                    statText = "atac";
                } else if (stat == 1) {
                    statText = "defensa";
                } else {
                   statText = "velocitat";
                }
                ((Encanteri) objecte).setStat(statText);
                objecte.setNom("Encanteri de "+ statText); //estableix el nom a encanteri de  + atribut que es modifica
                ((Encanteri) objecte).setQuantitat(getRandomNumberInRange(1, 4));
                break;
            case 2: //pocio
                objecte = new Pocio(); //inizialitza l'objecte com a pocio
                double vida = getRandomNumberInRange(1, 4);
                objecte.setNom("pocio (+"+vida+")");
                break;
        }
        objecte.setTipus(tipus + 1);
        return objecte;
    }
    public static void AfeigirObjecteAplicat(Objecte objecte) {
        boolean afeigit = false;
        for (int i = 0; i < objectesAplicats.length; i++) {
            if (!afeigit && objectesAplicats[i] != null) {
                objectesAplicats[i] = objecte;
                afeigit = true;
            }
        }
    }

    public static void esborrarStatsAplicats() {
        for (int i = 0; i < objectesAplicats.length; i++) {
            if (objectesAplicats[i] != null) {
                String stat = ((Encanteri) objectesAplicats[i]).getStat();
                double quantitat = ((Encanteri) objectesAplicats[i]).getQuantitat();
                if (stat.equals("atac")) {
                    personatge.setAtac(personatge.getAtac() - quantitat);
                } else if (stat.equals("defensa")) {
                    personatge.setDefensa(personatge.getDefensa() - quantitat);
                } else if (stat.equals("velocitat")) {
                    personatge.setVelocitat(personatge.getVelocitat() - quantitat);
                }
                objectesAplicats[i] = null;
            }
        }
    }
}
