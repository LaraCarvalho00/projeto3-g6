public class Veiculo {

	public String placa;
	private UsoDeVaga[] usos;
	private int totalUsos;

	public Veiculo(String placa) {
		this.placa = placa;
		this.usos = new UsoDeVaga[100];
		this.totalUsos = 0;
	}

	public void estacionar(Vaga vaga) {
		UsoDeVaga novoUso = new UsoDeVaga(vaga, null);
		this.usos[totalUsos] = novoUso;
		vaga.estacionar();
		totalUsos++;
	}

	public double sair() {
		UsoDeVaga ultimo = this.usos[this.totalUsos -1];
		return ultimo.sair();		
	}

	public double totalArrecadado() {
		double total = 0;
        for (int i = 0; i < totalUsos; i++) {
            total += usos[i].valorPago();
		}
		return total;
	}

	public double arrecadadoNoMes(int mes) {
		double totalMes = 0;
        for (int i = 0; i < totalUsos; i++) {
            if (usos[i].ehDoMes(mes)) {
                totalMes += usos[i].valorPago();
			}
		}
		return totalMes;
	}

	public int totalDeUsos() {
		return totalUsos;
	}

    public Object getVagaEstacionada() {
        return null;
    }

}
