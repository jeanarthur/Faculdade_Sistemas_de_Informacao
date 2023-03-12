import java.util.HashMap;
import java.util.Map;

public class Methods {

    // Exercício 1
    public static String fillStringUntilLimit(String string, String fillerString, int limit) throws Exception {
        int stringLength = string.length();
        if (string.isBlank()) { throw new Exception("String nao pode ser vazia."); }
        if (stringLength < limit){
            int diff = limit - stringLength;
            String filler = fillerString.repeat((int)Math.ceil((double)diff / fillerString.length()));
            filler = filler.substring(0, diff);
            return filler + string;
        } else if (stringLength == limit) { return string; }
        throw new Exception("Tamanho da string e maior que o limite definido.");
    }

    // Exercício 2
    public static String convertDateToTextFormat(String date) throws Exception {
        if (date.matches("\\d{2}/\\d{2}/\\d{4}")){
            String[] dateParts = date.split("/");

            int day = Integer.parseInt(dateParts[0]);
            if ( day == 0 || day > 31) { throw new Exception("Dia informado e invalido"); }

            int month = Integer.parseInt(dateParts[1]);
            if ( month == 0 || month > 12) { throw new Exception("Mês informado e invalido"); }

            int year = Integer.parseInt(dateParts[2]);

            return String.format("%s de %s de %d", getNumberInString(day), getMonthName(month).toLowerCase(), year);

        }
        throw new Exception("Data não esta no formato especificado");
    }

    private static String getNumberInString(int number) {
        Map<Integer, String> numbersInString = new HashMap<Integer, String>();
        numbersInString.put(0, "Zero");
        numbersInString.put(1, "Um");
        numbersInString.put(2, "Dois");
        numbersInString.put(3, "Três");
        numbersInString.put(4, "Quatro");
        numbersInString.put(5, "Cinco");
        numbersInString.put(6, "Seis");
        numbersInString.put(7, "Sete");
        numbersInString.put(8, "Oito");
        numbersInString.put(9, "Nove");
        numbersInString.put(10, "Dez");
        numbersInString.put(11, "Onze");
        numbersInString.put(12, "Doze");
        numbersInString.put(13, "Treze");
        numbersInString.put(14, "Quatorze");
        numbersInString.put(15, "Quinze");
        numbersInString.put(16, "Dezesseis");
        numbersInString.put(17, "Dezessete");
        numbersInString.put(18, "Dezoito");
        numbersInString.put(19, "Dezenove");
        numbersInString.put(20, "Vinte");
        numbersInString.put(30, "Trinta");

        if (number < 21){ return numbersInString.get(number); }
        else{
            int dozens = Integer.parseInt(String.valueOf(String.valueOf(number).charAt(0))) * 10;
            int unit = Integer.parseInt(String.valueOf(String.valueOf(number).charAt(1)));
            return String.format("%s e %s", numbersInString.get(dozens), numbersInString.get(unit).toLowerCase());
        }
    }

    private static String getMonthName(int month) throws Exception {
        switch (month){
            case 1 -> { return "Janeiro"; }
            case 2 -> { return "Fevereiro"; }
            case 3 -> { return "Março"; }
            case 4 -> { return "Abril"; }
            case 5 -> { return "Maio"; }
            case 6 -> { return "Junho"; }
            case 7 -> { return "Julho"; }
            case 8 -> { return "Agosto"; }
            case 9 -> { return "Setembro"; }
            case 10 -> { return "Outubro"; }
            case 11 -> { return "Novembro"; }
            case 12 -> { return "Dezembro"; }
            default -> throw new Exception("Mês informado e invalido");
        }
    }

    // Exercício 3
    public static String upperAllVowels(String string){
        String[] vowels = {"a", "e", "i", "o", "u"};
        for (String vowel : vowels){ string = string.replaceAll(vowel, vowel.toUpperCase()); }
        return string;
    }

    // Exercício 4
    public static Boolean isValidCPF(String cpf){
        cpf = cpf.replaceAll("[.|-]", "");
        if (cpf.length() > 11) { return false; }
        if (!cpf.substring(9, 10).equals(String.valueOf(getCPFVerificationDigit(cpf, 1)))) { return false; }
        return cpf.substring(10, 11).equals(String.valueOf(getCPFVerificationDigit(cpf, 2)));
    }
    
    private static int getCPFVerificationDigit(String cpf, int digitNumber){
        int digit = 0;
        for (int i = 0; i < cpf.length() - 3 + digitNumber; i++){ digit += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (9 + digitNumber - i); }
        int rest = digit % 11;
        return (rest < 2) ? 0 : 11 - rest;
    }

    // Exercício 5
    public static int countVowels(String string){
        string = string.replaceAll("[^aeiou]", "");
        return string.length();
    }
}
