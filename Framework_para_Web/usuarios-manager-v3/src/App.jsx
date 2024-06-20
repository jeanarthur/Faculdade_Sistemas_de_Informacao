import Cabecalho from "./components/Cabecalho"
import Rodape from "./components/Rodape"

import Home from "./pages/Home"
import Cadastro from "./pages/Cadastro"

import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import { ThemeProvider } from './contexts/ThemeContext';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />
  },
  {
    path: "/cadastro",
    element: <Cadastro/>
  }
])

function App() {

  return (
    <ThemeProvider>
      <Cabecalho/>
      <main className={`container-lg mt-5`}>
        <RouterProvider router={router}/>
      </main>
      <Rodape/>
    </ThemeProvider>
  )
}

export default App
