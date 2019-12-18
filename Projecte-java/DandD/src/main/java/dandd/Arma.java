package dandd;

class Arma extends Objecte {
    
    private double atac;
    private double defensa;
    private double velocitat;

    public double getAtac() {
        return atac;
    }

    public double getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(double velocitat) {
        this.velocitat = velocitat;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public void setAtac(double atac) {
        this.atac = atac;
    }

}