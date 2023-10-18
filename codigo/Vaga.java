

public class Vaga {
    private String identificacao;
    private boolean disponivel;

    public Vaga(String identificacao) {
        this.identificacao = identificacao;
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
        return identificacao;
    }
}
