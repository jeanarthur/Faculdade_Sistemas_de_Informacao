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

            return String.format("%s de %s de %d", convertNumberToString(day), getMonthName(month).toLowerCase(), year);

        }
        throw new Exception("Data não esta no formato especificado");
    }

    private static String convertNumberToString(int number) throws Exception {
        if (number == 0) { return "Zero"; }
        else if (number == 1) { return "Um"; }
        else if (number == 2) { return "Dois"; }
        else if (number == 3) { return "Três"; }
        else if (number == 4) { return "Quatro"; }
        else if (number == 5) { return "Cinco"; }
        else if (number == 6) { return "Seis"; }
        else if (number == 7) { return "Sete"; }
        else if (number == 8) { return "Oito"; }
        else if (number == 9) { return "Nove"; }
        else if (number == 10) { return "Dez"; }
        else if (number == 11) { return "Onze"; }
        else if (number == 12) { return "Doze"; }
        else if (number == 13) { return "Treze"; }
        else if (number == 14) { return "Quatorze"; }
        else if (number == 15) { return "Quinze"; }
        else if (number == 16) { return "Dezesseis"; }
        else if (number == 17) { return "Dezessete"; }
        else if (number == 18) { return "Dezoito"; }
        else if (number == 19) { return "Dezenove"; }
        else if (number == 20) { return "Vinte"; }
        else {
            int unit = Integer.parseInt(String.valueOf(String.valueOf(number).charAt(1)));
            if (number < 30) { return "Vinte e " + convertNumberToString(unit).toLowerCase(); }
            else if (number == 30) { return "Trinta"; }
            else if (number < 40){ return "Trinta e " + convertNumberToString(unit).toLowerCase(); }
        }
        return "";
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
