package dandd;

/**
 * Tipus d'objecte que pot equiparse un personatge
 */
class Arma extends Objecte {
    
    private double atac;
    private double defensa;
    private double velocitat;
	/**
	 * @return retorna l'atac
	 */
	public double getAtac() {
		return atac;
	}
	/**
	 * @param atac value to set
	 */
	public void setAtac(double atac) {
		this.atac = atac;
	}
	/**
	 * @return retorna la defensa
	 */
	public double getDefensa() {
		return defensa;
	}
	/**
	 * @param defensa value to set
	 */
	public void setDefensa(double defensa) {
		this.defensa = defensa;
	}
	/**
	 * @return retorna la velocitat
	 */
	public double getVelocitat() {
		return velocitat;
	}
	/**
	 * @param velocitat value to set
	 */
	public void setVelocitat(double velocitat) {
		this.velocitat = velocitat;
	}
}