import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class ClienteDAO implements DAO<Cliente> {
    private String nomeArq;
    private Scanner arqLeitura;
    private FileWriter arqEscrita;

    public ClienteDAO(String nomeArq) {
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

    public Cliente getNext() {
        if (arqLeitura.hasNext()) {
            String[] linha = arqLeitura.nextLine().split(";");
            String nome = linha[0].toLowerCase();
            String id = linha[1];
             return new Cliente(nome, id);
        }
       return null;
    }

    public void add(Cliente dado) throws IOException {
        abrirEscrita();
        arqEscrita.append(dado.dataToText() + "\n");
        fechar();
    }

    public Cliente[] getAll() {
        int TAM_MAX = 10000;
        int cont = 0;
        Cliente[] dados = new Cliente[TAM_MAX];
        try {
            fechar();
            abrirLeitura();
            while (arqLeitura.hasNext()) {
                Cliente cliente = this.getNext();
                if (cliente != null) {
                    dados[cont] = cliente;
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

    public void addAll(Cliente[] dados) {
        try {
            fechar();
            abrirEscrita();
            for (Cliente cliente : dados) {
                if (cliente != null) {
                    arqEscrita.append(cliente.dataToText() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fechar();
        }
    }
}
