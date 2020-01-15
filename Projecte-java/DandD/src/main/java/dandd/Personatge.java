package dandd;
/**
 * Personatge que es pot crear
 */
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

    
    /** 
     * Personatge que sera de un tipus i tindra un nom
     * @param nom indica el nom del personatge 
     * @param arquetip indica el tipus del perosnatge
     * @return 
     */
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

    
    /** 
     * Getter del parametre objectes
     * @return retorna els objectes que podra utilitzar el personatge
     */
    public Objecte[] getObjectes() {
        return objectes;
    }

    
    /** 
     * Setter del parametre objectes
     * @param objectes value to set
     */
    public void setObjectes(Objecte[] objectes) {
        this.objectes = objectes;
    }

    
    /** 
     * Getter del parametre percepcio
     * @return retorna la percepcio del personatge
     */
    public double getPercepcio() {
        return percepcio;
    }

    
    /** 
     * Setter del parametre percepcio
     * @param percepcio value to set
     */
    public void setPercepcio(double percepcio) {
        this.percepcio = percepcio;
    }

    
    /** 
     * Getter del parametre voluntat
     * @return retorna la voluntat del personatge
     */
    public double getVoluntat() {
        return voluntat;
    }

    
    /** 
     * Setter del parametre voluntat
     * @param voluntat value to set
     */
    public void setVoluntat(double voluntat) {
        this.voluntat = voluntat;
    }

    
    /** 
     * Getter del parametre coneixement
     * @return retorna el coneixement del personatge
     */
    public double getConeixement() {
        return coneixement;
    }

    
    /** 
     * Setter del parametre coneixement
     * @param coneixement value to set
     */
    public void setConeixement(double coneixement) {
        this.coneixement = coneixement;
    }

    
    /** 
     * Getter del parametre atac
     * @return retorna l'atac del personatge
     */
    public double getAtac() {
        return atac;
    }

    
    /** 
     * Setter del parametre atac
     * @param atac value to set
     */
    public void setAtac(double atac) {
        this.atac = atac;
    }

    
    /** 
     * Getter del parametre defensa
     * @return retorna la defensa del personatge
     */
    public double getDefensa() {
        return defensa;
    }

    
    /** 
     * Setter del parametre defensa
     * @param defensa value to set
     */
    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    
    /** 
     * Getter del parametre aguant
     * @return retorna l'aguant  del personatge
     */
    public double getAguant() {
        return aguant;
    }

    
    /** 
     * Setter del parametre aguant
     * @param aguant value to set
     */
    public void setAguant(double aguant) {
        this.aguant = aguant;
    }

    
    /**
     * Getter del parametre vida 
     * @return retorna la vida del personatge
     */
    public double getVida() {
        return vida;
    }

    
    /** 
     * Setter del parametre vida
     * @param vida value to set
     */
    public void setVida(double vida) {
        this.vida = vida;
    }

    
    /** 
     * Getter del parametre velocitat
     * @return retorna la velocitat del personatge
     */
    public double getVelocitat() {
        return velocitat;
    }

    
    /** 
     * Setter del parametre velocitat
     * @param velocitat value to set
     */
    public void setVelocitat(double velocitat) {
        this.velocitat = velocitat;
    }

    
    /** 
     * Getter del parametre genere
     * @return retorna el genere del personatge
     */
    public int getGenere() {
        return genere;
    }

    
    /** 
     * Setter del parametre genere
     * @param genere value to set
     */
    public void setGenere(int genere) {
        this.genere = genere;
    }

    
    /**
     * Getter del parametre arquetip
     * @return retorna l'arquetip del personatge
     */
    public int getArquetip() {
        return arquetip;
    }

    
    /** 
     * Setter del parametre arquetip
     * @param arquetip value to set
     */
    public void setArquetip(int arquetip) {
        this.arquetip = arquetip;
    }

    
    /** 
     * Getter del parametre nom
     * @return retorna el nom del personatge
     */
    public String getNom() {
        return nom;
    }

    
    /** 
     * Setter del parametre nom
     * @param nom value to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    //Metodes

    
    /** 
     * Metode que servira per poder atacar a l'enemic
     * @param enemic enemic al qual estem atacant
     */
    public void atacar(Enemic enemic) { // quan s'inicia l'atac del personatge
        if (this.getVida() > 0.0) {
            double atac = this.getAtac() - enemic.getDefensa();  // agafa l'atac del pesonatge i la defensa de l'enemic i les resta
            atac = atac > 0 ? atac : 1; // si el atac és 0 o menys l'atac es quedara en 1, en canvi si l'atac és superior a 0 es quedara aquell atac
            enemic.setVida(enemic.getVida() - atac ); // es resta l'atac del personatge a la vida de l'enemic
        } 
    }

    
    /** 
     * Metode que servira per poder agafar l'objecte i afegor-lo a l'inventari
     * @param objecte objecte que s'afegira a l'inventari
     */
    public void AfeigirObjecte(Objecte objecte) {
        boolean afeigit = false; // agafa l'objecte del enemic
        for (int i = 0; i < this.objectes.length; i++) { //recorre cada espai de l'inventari (maxim 20 objectes)
            if (!afeigit && this.objectes[i] == null) { // si no esta afegit i l'espai és null 
                this.objectes[i] = objecte; // s'afegeix l'objecte
                afeigit = true;
            }
        }
    }

    
    /** 
     * Metode que servira per poder eliminar l'objecte de l'inventari
     * @param objecte objecte que eliminarem
     */
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
