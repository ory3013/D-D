package dandd;

public class Enemic {
    private double velocitat;
    private double vida;
    private double defensa;
    private double atac;

    //contructors
    
    /** 
     * @return 
     */
    Enemic() {
        setVelocitat(0);
        setVida(0);
        setDefensa(0);
        setAtac(0);
    }
    
    /** 
     * @param velocitat
     * @param vida
     * @param defensa
     * @param atac
     * @return 
     */
    Enemic(double velocitat, double vida, double defensa, double atac) {
        this.setVelocitat(velocitat);
        this.setVida(vida);
        this.setDefensa(defensa);
        this.setAtac(atac);
    }

    // Getters & Setters

    
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

    //metodes
    
    /** 
     * @param personatge
     */
    public void atacar(Personatge personatge) { // quan s'inicia l'atac del enemic 
        if (this.getVida() > 0.0) {
            double atac = this.getAtac() - personatge.getDefensa(); // agafa l'atac del enemic i la defensa del pesonatge i les resta
            atac = atac > 0 ? atac : 1; // si el atac és 0 o menys l'atac es quedara en 1, en canvi si l'atac és superior a 0 es quedara aquell atac
            personatge.setVida(personatge.getVida() - atac); // es resta l'atac del enemic a la vida del personatge
        }
    }
}
