// Exercícios para join:

// Fácil:
// Escreva uma função que receba um array de strings e retorne uma única string com todas as strings separadas por um espaço usando join.
const strings = ["Um", "dois", "tres", "quatro", "cinco", "Mil"];
const concatenar = array => { return array.join(" ") };
console.log(strings);
console.log(concatenar(strings));
console.log(); // Apenas para separar os logs

// Crie uma função que receba um array de palavras e retorne uma única string com todas as palavras separadas por uma vírgula usando join.
const concatenarComVirgula = array => { return array.join(",") };
console.log(strings);
console.log(concatenarComVirgula(strings));
console.log(); // Apenas para separar os logs

// Intermediário:
// Implemente uma função que receba um array de números e retorne uma única string com todos os números separados por um hífen usando join.
const numeros = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55];
const concatenarComHifen = array => { return array.join("-") };
console.log(numeros);
console.log(concatenarComHifen(numeros));
console.log(); // Apenas para separar os logs

// Escreva uma função que receba um array de datas e retorne uma única string com todas as datas formatadas como "DD/MM/YYYY", separadas por um ponto e vírgula, usando join.
const datas = [
    "01-02-2003",
    "02-03-2004",
    "03-04-2005",
    "04-05-2006",
    "05-06-2007",
    "06-07-2008",
    "07-08-2009",
    "08-09-2010",
    "09-10-2011",
    "10-11-2012",
    "11-12-2013"
];
const formatarDatas = datas => { return datas.join(";").replaceAll("-", "/") };
console.log(datas);
console.log(formatarDatas(datas));
console.log(); // Apenas para separar os logs

// Difícil:
// Crie uma função que receba uma matriz (array de arrays) e retorne uma única string com todos os elementos da matriz separados por um ponto e vírgula, usando join.
const matriz = [
    [2, 9],
    [5, 5],
    [1, 3],
    [6, 5]
];
const separarPorPontoVirgula = matriz => { 
    return matriz.
        reduce((p, c) => {
            c.forEach(e => p.push(e));
            return p; 
        }, new Array()).
        join(";") 
};
console.log(matriz);
console.log(separarPorPontoVirgula(matriz));
console.log(); // Apenas para separar os logs

// Implemente uma função que receba um array de strings e retorne uma única string com todas as strings em maiúsculas, separadas por um espaço, usando join.
const caixaAltaEspaco = array => { return array.map(str => str.toUpperCase()).join(" ") };
console.log(strings);
console.log(caixaAltaEspaco(strings));
console.log(); // Apenas para separar os logs