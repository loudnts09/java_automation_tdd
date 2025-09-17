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
		this.nota1 = nota1;
	}

	public BigDecimal getNota2() {
		return nota2;
	}

	public void cadastrarNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	public BigDecimal getNota3() {
		return nota3;
	}

	public void cadastrarNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}

	public Integer getFrequencia() {
		return frequencia;
	}

	public void cadastrarFrequencia(Integer frequencia) {
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
		this.setStatus(StatusAprovacao.APR);
	}

	public StatusAprovacao getStatus() {
		return status;
	}

	private void setStatus(StatusAprovacao status) {
		this.status = status;
	}

	public BigDecimal calcularMediaParcial(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3){
		BigDecimal soma = nota1.add(nota2).add(nota3);
		BigDecimal media = soma.divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_EVEN);
		// StatusAprovacao status;
		// if(media.compareTo(BigDecimal.valueOf(6)) < 0){
		// 	status = StatusAprovacao.APR;
		// }else{
		// 	status = StatusAprovacao.REP;
		// }
		// setStatus(status);
		return nota1;
	}
}