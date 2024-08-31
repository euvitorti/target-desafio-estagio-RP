package desafioInverterString;

public class ContarLetra {

    // Método para verificar a existência de 'a' ou 'A' e contar as ocorrências
    public static int verificarEContar(String str) {
        int count = 0; // Contador de ocorrências

        // Converte a string em um array de caracteres
        char[] caracteres = str.toCharArray();

        // Itera sobre o array de caracteres
        for (char letra : caracteres) {
            // Verifica se o caractere é 'a' ou 'A'
            if (letra == 'a' || letra == 'A') {
                count++; // Incrementa o contador
            }
        }

        return count; // Retorna o número de ocorrências
    }
}
