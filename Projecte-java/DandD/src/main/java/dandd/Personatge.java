package dandd;

public class Personatge {

    private String nom;
    private int arquetip;
    private int genere; // 0-null, 1-home, 2-dona
    private double velocitat;
    private double vida;
    private double aguant;
    private double defensa;
    private double atac;
    private double coneixement;
    private double voluntat;
    private double percepcio;
    private Objecte[] objectes;

    Personatge(String nom, int arquetip) {
        this.setNom(nom);
        this.setArquetip(arquetip);
        this.setVelocitat(0);
        this.setVida(0);
        this.setAguant(0);
        this.setDefensa(0);
        this.setAtac(0);
        this.setConeixement(0);
        this.setVoluntat(0);
        this.setPercepcio(0);
        this.setObjectes(new Objecte[20]);
    }

    public Objecte[] getObjectes() {
        return objectes;
    }

    public void setObjectes(Objecte[] objectes) {
        this.objectes = objectes;
    }

    public double getPercepcio() {
        return percepcio;
    }

    public void setPercepcio(double percepcio) {
        this.percepcio = percepcio;
    }

    public double getVoluntat() {
        return voluntat;
    }

    public void setVoluntat(double voluntat) {
        this.voluntat = voluntat;
    }

    public double getConeixement() {
        return coneixement;
    }

    public void setConeixement(double coneixement) {
        this.coneixement = coneixement;
    }

    public double getAtac() {
        return atac;
    }

    public void setAtac(double atac) {
        this.atac = atac;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public double getAguant() {
        return aguant;
    }

    public void setAguant(double aguant) {
        this.aguant = aguant;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(double velocitat) {
        this.velocitat = velocitat;
    }

    public int getGenere() {
        return genere;
    }

    public void setGenere(int genere) {
        this.genere = genere;
    }

    public int getArquetip() {
        return arquetip;
    }

    public void setArquetip(int arquetip) {
        this.arquetip = arquetip;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //Metodes

    public void atacar(Enemic enemic) { // quan s'inicia l'atac del personatge 
        double atac = this.getAtac() - enemic.getDefensa();  // agafa l'atac del pesonatge i la defensa de l'enemic i les resta
        atac = atac > 0 ? atac : 1; // si el atac és 0 o menys l'atac es quedara en 1, en canvi si l'atac és superior a 0 es quedara aquell atac
        enemic.setVida(enemic.getVida() - atac ); // es resta l'atac del personatge a la vida de l'enemic
    }

    public void AfeigirObjecte(Objecte objecte) {
        boolean afeigit = false; // agafa l'objecte del enemic
        for (int i = 0; i < this.objectes.length; i++) { //recorre cada espai de l'inventari (maxim 20 objectes)
            if (!afeigit && this.objectes[i] == null) { // si no esta afegit i l'espai és null 
                this.objectes[i] = objecte; // s'afegeix l'objecte
                afeigit = true;
            }
        }
    }

    public void elmiminarObjecte(Objecte objecte) { 
        boolean eliminat = false; // el jugador utilitza un objecte
        for (int i = 0; i < this.objectes.length; i++) { 
            if (!eliminat && this.objectes[i] == objecte) { // es busca aquest objecte ala llista 
                this.objectes[i] = null; // s'elimina i es deix l'espai buit
                eliminat = true;
            }
        }
    }

}
