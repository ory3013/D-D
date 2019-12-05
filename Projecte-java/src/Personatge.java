public class Personatge {

    private String nombre;
    private String arquetipo;
    private double velocitat;
    private double vida;
    private double aguant;
    private double defensa;
    private double fuerza;
    private double coneixement;
    private double voluntat;
    private double persepcio;

    Personatge(String nombre, String arquetipo) {
        this.nombre = nombre;
        this.arquetipo = arquetipo;
        this.velocitat = 0;
        this.vida = 0;
        this.aguant = 0;
        this.defensa = 0;
        this.fuerza = 0;
        this.coneixement = 0;
        this.voluntat = 0;
        this.persepcio = 0;
    }

}