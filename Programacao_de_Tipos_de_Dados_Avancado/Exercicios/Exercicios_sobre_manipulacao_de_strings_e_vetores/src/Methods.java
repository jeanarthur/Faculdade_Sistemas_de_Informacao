import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Methods {

    // Exercicio 1
    public static String removeDuplicatedChars(String string) {
        for(Character c : string.toCharArray()){
            string = string.toLowerCase().replaceAll(String.format("%s{2,}", c), "#");
        }
        return string.replaceAll("#", "");
    }

    // Exercicio 2
    public static String duplicateVowels(String string){
        String result = "";
        for (Character c : string.toCharArray()){
            result += c.toString().matches("[aeiou]") ? c.toString().repeat(2) : c;
        }
        return result;
    }

    // Exercicio 3
    public static String removeOddChars(String string){
        for(Character c : string.toCharArray()){
            string = string.toLowerCase().replaceAll(String.format("[^%s]", c), "").length() % 2 != 0 ?
                    string.toLowerCase().replaceAll(c.toString().toLowerCase(), "") : string;
        }
        return string;
    }

    // Exercicio 4
    public static String alternateCase(String string){
        String result = "";
        for(int i = 0; i < string.length(); i++){
            result += i % 2 == 0 ? string.toLowerCase().charAt(i) : string.toUpperCase().charAt(i);
        }
        return result;
    }

    // Exercicio 5
    public static String groupRepeatedChars(String string){
        String result = "";
        for(Character c : string.toLowerCase().toCharArray()){
            int charAmount = string.toLowerCase().replaceAll(String.format("[^%s]", c), "").length();
            if (!result.toLowerCase().contains(c.toString().toLowerCase())) {
                result += charAmount > 1?
                        String.format("(%s){%d}", c, charAmount)
                        : c;
            }
        }
        return result;
    }

    // Exercicio 6
    public static String sortChars(String string){
        char[] result = string.toCharArray();
        Arrays.sort(result);
        return Arrays.toString(result).replaceAll("[\\[\\],\\s]", "");
    }

    // Exercicio 7
    public static String sortWords(String string){
        String[] words = string.toLowerCase().split("\\s");
        Arrays.sort(words);
        return Arrays.toString(words).replaceAll("[\\[\\],]", "");
    }

    // Exercicio 8
    public static Boolean isValidCNH(String cnh){
        if (cnh.length() != 11) { return false; }

        int sum = 0;
        for (int i = 0, j = 9; i < 9;) { sum += Integer.parseInt(cnh.substring(i, ++i)) * j--; }

        int firstDigit = (sum % 11 > 9) ? 0 : sum % 11;
        if (Integer.parseInt(cnh.substring(9, 10)) != firstDigit) { return false; }

        int discount = (sum % 11 > 9) ? 2 : 0;

        sum = 0;
        for (int i = 0, j = 1; i < 9;) {
            sum += Integer.parseInt(cnh.substring(i, ++i)) * j++;
        }

        int secondDigit = (sum % 11 > 9) ? 0 : (sum % 11) - discount;
        return Integer.parseInt(cnh.substring(10, 11)) == secondDigit;
    }

    // Exercicio 9
    public static String sortWordsButIgnore(String string, String[] toIgnore){
        String[] words = string.toLowerCase().split("\\s");
        String toSort = string.toLowerCase();
        String result = "";

        for(String word : words){
            if (Arrays.asList(toIgnore).contains(word)){
                result += "\033[36m" + word + "\033[0m ";
                toSort = toSort.replaceFirst(word, "");
            } else {
                if (!result.contains("@")){ result += "@ "; }
                else { result += "# "; }
            }
        }

        words = toSort.split("\\s");
        Arrays.sort(words);
        for(String word : words){
            if (word.isBlank()) { continue; }
            result = result.replaceFirst("@", word);
            result = result.replaceFirst("#", "@");
        }

        return result;
    }

    // Exercicio 10
    public static String getAllowedWords(String string, String[] allowedWords) {
        String[] words = string.toLowerCase().split("\\s");
        String result = "";

        for (String word : words) {
            if (Arrays.asList(allowedWords).contains(word)) {
                result += word + " ";
            }
        }
        return result;
    }
}
