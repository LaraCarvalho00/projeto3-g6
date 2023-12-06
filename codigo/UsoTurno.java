/**
 * Representa o uso de uma vaga de estacionamento durante um turno.
 */
public class UsoTurno extends UsoDeVaga {

    private TipoCliente tipoCliente;
    private boolean mesPago = false; // Indica se o mês está pago ou não

    public UsoTurno(Vaga vaga, TipoCliente tipoCliente) {
        super(vaga);
        this.tipoCliente = tipoCliente;
    }

    public UsoTurno(Vaga vaga, Servico servico, TipoCliente tipoCliente) {
        super(vaga, servico);
        this.tipoCliente = tipoCliente;
    }

    /**
     * Calcula o valor a ser pago pelo uso da vaga (0 se o mês já estiver pago).
     *
     * @return O valor a ser pago pelo uso durante um turno (0 se o mês já estiver pago)
     */
    @Override
    public double valorPago() {
        if (mesPago) {
            return 0; // Retorna 0 se o mês já estiver pago
        } else {
            return tipoCliente.getValor(); // Valor associado ao tipo de cliente para o uso durante um turno
        }
    }

    /**
     * Verifica se o mês está pago.
     *
     * @return true se o mês estiver pago, false caso contrário
     */
    public boolean mesEstaPago() {
        return mesPago;
    }
}
