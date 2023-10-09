package game.core.service;

import game.core.abstraction.Comando;
import game.core.exception.NenhumComandoRegistradoException;

import java.util.*;

public class GerenciadorDeComandos {

    private static Map<String, Comando> comandos;
    private static Map<String, String> descricoes;
    private static List<String> comandosDisponiveis;
    private static List<String> comandosGlobais;

    public GerenciadorDeComandos(){
        if (comandos == null)
            comandos = new HashMap<>();
        if (descricoes == null)
            descricoes = new HashMap<>();
        if (comandosDisponiveis == null)
            comandosDisponiveis = new ArrayList<>();
        if (comandosGlobais == null)
            comandosGlobais = new ArrayList<>();
    }

    public Comando getComando(String comando) throws NenhumComandoRegistradoException {
        if (comandos.size() < 1) throw new NenhumComandoRegistradoException("Nenhum comando foi registrado ao configurar Mundo!");
        return comandos.get(comando);
    }

    public String getDescricao(String comando) throws NenhumComandoRegistradoException {
        if (descricoes.size() < 1) throw new NenhumComandoRegistradoException("Nenhum comando foi registrado ao configurar Mundo!");
        return descricoes.get(comando);
    }

    public void registrarComando(String comando, String descricao, Comando comandoExecutado){
        descricoes.put(comando, descricao);
        comandos.put(comando, comandoExecutado);
    }

    public void registrarComando(String descricao, Comando comandoExecutado){
        String comando = String.valueOf(comandosDisponiveis.size()+1);
        descricoes.put(comando, descricao);
        comandos.put(comando, comandoExecutado);
    }

    public void registrarComando(String descricao, Comando comandoExecutado, boolean disponibilizar){
        String comando = String.valueOf(comandosDisponiveis.size()+1);
        descricoes.put(comando, descricao);
        comandos.put(comando, comandoExecutado);
        if(disponibilizar){ disponibilizarComando(comando); }
    }

    public void registrarComando(String comando, String descricao, Comando comandoExecutado, boolean disponibilizar){
        descricoes.put(comando, descricao);
        comandos.put(comando, comandoExecutado);
        if(disponibilizar){ disponibilizarComando(comando); }
    }

    public void aguardarComando() throws NenhumComandoRegistradoException {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String comando = scanner.nextLine();
            if (getComandosDisponiveis().contains(comando)){
                getComando(comando).executar();
                return;
            }
            System.out.println("Comando inválido!");
        }
    }

    public List<String> getComandosDisponiveis() throws NenhumComandoRegistradoException {
        if (comandosDisponiveis.size() < 1)
            throw new NenhumComandoRegistradoException("Nenhum comando foi registrado como disponível ao configurar Mundo!");
        return new ArrayList<>(comandosDisponiveis);
    }

    public void disponibilizarComando(String comando){
        comandosDisponiveis.add(comando);
    }

    public void desativarComando(String comando){
        comandosDisponiveis.remove(comando);
    }

    public void limparComandos(){
        comandosDisponiveis.clear();
        for(String comando : comandosGlobais){
            disponibilizarComando(comando);
        }
    }

    public void definirComandoGlobal(String comando){
        comandosGlobais.add(comando);
        if (!comandosDisponiveis.contains(comando))
            disponibilizarComando(comando);
    }

    public void removerComandoGlobal(String comando){
        comandosGlobais.remove(comando);
    }

}
