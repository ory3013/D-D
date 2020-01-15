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
     * Rigorous Test :-)
     */
    @Test
    public void siElPersonatgeTe0DeVidaNoAtaca()
    {
        Personatge personatgeProva = new Personatge("Prova", 2);
        personatgeProva.setVida(0);
        personatgeProva.setAtac(4);

        Enemic enemicProva = new Enemic(2, 15, 3, 3);

        System.out.println(enemicProva.getVida());

        personatgeProva.atacar(enemicProva);

        System.out.println(enemicProva.getVida());

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
}
