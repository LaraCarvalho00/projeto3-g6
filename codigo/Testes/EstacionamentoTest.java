package Testes;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.Cliente;
import main.Estacionamento;
import main.Vaga;
import main.Veiculo;

import java.util.List;

public class EstacionamentoTest {

    private Estacionamento estacionamento;

    @Before
    public void setUp() {
        estacionamento = new Estacionamento("Meu Estacionamento", 5, 10);
    }

    @Test
    public void testAddCliente() {
        Cliente cliente = new Cliente("1", "Cliente 1");
        estacionamento.addCliente(cliente);
        assertTrue(estacionamento.getClientes().contains(cliente));
    }

    @Test
    public void testAddVeiculo() {
        Cliente cliente = new Cliente("1", "Cliente 1");
        Veiculo veiculo = new Veiculo("ABC123");
        estacionamento.addCliente(cliente);
        estacionamento.addVeiculo(veiculo, "1");
        assertTrue(cliente.getVeiculos().contains(veiculo));
    }

    @Test
    public void testEstacionar() {
        Veiculo veiculo = new Veiculo("ABC123");
        Cliente cliente = new Cliente("1", "Cliente 1");
        estacionamento.addCliente(cliente);
        estacionamento.estacionar("ABC123");
        Vaga vaga = cliente.getVeiculos().get(0).getVagaEstacionada();
        assertNotNull(vaga);
        assertFalse(vaga.estaDisponivel());
    }

    @Test
    public void testSair() {
        Veiculo veiculo = new Veiculo("ABC123");
        Cliente cliente = new Cliente("1", "Cliente 1");
        estacionamento.addCliente(cliente);
        estacionamento.estacionar("ABC123");
        double valorPago = estacionamento.sair("ABC123");
        assertTrue(valorPago >= 0.0);
    }

    @Test
    public void testTotalArrecadado() {
        double totalArrecadado = estacionamento.totalArrecadado();
        assertTrue(totalArrecadado >= 0.0);
    }

    @Test
    public void testArrecadacaoNoMes() {
        double arrecadacaoNoMes = estacionamento.arrecadacaoNoMes(10); 
        assertTrue(arrecadacaoNoMes >= 0.0);
    }

    @Test
    public void testValorMedioPorUso() {
        double valorMedio = estacionamento.valorMedioPorUso();
        assertTrue(valorMedio >= 0.0);
    }

    @Test
    public void testTop5Clientes() {
        List<Cliente> top5 = estacionamento.top5Clientes(10); 
        assertTrue(top5.size() <= 5);
    }
}
