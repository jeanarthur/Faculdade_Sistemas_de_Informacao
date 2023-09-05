package br.poo.geradorestatisticasbr;

import br.poo.geradorestatisticasbr.estatisticas.IEstatistica;

public class GeradorEstatisticas {
	
	public IEstatistica calcular(IEstatistica estatistica, Jogo jogo) {
		return estatistica.calcular(jogo);
	}
	
}
