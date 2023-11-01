package main;
import java.time.LocalDateTime;
import java.util.List;

public class UsoDeVaga {
    private static final double FRACAO_USO = 0.25;
    private static final double VALOR_FRACAO = 4.0;
    private static final double VALOR_MAXIMO = 50.0;

    private Vaga vaga;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valorPago;
    private List<Servico> servicos;

    public UsoDeVaga(Vaga vaga, Servico servico) {
        this.vaga = vaga;
        this.entrada = LocalDateTime.now();
        if(servico != null){
             this.servicos.add(servico);
        }
    }

    public double sair() {
        this.saida = LocalDateTime.now();
        long minutosEstacionado = calcularMinutosEstacionado();
        double valorPago = calcularValorPago(minutosEstacionado);

        return valorPago;
    }

    private long calcularMinutosEstacionado() {
        return entrada.until(saida, java.time.temporal.ChronoUnit.MINUTES);
    }

    private double calcularValorPago(long minutosEstacionado) {
        double valor = minutosEstacionado * FRACAO_USO * VALOR_FRACAO;
        if (valor > VALOR_MAXIMO) {
            valor = VALOR_MAXIMO;
        }

        for(Servico servico : servicos){
            if(servico != null){
                valor += servico.getValor();
            }
        }

        return valor;
    }

    public boolean ehDoMes(int mes) {
        return entrada.getMonthValue() == mes;
    }

    public double valorPago() {
        return valorPago;
    }
    public boolean solicitarServico(Servico servico) {
        long minutosEstacionado = calcularMinutosEstacionado();
        if (minutosEstacionado >= servico.getTempoMinimoPermanenciaMinutos()) {
            servicos.add(servico);
            return true;
        } else {
            return false;
        }
    }
}
