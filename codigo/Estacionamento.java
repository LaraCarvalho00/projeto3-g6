import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Estacionamento {

    private String nome;
    private Cliente[] clientes;
    private Vaga[][] vagas;
    private int quantFileiras;
    private int vagasPorFileira;
    private double totalArrecadado;

    public Estacionamento(String nome, int fileiras, int vagasPorFila) {
        this.nome = nome;
        this.quantFileiras = fileiras;
        this.vagasPorFileira = vagasPorFila;
        this.clientes = new Cliente[100];
        this.vagas = new Vaga[fileiras][vagasPorFila];
        this.totalArrecadado = 0.0;
        gerarVagas();
    }

    public void addVeiculo(Veiculo veiculo, String idCli) {
        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getId().equals(idCli)) {
                cliente.addVeiculo(veiculo);
            }
        }
    }

    public void addCliente(Cliente cliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = cliente;
                break;
            }
        }
    }

    private void gerarVagas() {
        for (int i = 0; i < quantFileiras; i++) {
            for (int j = 0; i < vagasPorFileira; i++)
                vagas[i][j] = new Vaga(i, j);
        }
    }

    public void estacionar(String placa) {
        for (int i = 0; i < vagas.length; i++) {
            for (int j = 0; j < clientes.length; j++) {
                if (vagas[i][j].estaDisponivel() == true) {
                    Veiculo veiculo = findVeiculoByPlaca(placa);
                    if (veiculo != null) {
                        veiculo.estacionar(vagas[i][j]);
                        break;
                    }
                }
            }

        }
    }

    public void sair(String placa) {
        Veiculo veiculo = findVeiculoByPlaca(placa);
        if (veiculo != null) {
            totalArrecadado += veiculo.sair();
        }
    }

    public List<Cliente> top5Clientes(int mes) {
        PriorityQueue<Cliente> topClientes = new PriorityQueue<>(5,
                Comparator.comparingDouble(cliente -> -cliente.arrecadadoNoMes(mes)));

        for (Cliente cliente : clientes) {
            topClientes.offer(cliente);

            if (topClientes.size() > 5) {
                topClientes.poll();
            }
        }

        List<Cliente> top5Clientes = new ArrayList<>(topClientes);
        top5Clientes.sort(Comparator.comparingDouble(cliente -> -cliente.arrecadadoNoMes(mes)));

        return top5Clientes;
    }

    private Veiculo findVeiculoByPlaca(String placa) {
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                Veiculo[] veiculos = cliente.veiculos;
                for (Veiculo veiculo : veiculos) {
                    if (veiculo.placa.equals(placa)) {
                        return veiculo;
                    }
                }
            }
        }
        return null;
    }

    public double GetArrecadacao() {
        return totalArrecadado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estacionamento: ").append(nome).append("\n");
        sb.append("Quantidade de Fileiras: ").append(quantFileiras).append("\n");
        sb.append("Vagas por Fileira: ").append(vagasPorFileira).append("\n");
        sb.append("Total Arrecadado: ").append(totalArrecadado).append("\n");

        sb.append("Clientes:\n");
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                sb.append(cliente.toString()).append("\n");
            }
        }

        sb.append("Vagas:\n");
        for (Vaga[] fila : vagas) {
            sb.append(Arrays.toString(fila)).append("\n");
        }

        return sb.toString();
    }

}