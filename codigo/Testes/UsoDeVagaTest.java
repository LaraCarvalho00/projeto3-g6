package Testes;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import main.Servico;
import main.UsoDeVaga;
import main.Vaga;

public class UsoDeVagaTest {
    @Test
    public void testSairSemServico() {
        Vaga vaga = new Vaga(1, 1);
        UsoDeVaga uso = new UsoDeVaga(vaga, null);
        
        double valorPago = uso.sair();
        
        assertEquals(0.0, valorPago, 0.01);
    }
    
    @Test
    public void testSairComServico() {
        Vaga vaga = new Vaga(2, 1);
        UsoDeVaga uso = new UsoDeVaga(vaga, Servico.LAVAGEM);
        
        double valorPago = uso.sair();
        
        assertEquals(20.0, valorPago, 0.01);
    }
    
    @Test
    public void testSolicitarServicoValido() {
        Vaga vaga = new Vaga(3, 1);
        UsoDeVaga uso = new UsoDeVaga(vaga, null);
        
        boolean solicitado = uso.solicitarServico(Servico.POLIMENTO);
        
        assertTrue(solicitado);
    }
    
    @Test
    public void testSolicitarServicoInvalido() {
        Vaga vaga = new Vaga(4, 1);
        UsoDeVaga uso = new UsoDeVaga(vaga, null);
        
        boolean solicitado = uso.solicitarServico(Servico.MANOBRISTA);
        
        assertFalse(solicitado);
    }
}