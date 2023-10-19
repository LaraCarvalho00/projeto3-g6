public enum Servicos {
    MANOBRISTA(5.0, 0),
    LAVAGEM(20.0, 60),
    POLIMENTO(45.0, 120);

    private final double valor;
    private final int tempoMinimoPermanenciaMinutos;

    Servicos(double valor, int tempoMinimoPermanenciaMinutos) {
        this.valor = valor;
        this.tempoMinimoPermanenciaMinutos = tempoMinimoPermanenciaMinutos;
    }

    public double getValor() {
        return valor;
    }

    public int getTempoMinimoPermanenciaMinutos() {
        return tempoMinimoPermanenciaMinutos;
    }
}
