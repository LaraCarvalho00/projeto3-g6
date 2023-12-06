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

    /**
     * Construtor da classe ClienteDAO.
     * 
     * @param nomeArq O nome do arquivo a ser manipulado pelo DAO.
     */
    public ClienteDAO(String nomeArq) {
        this.nomeArq = nomeArq;
        this.arqEscrita = null;
        this.arqLeitura = null;
    }

    /**
     * Abre o arquivo para leitura.
     * 
     * @throws IOException Exceção lançada em caso de erro na abertura do arquivo.
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
     * @throws IOException Exceção lançada em caso de erro na abertura do arquivo.
     */
    public void abrirEscrita() throws IOException {
        if (arqLeitura != null) {
            arqLeitura.close();
            arqLeitura = null;
        }
        arqEscrita = new FileWriter(nomeArq, Charset.forName("UTF-8"), true);
    }

    /**
     * Fecha os recursos de leitura e escrita do arquivo.
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
     * Obtém o próximo registro do arquivo e cria um objeto Cliente com os dados lidos.
     * 
     * @return Um objeto Cliente lido do arquivo, ou null se não houver mais registros.
     */
    public Cliente getNext() {
        if (arqLeitura.hasNext()) {
            String[] linha = arqLeitura.nextLine().split(" ");
            String nome = linha[1].toLowerCase();
            String id = linha[0];
            String tipoClienteString = linha[2].toUpperCase();
            
            TipoCliente tipoCliente = TipoCliente.valueOf(tipoClienteString); // Converte a string para a enumeração TipoCliente
        
            return new Cliente(nome, id, tipoCliente);
        }
        return null;
    }

    /**
     * Adiciona um objeto Cliente ao arquivo.
     * 
     * @param dado O objeto Cliente a ser adicionado ao arquivo.
     * @throws IOException Exceção lançada em caso de erro na escrita do arquivo.
     */
    public void add(Cliente dado) throws IOException {
        abrirEscrita();
        arqEscrita.append(dado.dataToText() + "\n");
        fechar();
    }

    /**
     * Obtém todos os registros do arquivo e os retorna em um array de Clientes.
     * 
     * @return Um array de Clientes contendo todos os registros do arquivo.
     */
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

    /**
     * Adiciona vários objetos Cliente ao arquivo.
     * 
     * @param dados Um array de Clientes a ser adicionado ao arquivo.
     */
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
