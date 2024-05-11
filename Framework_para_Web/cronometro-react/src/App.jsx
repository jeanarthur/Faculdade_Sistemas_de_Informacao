import { useState } from 'react'
import './App.css'
import estilosCronometro from './css/cronometro.module.css'

function App() {
  const [temporizador, setTemporizador] = useState(null);
  const [status, setStatus] = useState(false);
  const [tempo, setTempo] = useState('00:00:00.000');
  const [inicio, setInicio] = useState(null);
  const [voltas, setVoltas] = useState(new Array());
  const [contagemVoltas, setContagemVoltas] = useState(0);

  let inicial = 0;

  const iniciar = () => {
    if (temporizador && status) return;
    if (!temporizador) {
      setInicio(Date.now());
      zerar();
    } 

    inicial = temporizador ? inicio : Date.now();
    let intervaloId = setInterval(()=>{
      let tempoDecorrido = Date.now() - inicial;
      let data = new Date(tempoDecorrido).toISOString();
      let tempoFomatado = data.replace(`${data.split('T')[0]}T`, '').replace('Z', '');
      setTempo(tempoFomatado);
    });

    setTemporizador(() => intervaloId);
    setStatus(true);
  }

  const pausar = () => {
    if (temporizador) {
      clearInterval(temporizador);
      setStatus(false);
    }
  }

  const volta = () => {
    if (temporizador && status) {
      setVoltas(new Array(<p key={`volta_${contagemVoltas + 1}`}>{`${contagemVoltas + 1}ª Volta: ${tempo}`}</p>, voltas));
      setContagemVoltas((contagemVoltas) => contagemVoltas + 1)
    }
  }
  
  const parar = () => {
    if (temporizador) {
      pausar();
      setTemporizador(null);
    }
  }

  const zerar = () => {
    setTempo('00:00:00.000');
    setVoltas(new Array());
    setContagemVoltas(0);
  }

  return (
    <>
      <div className={estilosCronometro.divCronometro}>
        <span className={estilosCronometro.numero}>{tempo}</span>
        <section className={estilosCronometro.secaoBotoes}>
          <button onClick={iniciar}>Iniciar</button>
          <button onClick={pausar}>Pausar</button>
          <button onClick={volta}>Volta</button>
          <button onClick={parar}>Parar</button>
        </section>
        <h2>Registro de voltas</h2>
      </div>
      <div className={estilosCronometro.divRegistros}>
        <div className={estilosCronometro.divVoltas}>{voltas}</div>
      </div>
    </>
  )
}

export default App
