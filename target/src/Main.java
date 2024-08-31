import desafioFibonacci.Fibonacci;
import desafioInverterString.ContarLetra;
import desafioSoma.Soma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void somar() {
        System.out.println("""
        \n------------
        Desafio Soma
        ------------
        """);

        Soma soma = new Soma();
        System.out.printf("Valor da soma: %d.\n", soma.somar());
    }

    public static void verificarNumeroFibonacci() {
        System.out.println("""
        \n---------------
        Desafio Fibonacci
        -----------------
        """);

        boolean inputValido = false;
        int numero = 0;

        while (!inputValido) {
            try {
                System.out.print("Informe um número: ");
                numero = scanner.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next();
            }
        }

        Fibonacci fibonacci = new Fibonacci();
        fibonacci.verificarNumeroFibonacci(numero);
    }

    public static void contarLetra() {
        System.out.println("""
        \n-----------------------------
        Desafio Contar Letra "A"
        -----------------------------
        """);

        System.out.print("Informe uma palavra ou um texto, como por exemplo: (Já sabemos quem vamos contratar!) 😊: ");
        String str = scanner.nextLine(); // Lê a string informada pelo usuário

        int resultado = ContarLetra.verificarEContar(str);

        // Exibe o resultado
        if (resultado > 0) {
            System.out.printf("A letra 'a' ou 'A' aparece %d vezes na string.", resultado);
        } else {
            System.out.println("A letra 'a' ou 'A' não aparece na string.");
        }
    }

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
            \n-----------------------------
            👩‍💻     Target Sistemas     👨‍💻
            -----------------------------
            1. Desafio Soma
            2. Desafio Fibonacci
            3. Desafio Contar Letra 'A'
            6. Sair
            """);

            System.out.print("Escolha uma opção: ");
            int opcao = -1;

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpar o buffer
            }

            switch (opcao) {
                case 1:
                    somar();
                    break;
                case 2:
                    verificarNumeroFibonacci();
                    break;
                case 3:
                    contarLetra();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Antes de ir... Acesse o meu portfólio: https://meuportfolio-euvitortis-projects.vercel.app/");
                    System.out.println("Saindo... Obrigado por usar o programa. 👋");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 6.");
                    break;
            }
        }

        scanner.close(); // Fecha o scanner
    }
}
