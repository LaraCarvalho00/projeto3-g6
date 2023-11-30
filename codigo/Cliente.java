import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Cliente implements IDataToText {

    private String nome;
    private String id;
    private Veiculo[] veiculos = new Veiculo[10];
    private int mensalista;
    private LocalDate dateMensalista;
    private TipoCliente tipoCliente;

    // Construtor da classe Cliente
    public Cliente(String nome, String id, TipoCliente tipoCliente, LocalDate dateMensalista) {
        this.nome = nome;
        this.id = id;
        this.dateMensalista = dateMensalista;
        this.tipoCliente = tipoCliente;
    }

    // Método para escrever informações do cliente em um arquivo
    public void escreverArquivo(String estacionamento) {
        try {
            FileWriter fileWriter = new FileWriter("cliente.txt", true);
            fileWriter.write(estacionamento + "," + this.nome + "," + this.id + "," + this.tipoCliente + ","
                    + this.dateMensalista + ";");

            for (Veiculo veiculo : veiculos) {
                if (veiculo != null)
                    veiculo.escreverArquivo(this.id, estacionamento);
            }

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para adicionar um veículo ao cliente
    public void addVeiculo(Veiculo veiculo) {
        if (veiculos != null) {
            for (int i = 0; i < veiculos.length; i++) {
                if (veiculos[i] == null) {
                    veiculos[i] = veiculo;
                    break;
                }
            }
        } else {
            veiculos[0] = veiculo;
        }
    }

    // Método para verificar se o cliente possui um veículo com uma determinada placa
    public Veiculo possuiVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null && veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    // Método para calcular o total de usos de veículos pelo cliente
    public int totalDeUsos() {
        int totalUsos = 0;
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                totalUsos += veiculo.totalDeUsos();
            }
        }
        return totalUsos;
    }

    // Método para calcular a arrecadação total do cliente
    public double arrecadadoTotal() {
        double totalArrecadado = 0;
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                totalArrecadado += veiculo.totalArrecadado();
            }
        }
        int count = -1;
        LocalDate momentoAtual = LocalDate.now();
        if (this.dateMensalista != null) {
            long mes = 0;
            mes = Period.between(momentoAtual, this.dateMensalista).getMonths();
            do {
                totalArrecadado += this.tipoCliente.getValor();
                count++;
            } while (count < mes);
        }

        return totalArrecadado;
    }

    // Método para calcular a arrecadação do cliente em um determinado mês
    public double arrecadadoNoMes(int mes) {
        double arrecadadoNoMes = 0;
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                arrecadadoNoMes += veiculo.arrecadadoNoMes(mes);
            }
        }

        if (this.dateMensalista != null && mes >= this.dateMensalista.getMonthValue()) {
            arrecadadoNoMes += this.tipoCliente.getValor();
        }

        return arrecadadoNoMes;
    }

    // Getter para o campo nome
    public String getNome() {
        return nome;
    }

    // Setter para o campo nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o campo id
    public String getId() {
        return id;
    }

    // Setter para o campo id
    public void setId(String id) {
        this.id = id;
    }

    // Getter para o campo veiculos
    public Veiculo[] getVeiculos() {
        return veiculos;
    }

    // Setter para o campo veiculos
    public void setVeiculos(Veiculo[] veiculos) {
        this.veiculos = veiculos;
    }

    // Getter para o tipo de cliente
    public TipoCliente getTipoCliente() {
        return this.tipoCliente;
    }

    // Setter para o tipo de cliente
    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    // Getter para a data do mensalista
    public LocalDate getDateMensalista() {
        return this.dateMensalista;
    }

    // Setter para a data do mensalista
    public void setDateMensalista(LocalDate dateMensalista) {
        this.dateMensalista = dateMensalista;
    }

    @Override
	public String dataToText() {
		return id + ";" + nome;
	}
	@Override
   	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente:\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Veículos: ").append(veiculos.length).append("\n");
        sb.append("Arrecadação Total: ").append(arrecadadoTotal()).append("\n");
        return sb.toString();
    }
}