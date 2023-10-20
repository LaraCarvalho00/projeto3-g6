import org.junit.Test;

import main.Vaga;
import main.Veiculo;

import static org.junit.Assert.*;

public class VeiculoTest {

    @Test
    public void testEstacionarSairTotalArrecadado() {
        Veiculo veiculo = new Veiculo("ABC123");
        Vaga vaga = new Vaga("Vaga1"); // Suponhamos que a vaga foi criada com identificação "Vaga1" e custo de estacionamento 5.0.

        veiculo.estacionar(vaga);
        double valorPago = veiculo.sair();
        double totalArrecadado = veiculo.totalArrecadado();

        assertEquals(5.0, valorPago, 0.01); // Verifica se o valor pago é igual ao custo da vaga.
        assertEquals(5.0, totalArrecadado, 0.01); // Verifica se o total arrecadado é igual ao custo da vaga.
    }

    @Test
    public void testArrecadadoNoMes() {
        Veiculo veiculo = new Veiculo("XYZ789");
        Vaga vaga1 = new Vaga("Vaga2"); // Suponhamos que a vaga foi criada com identificação "Vaga2" e custo de estacionamento 10.0.
        Vaga vaga3 = new Vaga("Vaga3"); // Suponhamos que a vaga foi criada com identificação "Vaga3" e custo de estacionamento 15.0.

        veiculo.estacionar(vaga1);
        veiculo.estacionar(vaga3);

        // Suponhamos que os usos ocorreram em meses diferentes.
        double arrecadadoMes1 = veiculo.arrecadadoNoMes(1);
        double arrecadadoMes2 = veiculo.arrecadadoNoMes(2);

        assertEquals(10.0, arrecadadoMes1, 0.01); // Verifica o valor arrecadado no primeiro mês.
        assertEquals(15.0, arrecadadoMes2, 0.01); // Verifica o valor arrecadado no segundo mês.
    }

    @Test
    public void testTotalDeUsos() {
        Veiculo veiculo = new Veiculo("LMN456");
        Vaga vaga1 = new Vaga("Vaga4"); // Suponhamos que a vaga foi criada com identificação "Vaga4" e custo de estacionamento 8.0.
        Vaga vaga5 = new Vaga("Vaga5"); // Suponhamos que a vaga foi criada com identificação "Vaga5" e custo de estacionamento 12.0.

        veiculo.estacionar(vaga1);
        veiculo.estacionar(vaga5);

        int totalUsos = veiculo.totalDeUsos();

        assertEquals(2, totalUsos); // Verifica se o total de usos é igual a 2.
    }
}
