package dandd;

/**
 * Eina amb les qual pot interactuar un persontage 
 */
abstract class Objecte {

    private String nom;
    private int tipus; // 1-arma, 2-encanteri, 3-pocio

    
    /** 
     * Getter del parametre nom
     * @return String
     */
    public String getNom() {
        return nom;
    }

    
    /** 
     * Getter del parametre tipus
     * @return int
     */
    public int getTipus() {
        return tipus;
    }

    
    /** 
     * Setter del parametre tipus
     * @param tipus
     */
    public void setTipus(int tipus) {
        this.tipus = tipus;
    }

    
    /** 
     * Setter del parametre nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    /** 
     * Metode per utilitzar l'objecte
     * @param personatge personatge que utilitza l'objecte
     */
    public void utilitzar(Personatge personatge) {

    }

}