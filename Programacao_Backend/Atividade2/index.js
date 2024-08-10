const fs = require('node:fs/promises');

async function readJSONFile(path){
    let data = await fs.readFile(path, 'utf8');
    return JSON.parse(data);
}

function processJSON(json){
    let students = json.alunos;
    students.forEach(async student => {
        let dirPath = await registerStudentDirectory(student);
        student.projetos.forEach(project => registerProject(project, dirPath));
    });
}

async function registerStudentDirectory(student){
    try {
        let dirPath = `./${student.nome}_${student.matricula}`;
        await fs.mkdir(dirPath);
        return dirPath;
    } catch (error) {
        console.error(`Error on register student (${error})`);
    }
}

async function registerProject(project, dirPath){
    try {
        fs.writeFile(`${dirPath}/${project.titulo}.txt`, project.resumo);
    } catch (error) {
        console.error(`Error on register project (${error})`);
    }
}

async function execute(){
    let json = await readJSONFile('./dados.json');
    processJSON(json);
}

execute();