import java.time.LocalTime;

/**
 * Enumeração que representa os diferentes tipos de clientes e seus respectivos valores e horários.
 */
enum TipoCliente {
    TURNO_MANHA(LocalTime.of(8, 0), LocalTime.of(12, 0), 200),
    TURNO_TARDE(LocalTime.of(12, 1), LocalTime.of(18, 0), 200),
    TURNO_NOITE(LocalTime.of(18, 1), LocalTime.of(23, 59), 200),
    MENSALISTA(null, null, 500),
    HORISTA(null, null, 0);

    private final LocalTime horaInicio;
    private final LocalTime horaFim;
    private final int valor;

    /**
     * Construtor para inicializar os horários e valores de cada tipo de cliente.
     *
     * @param horaInicio Horário de início do tipo de cliente
     * @param horaFim    Horário de término do tipo de cliente
     * @param valor      Valor associado ao tipo de cliente
     */
    TipoCliente(LocalTime horaInicio, LocalTime horaFim, int valor) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.valor = valor;
    }

    /**
     * Obtém o horário de início do tipo de cliente.
     *
     * @return Horário de início
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Obtém o horário de término do tipo de cliente.
     *
     * @return Horário de término
     */
    public LocalTime getHoraFim() {
        return horaFim;
    }

    /**
     * Obtém o valor associado ao tipo de cliente.
     *
     * @return Valor do tipo de cliente
     */
    public int getValor() {
        return valor;
    }
}
