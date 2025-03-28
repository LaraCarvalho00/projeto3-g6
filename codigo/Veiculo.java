import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Veiculo implements IDataToText {

    String placa;
    private List<UsoDeVaga> usos;

    /**
     * Construtor para criar um Veículo com uma placa e um número máximo de usos.
     * 
     * @param placa A placa do veículo
     */
    public Veiculo(String placa) {
        this.placa = placa;
        this.usos = new ArrayList<>();
    }

    /**
     * Estaciona o veículo em uma vaga de acordo com o tipo de cliente.
     * 
     * @param vaga        A vaga onde o veículo será estacionado
     * @param tipoCliente O tipo de cliente (Mensalista, Horista, Turno)
     */
    public void estacionar(Vaga vaga, TipoCliente tipoCliente) {
        UsoDeVaga novoUso;

        // Escolhe o tipo de uso de vaga baseado no tipo de cliente
        if (tipoCliente == TipoCliente.MENSALISTA) {
            novoUso = new UsoMensalista(vaga);
        } else if (tipoCliente == TipoCliente.HORISTA) {
            novoUso = new UsoHorista(vaga);
        } else {
            novoUso = new UsoTurno(vaga, tipoCliente);
        }

        // Estaciona o veículo na vaga e associa o novo uso ao veículo
        vaga.estacionar();
        usos.add(novoUso);
    }

    public void estacionar(Vaga vaga, TipoCliente tipoCliente, LocalDateTime entrada, LocalDateTime saida) {
        UsoDeVaga novoUso;

        // Escolhe o tipo de uso de vaga baseado no tipo de cliente
        if (tipoCliente == TipoCliente.MENSALISTA) {
            novoUso = new UsoMensalista(vaga, entrada, saida);
        } else if (tipoCliente == TipoCliente.HORISTA) {
            novoUso = new UsoHorista(vaga, entrada, saida);
        } else {
            novoUso = new UsoTurno(vaga, tipoCliente, entrada, saida);
        }

        // Estaciona o veículo na vaga e associa o novo uso ao veículo
        vaga.estacionar();
        usos.add(novoUso);
    }
    /**
     * Realiza a saída do veículo do estacionamento.
     * 
     * @param tipoCliente O tipo de cliente (Mensalista, Horista, Turno)
     * @return O valor total a ser pago pelo uso da vaga durante a saída
     * @throws Exception Lança uma exceção se o veículo não estiver estacionado
     */
    public double sair(TipoCliente tipoCliente) throws Exception {
        double totalPago = 0.0;
        for (UsoDeVaga usoVaga : usos) {
            if (usoVaga != null && usoVaga.getSaida() == null) {
                if (usoVaga.getEntrada() == null) {
                    throw new Exception("Veículo não foi estacionado para poder sair.");
                }
                switch (tipoCliente) {
                    case MENSALISTA:
                        if (usoVaga instanceof UsoMensalista) {
                            totalPago += ((UsoMensalista) usoVaga).sair();
                        }
                        break;

                    case TURNO_MANHA:
                    case TURNO_TARDE:
                    case TURNO_NOITE:
                        if (usoVaga instanceof UsoTurno) {
                            totalPago += ((UsoTurno) usoVaga).sair();
                        }
                        break;

                    case HORISTA:
                        if (usoVaga instanceof UsoHorista) {
                            totalPago += ((UsoHorista) usoVaga).sair();
                        }
                        break;
                }
            }
        }
        return totalPago;
    }

    /**
     * Gera um texto contendo informações sobre os usos de vaga associados ao
     * veículo.
     *
     * @return Uma string com informações detalhadas sobre os usos de vaga do
     *         veículo
     */
    @Override
    public String dataToText() {
        StringBuilder data = new StringBuilder();
        data.append("Placa do Veículo: ").append(placa).append("\n");

        for (UsoDeVaga usoVaga : usos) {
            data.append(usoVaga.dataToText()).append("\n");
        }

        return data.toString();
    }

    /**
     * Calcula o total arrecadado pelo veículo em um determinado mês.
     *
     * @param mes O mês para o qual se deseja calcular a arrecadação (1 a 12,
     *            representando janeiro a dezembro)
     * @return O valor total arrecadado pelo veículo no mês especificado
     */
    public double arrecadadoNoMes(int mes) {
        double totalArrecadadoNoMes = 0.0;
        for (UsoDeVaga usoVaga : usos) {
            if (usoVaga != null && usoVaga.getSaida() != null) {
                LocalDateTime data = usoVaga.getSaida();
                int mesData = data.getMonthValue();
                if (data != null && mesData == mes) {
                    totalArrecadadoNoMes += usoVaga.valorPago();
                }
            }
        }
        return totalArrecadadoNoMes;
    }

    /**
     * Calcula o valor total arrecadado pelo veículo.
     *
     * @return O valor total arrecadado pelo veículo por todos os usos realizados
     */
    public double totalArrecadado() {
        double totalArrecadado = 0.0;
        for (UsoDeVaga usoVaga : usos) {
            if (usoVaga != null && usoVaga.getSaida() != null) {
                totalArrecadado += usoVaga.valorPago();
            }
        }
        return totalArrecadado;
    }

    /**
     * Retorna o número total de usos realizados pelo veículo.
     *
     * @return O número total de usos realizados pelo veículo
     */
    public int totalDeUsos() {
        return usos.size();
    }

    /**
     * Obtém a placa do veículo.
     *
     * @return A placa do veículo
     */
    public String getPlaca() {
        return placa;
    }

}
