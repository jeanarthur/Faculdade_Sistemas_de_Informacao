// 1. Crie uma funcão que recebe como parâmetro um conjunto de elementos e imprima eles em ordem crescente.
function imprimirOrdenado(...elementos){
    console.log(elementos.sort());
}

imprimirOrdenado(1, 10, 9, 8, 5, 3, 2, 4, 7, 6);
imprimirOrdenado("z", "c", "a", "b", "j");

// 2. Crie uma função que recebe como parâmetro um conjunto de elementos e um elemento específico, a função deve retornar a posição da primeira ocorrência do elemento no array. Caso não exista deve retornar -1.
function localizarPosicao(elemento, ...elementos){
    return elementos.indexOf(elemento);
}

console.log(localizarPosicao("A", "B", "C", "A", "D"));

// 3. Crie uma função que recebe dois arrays como parâmetro e retorne um array com os elementos de ambos arrays.
function uniao(array1, array2){
    return array1.concat(array2);
}

console.log(uniao([1, 2, 3], ["a", "b", "c"]));

// 4. Implemente a funcionalidade do método reverse.
function reverso(array){
    let arrayInverso = [];
    for(let i = 0; i < array.length; i++){
        arrayInverso[i] = array[array.length - (i + 1)];
    }
    return arrayInverso;
}

console.log(reverso([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));

// 5. Implemente a funcionalidade do método keys. Ou seja, crie uma função que recebe como parâmetro um objeto e retorna um array com as propriedades do objeto.

// 6. Crie uma função que recebe um array e retorne um array com os números pares. Valide se cada elemento corresponde a um número.

// 7. Crie uma função que recebe um array e um caracter delimitador. A função deve juntar todos elementos do array em uma string e separar os elementos pelo delimitador.

// 8. Crie uma funcão que recebe um array de objetos que possuem o modelo abaixo. A função deve calcular a média de notas geral, a maior média e a menor média, estes dados devem ser retornados em um objeto.
// {
// nome: "fulano",
// notas: [4,5,2,8]
// }

// 9. Crie uma função que recebe um conjunto de elementos e um número como parâmetros. A função deve retornar um novo conjunto com vários conjuntos menores de elementos contendo cada um a quantidade de elementos igual ao valor passado como parametro.
// elementos = [1,2,3,4,5,6,7,8]
// calcular(elementos, 2)
// [[1,2], [3,4], [5,6], [7,8]]

// 10. Crie uma função que recebe um conjunto de objetos e uma string que será o nome de uma propriedade. A função deve retornar um conjunto de objetos apenas com aqueles que possuem a propriedade passada como parametro definida.