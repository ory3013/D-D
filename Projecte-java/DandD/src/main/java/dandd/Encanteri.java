package dandd;

class Encanteri extends Objecte {

    private String stat; //indica l'estat que modifica l'encanteri
    private double quantitat; //indica quantes unitats puja o baixa al stat 

    //  Getters & Setters

    public String getStat() {
        return stat;
    }

    public double getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(double quantitat) {
        this.quantitat = quantitat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

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
