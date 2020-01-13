package dandd;

/**
 * Encanteri utilitzable per un personatge
 */
class Encanteri extends Objecte {

    private String stat; //indica l'estat que modifica l'encanteri
    private double quantitat; //indica quantes unitats puja o baixa al stat 

    //  Getters & Setters

    
    /** 
     * obte stat al que afecta l'encanteri
     * @return String valor de stat
     */
    public String getStat() {
        return stat;
    }

    
    /** 
     * obte valor que incremeneta/decrementa a l'estat
     * @return double valor de l'atribut quantitat
     */
    public double getQuantitat() {
        return quantitat;
    }

    
    /** 
     * estableix stat al que afecta l'encanteri
     * @param quantitat valor de l'atribut quantitat
     */
    public void setQuantitat(double quantitat) {
        this.quantitat = quantitat;
    }

    
    /** 
     * estableix valor que incremeneta/decrementa a l'estat
     * @param stat valor de l'atribut stat
     */
    public void setStat(String stat) {
        this.stat = stat;
    }

    
    /** 
     * Aplica la mijora de stat al personatge
     * @param personatge personatge que s'aplica l'encanteri
     * @param enemic enemic que ataca al personatge
     */
    public void utilitzar(Personatge personatge, Enemic enemic) {
        //comprova quin a quin stat afecta la pocio
        if (stat == "atac") {
            //incrementa l'atac del personatge
            personatge.setAtac(personatge.getAtac() + this.getQuantitat());
        } else if (stat == "defensa") {
            //incrementa la defensa del personatge
            personatge.setDefensa(personatge.getDefensa() + this.getQuantitat());
        } else if (stat == "velocitat") {
            //incrementa la velocitat del personatge
            personatge.setVelocitat(personatge.getVelocitat() + this.getQuantitat());
        }
    }

    //retira els efectes aplicats al jugador
    
    /** 
     * Elimina la mijora als stats aplicada per l'encanteri
     * @param personatge
     */
    public void estabilitzar(Personatge personatge) {
        if (stat == "atac") {
            //decrementa l'atac del personatge
            personatge.setAtac(personatge.getAtac() - this.getQuantitat());
        } else if (stat == "defensa") {
            //decrementa la defensa del personatge
            personatge.setDefensa(personatge.getDefensa() - this.getQuantitat());
        } else if (stat == "velocitat") {
            //decrementa la velocitat del personatge
            personatge.setVelocitat(personatge.getVelocitat() - this.getQuantitat());
        }
    }




}
