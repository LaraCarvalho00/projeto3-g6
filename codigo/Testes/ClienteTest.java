package Testes;
import org.junit.Test;
import static org.junit.Assertions.*;

public class ClienteTest {

    @Test
    public void testAddVeiculoCorreto() {
        Cliente cliente = new Cliente("Nome", "ID");
        Veiculo veiculo = new Veiculo("ABC123");

        assertEquals(0, cliente.totalVeiculos());
        cliente.addVeiculo(veiculo);
        assertEquals(1, cliente.totalVeiculos());
        assertEquals(veiculo, cliente.possuiVeiculo("ABC123"));
    }

    @Test
    public void testAddVeiculoExistente() {
        Cliente cliente = new Cliente("Nome", "ID");
        Veiculo veiculo = new Veiculo("ABC123");

        cliente.addVeiculo(veiculo); // Adiciona o veículo pela primeira vez
        assertEquals(1, cliente.totalVeiculos());

        // Tenta adicionar o mesmo veículo novamente
        cliente.addVeiculo(veiculo);
        assertEquals(1, cliente.totalVeiculos()); // Deve permanecer com 1 veículo apenas
    }

    @Test
    public void testArrecadadoPorVeiculoCorreto() {
        Cliente cliente = new Cliente("Nome", "ID");
        Veiculo veiculo = new Veiculo("ABC123");
        veiculo.estacionar(new Vaga(1, 1));
        veiculo.sair();

        cliente.addVeiculo(veiculo);

        assertEquals(0.0, cliente.arrecadadoPorVeiculo("ABC123"));
    }

    @Test
    public void testArrecadadoPorVeiculoInexistente() {
        Cliente cliente = new Cliente("Nome", "ID");
        Veiculo veiculo = new Veiculo("ABC123");
        veiculo.estacionar(new Vaga(1, 1));
        veiculo.sair();

        // Cliente não possui esse veículo
        assertEquals(0.0, cliente.arrecadadoPorVeiculo("XYZ789"));
    }

    // Outros testes para os métodos restantes da classe Cliente
}
