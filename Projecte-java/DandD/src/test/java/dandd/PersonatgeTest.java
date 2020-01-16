package dandd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.Console;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PersonatgeTest 
{
    /**
     * Rigorous Test :-)h
     */
    @Test
    public void siElPersonatgeTe0DeVidaNoAtaca()
    {
        Personatge personatgeProva = new Personatge("Prova", 2);
        personatgeProva.setVida(0);
        personatgeProva.setAtac(4);

        Enemic enemicProva = new Enemic(2, 15, 3, 3);

        personatgeProva.atacar(enemicProva);

        assertEquals(15.0, enemicProva.getVida(), 0.1);
    }

    @Test
    public void siElAtacResultantEsMesGranDe0FaTotElDany()
    {
        Personatge personatgeProva = new Personatge("Prova", 2);
        personatgeProva.setVida(15);
        personatgeProva.setAtac(4);

        Enemic enemicProva = new Enemic(2, 15, 2, 3);

        personatgeProva.atacar(enemicProva);

        assertEquals(13.0, enemicProva.getVida(), 0.1);
    }

    @Test
    public void siElAtacResultantEsIgualOMesPetitDe0Fa1DeDany()
    {
        Personatge personatgeProva = new Personatge("Prova", 2);
        personatgeProva.setVida(15);
        personatgeProva.setAtac(3);

        Enemic enemicProva = new Enemic(2, 15, 4, 3);

        personatgeProva.atacar(enemicProva);

        assertEquals(14.0, enemicProva.getVida(), 0.1);
    }

    @Test
    public void siUnPersonatgeAmb4DeAtacLluitaAmbUnEnemicAmb1DeVidaI2DeDefensaElEnemicMorIQuedaAmbUnavidaDe1Negatiu()
    {
        Personatge personatgeProva = new Personatge("Prova", 2);
        personatgeProva.setVida(15);
        personatgeProva.setAtac(4);

        Enemic enemicProva = new Enemic(2, 1, 2, 3);

        personatgeProva.atacar(enemicProva);

        assertEquals(-1.0, enemicProva.getVida(), 0.1);
    }

    @Test
    public void siUnPersonatgeAmb2DeAtacLluitaAmbUnEnemicAmb3DeVidaI3DeDefensaElEnemicQuedaAmbUnavidaDe2()
    {
        Personatge personatgeProva = new Personatge("Prova", 2);
        personatgeProva.setVida(15);
        personatgeProva.setAtac(4);

        Enemic enemicProva = new Enemic(2, 3, 3, 3);

        personatgeProva.atacar(enemicProva);

        assertEquals(2.0, enemicProva.getVida(), 0.1);
    }

    @Test
    public void SiUnPersonatgeNoTeCapObjecteIAfegeixUnEsGuardaALaPrimeraPosicioDelInventari()
    {
        Arma armaProva = new Arma();
        Personatge personatgeProva = new Personatge("Prova", 2);

        personatgeProva.AfeigirObjecte(armaProva);

        Objecte[] objectes = personatgeProva.getObjectes();


        assertEquals(armaProva, objectes[0]);
    }

    @Test
    public void SiUnPersonatgeTe1ObjecteIAfegeixUnAltreEsGuardaALaSegonaPosicioDelInventari()
    {
        Arma armaProva1 = new Arma();
        Arma armaProva2 = new Arma();
        Personatge personatgeProva = new Personatge("Prova", 2);

        personatgeProva.AfeigirObjecte(armaProva1);
        personatgeProva.AfeigirObjecte(armaProva2);

        Objecte[] objectes = personatgeProva.getObjectes();

        assertEquals(armaProva2, objectes[1]);
    }

    @Test
    public void SiUnPersonatgeTe1ObjecteALaSegonaPosicioDelInventariIAfegeixUnAltreEsGuardaALaPrimeraPosicioDelInventari()
    {
        Arma armaProva1 = new Arma();
        Arma armaProva2 = new Arma();
        Arma armaProva3 = new Arma();
        Personatge personatgeProva = new Personatge("Prova", 2);

        personatgeProva.AfeigirObjecte(armaProva1);
        personatgeProva.AfeigirObjecte(armaProva2);
        personatgeProva.elmiminarObjecte(armaProva1);
        personatgeProva.AfeigirObjecte(armaProva3);

        Objecte[] objectes = personatgeProva.getObjectes();

        assertEquals(armaProva3, objectes[0]);
        assertEquals(armaProva2, objectes[1]);
    }

    @Test
    public void SiUnPersonatgeTe1ObjecteIElEleminaElInventariQuedaBuit()
    {
        Arma armaProva1 = new Arma();
        Personatge personatgeProva = new Personatge("Prova", 2);

        personatgeProva.AfeigirObjecte(armaProva1);
        personatgeProva.elmiminarObjecte(armaProva1);

        Objecte[] objectes = personatgeProva.getObjectes();

        assertEquals(null, objectes[0]);
    }

    @Test
    public void SiUnPersonatgeTe2ObjecteIElEleminaElUltimAquestEsEliminatDelInventari()
    {
        Arma armaProva1 = new Arma();
        Arma armaProva2 = new Arma();
        Personatge personatgeProva = new Personatge("Prova", 2);

        personatgeProva.AfeigirObjecte(armaProva1);
        personatgeProva.AfeigirObjecte(armaProva2);
        personatgeProva.elmiminarObjecte(armaProva2);

        Objecte[] objectes = personatgeProva.getObjectes();

        assertEquals(null, objectes[1]);
        assertEquals(armaProva1, objectes[0]);
    }

    @Test
    public void SiUnPersonatgeTe2ObjecteIElEleminaElPrimerAquestEsEliminatDelInventariILaPrimeraPosicioQuedaBuida()
    {
        Arma armaProva1 = new Arma();
        Arma armaProva2 = new Arma();
        Personatge personatgeProva = new Personatge("Prova", 2);

        personatgeProva.AfeigirObjecte(armaProva1);
        personatgeProva.AfeigirObjecte(armaProva2);
        personatgeProva.elmiminarObjecte(armaProva1);

        Objecte[] objectes = personatgeProva.getObjectes();

        assertEquals(null, objectes[0]);
        assertEquals(armaProva2, objectes[1]);

    }
}
