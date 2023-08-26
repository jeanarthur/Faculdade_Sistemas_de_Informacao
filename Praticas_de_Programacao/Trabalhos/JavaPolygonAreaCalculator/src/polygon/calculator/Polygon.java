package polygon.calculator;

import java.util.*;
import java.util.function.Supplier;

// Classe com métodos estáticos, para guardar polígonos e relacionados
public class Polygon {
    static Scanner scanner = new Scanner(System.in);
    String name;
    Supplier<Double> calcArea;

    // construtor do polígono, recebe nome e função lambda (Supplier) com o cálculo da área
    Polygon(String name, Supplier<Double> calcArea){
        this.name = name;
        this.calcArea = calcArea;
    }

    static List<Polygon> polygons = new ArrayList<>();
    static Map<Integer, Polygon> polygonOptions = new HashMap<>();

    // Cria todos os polígonos e os armazena numa lista de polígonos
    public static void createPolygons(){
        polygons.add(
                new Polygon(
                        "Quadrado",
                        () -> {
                            return Math.pow(getMeasure("Lado"), 2);
                        }
                )
        );

        polygons.add(
                new Polygon(
                        "Triângulo",
                        () -> {
                            return getMeasure("Base") * getMeasure("Altura") / 2;
                        }
                )
        );

        polygons.add(
                new Polygon(
                        "Trapézio",
                        () -> {
                            double largerBase = getMeasure("Base maior");

                            do{
                                double smallerBase = getMeasure("Base menor");

                                if(smallerBase < largerBase) {
                                    return (smallerBase + smallerBase) * getMeasure("Altura") / 2;
                                } else {
                                    ConsoleManager.printErrorMessage("\tBase menor deve ser menor que Base maior!");
                                }
                            } while (true);
                        }
                )
        );

        polygons.add(
                new Polygon(
                        "Losango",
                        () -> {
                            double largerDiagonal = getMeasure("Diagonal maior");

                            do{
                                double smallerDiagonal = getMeasure("Diagonal menor");

                                if(smallerDiagonal < largerDiagonal) {
                                    return largerDiagonal * smallerDiagonal / 2;
                                } else {
                                    ConsoleManager.printErrorMessage("\tDiagonal menor deve ser menor que Diagonal maior!");
                                }
                            } while (true);
                        }
                )
        );
    }

    // Carrega a lista de polígonos para o mapa de opções
    public static void loadOptions(){
        createPolygons();
        for (int i = 0; i < 9 && i < polygons.size(); i++){
            polygonOptions.put(i+1, polygons.get(i));
        }
    }

    // Imprime cada polígono e seu respectivo índice, do mapa de opções
    public static void printOptions(){
        polygonOptions.forEach(
                ((integer, polygon) -> System.out.printf("%4d. %s\n", integer, polygon.name))
        );
    }

    // Solicita entrada do usuário para a medida do polígono passada como parâmetro
    static double getMeasure(String measureName){
        do{
            try{
                System.out.printf("\t%s: ", measureName);
                return scanner.nextDouble();
            } catch (InputMismatchException e){
                scanner.nextLine(); // Joga fora a tecla <enter> restante do nextDouble()
                ConsoleManager.printErrorMessage("\tDigite um número!");
            }
        } while (true);
    }

}
