package br.poo.geradorestatisticasbr.estatisticas;

import br.poo.geradorestatisticasbr.Jogo;

public interface IEstatistica {

    IEstatistica calcular(Jogo jogo);

    String imprimir();

}
