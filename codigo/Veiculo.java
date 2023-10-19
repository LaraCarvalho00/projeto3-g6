

public class Veiculo {

	private String placa;
	private UsoDeVaga[] usos;
	private int totalUsos;

	public Veiculo(String placa) {
		this.placa = placa;
		this.usos = new UsoDeVaga[100];
		this.totalUsos = 0;
	}

	public void estacionar(Vaga vaga) {
		UsoDeVaga novoUso = new UsoDeVaga(vaga);
		this.usos[totalUsos] = novoUso;

		totalUsos++;
	}

	public double sair() {
		return valorASerPago;		
	}

	public double totalArrecadado() {
		double total = 0;
        for (int i = 0; i < totalUsos; i++) {
            total += usos[i].getValorPago();
		}
		return total;
	}

	public double arrecadadoNoMes(int mes) {
		double totalMes = 0;
        for (int i = 0; i < totalUsos; i++) {
            if (usos[i].getMes() == mes) {
                totalMes += usos[i].getValorPago();
			}
		}
		return totalMes;
	}

	public int totalDeUsos() {
		return totalUsos;
	}

}
