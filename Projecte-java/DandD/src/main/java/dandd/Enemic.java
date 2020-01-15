package dandd;
/**
 * Enemic que es pot crear
 */
public class Enemic {
    private double velocitat;
    private double vida;
    private double defensa;
    private double atac;

    //contructors
    
    /** 
     * Enemic amb les seves estadistiques al 0
     * @return 
     */
    Enemic() {
        setVelocitat(0);
        setVida(0);
        setDefensa(0);
        setAtac(0);
    }
    
    /** 
     * Enemic contra el que haurem de lluitar
     * @param velocitat velocitat que assignarem a l'enemic
     * @param vida vida que assignarem a l'enemic
     * @param defensa defensa que assignarem a l'enemic
     * @param atac atac que assignarem a l'enemic
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
     * Getter del parametre nom
     * @return retorna l'atac que tindra l'enemic
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
     * @return  retorna la defensa que tindra l'enemic
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
     * Getter del parametre vida
     * @return  retorna la vida que tindra l'enemic
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
     * @return  retorna la velocitat que tindra l'enemic
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

    //metodes
    
    /** 
     * Metode que servira per poder atacar al personatge
     * @param personatge personatge al qual estem atacant
     */
    public void atacar(Personatge personatge) { // quan s'inicia l'atac del enemic 
        if (this.getVida() > 0.0) {
            double atac = this.getAtac() - personatge.getDefensa(); // agafa l'atac del enemic i la defensa del pesonatge i les resta
            atac = atac > 0 ? atac : 1; // si el atac és 0 o menys l'atac es quedara en 1, en canvi si l'atac és superior a 0 es quedara aquell atac
            personatge.setVida(personatge.getVida() - atac); // es resta l'atac del enemic a la vida del personatge
        }
    }
}
