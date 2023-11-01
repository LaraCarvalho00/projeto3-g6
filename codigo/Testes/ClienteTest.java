package Testes;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import main.Cliente;
import main.Vaga;
import main.Veiculo;
import main.UsoDeVaga;

public class ClienteTest {
    private Cliente cliente;
    private Veiculo veiculo1;
    private Veiculo veiculo2;
    private Vaga vaga1;
    private Vaga vaga2;

    @Before
    public void setUp() {
        cliente = new Cliente("John Doe", "123456789");
        veiculo1 = new Veiculo("ABC123");
        veiculo2 = new Veiculo("XYZ789");
        vaga1 = new Vaga("A1");
        vaga2 = new Vaga("B1");
    }

    @Test
    public void testAddVeiculo() {
        cliente.addVeiculo(veiculo1);
        cliente.addVeiculo(veiculo2);

        assertEquals(2, cliente.totalDeUsos());
    }

    @Test
    public void testArrecadadoPorVeiculo() {
        cliente.addVeiculo(veiculo1);
        vaga1.estacionar();
        vaga1.sair();

        UsoDeVaga usoDeVaga1 = new UsoDeVaga(vaga1);
        double valorPago = usoDeVaga1.sair();

        assertEquals(valorPago, cliente.arrecadadoPorVeiculo("A1"), 0.01);
    }

    @Test
    public void testArrecadadoNoMes() {
        cliente.addVeiculo(veiculo1);
        cliente.addVeiculo(veiculo2);
      
        vaga1.estacionar();
        vaga1.sair();

        vaga2.estacionar();
        vaga2.sair();

        
        UsoDeVaga usoDeVaga1 = new UsoDeVaga(vaga1);
        UsoDeVaga usoDeVaga2 = new UsoDeVaga(vaga2);
        assertEquals(usoDeVaga1.valorPago() + usoDeVaga2.valorPago(), cliente.arrecadadoNoMes(1), 0.01);
    }

    @Test
    public void testArrecadadoTotal() {
        cliente.addVeiculo(veiculo1);
        cliente.addVeiculo(veiculo2);

        vaga1.estacionar();
        vaga1.sair();

        vaga2.estacionar();
        vaga2.sair();

        UsoDeVaga usoDeVaga1 = new UsoDeVaga(vaga1);
        UsoDeVaga usoDeVaga2 = new UsoDeVaga(vaga2);
        assertEquals(usoDeVaga1.valorPago() + usoDeVaga2.valorPago(), cliente.arrecadadoTotal(), 0.01);
    }
}
