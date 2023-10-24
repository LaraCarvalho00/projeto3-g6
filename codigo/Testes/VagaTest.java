package Testes;

public class VagaTest {
    public static void main(String[] args) {
        
        Vaga vaga = new Vaga("Vaga A");

        
        if (vaga.estaDisponivel()) {
            System.out.println("A vaga está disponível.");
        } else {
            System.out.println("A vaga não está disponível.");
        }

        
        boolean estacionou = vaga.estacionar();
        if (estacionou) {
            System.out.println("Carro estacionado com sucesso.");
        } else {
            System.out.println("A vaga já está ocupada.");
        }

        
        if (vaga.estaDisponivel()) {
            System.out.println("A vaga está disponível.");
        } else {
            System.out.println("A vaga não está disponível.");
        }

        
        boolean saiu = vaga.sair();
        if (saiu) {
            System.out.println("Carro retirado com sucesso.");
        } else {
            System.out.println("A vaga já está vazia.");
        }

        
        if (vaga.estaDisponivel()) {
            System.out.println("A vaga está disponível.");
        } else {
            System.out.println("A vaga não está disponível.");
        }
    }
}
