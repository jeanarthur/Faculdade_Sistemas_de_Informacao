// 1. Exercícios para forEach:
// • Fácil:
// 1. Escreva um código que use o método forEach para imprimir todos os elementos de um array de números.
let numeros = [30, 3, 2024, 10, 7];
numeros.forEach(num => console.log(num));
console.log(); // Apenas para separar os logs

// 2. Crie uma função que receba um array de strings e use forEach para imprimir cada string em maiúsculas.
let palavras = ["hello", "word"];
palavras.forEach(palavra => console.log(palavra.toUpperCase()));
console.log(); // Apenas para separar os logs

// • Intermediário:
// 1. Escreva um programa que use forEach para iterar sobre um array de objetos e imprima o valor de uma propriedade específica de cada objeto.
let coordenadas = [
    {
        x: 0,
        y: 0,
        z: 0
    },
    {
        x: 10,
        y: 2,
        z: 0
    },
    {
        x: -10,
        y: -10,
        z: 5
    }
]
coordenadas.forEach(ponto => console.log(`X: ${ponto.x}`));
console.log(); // Apenas para separar os logs

// 2. Crie uma função que receba um array de números e use forEach para calcular e imprimir a soma de todos os elementos.
let numeros2 = [9, 90, 900, 9000];
let numeros2Context = {}; // usado para separar o contexto e armazenar a soma
numeros2.forEach(function(num, i){
    if (!this.somatorio){
        this.somatorio = 0;
    }

    this.somatorio += num;

    if (i === numeros2.length - 1){
        console.log(`Soma do Array: ${this.somatorio}`);
    }
}, numeros2Context);
console.log(); // Apenas para separar os logs

// • Difícil:
// 1. Implemente uma função que receba uma matriz (array de arrays) e use forEach para calcular e imprimir a soma de cada linha da matriz.
let matriz = [
    [1, 9],
    [5, 5],
    [1, 3],
    [2, 5]
];
let matrizContext = {}; // usado para separar o contexto e armazenar as somas
matriz.forEach(function(array, i){
    if (!this.somatorio){
        this.somatorio = 0;
    }
    array.forEach(function(num, j){
        this.somatorio += num;
    
        if (j === array.length - 1){
            console.log(`Soma do ${i + 1}º Array: ${this.somatorio}`);
        }
    }, this);
    this.somatorio = 0;
}, matrizContext);
console.log(); // Apenas para separar os logs

// 2. Escreva um programa que use forEach para iterar sobre um array de arrays de números e encontre o maior número em cada subarray, imprimindo-o.
let matriz2 = [
    [1, 9],
    [5, 5],
    [1, 3],
    [2, 5]
];
let matriz2Context = {}; // usado para separar o contexto e armazenar as somas
matriz.forEach(function(array, i){
    array.forEach(function(num, j){
        if (j === 0 || num > this.maior){
            this.maior = num;
        }
    
        if (j === array.length - 1){
            console.log(`Maior número do ${i + 1}º Array: ${this.maior}`);
        }
    }, this);
}, matriz2Context);
console.log(); // Apenas para separar os logs

// 2. Exercícios para map:
// • Fácil:
// 1. Escreva uma função que receba um array de números e retorne um novo array com cada número multiplicado por 2 usando map.
let numeros3 = [0, 1, 2, 3, 4];
let numerosDobrados = numeros3.map(num => num * 2);
console.log(numeros3);
console.log(numerosDobrados);
console.log(); // Apenas para separar os logs

// 2. Crie uma função que receba um array de palavras e retorne um novo array com cada palavra em maiúsculas usando map.
let palavras2 = ["hello", "word"];
let palavrasMaiuscula = palavras2.map(palavra => palavra.toUpperCase());
console.log(palavras2);
console.log(palavrasMaiuscula);
console.log(); // Apenas para separar os logs

// • Intermediário:
// 1. Implemente uma função que receba um array de objetos e retorne um novo array apenas com os valores de uma propriedade específica de cada objeto, usando map.
let coordenadas2 = [
    {
        x: 0,
        y: 0,
        z: 0
    },
    {
        x: 10,
        y: 2,
        z: 0
    },
    {
        x: -10,
        y: -10,
        z: 5
    }
]
let coordenadasX = coordenadas2.map(ponto => ponto.x);
console.log(coordenadas2);
console.log(coordenadasX);
console.log(); // Apenas para separar os logs

// 2. Escreva uma função que receba um array de strings e retorne um novo array com o comprimento de cada string usando map.
let palavras3 = ["hello", "word"];
let tamanhoPalavras = palavras2.map(palavra => palavra.length);
console.log(palavras2);
console.log(tamanhoPalavras);
console.log(); // Apenas para separar os logs

// • Difícil:
// 1. Crie uma função que receba uma matriz (array de arrays) e retorne um novo array com a soma de cada linha da matriz, usando map.
let matriz3 = [
    [1, 9],
    [5, 5],
    [1, 3],
    [2, 5]
];
let matriz3Context = {}; // usado para separar o contexto e armazenar as somas
let somaLinhaMatriz = matriz.map(function(array){
    this.somatorio = 0;
    array.forEach(function(num){
        this.somatorio += num;
    }, this);
    return this.somatorio;
}, matriz3Context);
console.log(matriz3);
console.log(somaLinhaMatriz);
console.log(); // Apenas para separar os logs

// 2. Implemente uma função que receba um array de números e retorne um novo array com a raiz quadrada de cada número, arredondada para o inteiro mais próximo, usando map..
let numeros4 = [0, 9, 34, 978, 3221937];
let numerosRaizQuadrada = numeros4.map(num => Math.round(Math.sqrt(num)));
console.log(numeros4);
console.log(numerosRaizQuadrada);
console.log(); // Apenas para separar os logs