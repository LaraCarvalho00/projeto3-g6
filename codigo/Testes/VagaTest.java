package Testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Vaga;

public class VagaTest {

    @Test
    public void testEstaDisponivel() {
        Vaga vaga = new Vaga("Vaga A");
        assertTrue(vaga.estaDisponivel());
    }

    @Test
    public void testEstacionar() {
        Vaga vaga = new Vaga("Vaga A");
        assertTrue(vaga.estacionar());
        assertFalse(vaga.estaDisponivel()); 
    }

    @Test
    public void testSair() {
        Vaga vaga = new Vaga("Vaga A");
        vaga.estacionar();
        assertTrue(vaga.sair());
        assertTrue(vaga.estaDisponivel()); 
    }

    @Test
    public void testGetIdentificacao() {
        Vaga vaga = new Vaga("Vaga A");
        assertEquals("Vaga A", vaga.getIdentificacao());
    }
}