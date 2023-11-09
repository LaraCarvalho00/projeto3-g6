public class HistoricoCliente {
    private String data;
    private String servico;
    private double valor;

    public HistoricoCliente(String data, String servico, double valor) {
        this.data = data;
        this.servico = servico;
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public String getServico() {
        return servico;
    }

    public double getValor() {
        return valor;
    }
}
