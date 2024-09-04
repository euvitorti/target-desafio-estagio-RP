package desafioContarLetra;

import java.util.Arrays;
import java.util.List;

public class ContarLetra {

    /**
     * Método para verificar a existência de variações de 'a' ou 'A' e contar suas ocorrências.
     *
     * @param str A string na qual se deseja contar as ocorrências de 'a', 'A' e suas variantes.
     * @return int - O número de ocorrências das variantes da letra 'a' ou 'A'.
     */
    public static int verificarFrase(String str) {

        // Lista de variantes da letra 'a' (minúscula) e 'A' (maiúscula), incluindo acentos.
        List<Character> variantesLetra = Arrays.asList(
                'a', 'à', 'á', 'â', 'ã', 'ä', // Minúsculas
                'A', 'À', 'Á', 'Â', 'Ã', 'Ä'  // Maiúsculas
        );

        // Converte a string em um fluxo de inteiros representando os códigos dos caracteres,
        // mapeia para objetos Character e filtra apenas aqueles que estão na lista de variantes,
        // em seguida, conta as ocorrências que passaram pelo filtro.
        return (int) str.chars() // Converte a string em um IntStream de códigos de caracteres
                .mapToObj(c -> (char) c) // Converte cada código de caractere para um Character
                .filter(variantesLetra::contains) // Filtra os caracteres que estão na lista de variantes
                .count(); // Conta o número de caracteres que passaram no filtro
    }

    // Outra forma de implementar o mesmo objetivo, mas sem uso de streams
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
