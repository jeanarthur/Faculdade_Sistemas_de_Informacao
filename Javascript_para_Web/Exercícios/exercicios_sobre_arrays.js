console.info(`1. Crie uma funcão que recebe como parâmetro um conjunto de elementos e imprima eles em ordem crescente.`);
function imprimirOrdenado(...elementos){
    console.log(elementos.sort());
}

imprimirOrdenado(1, 9, 8, 5, 3, 2, 4, 7, 6, 0);
imprimirOrdenado("z", "c", "a", "b", "j");
console.log(); // Apenas para separar os logs

console.info(`2. Crie uma função que recebe como parâmetro um conjunto de elementos e um elemento específico, a função deve retornar a posição da primeira ocorrência do elemento no array. Caso não exista deve retornar -1.`);
function localizarPosicao(elemento, elementos){
    return elementos.indexOf(elemento);
}

console.log(localizarPosicao("A", ["B", "C", "A", "D"]));
console.log(localizarPosicao("Z", ["B", "C", "A", "D"]));
console.log(); // Apenas para separar os logs

console.info(`3. Crie uma função que recebe dois arrays como parâmetro e retorne um array com os elementos de ambos arrays.`);
function uniao(array1, array2){
    return array1.concat(array2);
}

console.log(uniao([1, 2, 3], ["a", "b", "c"]));
console.log(); // Apenas para separar os logs

console.info(`4. Implemente a funcionalidade do método reverse.`);
function reverso(array){
    let arrayInverso = [];
    for(let i = 0; i < array.length; i++){
        arrayInverso[i] = array[array.length - (i + 1)];
    }
    return arrayInverso;
}

console.log(reverso([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
console.log(); // Apenas para separar os logs

console.info(`5. Implemente a funcionalidade do método keys. Ou seja, crie uma função que recebe como parâmetro um objeto e retorna um array com as propriedades do objeto.`);
function propriedades(objeto){
    let propriedades = [];
    for(let propriedade in objeto){
        propriedades.push(propriedade);
    }
    return propriedades;
}

let obj = {
    nome: null,
    idade: null,
    cpf: null,
    endereco: null
}
console.log(propriedades(obj));
console.log(); // Apenas para separar os logs

console.info(`6. Crie uma função que recebe um array e retorne um array com os números pares. Valide se cada elemento corresponde a um número.`);
function pares(array){
    let pares = [];
    for(num in array){
        let n = array[num];
        if (typeof n === 'number' 
            && n % 2 === 0){
            pares.push(array[num]);
        }
    }
    return pares;
}

console.log(pares([1, 2, 3, 4, 5, 6, 7, 8]));
console.log(pares([1, [2, 3, 4], 5, "6", 8, 9, 10]));
console.log(); // Apenas para separar os logs

console.info(`7. Crie uma função que recebe um array e um caracter delimitador. A função deve juntar todos elementos do array em uma string e separar os elementos pelo delimitador.`);
function juntarComDelimitador(array, delimitador){
    let str = "";
    array.forEach(e => str += e + delimitador);
    str = str.slice(0, str.length - 1);
    return str;
}

console.log(juntarComDelimitador([1, 2, 3, 4, 5, 6, 7, 8, 9], "-"));
console.log(); // Apenas para separar os logs

console.info(`8. Crie uma funcão que recebe um array de objetos que possuem o modelo abaixo. A função deve calcular a média de notas geral, a maior média e a menor média, estes dados devem ser retornados em um objeto.
// {
// nome: "fulano",
// notas: [4,5,2,8]
// }`);
function calcularMedias(arrayObjetos){
    function calcularMedia(numArr){
        const somarArr = (numArr) => {
            let soma = 0;
            for(let i = 0; i < numArr.length; i++){
                soma += numArr[i];
            }
            return soma;
        }
    
        return (somarArr(numArr) / numArr.length);
    }

    let medias = [];
    arrayObjetos.forEach(obj => medias.push(calcularMedia(obj.notas)));

    let media = { 
        geral: calcularMedia(medias),
        maior: Math.max(...medias),
        menor: Math.min(...medias)
    }

    return media;
}

let alunos = [
    { nome: "A", notas: [4, 5, 2, 8] },
    { nome: "B", notas: [5, 5, 5, 5] },
    { nome: "C", notas: [2, 7, 9, 8] }
]
console.log(calcularMedias(alunos));
console.log(); // Apenas para separar os logs

console.info(`9. Crie uma função que recebe um conjunto de elementos e um número como parâmetros. A função deve retornar um novo conjunto com vários conjuntos menores de elementos contendo cada um a quantidade de elementos igual ao valor passado como parametro.
// elementos = [1,2,3,4,5,6,7,8]
// calcular(elementos, 2)
// [[1,2], [3,4], [5,6], [7,8]]`);
function separarEmSubArrays(array, quantidadeDeElementosPorSubArray){
    let arrayPrincipal = [];

    let i = 0;
    let subArray = []
    array.forEach(e => {
        subArray.push(e);
        i++;
        if (i > 1 && i % quantidadeDeElementosPorSubArray === 0){
            arrayPrincipal.push(subArray);
            subArray = [];
        } else if (array.indexOf(e) === array.length - 1){
            while(i % quantidadeDeElementosPorSubArray !== 0){
                subArray.push(null);
                i++;
            }
            arrayPrincipal.push(subArray);
        }
    });

    return arrayPrincipal;
}

let elementos = [1,2,3,4,5,6,7,8];
console.log(separarEmSubArrays(elementos, 2));
console.log(separarEmSubArrays(elementos, 3));
console.log(separarEmSubArrays(elementos, 4));
console.log(); // Apenas para separar os logs


console.info(`10. Crie uma função que recebe um conjunto de objetos e uma string que será o nome de uma propriedade. A função deve retornar um conjunto de objetos apenas com aqueles que possuem a propriedade passada como parametro definida.`);
function filtarObjetosPorPropriedade(arrayObjetos, propriedade){
    let objetosComPropriedade = [];
    arrayObjetos.forEach(obj => {
        if (obj[propriedade]){
            objetosComPropriedade.push(obj);
        }
    });
    return objetosComPropriedade;
}

let arrayObjetos = [
    { x: 0, y: 2, z: 3 },
    { x: 0, y: 2},
    { a: 0, b: 2, c: 3 },
    { h: 0, w: 2, z: 3 },
    { x: 3, y: 2, z: 1 },
    { xA: 0, yA: 2, zA: 3 }
];

console.log(filtarObjetosPorPropriedade(arrayObjetos, "z"));