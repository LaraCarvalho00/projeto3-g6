import java.util.List;

import main.Cliente;
import main.Estacionamento;
import main.Veiculo;

public class CargaDados {

    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento("Estacionamento XYZ", 5, 10);

        // Clientes
        Cliente cliente1 = new Cliente("João", "C1");
        Cliente cliente2 = new Cliente("Maria", "C2");
        Cliente cliente3 = new Cliente("Pedro", "C3");
        Cliente cliente4 = new Cliente("Ana", "C4");

        // Veículos
        Veiculo veiculo1 = new Veiculo("ABC123");
        Veiculo veiculo2 = new Veiculo("XYZ789");
        Veiculo veiculo3 = new Veiculo("DEF456");
        Veiculo veiculo4 = new Veiculo("GHI789");

        cliente1.addVeiculo(veiculo1);
        cliente2.addVeiculo(veiculo2);
        cliente3.addVeiculo(veiculo3);
        cliente4.addVeiculo(veiculo4);

        estacionamento.addCliente(cliente1);
        estacionamento.addCliente(cliente2);
        estacionamento.addCliente(cliente3);
        estacionamento.addCliente(cliente4);

        estacionamento.estacionar(veiculo1.placa);
        estacionamento.estacionar(veiculo2.placa);
        estacionamento.estacionar(veiculo3.placa);
        estacionamento.estacionar(veiculo4.placa);

        veiculo1.sair();
        veiculo2.sair();
        veiculo3.sair();
        veiculo4.sair();

        // Mais operações
        estacionamento.estacionar(veiculo1.placa);
        veiculo1.sair();
        estacionamento.estacionar(veiculo2.placa);
        veiculo2.sair();

        double arrecadacaoTotal = estacionamento.totalArrecadado();
        double arrecadacaoNoMes = estacionamento.arrecadacaoNoMes(10);
        double valorMedioPorUso = estacionamento.valorMedioPorUso();
        List<Cliente> topClientes = estacionamento.top5Clientes(10);

        System.out.println("Arrecadação total: " + arrecadacaoTotal);
        System.out.println("Arrecadação no mês 10: " + arrecadacaoNoMes);
        System.out.println("Valor médio por uso: " + valorMedioPorUso);
        System.out.println("Top 5 clientes no mês 10:");
        for (Cliente cliente : topClientes) {
            System.out.println(cliente.getId() + " - Arrecadação: " + cliente.arrecadadoNoMes(10));
        }
    }
}
