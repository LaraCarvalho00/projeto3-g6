public enum Servico {
    MANOBRISTA(5.0, 0),
    LAVAGEM(20.0, 60),
    POLIMENTO(45.0, 120);

    double Preco;
    double tempoMinimo;

    Servico(double preco, double tempoMinimo) {
        this.Preco = preco;
        this.tempoMinimo = tempoMinimo;
    }

    public double getPreco() {
        return Preco;
    }

    public double getTempoMinimo() {
        return tempoMinimo;
    }
}