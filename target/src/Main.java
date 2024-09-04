import desafioContarLetra.ContarLetra;
import desafioFibonacci.Fibonacci;
import desafioSoma.Soma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Scanner para ler entradas do usuário
    private static final Scanner scanner = new Scanner(System.in);

    // Mensagem de erro para opções inválidas
    private static final String OPCAO_INVALIDA = "Opção inválida. Por favor, escolha uma opção válida.";

    // Menu principal exibido ao usuário
    private static final String MENU_PRINCIPAL = """
        \n-----------------------------
        👩‍💻     Target Sistemas     👨‍💻
        -----------------------------
        1. Desafio Soma
        2. Desafio Fibonacci
        3. Desafio Contar Letra 'A'
        4. Sair
        """;

    // Menu específico para o desafio de soma
    private static final String MENU_SOMA = """
        \n------------
        Desafio Soma
        ------------
        1. Somar Numero Padrão do Caso
        2. Escolher Somar Número
        """;

    /*
     Método para exibir um menu e ler a opção escolhida pelo usuário.
     Garante que a entrada seja válida e maior que 0.
    */
    private static int lerOpcao(String menu) {
        System.out.println(menu);
        while (true) {
            try {
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()
                if (opcao > 0) return opcao; // Verifica se a opção é válida (maior que 0)
                System.out.println(OPCAO_INVALIDA);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa o buffer para evitar loop infinito
            }
        }
    }

    /*
     Método para ler um número inteiro informado pelo usuário.
     Garante que a entrada seja válida.
    */
    private static int lerNumero() {
        while (true) {
            try {
                int numero = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpa o buffer para evitar loop infinito
            }
        }
    }

    /*
     Método que lida com a lógica do Desafio Soma.
     Oferece opções para somar um número padrão ou um número escolhido pelo usuário.
    */
    private static void somar() {
        int opcao = lerOpcao(MENU_SOMA); // Exibe o menu de soma e lê a opção escolhida
        Soma soma = new Soma(); // Instancia a classe Soma

        // Realiza a operação de soma conforme a opção escolhida
        int resultado = switch (opcao) {
            case 1 -> soma.somarNumeroPadrao(); // Soma usando número padrão
            case 2 -> {
                System.out.print("Informe um número para somar: ");
                yield soma.escolherSomarNumero(lerNumero()); // Soma usando o número informado pelo usuário
            }
            default -> {
                System.out.println(OPCAO_INVALIDA);
                yield 0;
            }
        };

        // Exibe o resultado se a soma foi realizada
        if (resultado != 0) System.out.printf("Valor da soma: %d.\n", resultado);
    }

    /*
     Método que lida com a lógica do Desafio Fibonacci.
     Solicita um número ao usuário e verifica se faz parte da sequência de Fibonacci.
    */
    private static void verificarNumeroFibonacci() {
        System.out.println("""
        -----------------
        Desafio Fibonacci
        -----------------""");

        // Lê o número informado pelo usuário e verifica na sequência de Fibonacci
        System.out.print("Informe um número: ");
        new Fibonacci().verificarNumeroFibonacci(lerNumero());
    }

    /*
     Método que lida com a lógica do Desafio Contar Letra 'A'.
     Conta quantas vezes a letra 'a' ou 'A' aparece em uma string fornecida pelo usuário.
    */
    private static void contarLetra() {
        System.out.println("""
        -----------------------------
        Desafio Contar Letra "A"
        -----------------------------""");

        System.out.print("Informe uma palavra ou um texto: ");
        String str = scanner.nextLine();

        int resultado = ContarLetra.verificarFrase(str);
        System.out.printf("A letra 'a' ou 'A' aparece %d vezes na string.\n", resultado);
    }

    /*
     Método principal que controla o fluxo do programa.
     Exibe o menu principal e chama os métodos correspondentes às opções escolhidas pelo usuário.
    */
    public static void main(String[] args) {
        while (true) {
            int opcao = lerOpcao(MENU_PRINCIPAL); // Exibe o menu principal e lê a opção escolhida
            switch (opcao) {
                case 1 -> somar(); // Chama o método para o Desafio Soma
                case 2 -> verificarNumeroFibonacci(); // Chama o método para o Desafio Fibonacci
                case 3 -> contarLetra(); // Chama o método para o Desafio Contar Letra 'A'
                case 4 -> { // Sai do programa
                    System.out.println("""
                    #QueroSerTargetiano 👨‍💻
                    Antes de ir... Acesse o meu portfólio: https://meuportfolio-euvitortis-projects.vercel.app/
                    Saindo... Obrigado por usar o programa. 👋""");
                    scanner.close();
                    return;
                }
                default -> System.out.println(OPCAO_INVALIDA);
            }
        }
    }
}
