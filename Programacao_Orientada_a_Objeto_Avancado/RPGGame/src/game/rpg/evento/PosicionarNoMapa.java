package game.rpg.evento;

import game.core.abstraction.Evento;
import game.core.abstraction.Posicao;
import game.core.abstraction.Posicionavel;
import game.core.exception.JogoException;
import game.core.exception.PosicaoForaDoMapaException;
import game.core.model.MundoVirtual;
import game.rpg.RPG;
import game.core.service.GerenciadorDePosicionaveis;

import java.util.Random;

public class PosicionarNoMapa implements Evento {

    private Posicionavel posicionavel;
    private int x;
    private int y;

    public PosicionarNoMapa(Posicionavel posicionavel){
        this.posicionavel = posicionavel;
        this.x = -1;
        this.y = -1;
    }

    public PosicionarNoMapa(Posicionavel posicionavel, Posicao posicao){
        this.posicionavel = posicionavel;
        this.x = posicao.getX();
        this.y = posicao.getY();
    }

    @Override
    public boolean executar() throws JogoException {
        GerenciadorDePosicionaveis gerenciadorDePosicao = new GerenciadorDePosicionaveis();
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
        if (x == -1 || y == -1){
            if(!posicionarAleatorio() && !posicionarNoPrimeiroEspacoVazio()) {
                System.out.println("Impossível posicionar, não há espaço vazio!");
            }
        } else {
            mundoVirtual.getMapaDoMundo()[y][x] = posicionavel;
            gerenciadorDePosicao.registrarPosicao(posicionavel, new Posicao(x, y));
        }

        return false;
    }

    private boolean posicionarAleatorio(){
        GerenciadorDePosicionaveis gerenciadorDePosicao = new GerenciadorDePosicionaveis();
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
        Random random = new Random();

        int maxX = mundoVirtual.getMapaDoMundo()[0].length;
        int maxY = mundoVirtual.getMapaDoMundo().length;

        int tentativas = 0;
        while (true){
            x = random.nextInt(maxX);
            y = random.nextInt(maxY);
            if (mundoVirtual.getMapaDoMundo()[y][x] != null){
                tentativas++;
                if (tentativas >= 100){ return false; }
                continue;
            }

            mundoVirtual.getMapaDoMundo()[y][x] = posicionavel;
            try{
                gerenciadorDePosicao.registrarPosicao(posicionavel, new Posicao(x, y));
            } catch (PosicaoForaDoMapaException e){
                System.out.println("Essa posição está fora de alcançe.");
            }
            break;
        }
        return true;
    }

    private boolean posicionarNoPrimeiroEspacoVazio(){
        GerenciadorDePosicionaveis gerenciadorDePosicao = new GerenciadorDePosicionaveis();
        MundoVirtual mundoVirtual = RPG.getMundoVirtualAtivo();
        Posicionavel[][] mapa = mundoVirtual.getMapaDoMundo();

        for (int i = 0; i < mapa[0].length; i++){
            for (int j = 0; j < mapa.length; j++){
                if (mundoVirtual.getMapaDoMundo()[i][j] != null){ continue; }
                mundoVirtual.getMapaDoMundo()[i][j] = posicionavel;
                try{
                    gerenciadorDePosicao.registrarPosicao(posicionavel, new Posicao(x, y));
                } catch (PosicaoForaDoMapaException e){
                    System.out.println("Há uma barreira aqui, você não consegue caminhar nessa direção.");
                }
                return true;
            }
        }
        return false;
    }
}
