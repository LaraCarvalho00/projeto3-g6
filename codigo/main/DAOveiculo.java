import java.util.ArrayList;
import java.util.List;

import main.Veiculo;

public class DAOveiculo {
    private List<Veiculo> veiculos;

    public DAOveiculo() {
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
           if( veiculo.equals(input)){
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
