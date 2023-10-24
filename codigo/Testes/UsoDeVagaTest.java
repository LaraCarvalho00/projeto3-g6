package Testes;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Vaga;

public class UsoDeVagaTest {

    @Test
    public void testEstacionar() {
        Vaga vaga = new Vaga("A1");
        boolean estacionouComSucesso = vaga.estacionar();

        assertTrue(estacionouComSucesso);
        assertFalse(vaga.estaDisponivel());
    }

    @Test
    public void testSair() {
        Vaga vaga = new Vaga("B2");
        vaga.estacionar(); // Estaciona a vaga primeiro
        boolean saiuComSucesso = vaga.sair();

        assertTrue(saiuComSucesso);
        assertTrue(vaga.estaDisponivel());
    }

    @Test
    public void testEstaDisponivel() {
        Vaga vaga1 = new Vaga("C3");
        Vaga vaga2 = new Vaga("D4");

        assertTrue(vaga1.estaDisponivel());
        assertTrue(vaga2.estaDisponivel());

        vaga1.estacionar();
        assertFalse(vaga1.estaDisponivel());

        vaga2.estacionar();
        assertFalse(vaga2.estaDisponivel());

        vaga1.sair();
        assertTrue(vaga1.estaDisponivel());

        vaga2.sair();
        assertTrue(vaga2.estaDisponivel());
    }

    @Test
    public void testGetIdentificacao() {
        Vaga vaga = new Vaga("E5");
        String identificacao = vaga.getIdentificacao();

        assertEquals("E5", identificacao);
    }
}
