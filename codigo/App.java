import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Carga de dados
        Estacionamento estacionamento = new Estacionamento("Estacionamento XYZ", 5, 10);

        // Clientes
        Cliente cliente1 = new Cliente("João", "C1");
        Cliente cliente2 = new Cliente("Maria", "C2");
        Cliente cliente3 = new Cliente("Pedro", "C3");
        Cliente cliente4 = new Cliente("Ana", "C4");

        // Veículos
        Veiculo veiculo1 = new Veiculo("ABC123");
        Veiculo veiculo2 = new Veiculo("XYZ789");
        Veiculo veiculo3 = new Veiculo("DEF456");
        Veiculo veiculo4 = new Veiculo("GHI789");

        cliente1.addVeiculo(veiculo1);
        cliente2.addVeiculo(veiculo2);
        cliente3.addVeiculo(veiculo3);
        cliente4.addVeiculo(veiculo4);

        estacionamento.addCliente(cliente1);
        estacionamento.addCliente(cliente2);
        estacionamento.addCliente(cliente3);
        estacionamento.addCliente(cliente4);

        estacionamento.estacionar(veiculo1.placa);
        estacionamento.estacionar(veiculo2.placa);
        estacionamento.estacionar(veiculo3.placa);
        estacionamento.estacionar(veiculo4.placa);

        veiculo1.sair();
        veiculo2.sair();
        veiculo3.sair();
        veiculo4.sair();

        // Mais operações
        estacionamento.estacionar(veiculo1.placa);
        veiculo1.sair();
        estacionamento.estacionar(veiculo2.placa);
        veiculo2.sair();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Cliente ou Administrador: C/A");
        String resposta = scanner.nextLine();

        if (resposta == "A") {
            while (true) {
                exibirMenuEstacionamento();
                int escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.println("Digite o nome do cliente:");
                        String nomeCliente = scanner.nextLine();
                        System.out.println("Digite o ID do cliente:");
                        String idCliente = scanner.nextLine();
                        Cliente novoCliente = new Cliente(nomeCliente, idCliente);
                        estacionamento.addCliente(novoCliente);
                        break;

                    case 2:
                        System.out.println("Digite o ID do cliente:");
                        String idClienteVeiculo = scanner.nextLine();
                        System.out.println("Digite a placa do veículo:");
                        String placaVeiculo = scanner.nextLine();
                        Veiculo novoVeiculo = new Veiculo(placaVeiculo);
                        estacionamento.addVeiculo(novoVeiculo, idClienteVeiculo);
                        break;

                    case 3:
                        System.out.println("Digite a placa do veículo:");
                        String placaEstacionar = scanner.nextLine();
                        estacionamento.estacionar(placaEstacionar);
                        break;

                    case 4:
                        System.out.println("Digite a placa do veículo que está saindo:");
                        String placaSair = scanner.nextLine();
                        estacionamento.sair(placaSair);
                        break;

                    case 5:
                        System.out.println("Digite o mês desejado:");
                        int mes = scanner.nextInt();
                        List<Cliente> topClientes = estacionamento.top5Clientes(mes);
                        for (Cliente cliente : topClientes) {
                            System.out.print(cliente);
                        }
                        break;

                    case 6:
                        System.out.println("Encerrando o programa.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Escolha inválida. Tente novamente.");
                }
            }
        }
        if (resposta == "C") {

            while (true) {

                System.out.println("Digite o nome do cliente:");
                String nome = scanner.nextLine();
                System.out.println("Digite o ID do cliente:");
                String id = scanner.nextLine();
                Cliente cliente = new Cliente(nome, id);

                while (true) {
                    exibirMenuCliente();
                    int escolha = scanner.nextInt();
                    scanner.nextLine();
                    switch (escolha) {
                        case 1:
                            System.out.println("Veículos do cliente:");

                            for (int i = 0; i < cliente.totalVeiculos(); i++) {
                                System.out.println(cliente.veiculos[i]);
                            }

                            break;
                        case 2:
                            System.out.println("Digite o mês para verificar a arrecadação:");
                            int mesArrecadacao = scanner.nextInt();
                            double arrecadacaoMes = cliente.arrecadadoNoMes(mesArrecadacao);
                            System.out.println(
                                    "Arrecadação do cliente no mês " + mesArrecadacao + ": " + arrecadacaoMes);
                            break;
                        case 4:
                            double arrecadacaoTotalCliente = cliente.arrecadadoTotal();
                            System.out.println("Arrecadação total do cliente: " + arrecadacaoTotalCliente);
                            break;
                        case 5:
                            // Voltar ao Menu Principal
                            break;
                        case 6:
                            System.out.println("Encerrando o programa.");
                            scanner.close();
                            System.exit(0);
                        default:
                            System.out.println("Escolha inválida. Tente novamente.");
                    }
                }
            }

        }
        else
        {
            System.out.println("Resposta invalida, digite C ou A");
        }
        scanner.close();
    }

    public static void exibirMenuEstacionamento() {
        System.out.println("==== Menu Estacionamento ====");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Veículo");
        System.out.println("3. Estacionar Veículo");
        System.out.println("4. Registrar Saída");
        System.out.println("5. Top 5 Clientes");
        System.out.println(". Sair do Programa");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirMenuCliente() {
        System.out.println("==== Menu Cliente ====");
        System.out.println("1. Verificar Veículos");
        System.out.println("2. Arrecadação no Mês");
        System.out.println("3. Arrecadação Total");
        System.out.println("4. Voltar ao Menu Principal");
        System.out.println("5. Sair do Programa");
        System.out.print("Escolha uma opção: ");
    }
}
