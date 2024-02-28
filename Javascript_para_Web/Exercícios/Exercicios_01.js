// Variáveis com nome e idade
let nome = "Jean";
let idade = 21;

console.log(`Nome: ${nome} | Idade: ${idade}`);
console.log(); // Apenas para separar os logs

// Operações aritméticas
let x = 12;
let y = 4;

let soma = x + y;
let subtracao = x - y;
let divisao = x / y;
let multiplicacao = x * y;

console.log(`x: ${x} | y: ${y}`);
console.log("x + y = " + soma);
console.log("x - y = " + subtracao);
console.log("x / y = " + divisao);
console.log("x * y = " + multiplicacao);
console.log(); // Apenas para separar os logs

// Strings e Concatenação
let h = "Hello";
let w = "World";

console.log(`h: ${h} | w: ${w}`);
console.log("h + w = " + h + w);
console.log(); // Apenas para separar os logs

// Acessando Caracteres
let hw = "Hello World";

console.log("Palavra: " + hw);
console.log("Primeira letra: " + hw[0]);
console.log("Última letra: " + hw[hw.length - 1]);
console.log(); // Apenas para separar os logs

// Operações Booleanas
let a = 5;
let b = 5;

console.log(`a: ${a} | b: ${b}`);
console.log("a > b: " + (a > b));
console.log("a >= b: " + (a >= b));
console.log("a < b: " + (a < b));
console.log("a <= b: " + (a <= b));
console.log("a = b: " + (a === b));
console.log("a ≠ b: " + (a !== b));
console.log(); // Apenas para separar os logs

// Escopo de Variáveis
let variavel = "Variável fora da função";
console.log(variavel);

function escopoDaFuncao(){
  let variavel = "Variável dentro da função";
  console.log(variavel);
}
escopoDaFuncao();
console.log(variavel);
console.log(); // Apenas para separar os logs

// Uso do Console
console.log("Registrando log no console");
console.info("Registrando info no console");
console.warn("Registrando alerta no console");
console.error("Registrando erro no console");
console.log(); // Apenas para separar os logs

// Conversão de Tipos
let stringNumero = 10;
let numero = parseInt(stringNumero);

console.log("Número convertido para int: " + numero);
console.log(); // Apenas para separar os logs

// Execução no Navegador e Node
// Esse arquivo pode ser executando em ambos os ambientes

// Funções
function somar(a, b){
  return a + b;
}

console.log("Soma: 123 + 321 = " + somar(123, 321));