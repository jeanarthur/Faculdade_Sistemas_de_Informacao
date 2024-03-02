// Função Saudação:
// Crie uma função chamada saudacao que aceite um nome como parâmetro e retorne uma saudação personalizada.
function saudacao(nome){
    console.log(`Seja bem-vindo ${nome}!`);
}
saudacao('Jean');
console.log(); // Apenas para separar os logs

// Função Soma e Quadrado:
// Crie uma função chamada somaQuadrado que aceite dois números como parâmetros e retorne a soma dos números e o quadrado dessa soma.
const somaQuadrado = (a, b) => {return {soma: a + b, quadradoDaSoma: Math.pow(a + b, 2)}};
let resultado = somaQuadrado(5, 5);
console.log(`Soma: ${resultado.soma} | Quadrado da soma: ${resultado.quadradoDaSoma}`)
console.log(); // Apenas para separar os logs

// Função Concatenação:
// Crie uma função chamada concatenaPalavras que aceite duas strings como parâmetros e retorne a concatenação delas.
const concatenaPalavras = (str1, str2) => str1 + str2;
console.log(concatenaPalavras('palavra', 'Concatenada'));
console.log(); // Apenas para separar os logs

// Acesso a Caracteres:
// Crie uma função chamada primeiroUltimoCaractere que aceite uma string como parâmetro e retorne uma string contendo o primeiro e o último caractere.
const primeiroUltimoCaractere = (str) => str[0] + str[str.length - 1];
console.log(`Primeiro e último caracter de Hello World: ${primeiroUltimoCaractere('Hello World')}`);
console.log(); // Apenas para separar os logs

// Função Comparação:
// Crie uma função chamada comparacaoNumeros que aceite dois números como parâmetros e retorne uma mensagem indicando qual é maior.
const comparacaoNumeros = (a, b) => {
    if (a !== b)
        console.log(`${Math.max(a, b)} > ${Math.min(a, b)}`);
    else
        console.log('Os valores são iguais');
}
comparacaoNumeros(2, 5);
console.log(); // Apenas para separar os logs

// Escopo de Variáveis:
// Crie uma função que declare uma variável dentro dela e outra fora. Tente acessar essas variáveis dentro e fora da função, observando o escopo.
function declaraVariavel(){
    let variavel = "Variavel dentro da funcao";
    console.log(variavel);
}
let variavel = "variavel fora da funncao";
declaraVariavel();
console.log(variavel);
console.log(); // Apenas para separar os logs

// Função Média:
// Crie uma função chamada calcularMedia que aceite um array de números como parâmetro e retorne a média.
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
console.log(`Média do array [1, 2, 3, 4, 5]: ${calcularMedia([1, 2, 3, 4, 5])}`);
console.log(); // Apenas para separar os logs

// Função Fatorial
// Crie uma função chamada fatorial que aceite um número como parâmetro e retorne o fatorial desse número.
const fatorial = (n) => {if(n > 0){ return n * fatorial(n - 1) } else { return 1; }}
console.log(`0! = ${fatorial(0)}`);
console.log(`1! = ${fatorial(1)}`);
console.log(`2! = ${fatorial(2)}`);
console.log(`3! = ${fatorial(3)}`);
console.log(`4! = ${fatorial(4)}`);
console.log(`5! = ${fatorial(5)}`);
console.log(); // Apenas para separar os logs

// Callback Simples:
// Crie uma função chamada executaCallback que aceite outra função como parâmetro e a execute.
const executaCallback = (funcao) => funcao();
executaCallback(saudacao.bind(this, "Jean"));
console.log(); // Apenas para separar os logs

// Função de aguardar:
// Crie uma função chamada aguardarSegundos que aguarde um número específico de segundos antes de exibir uma mensagem.
function aguardarSegundos(mensagem, segundos){
    setTimeout(()=>{ console.log(mensagem); }, segundos*1000);
}
aguardarSegundos('Mensagem após aguardar 2 segundos', 2);

// Validação de Números:
// Crie uma função chamada ehNumero que aceite um parâmetro e retorne verdadeiro se for um número e falso caso contrário.
const ehNumero = (num) => isFinite(num);
console.log(`6 é número: ${ehNumero(6)}`);
console.log(`'6' é número: ${ehNumero('6')}`);
console.log(`'A' é número: ${ehNumero('A')}`);
console.log(); // Apenas para separar os logs