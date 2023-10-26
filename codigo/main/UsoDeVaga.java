package main;
import java.time.LocalDateTime;

public class UsoDeVaga {
    private static final double FRACAO_USO = 0.25;
    private static final double VALOR_FRACAO = 4.0;
    private static final double VALOR_MAXIMO = 50.0;

    private Vaga vaga;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valorPago;
    private Servicos servicos;

    public UsoDeVaga(Vaga vaga, Servico servico) {
        this.vaga = vaga;
        this.entrada = LocalDateTime.now();
        this.servicos = servicos;
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

        valor += servicos.getValor();

        return valor;
    }

    public boolean ehDoMes(int mes) {
        return entrada.getMonthValue() == mes;
    }

    public double valorPago() {
        return valorPago;
    }
}
