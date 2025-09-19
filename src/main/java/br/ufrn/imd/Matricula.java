package br.ufrn.imd;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Matricula {
	private final Discente discente;
	
	private final Turma turma;
	
	private BigDecimal nota1;

	private BigDecimal nota2;

	private BigDecimal nota3;

	private Integer frequencia;
	
	private StatusAprovacao status;

	Matricula(Discente discente, Turma turma) {
		this.discente = discente;
		this.turma = turma;
	}

	public BigDecimal getNota1() {
		return nota1;
	}

	public void cadastrarNota1(BigDecimal nota1) {
		if(nota1.compareTo(BigDecimal.ZERO) < 0 || nota1.compareTo(BigDecimal.TEN) > 0){
			throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
		}
		this.nota1 = nota1;
	}

	public BigDecimal getNota2() {
		return nota2;
	}

	public void cadastrarNota2(BigDecimal nota2) {
		if(nota2.compareTo(BigDecimal.ZERO) < 0 || nota2.compareTo(BigDecimal.TEN) > 0){
			throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
		}
		this.nota2 = nota2;
	}

	public BigDecimal getNota3() {
		return nota3;
	}

	public void cadastrarNota3(BigDecimal nota3) {
		if(nota3.compareTo(BigDecimal.ZERO) < 0 || nota3.compareTo(BigDecimal.TEN) > 0){
			throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
		}
		this.nota3 = nota3;
	}

	public Integer getFrequencia() {
		return frequencia;
	}

	public void cadastrarFrequencia(Integer frequencia) {
		if(frequencia < 0 || frequencia > 100){
			throw new IllegalArgumentException("A frequência deve estar entre 0 e 100");
		}
		this.frequencia = frequencia;
	}

	public Discente getDiscente() {
		return discente;
	}

	public Turma getTurma() {
		return turma;
	}

	public void consolidarParcialmente() {
		// TODO Implementar aqui a lógica de consolidação parcial
		BigDecimal media = calcularMediaParcial();

		if(frequencia < 75){
			if(media.compareTo(new BigDecimal(3)) < 0){
				this.setStatus(StatusAprovacao.REPMF);
			}
			else{
				this.setStatus(StatusAprovacao.REPF);
			}
			return;
		}

		if(media.compareTo(new BigDecimal(6)) >= 0 && nota1.compareTo(new BigDecimal(4)) >= 0 && nota2.compareTo(new BigDecimal(4)) >= 0 && nota3.compareTo(new BigDecimal(4)) >= 0){
			this.setStatus(StatusAprovacao.APR);
		}
		else if(media.compareTo(new BigDecimal(3)) >= 0){
			this.setStatus(StatusAprovacao.REC);
		}
		else{
			this.setStatus(StatusAprovacao.REP);
		}
	}

	public StatusAprovacao getStatus() {
		return status;
	}

	private void setStatus(StatusAprovacao status) {
		this.status = status;
	}

	public BigDecimal calcularMediaParcial(){
		BigDecimal soma = nota1.add(nota2).add(nota3);
		BigDecimal media = soma.divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_EVEN);

		return media;
	}
}