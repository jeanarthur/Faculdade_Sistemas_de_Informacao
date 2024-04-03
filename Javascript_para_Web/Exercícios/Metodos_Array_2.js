//Exercícios para filter:
//
//Fácil:
//
//Escreva uma função que receba um array de números e retorne um novo array apenas com os números pares usando filter.
const numeros = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55];
const pares = numeros.filter(num => num % 2 === 0);
console.log(numeros);
console.log(pares);
console.log(); // Apenas para separar os logs


//Crie uma função que receba um array de strings e retorne um novo array apenas com as strings que têm mais de três caracteres usando filter.
const strings = ["Um", "dois", "tres", "quatro", "cinco", "Mil"];
const maisDe3Carcteres = strings.filter(palavra => palavra.length > 3);
console.log(strings);
console.log(maisDe3Carcteres);
console.log(); // Apenas para separar os logs

//Intermediário:
//
//Implemente uma função que receba um array de objetos e retorne um novo array apenas com os objetos que têm uma propriedade específica definida, usando filter.
let arrayObjetos = [
    { x: 0, y: 2, z: 3 },
    { x: 0, y: 2},
    { a: 0, b: 2, c: 3 },
    { h: 0, w: 2, z: 3 },
    { x: 3, y: 2, z: 1 },
    { xA: 0, yA: 2, zA: 3 }
];
let objetosComZ = arrayObjetos.filter(obj => obj.z);
console.log(arrayObjetos);
console.log(objetosComZ);
console.log(); // Apenas para separar os logs

//Escreva uma função que receba um array de números e retorne um novo array apenas com os números que são múltiplos de 3 usando filter.
const multiplosDe3 = numeros.filter(num => num % 3 === 0);
console.log(numeros);
console.log(multiplosDe3);
console.log(); // Apenas para separar os logs

//Difícil:
//
//Crie uma função que receba uma matriz (array de arrays) e retorne um novo array apenas com as linhas que têm a soma dos elementos maior que 10, usando filter.
const matriz = [
    [2, 9],
    [5, 5],
    [1, 3],
    [6, 5]
];
const somaLinhaMaiorQue10 = matriz.filter(linha => {
    const soma = linha.reduce((vA, pV)=> {return vA + pV}, 0);
    return soma > 10;
})
console.log(matriz);
console.log(somaLinhaMaiorQue10);
console.log(); // Apenas para separar os logs

//Implemente uma função que receba um array de strings e retorne um novo array apenas com as strings que começam com uma letra maiúscula, usando filter.
const iniciadosComMaiuscula = strings.filter(palavra => palavra[0] === palavra[0].toUpperCase());
console.log(strings);
console.log(iniciadosComMaiuscula);
console.log(); // Apenas para separar os logs

//Exercícios para reduce:
//
//Fácil:
//
//Escreva uma função que receba um array de números e retorne a soma de todos os elementos usando reduce.
const soma = numeros.reduce((vA, pV) => { return vA + pV }, 0);
console.log(numeros);
console.log(soma);
console.log(); // Apenas para separar os logs

//Crie uma função que receba um array de strings e retorne uma única string concatenando todos os elementos usando reduce.
const concatenado = strings.reduce((vA, pV) => { return vA + pV }, "");
console.log(strings);
console.log(concatenado);
console.log(); // Apenas para separar os logs

//Intermediário:
//
//Implemente uma função que receba um array de objetos e retorne a soma de uma propriedade específica de todos os objetos usando reduce.
const somaZ = objetosComZ.reduce((vA, pV) => { return vA + pV.z; }, 0);
console.log(objetosComZ);
console.log(somaZ);
console.log(); // Apenas para separar os logs

//Escreva uma função que receba um array de números e retorne o produto de todos os elementos usando reduce.
const produto = numeros.reduce((vA, pV) => { return vA * pV; }, 1);
console.log(numeros);
console.log(produto);
console.log(); // Apenas para separar os logs

//Difícil:
//
//Crie uma função que receba uma matriz (array de arrays) e retorne um único valor com a soma de todos os elementos da matriz, usando reduce.
const somaMatriz = matriz.reduce((vA, pV) => {
    return vA + pV.reduce((vA, pV) => { return vA + pV; }, 0);
}, 0);
console.log(matriz);
console.log(somaMatriz);
console.log(); // Apenas para separar os logs

//Implemente uma função que receba um array de números e retorne o maior número usando reduce
const maior = numeros.reduce((vA, pV) => {return vA > pV ? vA : pV;}, -Infinity);
console.log(numeros);
console.log(maior);
console.log(); // Apenas para separar os logs