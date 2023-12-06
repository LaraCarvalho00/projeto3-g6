import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe que representa uma vaga no estacionamento.
 */
public class Vaga {
    private String id;           // Identificação única da vaga
    private boolean disponivel;  // Indica se a vaga está disponível

    /**
     * Construtor para criar uma Vaga com uma identificação única.
     *
     * @param id Identificação única da vaga
     */
    public Vaga(String id) {
        this.id = id;
        this.disponivel = true;  // Inicialmente, a vaga está disponível
    }

    /**
     * Obtém a identificação da vaga.
     *
     * @return Identificação da vaga
     */
    public String getId() {
        return this.id;
    }

    /**
     * Obtém a disponibilidade da vaga.
     *
     * @return true se a vaga está disponível, false caso contrário
     */
    public boolean getDisponivel() {
        return this.disponivel;
    }

    /**
     * Configura a disponibilidade da vaga.
     *
     * @param disponivel true para marcar a vaga como disponível, false para ocupada
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Estaciona um veículo na vaga.
     *
     * @return true se o veículo foi estacionado com sucesso, false se a vaga já estiver ocupada
     */
    public boolean estacionar() {
        if (disponivel) {
            this.disponivel = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Libera a vaga, indicando que o veículo saiu.
     *
     * @return true se a vaga foi liberada com sucesso, false se a vaga já estiver livre
     */
    public boolean sair() {
        if (!disponivel) {
            this.disponivel = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Escreve informações da vaga em um arquivo.
     *
     * @param estacionamento Identificador do estacionamento
     */
    public void escreverArquivo(String estacionamento) {
        try {
            FileWriter fileWriter = new FileWriter("vaga.txt", true);
            fileWriter.write(estacionamento + "," + this.id + "," + this.disponivel + ";");
            System.out.println("Escrito uma vaga no arquivo.");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Configura a identificação da vaga.
     *
     * @param id Identificação da vaga
     */
    public void setId(String id) {
        this.id = id;
    }
}
