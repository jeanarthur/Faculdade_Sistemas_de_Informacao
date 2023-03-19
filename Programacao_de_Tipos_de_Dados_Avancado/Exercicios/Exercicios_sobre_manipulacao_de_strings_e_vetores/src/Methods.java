import java.util.Arrays;

public class Methods {

    public static String removeDuplicatedChars(String string) {
        for(Character c : string.toCharArray()){
            string = string.toLowerCase().replaceAll(String.format("%s{2,}", c), "#");
        }
        return string.replaceAll("#", "");
    }

    public static String duplicateVowels(String string){
        String result = "";
        for (Character c : string.toCharArray()){
            result += c.toString().matches("[aeiou]") ? c.toString().repeat(2) : c;
        }
        return result;
    }

    public static String removeOddChars(String string){
        for(Character c : string.toCharArray()){
            string = string.toLowerCase().replaceAll(String.format("[^%s]", c), "").length() % 2 != 0 ?
                    string.toLowerCase().replaceAll(c.toString().toLowerCase(), "") : string;
        }
        return string;
    }

    public static String alternateCase(String string){
        String result = "";
        for(int i = 0; i < string.length(); i++){
            result += i % 2 == 0 ? string.toLowerCase().charAt(i) : string.toUpperCase().charAt(i);
        }
        return result;
    }

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

    public static String sortChars(String string){
        char[] result = string.toCharArray();
        Arrays.sort(result);
        return Arrays.toString(result).replaceAll("[\\[\\],\\s]", "");
    }

    public static String sortWords(String string){
        String[] words = string.split("\\s");
        Arrays.sort(words);
        return Arrays.toString(words).replaceAll("\\[\\],", "");
    }

}
