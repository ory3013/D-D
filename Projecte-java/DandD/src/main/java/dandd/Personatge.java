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

    
    /** 
     * @param nom
     * @param arquetip
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
     * @return Objecte[]
     */
    public Objecte[] getObjectes() {
        return objectes;
    }

    
    /** 
     * @param objectes
     */
    public void setObjectes(Objecte[] objectes) {
        this.objectes = objectes;
    }

    
    /** 
     * @return double
     */
    public double getPercepcio() {
        return percepcio;
    }

    
    /** 
     * @param percepcio
     */
    public void setPercepcio(double percepcio) {
        this.percepcio = percepcio;
    }

    
    /** 
     * @return double
     */
    public double getVoluntat() {
        return voluntat;
    }

    
    /** 
     * @param voluntat
     */
    public void setVoluntat(double voluntat) {
        this.voluntat = voluntat;
    }

    
    /** 
     * @return double
     */
    public double getConeixement() {
        return coneixement;
    }

    
    /** 
     * @param coneixement
     */
    public void setConeixement(double coneixement) {
        this.coneixement = coneixement;
    }

    
    /** 
     * @return double
     */
    public double getAtac() {
        return atac;
    }

    
    /** 
     * @param atac
     */
    public void setAtac(double atac) {
        this.atac = atac;
    }

    
    /** 
     * @return double
     */
    public double getDefensa() {
        return defensa;
    }

    
    /** 
     * @param defensa
     */
    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    
    /** 
     * @return double
     */
    public double getAguant() {
        return aguant;
    }

    
    /** 
     * @param aguant
     */
    public void setAguant(double aguant) {
        this.aguant = aguant;
    }

    
    /** 
     * @return double
     */
    public double getVida() {
        return vida;
    }

    
    /** 
     * @param vida
     */
    public void setVida(double vida) {
        this.vida = vida;
    }

    
    /** 
     * @return double
     */
    public double getVelocitat() {
        return velocitat;
    }

    
    /** 
     * @param velocitat
     */
    public void setVelocitat(double velocitat) {
        this.velocitat = velocitat;
    }

    
    /** 
     * @return int
     */
    public int getGenere() {
        return genere;
    }

    
    /** 
     * @param genere
     */
    public void setGenere(int genere) {
        this.genere = genere;
    }

    
    /** 
     * @return int
     */
    public int getArquetip() {
        return arquetip;
    }

    
    /** 
     * @param arquetip
     */
    public void setArquetip(int arquetip) {
        this.arquetip = arquetip;
    }

    
    /** 
     * @return String
     */
    public String getNom() {
        return nom;
    }

    
    /** 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    //Metodes

    
    /** 
     * @param enemic
     */
    public void atacar(Enemic enemic) { // quan s'inicia l'atac del personatge
        if (this.getVida() > 0.0) {
            double atac = this.getAtac() - enemic.getDefensa();  // agafa l'atac del pesonatge i la defensa de l'enemic i les resta
            atac = atac > 0 ? atac : 1; // si el atac és 0 o menys l'atac es quedara en 1, en canvi si l'atac és superior a 0 es quedara aquell atac
            enemic.setVida(enemic.getVida() - atac ); // es resta l'atac del personatge a la vida de l'enemic
        } 
    }

    
    /** 
     * @param objecte
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
     * @param objecte
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
