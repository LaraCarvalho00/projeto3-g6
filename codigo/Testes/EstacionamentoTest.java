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
        // Certifique-se de adicionar lógica para calcular a arrecadação no método
        double totalArrecadado = estacionamento.totalArrecadado();
        assertTrue(totalArrecadado >= 0.0);
    }

    @Test
    public void testArrecadacaoNoMes() {
        // Certifique-se de adicionar lógica para calcular a arrecadação no mês no método
        double arrecadacaoNoMes = estacionamento.arrecadacaoNoMes(10); // Suponha o mês 10
        assertTrue(arrecadacaoNoMes >= 0.0);
    }

    @Test
    public void testValorMedioPorUso() {
        // Certifique-se de adicionar lógica para calcular o valor médio por uso no método
        double valorMedio = estacionamento.valorMedioPorUso();
        assertTrue(valorMedio >= 0.0);
    }

    @Test
    public void testTop5Clientes() {
        // Certifique-se de adicionar lógica para calcular os top 5 clientes no mês no método
        List<Cliente> top5 = estacionamento.top5Clientes(10); // Suponha o mês 10
        assertTrue(top5.size() <= 5);
    }
}
