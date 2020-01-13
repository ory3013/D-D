package dandd;

/**
 * Pocio utilitzable per un personatge
 */
class Pocio extends Objecte {

    private double vida;

    //  Getters & Setters

    
    /** 
     * obte el valor de vida
     * @return double valor de vida
     */
    public double getVida() {
        return vida;
    }

    
    /** 
     * Estableix el valor de vida
     * @param vida valor de vida
     */
    public void setVida(double vida) {
        this.vida = vida;
    }

    // Metodes

    
    /** 
     * Aplica la vida de la pocio a un personatge
     * @param personatge personatge que utilitza la pocio
     * @param enemic enemic que ataca al personatge
     */
    public void utilitzar(Personatge personatge, Enemic enemic) { //s'utilitza
        personatge.setVida(personatge.getVida() + this.getVida()); // s'augmenta la vida del personatge
        enemic.atacar(personatge);
    }
}
