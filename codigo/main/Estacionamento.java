package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Estacionamento {

    private String nome;
    private Cliente[] clientes;
    private Vaga[] vagas;
    private int quantFileiras;
    private int vagasPorFileira;
    private double totalArrecadado;

    public Estacionamento(String nome, int fileiras, int vagasPorFila) {
        int vagasTotais = vagasPorFila * vagasPorFileira;
        this.nome = nome;
        this.quantFileiras = fileiras;
        this.vagasPorFileira = vagasPorFila;
        this.clientes = new Cliente[100];
        this.vagas = new Vaga[vagasTotais];
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
        vagas = new Vaga[quantFileiras * vagasPorFileira];

        for (int i = 0; i < vagas.length; i++) {
            vagas[i] = new Vaga("Vaga " + (i + 1));
        }
    }

    public void estacionar(String placa) {
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i].estaDisponivel()) {
                Veiculo veiculo = findVeiculoByPlaca(placa);
                if (veiculo != null) {
                    veiculo.estacionar(vagas[i]);
                    totalArrecadado += veiculo.getPreco();
                    vagas[i].desocupar();
                    break;
                }
            }
        }
    }

    public void sair(String placa) {
        Veiculo veiculo = findVeiculoByPlaca(placa);
        if (veiculo != null) {
            veiculo.sair();
            totalArrecadado += veiculo.getPreco();
        }
    }

    private Veiculo findVeiculoByPlaca(String placa) {
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                List<Veiculo> veiculos = cliente.getVeiculos();
                for (Veiculo veiculo : veiculos) {
                    if (veiculo.getPlaca().equals(placa)) {
                        return veiculo;
                    }
                }
            }
        }
        return null;
    }

}