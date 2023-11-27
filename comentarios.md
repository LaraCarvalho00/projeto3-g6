# Correção

  - DAO não utilizava arquivos e, portanto, não fazia persistência
  - Teste de Vaga feito com println! 
  - No commit de 25/10, muitos erros de compilação (ex: Servicos com nome errado, Veiculo usando construtor errado)
  - Não dá feedback correto no cadastro de clientes e veículos, nem na saída de veículos
  - Preço 0 para veículo estacionado
  - Sem opção de escolher serviços
  - Main não chama CargaDados para iniciar com população de teste
  - **RUIM**: Cliente: percorre o array inteiro para salvar um veículo novo??
  - **RUIM**: Cliente: total de usos não é o tamanho do vetor de veículos
  - **RUIM**: Vaga está usando o construtor errado (não é string)
  - **RUIM**: Estacionamento tem método nulo para localizar veículo
  - **RUIM**: Estacionamento deve puxar arrecadação dos clientes
  - **RUIM**: Veículo deve verificar se está estacionado antes de sair e de entrar

## Nota base do grupo: 7,5


  - Contribuições
    - Brendon 3/❌
    - Davi 5/
    - Lara 3/❌❌
    - Larissa 3/❌❌
      - Teste não foi feito usando JUnit!
    - Otávio 5/❌
        
  - Tarefas nas aulas ao longo do projeto: 5 pontos;
    - **Todos faltaram na aula de 11/10**
    - Brendon ✔️❌
    - Davi ✔️❌
    - Lara ✔️❌
    - Larissa ➕➖❌
    - Otávio ✔️❌

- Requisitos : 7,5/12 pontos;
- Documentação: 0/3 pontos;
- Atrasos: 

   

## Requisitos

  - Cadastrar estacionamentos com número de vagas ❌
  - Veículos registrados por placa e ligados a clientes. ➕➖
  - Cliente identificado com nome e com mais de um veículo. 
  - Dados de clientes e veículos salvos e carregados. ➕➖
    - 3 estacionamentos
	- Gerar aleatoriamente 50 usos de vagas
  - Estacionar, sair e cobrança: R$4 a cada 15 minutos, com valor limite de R$50. ➕➖
  - Serviços, tempo mínimo e cobrança
  - Um cliente identificado tem acesso a seu histórico de uso do estacionamento. ❌
  - Relatórios:
    - Valor total arrecadado do estacionamento; ❌
    - Valor arrecadado em determinado mês;
    - Valor médio de cada utilização do estacionamento;
    - Ranking dos clientes que mais geraram arrecadação em um determinado mês.

