import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ObservadorEstacionamento implements Observer {

    @Override
    public void atualizar(String top5) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Atualização no Top 5 Clientes:\n");
        mensagem.append(top5).append("\n");

        // Escrever a mensagem em um arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("top5.txt", true))) {
            writer.write("Data da atualização: " + LocalDateTime.now() + "\n");
            writer.write(mensagem.toString());
            writer.write("------------------------------------------------------\n");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        // Imprimir a mensagem no console
        System.out.println(mensagem.toString());
    }
}
