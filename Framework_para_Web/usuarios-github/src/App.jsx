import { useState } from 'react'
import estilo from './app.module.css'
import axios from 'axios'

function App() {
  const [usuarioSelecionado, setUsuarioSelecionado] = useState(null)
  const [erro, setErro] = useState()
  const [usuarios, setUsuarios] = useState([])
  const [repositorios, setRepositorios] = useState([])
  const [seguidores, setSeguidores] = useState([])
  const [visualizacao, setVisualizacao] = useState(null)
  const [usuariosNavegados, setUsuariosNavegados] = useState([])

  if (usuarios.length == 0){
    axios.get("https://api.github.com/users")
      .then((res) => {
        setUsuarios(res.data)
      })
  }

  if (usuarioSelecionado === null && visualizacao !== 'lista_usuarios') {
    setVisualizacao('lista_usuarios')
  }

  function mudaUsuario(usuarioBuscado){
    const usuarioFiltrado = usuarios.filter(usuario => usuario.login == usuarioBuscado)
    if(usuarioFiltrado.length == 0){
      setErro(`Usuário '${usuarioBuscado}' não encontrado`)
    }else{
      setErro(null)
      setUsuarioSelecionado(usuarioFiltrado[0])
      setVisualizacao('usuario-selecionado')
    }
  }

  function selecionaSeguidor(usuarioBuscado){
    const usuarioFiltrado = seguidores.filter(usuario => usuario.login == usuarioBuscado)
    if(usuarioFiltrado.length == 0){
      setErro(`Usuário '${usuarioBuscado}' não encontrado`)
    }else{
      setErro(null)
      usuariosNavegados.push(usuarioSelecionado)
      setUsuarioSelecionado(usuarioFiltrado[0])
      setVisualizacao('usuario-selecionado')
    }
  }

  function voltar(){
    setVisualizacao(usuariosNavegados.length > 0 ? 'usuario-selecionado' : 'lista_usuarios')
    setUsuarioSelecionado(usuariosNavegados.length > 0 ? usuariosNavegados.pop() : null)
    setRepositorios([])
    setSeguidores([])
  }

  function repos(event){
    event.preventDefault()

    if(visualizacao === 'repositorios'){
      setVisualizacao('usuario-selecionado')
      return
    }else if(event.target.href){
      setRepositorios([])
      axios.get(event.target.href)
        .then((res) => {
          setRepositorios(res.data)
        })
    }

    setVisualizacao('repositorios')
  }

  function obterSeguidores(event){
    event.preventDefault()

    if(visualizacao === 'seguidores'){
      setVisualizacao('usuario-selecionado')
      return
    }else if(event.target.href){
      setSeguidores([])
      axios.get(event.target.href)
        .then((res) => {
          setSeguidores(res.data)
        })
    }

    setVisualizacao('seguidores')
  }

  return (
    <div className='container mt-4'>
      {
        erro && (
          <p className='alert alert-danger'>{erro}</p>
        )
      }
      {
        // Se usuarioSelecionado não estiver preenchido
        // Mostra o conteúdo em tela
        visualizacao === 'lista_usuarios' && (
          <>
            <h2>Usuários</h2>
            <ul className='list-group'>
              {/* Ctrl + Shift + Alt + (setinha) */}
              {
                usuarios.map(usuario => {
                  return (
                    <li key={usuario.login} onClick={() => mudaUsuario(usuario.login)} className={'list-group-item ' + estilo.cursor}>
                      {usuario.login}
                    </li>
                  )
                })
              }
            </ul>
          </>
        )
      }

      {
        usuarioSelecionado && (
          <>
            <h2>
              <img src={usuarioSelecionado.avatar_url} className={'img-fluid rounded-pill ' + estilo.avatar} />
              { usuarioSelecionado.login } 
              <span onClick={voltar} className={'mx-3 fs-6 btn btn-secondary btn-sm'}>Voltar</span>
            </h2>
            <p><strong>URLs:</strong></p>
            <ul>
              <li>
                <a target='_blank' href={usuarioSelecionado.html_url}>Perfil</a>
              </li>
              <li>
                <a onClick={repos} target="_blank" href={usuarioSelecionado.repos_url}>Repositórios</a>
              </li>
              <li>
                <a onClick={obterSeguidores} target="_blank" href={usuarioSelecionado.followers_url}>Seguidores</a>
              </li>

            </ul>

            {
              repositorios.length > 0 && visualizacao === 'repositorios' && (
                <>
                  <h2>Repositórios</h2>
                  <ul className='list-group'>
                    {
                      repositorios.map(repo => {
                        return (
                          <li key={repo.name} className={'list-group-item ' + estilo.cursor}>
                            <a href={repo.html_url} target="_blank">{repo.name}</a>
                          </li>
                        )
                      })
                    }
                  </ul>
                </>
              )
            }

            {
              seguidores.length > 0 && visualizacao === 'seguidores' && (
                <>
                  <h2>Seguidores</h2>
                  <ul className='list-group'>
                    {
                      seguidores.map(seguidor => {
                        return (
                          <li key={seguidor.login} onClick={() => selecionaSeguidor(seguidor.login)} className={'list-group-item ' + estilo.cursor}>
                            {seguidor.login}
                          </li>
                        )
                      })
                    }
                  </ul>
                </>
              )
            }
          </>
        )
      }
      
    </div>
  )
}

export default App
