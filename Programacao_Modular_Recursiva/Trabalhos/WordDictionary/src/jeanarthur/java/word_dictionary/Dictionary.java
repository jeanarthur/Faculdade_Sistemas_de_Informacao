package jeanarthur.java.word_dictionary;

import jeanarthur.java.util.Action;
import jeanarthur.java.util.Menu;
import jeanarthur.java.util.Setting;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static jeanarthur.java.util.ArrayOperation.getFreeSpaceIndex;
import static jeanarthur.java.util.ArrayOperation.getNotNullValues;
import static jeanarthur.java.util.InputOperation.requestInput;
import static jeanarthur.java.util.InputOperation.requestNonDuplicateInputConsidering;

public class Dictionary {

    private static final String[] wordsPrimaryLanguage = new String[100];
    private static final String[] wordsSecondaryLanguage = new String[100];
    private static final String[][] dictionary = {wordsPrimaryLanguage, wordsSecondaryLanguage};
    static int wordListIndex = 0;
    public static Map<String, Consumer<String>> actionsInList = new HashMap<>();
    private static String currentActionInList;

    public static void register(){
        register(
            requestNonDuplicateInputConsidering(dictionary[0], String.format("| Digite a palavra (%s): ", Setting.get("primaryLanguage").getCurrentState())),
            requestNonDuplicateInputConsidering(dictionary[1], String.format("| Digite a palavra (%s): ", Setting.get("secondaryLanguage").getCurrentState()))
        );
    }

    public static void register(String word1, String word2){
        int freeIndex = getFreeSpaceIndex(dictionary[0]);
        try{
            if (freeIndex == -1) { throw Exception.wordLimitReached; }
            dictionary[0][freeIndex] = word1;
            dictionary[1][freeIndex] = word2;
        } catch (RuntimeException runtimeException){
            if (runtimeException.getMessage().equals(Exception.wordLimitReached.getMessage())){ throw Exception.wordLimitReached; }
            if (freeIndex != -1) {
                dictionary[0][freeIndex] = null;
                dictionary[1][freeIndex] = null;
            }
            throw Exception.wordNotFound;
        }
    }

    public static void consult(){
        consult(requestInput("| Consultar: "));
    }

    public static void consult(String word){
        try {
            int index = getIndexOf(word);
            updateConsultedWordMenu(new String[]{dictionary[0][index], dictionary[1][index]});
        } catch (NullPointerException nullPointerException){
            throw Exception.generic(nullPointerException.getMessage());
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            throw Exception.wordNotFound;
        }
    }

    public static void delete(){
        delete(requestInput("| Excluir: "));
    }

    public static void delete(String word){
        try{
            int index = getIndexOf(word);
            System.out.printf("| Palavra '%s' -> '%s' foi excluída!\n", dictionary[0][index], dictionary[1][index]);
            dictionary[0][index] = null;
            dictionary[1][index] = null;
            updateConsultedWordMenu(new String[]{dictionary[0][index], dictionary[1][index]});
        } catch (NullPointerException nullPointerException){
            throw Exception.generic(nullPointerException.getMessage());
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            throw Exception.wordNotFound;
        }
    }

    public static void edit(){
        edit(requestInput("| Editar: "));
    }

    public static void edit(String word){
        try{
            String[] activeLanguageWords = dictionary[Setting.get("activeLanguage").getStateValue()];
            int index = getIndexOf(word);
            activeLanguageWords[index] = requestNonDuplicateInputConsidering(activeLanguageWords, String.format("| Alterar '%s'(%s) para: ", activeLanguageWords[index], Setting.get("activeLanguage").getCurrentState()));
            updateConsultedWordMenu(new String[]{dictionary[0][index], dictionary[1][index]});
        } catch (NullPointerException nullPointerException){
            throw Exception.generic(nullPointerException.getMessage());
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            throw Exception.wordNotFound;
        }
    }

    private static int getIndexOf(String word){
        int index = -1;
        String[] activeLanguageWords = dictionary[Setting.get("activeLanguage").getStateValue()];
        for (int i = 0; i < activeLanguageWords.length; i++){
            if (activeLanguageWords[i] != null && activeLanguageWords[i].equals(word)){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void registerActionsInList(){
        actionsInList.put("consult", consultFromList);
        actionsInList.put("edit", editFromList);
        actionsInList.put("delete", deleteFromList);
    }

    static void updateList(Consumer<String> actionInList){
        String[] registeredWords = getNotNullValues(dictionary[Setting.get("activeLanguage").getStateValue()]);
        Menu wordList = Menu.get("wordList");
        wordList.clear();
        int wordCount = 0;
        for (int i = wordListIndex; i < registeredWords.length; i++){
            wordList.add(new Action(registeredWords[i], actionInList, registeredWords[i]), String.valueOf(i + 1));
            if (++wordCount == 5){ break; }
        }
        wordList.addSeparator();
        if (wordListIndex > 0){ wordList.add(new Action("Anterior", previousInList), "a"); }
        if (wordListIndex + 5 < registeredWords.length){ wordList.add(new Action("Próximo", nextInList, registeredWords), "p"); }
        wordList.add(new Action("Voltar", Menu.exit), "v");
    }

    static void updateConsultedWordMenu(String[] words){
        Menu consulted = Menu.get("consultedWord");
        consulted.clear();
        consulted.add(String.format("%s: %s\n", Setting.get("primaryLanguage").getCurrentState(), words[0]));
        consulted.add(String.format("%s: %s\n", Setting.get("secondaryLanguage").getCurrentState(), words[1]));
        consulted.addSeparator();
        consulted.add(new Action("Editar", Dictionary.editFromList, words[Setting.get("activeLanguage").getStateValue()]), "a");
        consulted.add(new Action("Excluir", Dictionary.deleteFromConsult, words[Setting.get("activeLanguage").getStateValue()]), "b");
        consulted.add(new Action("Voltar", Menu.exit), "v");
    }

    static void updateGenericActionMenu(String title, Runnable action){
        Menu.put("genericAction", new Menu(title));
        Setting.put("activeLanguage", new Setting("Pesquisar/Listar em", Setting.get("primaryLanguage").getCurrentState(), Setting.get("secondaryLanguage").getCurrentState()));
        Menu generic = Menu.get("genericAction");
        generic.add(new Action("Pesquisar", action));
        generic.add(new Action("Listar", Dictionary.list));
        generic.addSeparator();
        generic.add(Setting.get("activeLanguage"));
        generic.addSeparator();
        generic.add(new Action("Voltar", Menu.exit), "v");
        generic.open();
    }

    public static void start(){
        registerActionsInList();
        Menu.get("instructions").open();
        Menu.get("main").open();
    }

    static Runnable register = Dictionary::register;

    static Runnable search = () -> {
        consult();
        Menu.get("consultedWord").open();
    };

    static Runnable consult = () -> {
        currentActionInList = "consult";
        updateGenericActionMenu("Consultar", search);
    };
    
    static Runnable edit = () -> {
        currentActionInList = "edit";
        updateGenericActionMenu("Editar", Dictionary::edit);
    };
    static Runnable delete = () -> {
        currentActionInList = "delete";
        updateGenericActionMenu("Excluir", Dictionary::delete);
    };

    static Consumer<String> consultFromList = (String word) -> {
        Dictionary.consult(word);
        updateList(actionsInList.get(currentActionInList));
        Menu.get("consultedWord").open();
    };

    static Consumer<String> editFromList = (String word) -> {
        Dictionary.edit(word);
        updateList(actionsInList.get(currentActionInList));
    };

    static Consumer<String> deleteFromList = (String word) -> {
        Dictionary.delete(word);
        updateList(actionsInList.get(currentActionInList));
    };

    static Consumer<String> deleteFromConsult = (String word) -> {
        Dictionary.delete(word);
        updateList(actionsInList.get(currentActionInList));
        Menu.currentMenu.close();
    };
    
    static Runnable list = () -> {
        wordListIndex = 0;
        updateList(actionsInList.get(currentActionInList));
        Menu.get("wordList").open();
    };
    
    private static final Consumer<String[]> nextInList = (String[] registeredWords) -> {
        wordListIndex += (wordListIndex + 5 < registeredWords.length) ? 5 : registeredWords.length - wordListIndex;
        updateList(actionsInList.get(currentActionInList));
    };
    
    private static final Runnable previousInList = () -> {
        wordListIndex -= 5;
        updateList(actionsInList.get(currentActionInList));
    };
}