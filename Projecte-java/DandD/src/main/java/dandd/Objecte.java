package dandd;

abstract class Objecte {

    private String nom;
    private int tipus; // 1-arma, 2-encanteri, 3-pocio

    public String getNom() {
        return nom;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void utilitzar(Personatge personatge) {

    }

}