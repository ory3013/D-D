package dandd;

public class Enemic {
    private double velocitat;
    private double vida;
    private double defensa;
    private double atac;

    //contructors
    Enemic() {
        setVelocitat(0);
        setVida(0);
        setDefensa(0);
        setAtac(0);
    }
    Enemic(double velocitat, double vida, double defensa, double atac) {
        this.setVelocitat(0);
        this.setVida(0);
        this.setDefensa(0);
        this.setAtac(0);
    }

    // Getters & Setters

    public double getAtac() {
        return atac;
    }

    public void setAtac(double atac) {
        this.atac = atac;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(double velocitat) {
        this.velocitat = velocitat;
    }

    //metodes
    public void atacar(Personatge personatge) {
        double atac = this.getAtac() - personatge.getDefensa();
        atac = atac > 0 ? atac : 1;
        personatge.setVida(personatge.getVida() - atac);
    }
}