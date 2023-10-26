import java.util.ArrayList;
import java.util.List;

import main.Cliente;

public class ClienteDAO {
    private List<Cliente> clientes;

    public ClienteDAO() {
        clientes = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarPorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null; 
    }

    public void atualizarCliente(Cliente input) {
        for (Cliente cliente : clientes) {
            if(cliente.id.equals(input.id)){
                cliente = input;
            }
        }
    }

    public void excluirCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
}
