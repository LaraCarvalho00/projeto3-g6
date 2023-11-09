import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //Carga de dados
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

        while (true) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine();  

            switch (escolha) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID do cliente: ");
                    String id = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, id);
                    estacionamento.addCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso.");
                    break;
                case 2:
                    System.out.print("Placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("ID do cliente: ");
                    String idCli = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(placa);
                    estacionamento.addVeiculo(veiculo, idCli);
                    System.out.println("Veículo cadastrado com sucesso.");
                    break;
                case 3:
                    System.out.print("Placa do veículo: ");
                    placa = scanner.nextLine();
                    estacionamento.estacionar(placa);
                    System.out.println("Veículo estacionado com sucesso.");
                    break;
                case 4:
                    System.out.print("Placa do veículo: ");
                    placa = scanner.nextLine();
                    double valorASerPago = estacionamento.sair(placa);
                    System.out.println("Valor a ser pago: R$" + valorASerPago);
                    break;
                case 5:
                    System.out.print("Mês para calcular arrecadação: ");
                    int mes = scanner.nextInt();
                    double arrecadacaoNoMes = estacionamento.arrecadacaoNoMes(mes);
                    System.out.println("Arrecadação no mês " + mes + ": R$" + arrecadacaoNoMes);
                    break;
                case 6:
                    double valorMedioPorUso = estacionamento.valorMedioPorUso();
                    System.out.println("Valor médio por uso: R$" + valorMedioPorUso);
                    break;
                case 7:
                    System.out.print("Mês para calcular top 5 clientes: ");
                    mes = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Top 5 clientes no mês " + mes + ":");
                    for (Cliente client : estacionamento.top5Clientes(mes)) {
                        System.out.println(client.getId() + " - Arrecadação: R$" + client.arrecadadoNoMes(mes));
                    }
                    break;
                case 8:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("==== Menu ====");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Veículo");
        System.out.println("3. Estacionar Veículo");
        System.out.println("4. Registrar Saída");
        System.out.println("5. Arrecadação no Mês");
        System.out.println("6. Valor Médio por Uso");
        System.out.println("7. Top 5 Clientes");
        System.out.println("8. Sair do Programa");
        System.out.print("Escolha uma opção: ");
    }
}
