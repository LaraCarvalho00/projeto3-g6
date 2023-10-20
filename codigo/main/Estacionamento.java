package main;

public class Estacionamento {

	private String nome;
	private Cliente[] clientes;
	private Vaga[] vagas;
	private int quantFileiras;
	private int vagasPorFileira;

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
		Cliente buscando = new Cliente(idCli, idCli);
		Cliente atual = null;
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i].equals(buscando)){
				atual = clientes[i];
				break;
			}
		}
		if(atual!=null){
			atual.addVeiculo(veiculo);

		}
	}


	public void addCliente(Cliente cliente) {
		
		
	}

	private void gerarVagas() {
		
	}

	public void estacionar(String placa) {
		
	}

	public double sair(String placa) {
		
	}

	public double totalArrecadado() {
		
	}

	public double arrecadacaoNoMes(int mes) {
		
	}

	public double valorMedioPorUso() {
		
	}

	public String top5Clientes(int mes) {
		
	}

}
