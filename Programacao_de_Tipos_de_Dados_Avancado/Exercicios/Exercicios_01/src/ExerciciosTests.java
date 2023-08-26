import junit.framework.*;

import java.util.Objects;

import static org.junit.Assert.assertArrayEquals;

public class ExerciciosTests extends TestCase{
    public int[] arrayA = {1, 1, 2, 4, 6, 6, 7, 7, 13, 15};
    public int[] arrayB = {1, 1, 1, 3, 5, 7, 9, 11, 15};

    public void testeExercicio_1(){
        // Valida se o valor retornado é um array
        assertTrue(Exercicio_1.declareIntArray().getClass().isArray());
    }

    public void testeExercicio_2(){
        int averageArrayA = Exercicio_2.calcArrayAverage(arrayA);
        int averageArrayB = Exercicio_2.calcArrayAverage(arrayB);

        assertEquals(6, averageArrayA);
        assertEquals(5, averageArrayB);
    }

    public void testeExercicio_3(){
        int sumArrayA = Exercicio_3.sumArray(arrayA);
        int sumArrayB = Exercicio_3.sumArray(arrayB);

        assertEquals(62, sumArrayA);
        assertEquals(53, sumArrayB);
    }

    public void testeExercicio_4(){
        int[] powArrayA = Exercicio_4.powArrayValues(arrayA);
        int[] powArrayB = Exercicio_4.powArrayValues(arrayB);
        int[] expectedPowArrayA = {1, 1, 4, 16, 36, 36, 49, 49, 169, 225};
        int[] expectedPowArrayB = {1, 1, 1, 9, 25, 49, 81, 121, 225};

        assertArrayEquals(expectedPowArrayA, powArrayA);
        assertArrayEquals(expectedPowArrayB, powArrayB);
    }

    public void testeExercicio_5(){
        int[] numbers = new int[100];
        for (int i = 0; i < 100;){ numbers[i] = ++i; }
        String expected = "Primos no array: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97";
        String result = Exercicio_5.getStringWithPrimeNumbersInArray(numbers);

        assertEquals(expected, result);
    }

    public void testeExercicio_6(){
        String[] numbers = {"1", "2", "3", "7", "9"};
        String expected = "Foram digitados 1 número(s) par(es) e 4 número(s) ímpar(es)";
        String result = Exercicio_6.getStringWithOddAndEvenNumbersAmount(numbers);

        assertEquals(expected, result);
    }

    public void testeExercicio_7(){
        String expected = "Menor número do array: 1 | Maior número do array: 15";
        String result = Exercicio_7.getStringWithLargerAndSmallerNumberInArray(arrayA);

        assertEquals(expected, result);
    }

    public void testeExercicio_8(){
        int[] expected = {1, 7, 15};
        int[] result = Exercicio_8.intersectionInArrays(arrayA, arrayB);

        assertArrayEquals(expected, result);
    }

    public void testeExercicio_9(){
        int[] expected = {2, 4, 6, 13};
        int[] result = Exercicio_9.differenceInArrays(arrayA, arrayB);

        assertArrayEquals(expected, result);
    }

    public void testeExercicio_10(){
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 9, 11, 13, 15};
        int[] result = Exercicio_10.unionInArrays(arrayA, arrayB);

        assertArrayEquals(expected, result);
    }

}
