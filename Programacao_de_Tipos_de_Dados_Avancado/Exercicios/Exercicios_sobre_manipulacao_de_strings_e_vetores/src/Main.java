public class Main {
    public static void main(String[] args) {
        System.out.println(Methods.removeDuplicatedChars("Abacccaaxi"));
        System.out.println(Methods.duplicateVowels("Abacaxi"));
        System.out.println(Methods.removeOddChars("Arara"));
        System.out.println(Methods.alternateCase("Abacaxi"));
        System.out.println(Methods.groupRepeatedChars("Abacaxi"));
        System.out.println(Methods.sortChars("Abacaxi"));
        System.out.println(Methods.sortWords("Ontem de antes"));
        System.out.println(Methods.isValidCNH("58672907551") ? "CNH valida" : "CNH invalida");
        System.out.println(Methods.isValidCNH("58672907559") ? "CNH valida" : "CNH invalida");
        String[] articlesPrepositions = {"a", "ante", "após", "até", "com", "contra", "de", "desde", "em", "entre", "para", "perante", "por", "sem", "sob", "sobre", "trás", "o", "a", "os", "as", "um", "uma", "uns", "umas", "ao", "à", "aos", "às", "do", "da", "dos", "das", "no", "na", "nos", "nas", "pelo", "pela", "pelos", "pelas", "num", "numa", "nuns", "numas"};
        System.out.println(Methods.sortWordsButIgnore("O livro esta em cima da mesa", articlesPrepositions));
        System.out.println(Methods.getAllowedWords("O livro esta em cima da mesa", articlesPrepositions));
    }
}