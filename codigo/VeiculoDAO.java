import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class VeiculoDAO implements DAO<Veiculo> {
    private String nomeArq;
    private Scanner arqLeitura;
    private FileWriter arqEscrita;

    public VeiculoDAO(String nomeArq) {
        this.nomeArq = nomeArq;
        this.arqEscrita = null;
        this.arqLeitura = null;
    }

    public void abrirLeitura() throws IOException {
        if (arqEscrita != null) {
            arqEscrita.close();
            arqEscrita = null;
        }
        arqLeitura = new Scanner(new File(nomeArq), Charset.forName("UTF-8"));
    }

    public void abrirEscrita() throws IOException {
        if (arqLeitura != null) {
            arqLeitura.close();
            arqLeitura = null;
        }
        arqEscrita = new FileWriter(nomeArq, Charset.forName("UTF-8"), true);
    }

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

    public Veiculo getNext() {
        if (arqLeitura.hasNext()) {
            String[] linha = arqLeitura.nextLine().split(";");

            String placa = linha[0];
            return new Veiculo(placa, 1000);
        }
        return null;
    }

    public void add(Veiculo dado) throws IOException {
        abrirEscrita();
        arqEscrita.append(dado.dataToText() + "\n");
        fechar();
    }

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

    public void addAll(Veiculo[] dados) {
        try {
            fechar();
            abrirEscrita();
            for (Veiculo veiculo : dados) {
                if (veiculo != null) {
                    arqEscrita.append(veiculo.dataToText() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fechar();
        }
    }
}
