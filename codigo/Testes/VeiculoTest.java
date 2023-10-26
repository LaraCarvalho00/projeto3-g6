package Testes;

import org.junit.Test;

import main.Vaga;
import main.Veiculo;

import static org.junit.Assert.*;

public class VeiculoTest {

    @Test
    public void testEstacionar() {
        Veiculo veiculo = new Veiculo("ABC123");
        Vaga vaga = new Vaga("Vaga1");
    
        veiculo.estacionar(vaga);
    
        assertFalse(vaga.estaDisponivel());
    }
    

    @Test
    public void testSairTotalArrecadado() {
        Veiculo veiculo = new Veiculo("ABC123");
        Vaga vaga = new Vaga("Vaga1");
    
        veiculo.estacionar(vaga);
        double valorPago = veiculo.sair();
        double totalArrecadado = veiculo.totalArrecadado();
    
        
        assertEquals(0.0, valorPago, 0.01);
        assertEquals(0.0, totalArrecadado, 0.01);
    }
    

    @Test
public void testArrecadadoNoMes() {
    Veiculo veiculo = new Veiculo("XYZ789");
    Vaga vaga1 = new Vaga("Vaga2"); 
    Vaga vaga3 = new Vaga("Vaga3"); 

    veiculo.estacionar(vaga1);

    double arrecadadoMes1 = veiculo.arrecadadoNoMes(1); 
    assertEquals(0.0, arrecadadoMes1, 0.01); 

    veiculo.estacionar(vaga3);

    double arrecadadoMes2 = veiculo.arrecadadoNoMes(2); 
    assertEquals(0.0, arrecadadoMes2, 0.01); 
}


    @Test
    public void testTotalDeUsos() {
        Veiculo veiculo = new Veiculo("LMN456");
        Vaga vaga1 = new Vaga("Vaga4"); 
        Vaga vaga5 = new Vaga("Vaga5"); 

        veiculo.estacionar(vaga1);
        veiculo.estacionar(vaga5);

        int totalUsos = veiculo.totalDeUsos();

        assertEquals(2, totalUsos); 
    }

}
