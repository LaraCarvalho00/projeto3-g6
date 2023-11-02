package main;


public class Vaga {
    private int identificacao;
    private boolean disponivel;

    public Vaga(int identificacao) {
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

    public int getIdentificacao() {
        return identificacao;
    }
}
