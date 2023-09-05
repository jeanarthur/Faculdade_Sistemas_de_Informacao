package br.poo.geradorestatisticasbr.estatisticas;

import br.poo.geradorestatisticasbr.Jogo;
import br.poo.geradorestatisticasbr.Time;

public class EstatisticaTempoJogo implements IEstatistica{
	private double posseBolaTimeVisitanteDefesaEmMin;
	private double posseBolaTimeVisitanteAtaqueEmMin;
	private double posseBolaTimeMandanteDefesaEmMin;
	private double posseBolaTimeMandanteAtaqueEmMin;
	private double tempoTotalBolaRolandoEmMin;
	private double tempoTotalJogoEmMin;
	
	public double getPosseBolaTimeVisitanteDefesaEmMin() {
		return posseBolaTimeVisitanteDefesaEmMin;
	}

	public double getPosseBolaTimeVisitanteAtaqueEmMin() {
		return posseBolaTimeVisitanteAtaqueEmMin;
	}

	public double getPosseBolaTimeMandanteDefesaEmMin() {
		return posseBolaTimeMandanteDefesaEmMin;
	}

	public double getPosseBolaTimeMandanteAtaqueEmMin() {
		return posseBolaTimeMandanteAtaqueEmMin;
	}

	public double getTempoTotalBolaRolandoEmMin() {
		return tempoTotalBolaRolandoEmMin;
	}

	public double getTempoTotalJogoEmMin() {
		return tempoTotalJogoEmMin;
	}
	
	public double getPosseBolaTimeVisitanteDefesaEmPorcentagem() {
		return (posseBolaTimeVisitanteDefesaEmMin / (posseBolaTimeVisitanteDefesaEmMin + posseBolaTimeVisitanteAtaqueEmMin)) * 100;
	}

	public double getPosseBolaTimeVisitanteAtaqueEmPorcentagem() {
		return (posseBolaTimeVisitanteAtaqueEmMin / (posseBolaTimeVisitanteDefesaEmMin + posseBolaTimeVisitanteAtaqueEmMin)) * 100;
	}

	public double getPosseBolaTimeMandanteDefesaEmPorcentagem() {
		return (posseBolaTimeMandanteDefesaEmMin / (posseBolaTimeMandanteDefesaEmMin + posseBolaTimeMandanteAtaqueEmMin)) * 100;
	}

	public double getPosseBolaTimeMandanteAtaqueEmPorcentagem() {
		return (posseBolaTimeMandanteAtaqueEmMin / (posseBolaTimeMandanteDefesaEmMin + posseBolaTimeMandanteAtaqueEmMin)) * 100;
	}

	public double getTempoTotalBolaRolandoEmPorcentagem() {
		return (tempoTotalBolaRolandoEmMin / tempoTotalJogoEmMin) * 100;
	}

	@Override
	public IEstatistica calcular(Jogo jogo) {
		Time visitante = jogo.getVisitante();
		Time mandante = jogo.getMandante();

		this.posseBolaTimeVisitanteDefesaEmMin = visitante.getPosseBolaDefesaEmMin();
		this.posseBolaTimeVisitanteAtaqueEmMin = visitante.getPosseBolaAtaqueEmMin();
		this.posseBolaTimeMandanteDefesaEmMin = mandante.getPosseBolaDefesaEmMin();
		this.posseBolaTimeMandanteAtaqueEmMin = mandante.getPosseBolaAtaqueEmMin();
		this.tempoTotalBolaRolandoEmMin = jogo.getTempoTotalBolaRolandoEmMin();
		this.tempoTotalJogoEmMin = jogo.getTempoTotalJogoEmMin();
		return this;
	}

	public String imprimir() {
		return "A bola ficou rolando por " + getTempoTotalBolaRolandoEmPorcentagem() + "% do tempo de jogo" + System.lineSeparator() +
			"O time mandante ficou " + getPosseBolaTimeMandanteDefesaEmPorcentagem() + "% do tempo de jogo na defesa" + System.lineSeparator() +
			"O time mandante ficou " + getPosseBolaTimeMandanteAtaqueEmPorcentagem() + "% do tempo de jogo no ataque" + System.lineSeparator() +
			"O time visitante ficou " + getPosseBolaTimeVisitanteDefesaEmPorcentagem() + "% do tempo de jogo na defesa" + System.lineSeparator() +
			"O time visitante ficou " + getPosseBolaTimeVisitanteAtaqueEmPorcentagem() + "% do tempo de jogo no ataque" + System.lineSeparator();
	}
	
	
}
