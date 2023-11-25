public class Vaga {
    private String id;
    private boolean disponivel;

    public Vaga(int numero, int fila) {
        this.id = "Vaga " + numero + "fila " + fila;
        this.disponivel = true;
    }

    public boolean estacionar() {
        if (disponivel) {
            disponivel = false;
            return true; 
        } else {
            return false;
        }
    }

    public boolean sair() {
        if (!disponivel) {
            disponivel = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public String getIdentificacao() {
        return id;
    }
}

