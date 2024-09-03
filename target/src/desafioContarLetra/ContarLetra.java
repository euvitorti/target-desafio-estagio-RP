package desafioContarLetra;

import java.util.Arrays;
import java.util.List;

public class ContarLetra {

    // Método para verificar a existência de 'a' ou 'A' e contar as ocorrências
    public static int verificarFrase(String str) {

        List<Character> variantesLetra = Arrays.asList(
                'a', 'à', 'á', 'â', 'ã', 'ä', // Minúsculas
                'A', 'À', 'Á', 'Â', 'Ã', 'Ä'  // Maiúsculas
        );

        return (int) str.chars() // Converte a string em um IntStream de códigos de caracteres
                .mapToObj(c -> (char) c) // Converte cada caractere para Character
                .filter(variantesLetra::contains) // Filtra os caracteres que estão na lista de variantes
                .count(); // Conta o número de caracteres que passaram no filtro
    }

    // Outra forma
//    public static int verificarEContar(String str) {
//        int count = 0; // Contador de ocorrências
//
//        // Converte a string em um array de caracteres
//        char[] caracteres = str.toCharArray();
//
//        // Itera sobre o array de caracteres
//        for (char letra : caracteres) {
//            // Verifica se o caractere é 'a' ou 'A'
//            if (letra == 'a' || letra == 'A') {
//                count++; // Incrementa o contador
//            }
//        }
//
//        return count; // Retorna o número de ocorrências
//    }
}
