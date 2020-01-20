package dandd;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.reflect.*;

/**
 * Classe principal del programa. Executa el codi del joc fent us de les funcions propies i de les altres classes quan és necessari.
 */
public class App 
{
    public static Personatge personatge;
    public static Enemic enemic;
    public static Objecte[] objectesAplicats = new Objecte[30];
    
    /** 
     * Metode principal, s'executa al iniciar l'aplicacio
     * @param args arguments introduits al iniciar la aplicacio
     */
    public static void main(String[] args){
        
        //inicialitza un array amb 1 personatges de cata tipus
        Personatge[] personatges = {
            new Personatge("Guerrer", 1),
            new Personatge("Mag", 2),
            new Personatge("Elfling", 3)
        };

        System.out.println("Selecciona un personatge"); //mostra un missagte per pantalla
        for(int i = 0; i < personatges.length; i++)  { // bucle que recorre els personatges de l'array
            System.out.println((i+1) + " - " + personatges[i].getNom()); //mostra per pantalla el personatge que s'esta recorrent.
        }
        System.out.println("Premeu 0 per seleccionar aleatoriament"); //mostra un missagte per pantalla
        int seleccio = (int) preguntarNumero(1, personatges.length, true); //pregunta a l'usuari un numero entre 1 y la quantitat de personatges a l'array, numero zero inclos
        if (seleccio == 0) { //comprova si el numero introduit es un zero
            seleccio = getRandomNumberInRange(1, personatges.length); // agafa un numero aleatori entre 1 y la quantitat de personatges a l'array
        }
        seleccio--;

        clearScreen(); // Esborra la pantalla
        personatge = new Personatge(personatges[seleccio].getNom(), personatges[seleccio].getArquetip()); //inicialitza el personatge
        System.out.println("Heu seleccionat el personatge " + personatges[seleccio].getNom()); //mostra per pantalla el personatge seleccionat.
        pause(); //espera a que l'usuari premi enter

        if (personatge.getArquetip() == 1 || personatge.getArquetip() == 2) { //comprova si el personatge es guerrer o mag
            System.out.println("Seleccioneu un genere");
            System.out.println("1 - Mascle");
            System.out.println("2 - Femella");
            System.out.println("Premeu 0 per seleccionar aleatoriament");
            seleccio = (int) preguntarNumero(1, 2, true); //pregunta a l'usuari un numero entre 1 y 2, zero inclos
            if (seleccio == 0) { //comprova si el numero es un 0
                seleccio = getRandomNumberInRange(1,2); // agafa un numero entre 1 y 2
            }
            personatge.setGenere(seleccio); // estableix el genere del personatge
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

    /**
     * Mostra el menu anterior a una batalla per pantalla
     */
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

    /**
     * Mostra el menu de batalla per pantalla
     */
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
                    atacar();
                    if (enemic.getVida() <= 0.0) {
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

    /**
     * executa una ronda d'atacs
     */
    private static void atacar() {
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
        }
    }

    /**
     * Mostra per pantalla els stats del jugador
     */
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

    /**
     * Mostra per pantalla els stats de l'enemic
     */
    private static void mostrarStatsEnemic() {
        clearScreen(); // Esborra la pantalla
        System.out.println("Vida: "+enemic.getVida());
        System.out.println("Velocitat: "+enemic.getVelocitat());
        System.out.println("Defensa: "+enemic.getDefensa());
        System.out.println("Atac: "+enemic.getAtac());
        pause();
    }

    
    /** 
     * Crea un enemic amb els estats indicats per l'usuari
     * @return Enemic Retorna l'enemic generat
     */
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

    
    /** 
     * Permet al usuari seleccionar un objecte del seu inventari
     * @return Objecte Objecte seleccionat
     */
    public static Objecte seleccionarObjecte() {
        boolean menu = true; //variable centinella per sortir del menu
        while (menu) {
            
            Objecte[] objectes = personatge.getObjectes(); //obte els objectes del personatge

            clearScreen(); // Esborra la pantalla
            System.out.println("Quin objecte voleu fer servir?");
            for (int i = 0; i < objectes.length; i++) { //recorre tots els slots de l'inventari
                if (objectes[i] != null && objectes[i].getTipus() > 1) { //comprova si el slot no esta buit i no es un arma
                    System.out.println( (i + 1) + " - " + objectes[i].getNom()); //mostra l'objecte del slot actual
                }
            }
            System.out.println("0 - Tornar");
            int seleccio = (int) preguntarNumero(1, objectes.length, true); //pregunta un numero entre 1 y el numero de slots de l'inventary
            if (seleccio == 0) { //comprova si el numero es un 0
                return null; //retorna null
            } else if (seleccio > 0 && seleccio <= objectes.length) {
                return objectes[seleccio - 1]; //retorna l'objecte seleccionat
            } else {
                menu = true;
            }
        }
        return null;
    }

    
    /** 
     * Pregunta a l'usuari un numero entre un minim i un maxim
     * @param min el numero minim que l'usuari pot introduir
     * @param max el numero maxim que l'usuari pot introduir
     * @param zero indica si s'accepta el numero zero, inclus si esta fora del rang
     * @return double retorna el numero introduit per l'usuari
     */
    public static double preguntarNumero(int min, int max, boolean zero) {
        double number = 0;
        boolean error = true; // defineix variable centinella
        while (error) {
            try {
                Scanner sc = new Scanner(System.in); 
                number = sc.nextDouble(); // pregunta a l'usuari un numero
                if (zero && number == 0) { //comproba si el numero es zero y si s'accepten zeros
                    return number;
                }
                if (number < min || number > max) { //comprova si el numero es al rang introduit per parametres del metode
                    throw new EmptyStackException(); // tira una exepcio per repetir el bucle
                }
                error = false;
            } catch (Exception e) {
                System.out.println("Input invalid"); //avisa a l'usuari que l'entrada es invalida
                error = true;
            }
        }
        return number;
    }

    
    /** 
     * pregunta a l'usuari el valor d'un stat
     * @param nom nom del stat que es vol preguntar
     * @return double retorna el valor al stat introduit
     */
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

    /**
     * pausa l'execucio del programa fins que l'usuari premi enter
     */
    public static void pause() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Prem la tecla Enter per continuar . . . ");
        scan.nextLine();
    }

    /**
     * Esborra el contingut de la pantalla
     */
    public static void clearScreen() {
        System.out.flush();
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}        
    }

    
    /** 
     * Genera un numero aleatori entre el rang introduit
     * @param min numero minim que es pot generar
     * @param max numero maxim que es pot generar
     * @return int numero generat
     */
    private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
    }

    
    /** 
     * Genera un objecte aleatoriament
     * @return Objecte objecte generat
     */
    public static Objecte generarObjecteAleatori() {
        int tipus = getRandomNumberInRange(0, 2);
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
    
    /** 
     * afegeix un objecte a la llista d'objectes utilitzats d'urant una ronda
     * amb l'objectiu de retirar els efectes a la seguent ronda
     * @param objecte objecte que es vol afeigir a la llista
     */
    public static void AfeigirObjecteAplicat(Objecte objecte) {
        boolean afeigit = false;
        for (int i = 0; i < objectesAplicats.length; i++) {
            if (!afeigit && objectesAplicats[i] != null) {
                objectesAplicats[i] = objecte;
                afeigit = true;
            }
        }
    }

    /**
     * resta els estats aplicats al personatge per encanteris durant la ronda anterior
     */
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
