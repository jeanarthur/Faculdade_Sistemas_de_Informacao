import { useState } from 'react'
import './Empresa.css'

function App() {
  const [produtos, setProdutos] = useState([]);
  const [servicos, setServicos] = useState([]);

  if (produtos.length == 0) {
    setProdutos([
      "Produto A",
      "Produto B",
      "Produto C"
    ]);
  }

  if (servicos.length == 0) {
    setServicos([
      "Serviço A",
      "Serviço B",
      "Serviço C"
    ]);
  }

  return (
    <>
      <header>
        <h1 id="nome-empresa">Empresa XYZ</h1>
      </header>

      <nav>
        <ul>
          <li><a className="menu" id="link01" href="#">Início</a></li>
          <li><a className="menu" href="#">Produtos</a></li>
          <li><a className="menu" href="#">Serviços</a></li>
          <li><a className="menu" href="#">Contato</a></li>
        </ul>
      </nav>

      <section>
        <h2>Sobre Nossa Empresa</h2>
        <p id="sobre">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed viverra justo sed metus aliquam, eget fringilla lectus dapibus.</p>
        
        <h2>Nossos Produtos</h2>
        <ul id="produtos">
          {
            produtos.map((produto, index) => (<li key={`${produto}_${index}`}>{produto}</li>))
          }
        </ul>
        
        <h2>Serviços Oferecidos</h2>
        <ul id="servicos">
          {
            servicos.map((servico, index) => (<li key={`${servico}_${index}`}>{servico}</li>))
          }
        </ul>
        
        <h2>Contato</h2>
        <p>Telefone: <span>(00) 1234-5678</span></p>
        <p>Email:<a href="/cdn-cgi/l/email-protection" className="__cf_email__" data-cfemail="d8bbb7b6acb9acb798bdb5a8aabdabb9f6bbb7b5">[email&#160;protected]</a></p>
        
        <h2>Relatório de Vendas</h2>
        <table id="vendas">
          <thead>
            <tr>
              <th>Data</th>
              <th>Produto</th>
              <th>Quantidade</th>
              <th>Valor</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>01/01/2024</td>
              <td>Produto A</td>
              <td>10</td>
              <td>R$ 100,00</td>
            </tr>
            <tr>
              <td>02/01/2024</td>
              <td>Produto B</td>
              <td>8</td>
              <td>R$ 80,00</td>
            </tr>
            <tr>
              <td>03/01/2024</td>
              <td>Produto C</td>
              <td>15</td>
              <td>R$ 150,00</td>
            </tr>
            <tr>
              <td>01/02/2024</td>
              <td>Produto A</td>
              <td>10</td>
              <td>R$ 120,00</td>
            </tr>
            <tr>
              <td>02/02/2024</td>
              <td>Produto B</td>
              <td>8</td>
              <td>R$ 10,00</td>
            </tr>
            <tr>
              <td>03/02/2024</td>
              <td>Produto C</td>
              <td>15</td>
              <td>R$ 300,00</td>
            </tr>
            <tr>
              <td>01/03/2024</td>
              <td>Produto A</td>
              <td>10</td>
              <td>R$ 190,00</td>
            </tr>
            <tr>
              <td>02/03/2024</td>
              <td>Produto B</td>
              <td>8</td>
              <td>R$ 180,00</td>
            </tr>
            <tr>
              <td>03/03/2024</td>
              <td>Produto C</td>
              <td>15</td>
              <td>R$ 1150,00</td>
            </tr>
          </tbody>
        </table>

        <table>
          <thead id="resumo-vendas-cab">
            <tr>
              <th colSpan="3">Resumo de vendas</th>
            </tr>
            <tr>
              <th>Produto</th>
              <th>Quantidade</th>
              <th>Valor</th>
            </tr>
          </thead>
          <tbody id="resumo-vendas"></tbody>
        </table>


        <div>
          <form id="formulario">
            <label htmlFor="dataVenda">Data da Venda:</label>
            <input type="date" id="dataVenda" name="dataVenda" required/>
          
            <label htmlFor="nomeProduto">Nome do Produto:</label>
            <input type="text" id="nomeProduto" name="nomeProduto" required/>
          
            <label htmlFor="quantidadeVendida">Quantidade Vendida:</label>
            <input type="number" id="quantidadeVendida" name="quantidadeVendida" required/>
          
            <label htmlFor="valorVendido">Valor Vendido (R$):</label>
            <input type="text" id="valorVendido" name="valorVendido" required/>
          
            <input type="submit" value="Adicionar Venda"/>
          </form>

          <form id="removerProdutoForm">
            <p>Remover um produto</p>
            <label htmlFor="produtoParaRemover">Produto</label>
            <select name="produtoParaRemover" id="produtoParaRemover">

            </select>

            <input type="submit" value="Remover produto"/>
          </form>
        </div>
      </section>

      <footer>
        <p>&copy; 2024 Empresa XYZ. Todos os direitos reservados.</p>
      </footer>
    </>
  )
}

export default App
