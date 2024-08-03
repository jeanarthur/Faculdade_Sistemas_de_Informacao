const fs = require('fs');

const stream = fs.createReadStream('./texto.txt', {
    encoding: 'utf8',
    highWaterMark: 4096 
});

var chunkIndex = 0;
stream.on('data', (chunk) => {

    let palavras = chunk
                    .replaceAll('\r\n', ' ') // substitui quebras de linha por espaço
                    .replaceAll('\n', ' ') // substitui quebras de linha por espaço
                    .replaceAll(/\s+/gm, ' '); // substitui espaços consecutivos por um único espaço

    palavras = palavras.split(' ') // separa as palavras pelo espaço
                .filter(palavra => palavra != ''); // remove "palavras" vazias

    console.log(`+========================== Chunk ${chunkIndex.toString().padStart(2, '0')} (${palavras.length} palavras) ==============================+`);
    console.log(chunk);
    console.log("");
    
    chunkIndex++;
})