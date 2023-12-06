import java.time.LocalDateTime;


public class Estacionamento {
	private String nome;
	private Cliente[] clientes;
	private Vaga[] vagas;
	private int quantFileiras;
	private int vagasPorFileira;
	public int contCli = 0;

	/**
	 * Construtor da classe Estacionamento.
	 * 
	 * @param nome         Nome do estacionamento.
	 * @param fileiras     Número de fileiras no estacionamento.
	 * @param vagasPorFila Número de vagas por fileira no estacionamento.
	 */
	public Estacionamento(String nome, int fileiras, int vagasPorFila) {
		this.nome = nome;
		this.clientes = new Cliente[1000];
		this.vagas = new Vaga[fileiras * vagasPorFila];
		this.quantFileiras = fileiras;
		this.vagasPorFileira = vagasPorFila;
		gerarVagas();
	}

	/**
	 * Adiciona um veículo a um cliente no estacionamento.
	 * 
	 * @param veiculo Veículo a ser adicionado.
	 * @param idCli   ID do cliente ao qual o veículo será associado.
	 */
	public void addVeiculo(Veiculo veiculo, String idCli) {

		for (Cliente cliente : clientes) {
			if (cliente.id == idCli) {
				if (cliente.possuiVeiculo(veiculo.placa) == veiculo) {
					return;
				}
				cliente.addVeiculo(veiculo);
				return;
			}
		}
	}

	/**
	 * Adiciona um cliente ao estacionamento.
	 * 
	 * @param cliente Cliente a ser adicionado.
	 */
	public void addCliente(Cliente cliente) {
		this.clientes[this.contCli] = cliente;
		this.contCli++;

	}

	/**
	 * Gera as vagas do estacionamento.
	 */
	public void gerarVagas() {
		int index = 0;
		// System.out.println(this.vagas.length);
		for (int i = 0; i < this.quantFileiras; i++) {
			for (int j = 0; j < this.vagasPorFileira; j++) {
				String id = String.format("Fila%dVaga%02d", i, j);
				this.vagas[index] = new Vaga(id);

				index++;
			}
		}
	}

	/**
	 * Estaciona um veículo no estacionamento.
	 * 
	 * @param placa Placa do veículo a ser estacionado.
	 * @param time  Horário de entrada do veículo.
	 * @throws Exception
	 */
	public void estacionar(String placa, LocalDateTime time, TipoCliente tipo) throws Exception {
		boolean estacionado = false;

		for (Cliente cliente : clientes) {
			Veiculo veiculo = cliente.possuiVeiculo(placa);

			if (veiculo != null) {
				for (Vaga vaga : vagas) {
					if (vaga.getDisponivel() && !estacionado) {
						veiculo.estacionar(vaga, tipo);
						estacionado = true;
						break;
					}
				}
				if (estacionado) {
					break;
				}
			}
		}
		if (!estacionado) {
			throw new Exception("Carro ja esta estacionado");
		}
	}

	/**
	 * Remove um veículo estacionado do estacionamento.
	 * 
	 * @param placa Placa do veículo a ser removido.
	 * @param time  Horário de saída do veículo.
	 * @return double valor pago
	 * @throws Exception
	 */
	public double sair(String placa, LocalDateTime time,TipoCliente tipo) throws Exception {
		double valorPago = 0.0;
		for (Cliente cliente : clientes) {
			Veiculo veiculo = cliente.possuiVeiculo(placa);

			if (veiculo != null) {
				valorPago = veiculo.sair(tipo);
			}
		}
		if (valorPago < 0.1) {
			return valorPago;
		} else {
			throw new Exception("Veiculo nao estacionado");
		}
	}

	/**
	 * Calcula o total arrecadado pelo estacionamento.
	 * 
	 * @return Valor total arrecadado.
	 */

	public double totalArrecadado() {
		double sum = 0;
		// System.out.println(this.clientes.length);
		for (int i = 0; i < clientes.length; i++) {
			if (this.clientes[i] != null) {
				sum += this.clientes[i].arrecadadoTotal();
			}
		}
		return sum;
	}

	/**
	 * Calcula a arrecadação do estacionamento em um determinado mês.
	 * 
	 * @param mes Mês para o qual se deseja calcular a arrecadação.
	 * @return Valor arrecadado no mês.
	 */
	public double arrecadacaoNoMes(int mes) {
		double totalArrecadadoNoMes = 0.0;
		for (int i = 0; i < this.contCli; i++) {
			totalArrecadadoNoMes += this.clientes[i].arrecadadoNoMes(mes);
		}
		return totalArrecadadoNoMes;
	}

	/**
	 * Calcula o valor médio gasto por uso de vaga.
	 * 
	 * @return Valor médio por uso de vaga.
	 */
	public double valorMedioPorUso() {
		double sum = 0;
		int count = 0;
		for (int i = 0; i < this.clientes.length; i++) {
			if (this.clientes[i] != null) { // Verifica se o cliente não é nulo
				sum += (this.clientes[i].arrecadadoTotal() / this.clientes[i].totalDeUsos());
				count++;
			}
		}
		if (count > 0) {
			return sum / count; // Retorna a média apenas se houver clientes não nulos
		} else {
			return 0; // Retorna 0 se não houver clientes não nulos
		}
	}

	/**
 * Retorna os cinco principais clientes do estacionamento em um determinado mês.
 * 
 * @param mes Mês para o qual se deseja obter os principais clientes.
 * @return Lista com os dados dos cinco principais clientes no formato de texto.
 */
public String top5Clientes(int mes) {
    // Array para armazenar informações dos clientes
    String[] clienteInfo = new String[5];
    // Array para armazenar os valores arrecadados pelos clientes
    Double[] value = new Double[5];

    // Itera sobre os clientes do estacionamento
    for (int i = 0; i < this.clientes.length; i++) {
        if (this.clientes[i] != null) {
            // Calcula a arrecadação do cliente no mês especificado
            double arrecadado = this.clientes[i].arrecadadoNoMes(mes);
            // Compara com os clientes existentes para determinar os cinco principais
            for (int j = 0; j < 5; j++) {
                if (value[j] != null) {
                    if (arrecadado > value[j]) {
                        // Reorganiza os clientes em ordem decrescente de arrecadação
                        String tempInfo = clienteInfo[j];
                        double tempValue = value[j];
                        value[j] = arrecadado;
                        // Obtém as informações do cliente usando o método dataToText
                        clienteInfo[j] = this.clientes[i].dataToText();

                        // Reposiciona os clientes conforme a ordem de arrecadação
                        for (int k = j + 1; k < 5; k++) {
                            double tempValue2 = 0;
                            String temp2 = clienteInfo[k];
                            if (value[k] != null) {
                                tempValue2 = value[k];
                            }

                            clienteInfo[k] = tempInfo;
                            value[k] = tempValue;
                            tempInfo = temp2;
                            tempValue = tempValue2;
                        }
                        break;
                    }
                } else {
                    // Se o array ainda não está preenchido, adiciona o cliente atual
                    value[j] = arrecadado;
                    clienteInfo[j] = this.clientes[i].dataToText();
                    break;
                }
            }
        }
    }

    // Constrói a string com os dados dos cinco principais clientes
    StringBuilder top5 = new StringBuilder();
    for (String info : clienteInfo) {
        if (info != null) {
            top5.append(info).append(" ");
        }
    }
    return top5.toString();
}


}
