package dandd;

class Pocio extends Objecte {

    private double vida;

    //  Getters & Setters

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    // Metodes

    public void utilitzar(Personatge personatge, Enemic enemic) {
        personatge.setVida(personatge.getVida() + this.getVida());
        enemic.atacar(personatge);
    }
}