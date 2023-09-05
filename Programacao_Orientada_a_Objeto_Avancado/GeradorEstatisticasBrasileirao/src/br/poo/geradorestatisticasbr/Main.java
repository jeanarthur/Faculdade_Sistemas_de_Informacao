package br.poo.geradorestatisticasbr;

import br.poo.geradorestatisticasbr.estatisticas.EstatisticaFaltasCartoes;
import br.poo.geradorestatisticasbr.estatisticas.EstatisticaGolsChutes;
import br.poo.geradorestatisticasbr.estatisticas.EstatisticaTempoJogo;
import br.poo.geradorestatisticasbr.estatisticas.IEstatistica;

public class Main {

	public static void main(String[] args) {
		Time mandante = new Time(4, 30, 20, 18, 24, 1, 1);
		Time visitante = new Time(2, 21, 22,10, 32, 1, 0);
		Jogo jogo = new Jogo(70,96, visitante, mandante);

		GeradorEstatisticas gerador = new GeradorEstatisticas();
		IEstatistica tempoJogo = gerador.calcular(new EstatisticaTempoJogo(), jogo);
		IEstatistica chutesGol = gerador.calcular(new EstatisticaGolsChutes(), jogo);
		IEstatistica faltasCartoes = gerador.calcular(new EstatisticaFaltasCartoes(), jogo);

		System.out.println(tempoJogo.imprimir());
		System.out.println(chutesGol.imprimir());
		System.out.println(faltasCartoes.imprimir());
	}

}
