import desafioContarLetra.ContarLetra;
import desafioFibonacci.Fibonacci;
import desafioSoma.Soma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    // Mensagens e opções usadas em múltiplos lugares
    private static final String MENU_PRINCIPAL = """
        \n-----------------------------
        👩‍💻     Target Sistemas     👨‍💻
        -----------------------------
        1. Desafio Soma
        2. Desafio Fibonacci
        3. Desafio Contar Letra 'A'
        4. Sair
        """;

    private static final String MENU_SOMA = """
        \n------------
        Desafio Soma
        ------------
        1. Somar Numero Padrão do Caso
        2. Escolher Somar Número
        """;

    private static final String OPCAO_INVALIDA = "Opção inválida. Por favor, escolha uma opção válida.";

    private static int lerOpcao(String menu) {
        int opcao = 0;
        boolean inputValido = false;

        // Exibe o menu e lê a opção escolhida pelo usuário
        System.out.println(menu);
        while (!inputValido) {
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

                if (opcao > 0) {
                    inputValido = true; // Se a opção for válida, sai do loop
                } else {
                    System.out.println(OPCAO_INVALIDA);
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpar o buffer para evitar loop infinito
            }
        }

        return opcao;
    }

    private static void somar() {
        int opcao = lerOpcao(MENU_SOMA);
        Soma soma = new Soma(); // Cria uma instância da classe Soma
        int resultado;

        switch (opcao) {
            case 1:
                resultado = soma.somarNumeroPadrao(); // Soma os números padrão
                System.out.printf("Valor da soma com número padrão: %d.\n", resultado);
                break;
            case 2:
                try {
                    System.out.print("Informe um número para somar: ");
                    int numero = scanner.nextInt(); // Lê o número informado pelo usuário
                    resultado = soma.escolherSomarNumero(numero); // Soma o número informado
                    System.out.printf("Valor da soma com número informado: %d.\n", resultado);
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Somente números inteiros são permitidos.");
                    scanner.next(); // Limpar o buffer para evitar problemas
                }
                break;
            default:
                System.out.println(OPCAO_INVALIDA);
                break;
        }
    }

    private static void verificarNumeroFibonacci() {
        System.out.println("""
        \n---------------
        Desafio Fibonacci
        -----------------
        """);

        boolean inputValido = false; // Variável para controlar se a entrada é válida
        int numero = 0;

        while (!inputValido) {
            try {
                System.out.print("Informe um número: ");
                numero = scanner.nextInt(); // Lê o número informado pelo usuário
                inputValido = true; // Marca a entrada como válida se não houver exceção
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpa o buffer do scanner para evitar loop infinito
            }
        }

        Fibonacci fibonacci = new Fibonacci(); // Cria uma instância da classe Fibonacci
        fibonacci.verificarNumeroFibonacci(numero); // Verifica se o número faz parte da sequência de Fibonacci
    }

    private static void contarLetra() {
        System.out.println("""
        \n-----------------------------
        Desafio Contar Letra "A"
        -----------------------------
        """);

        System.out.print("Informe uma palavra ou um texto, como por exemplo: (Já sabemos quem vamos contratar!) 😊: ");
        String str = scanner.nextLine(); // Lê a string informada pelo usuário

        int resultado = ContarLetra.verificarFrase(str); // Chama o método para contar a letra 'a'

        // Exibe o resultado
        if (resultado > 0) {
            System.out.printf("A letra 'a' ou 'A' aparece %d vezes na string.\n", resultado);
        } else {
            System.out.println("A letra 'a' ou 'A' não aparece na string.");
        }
    }

    public static void main(String[] args) {
        boolean continuar = true; // Controle para manter o loop do menu ativo

        // Loop do menu principal
        while (continuar) {
            int opcao = lerOpcao(MENU_PRINCIPAL);

            switch (opcao) {
                case 1:
                    somar(); // Chama o método de soma
                    break;
                case 2:
                    verificarNumeroFibonacci(); // Chama o método de verificação Fibonacci
                    break;
                case 3:
                    contarLetra(); // Chama o método de contagem de letras
                    break;
                case 4:
                    continuar = false; // Sinaliza para sair do loop e encerrar o programa
                    System.out.println("""
                            
                            #QueroSerTargetiano 👨‍💻
                            
                            Antes de ir... Acesse o meu portfólio: https://meuportfolio-euvitortis-projects.vercel.app/
                            
                            Saindo... Obrigado por usar o programa. 👋
                            """);
                    break;
                default:
                    System.out.println(OPCAO_INVALIDA);
                    break;
            }
        }

        scanner.close(); // Fecha o scanner para liberar recursos
    }
}
