package br.poo.geradorestatisticasbr.estatisticas;

import br.poo.geradorestatisticasbr.Jogo;
import br.poo.geradorestatisticasbr.Time;

public class EstatisticaFaltasCartoes implements IEstatistica{
	
	private int totalCartoesAmarelosTimeVisitante;
	private int totalCartoesVermelhosTimeVisitante;
	private int totalCartoesAmarelosTimeMandante;
	private int totalCartoesVermelhosTimeMandante;
	private int totalFaltasTimeVisitante;
	private int totalFaltasTimeMandante;
	
	public int getTotalCartoesAmarelosTimeVisitante() {
		return totalCartoesAmarelosTimeVisitante;
	}

	public int getTotalCartoesVermelhosTimeVisitante() {
		return totalCartoesVermelhosTimeVisitante;
	}

	public int getTotalCartoesAmarelosTimeMandante() {
		return totalCartoesAmarelosTimeMandante;
	}

	public int getTotalCartoesVermelhosTimeMandante() {
		return totalCartoesVermelhosTimeMandante;
	}

	public int getTotalFaltasTimeVisitante() {
		return totalFaltasTimeVisitante;
	}

	public int getTotalFaltasTimeMandante() {
		return totalFaltasTimeMandante;
	}

	public int getTotalFaltas() {
		return totalFaltasTimeVisitante + totalFaltasTimeMandante;
	}
	
	public double getPorcentagemFaltasTimeVisitante() {
		return ((double)totalFaltasTimeVisitante / getTotalFaltas()) * 100;
	}
	
	public double getPorcentagemFaltasTimeMandante() {
		return ((double)totalFaltasTimeMandante / getTotalFaltas()) * 100;
	}

	@Override
	public IEstatistica calcular(Jogo jogo) {
		Time visitante = jogo.getVisitante();
		Time mandante = jogo.getMandante();

		this.totalCartoesAmarelosTimeVisitante = visitante.getCartoesAmarelos();
		this.totalCartoesVermelhosTimeVisitante = visitante.getCartoesVermelhos();
		this.totalCartoesAmarelosTimeMandante = mandante.getCartoesAmarelos();
		this.totalCartoesVermelhosTimeMandante = mandante.getCartoesVermelhos();
		this.totalFaltasTimeVisitante = visitante.getFaltas();
		this.totalFaltasTimeMandante = visitante.getFaltas();
		return this;
	}

	@Override
	public String imprimir() {
		return "Total de Faltas: " + this.getTotalFaltas() + System.lineSeparator() +
			"O time mandante teve " + this.getPorcentagemFaltasTimeMandante() + "% das faltas do jogo" + System.lineSeparator() +
			"O time visitante teve " + this.getPorcentagemFaltasTimeVisitante() + "% das faltas do jogo" + System.lineSeparator() +
			"Total de cartões amarelos do time visitante: " + this.getTotalCartoesAmarelosTimeVisitante() + System.lineSeparator() +
			"Total de cartões vermelhos do time visitante: " + this.getTotalCartoesVermelhosTimeVisitante() + System.lineSeparator() +
			"Total de cartões amarelos do time mandante: " + this.getTotalCartoesAmarelosTimeMandante() + System.lineSeparator() +
			"Total de cartões vermelhos do time mandante: " + this.getTotalCartoesVermelhosTimeMandante() + System.lineSeparator();
	}
}
