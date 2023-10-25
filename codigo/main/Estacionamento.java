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
					vagas[i].estacionar();
					break;
				}
			}
		}
	}

	private Veiculo findVeiculoByPlaca(String placa) {
		return null;
	}

	public double sair(String placa) {
		double valorASerPago = 0.0;
		Veiculo veiculo = findVeiculoByPlaca(placa);
		if (veiculo != null) {
			for (int i = 0; i < veiculo.totalDeUsos(); i++) {
				valorASerPago += veiculo.sair();
			}
		}
		return valorASerPago;
	}

	public double totalArrecadado() {
		return totalArrecadado;
	}

	public double arrecadacaoNoMes(int mes) {
		double arrecadacaoNoMes = 0.0;
		for (Cliente cliente : clientes) {
			if (cliente != null) {
				arrecadacaoNoMes += cliente.arrecadadoNoMes(mes);
			}
		}
		return arrecadacaoNoMes;
	}

	public double valorMedioPorUso() {
		double totalArrecadado = 0.0;
		int totalUsos = 0;
		for (Cliente cliente : clientes) {
			if (cliente != null) {
				totalArrecadado += cliente.arrecadadoTotal();
				totalUsos += cliente.totalDeUsos();
			}
		}
		if (totalUsos > 0) {
			return totalArrecadado / totalUsos;
		} else {
			return 0.0;
		}
	}

	public List<Cliente> top5Clientes(int mes) {
    
    List<Cliente> clientesNoMes = new ArrayList<>();
    
	for (Cliente cliente : clientes) {
            clientesNoMes.add(cliente);
    }

    clientesNoMes.sort(Comparator.comparingDouble(cliente -> cliente.arrecadadoNoMes(mes)));

    int numClientes = Math.min(5, clientesNoMes.size());
    List<Cliente> top5Clientes = new ArrayList<>();
    for (int i = 0; i < numClientes; i++) {
        top5Clientes.add(clientesNoMes.get(clientesNoMes.size() - 1 - i));
    }
	
    return top5Clientes;
}


}