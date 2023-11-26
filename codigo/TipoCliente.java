import java.time.LocalTime;

enum TipoCliente {
    TURNO_MANHA(LocalTime.of(8, 0), LocalTime.of(12, 0), 200),
    TURNO_TARDE(LocalTime.of(12, 1), LocalTime.of(18, 0), 200),
    TURNO_NOITE(LocalTime.of(18, 1), LocalTime.of(23, 59), 200),
    MENSALISTA(null, null, 500), 
    HORISTA(null, null, 0); 

    private final LocalTime horaInicio;
    private final LocalTime horaFim;
    private final int valor;

    TipoCliente(LocalTime horaInicio, LocalTime horaFim, int valor) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.valor = valor;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public int getValor() {
        return valor;
    }
}
