package br.poo.geradorestatisticasbr;

public class Jogo {

	private int tempoTotalBolaRolandoEmMin;
	private int tempoTotalJogoEmMin;
	private Time visitante;
	private Time mandante;

	public Time getVisitante() {
		return visitante;
	}

	public Time getMandante() {
		return mandante;
	}

	public int getTempoTotalBolaRolandoEmMin() {
		return tempoTotalBolaRolandoEmMin;
	}
	
	public int getTempoTotalJogoEmMin() {
		return tempoTotalJogoEmMin;
	}


	public Jogo(int tempoTotalBolaRolandoEmMin, int tempoTotalJogoEmMin, Time visitante, Time mandante) {
		this.tempoTotalBolaRolandoEmMin = tempoTotalBolaRolandoEmMin;
		this.tempoTotalJogoEmMin = tempoTotalJogoEmMin;
		this.visitante = visitante;
		this.mandante = mandante;
	}
}
