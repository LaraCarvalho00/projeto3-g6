import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    private List<Veiculo> veiculos;

    public VeiculoDAO() {
        veiculos = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public Veiculo buscarPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.placa.equals(placa)) {
                return veiculo;
            }
        }
        return null; 
    }

    public void atualizarVeiculo(Veiculo input) {
        for (Veiculo veiculo : veiculos) {
           if( veiculo.placa.equals(input.placa)){
              veiculo = input; 
           }
        }
    }

    public void excluirVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }
}
