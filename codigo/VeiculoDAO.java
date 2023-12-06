import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe responsável por manipular a persistência de objetos Veiculo em um arquivo.
 */
public class VeiculoDAO implements DAO<Veiculo> {
    private String nomeArq;       // Nome do arquivo de armazenamento
    private Scanner arqLeitura;   // Scanner para leitura do arquivo
    private FileWriter arqEscrita; // FileWriter para escrita no arquivo

    /**
     * Construtor da classe VeiculoDAO.
     *
     * @param nomeArq Nome do arquivo para armazenar os objetos Veiculo
     */
    public VeiculoDAO(String nomeArq) {
        this.nomeArq = nomeArq;
        this.arqEscrita = null;
        this.arqLeitura = null;
    }

    /**
     * Abre o arquivo para leitura.
     *
     * @throws IOException Exceção lançada caso ocorra um erro na abertura do arquivo
     */
    public void abrirLeitura() throws IOException {
        if (arqEscrita != null) {
            arqEscrita.close();
            arqEscrita = null;
        }
        arqLeitura = new Scanner(new File(nomeArq), Charset.forName("UTF-8"));
    }

    /**
     * Abre o arquivo para escrita.
     *
     * @throws IOException Exceção lançada caso ocorra um erro na abertura do arquivo
     */
    public void abrirEscrita() throws IOException {
        if (arqLeitura != null) {
            arqLeitura.close();
            arqLeitura = null;
        }
        arqEscrita = new FileWriter(nomeArq, Charset.forName("UTF-8"), true);
    }

    /**
     * Fecha os recursos de leitura e escrita.
     */
    public void fechar() {
        try {
            if (arqEscrita != null) {
                arqEscrita.close();
            }
            if (arqLeitura != null) {
                arqLeitura.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            arqEscrita = null;
            arqLeitura = null;
        }
    }

    /**
     * Obtém o próximo objeto Veiculo do arquivo.
     *
     * @return Objeto Veiculo lido do arquivo
     */
    public Veiculo getNext() {
        if (arqLeitura.hasNext()) {
            String[] linha = arqLeitura.nextLine().split(";");
            String placa = linha[0];
            return new Veiculo(placa);
        }
        return null;
    }

    /**
     * Adiciona um objeto Veiculo ao arquivo.
     *
     * @param dado Objeto Veiculo a ser adicionado
     * @throws IOException Exceção lançada caso ocorra um erro na escrita do arquivo
     */
    public void add(Veiculo dado) throws IOException {
        abrirEscrita();
        arqEscrita.append(dado.dataToText()).append("\n");
        fechar();
    }

    /**
     * Obtém todos os objetos Veiculo do arquivo.
     *
     * @return Array contendo todos os objetos Veiculo lidos do arquivo
     */
    public Veiculo[] getAll() {
        int TAM_MAX = 10000;
        int cont = 0;
        Veiculo[] dados = new Veiculo[TAM_MAX];
        try {
            fechar();
            abrirLeitura();
            while (arqLeitura.hasNext()) {
                Veiculo veiculo = this.getNext();
                if (veiculo != null) {
                    dados[cont] = veiculo;
                    cont++;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            dados = null;
        } finally {
            fechar();
        }
        dados = Arrays.copyOf(dados, cont);
        return dados;
    }

    /**
     * Adiciona vários objetos Veiculo ao arquivo.
     *
     * @param dados Array de objetos Veiculo a serem adicionados
     */
    public void addAll(Veiculo[] dados) {
        try {
            fechar();
            abrirEscrita();
            for (Veiculo veiculo : dados) {
                if (veiculo != null) {
                    arqEscrita.append(veiculo.dataToText()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fechar();
        }
    }
}
