package br.poo.geradorestatisticasbr.estatisticas;

import br.poo.geradorestatisticasbr.Jogo;
import br.poo.geradorestatisticasbr.Time;

public class EstatisticaGolsChutes implements IEstatistica{
	private int golsTimeVisitante;
	private int golsTimeMandante;
	private int chutesAGolTimeVisitante;
	private int chutesAGolTimeMandante;
	
	public int getGolsTimeVisitante() {
		return golsTimeVisitante;
	}
	
	public int getGolsTimeMandante() {
		return golsTimeMandante;
	}
	
	public int getChutesAGolTimeVisitante() {
		return chutesAGolTimeVisitante;
	}
	
	public int getChutesAGolTimeMandante() {
		return chutesAGolTimeMandante;
	}
	
	public int getTotalGols() {
		return golsTimeMandante + golsTimeVisitante;
	}

	@Override
	public IEstatistica calcular(Jogo jogo) {
		Time visitante = jogo.getVisitante();
		Time mandante = jogo.getMandante();

		this.golsTimeVisitante = visitante.getGols();
		this.golsTimeMandante = mandante.getGols();
		this.chutesAGolTimeVisitante = visitante.getChutesAGol();
		this.chutesAGolTimeMandante = mandante.getChutesAGol();
		return this;
	}

	public String imprimir() {
		return "Total de gols no jogo: " + getTotalGols()  + System.lineSeparator() +
			"O time mandante fez " + this.getGolsTimeMandante() + " gols" + System.lineSeparator() +
			"O time visitante fez " + this.getGolsTimeVisitante() + " gols" + System.lineSeparator() +
			"O time mandante chutou " + this.getChutesAGolTimeMandante() + " vezes no gol" + System.lineSeparator() +
			"O time visitante chutou " + this.getChutesAGolTimeVisitante() + " vezes no gol" + System.lineSeparator();
	}
}
