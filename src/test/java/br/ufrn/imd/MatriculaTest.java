package br.ufrn.imd;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */

public class MatriculaTest {

    private Matricula criarMatriculaExemplo(){
        Discente discente = new Discente();
        discente.setNome("Lourrayni");
        discente.setMatricula(4321);

        Docente docente = new Docente();
        docente.setNome("Eiji");
        docente.setSiape(1234);

        Disciplina disciplina = new Disciplina();
        disciplina.setNome("Testes de Software");
        disciplina.setCodigo("DIM321");

        Turma turma = new Turma(docente, disciplina);
    
        return new Matricula(discente, turma);
    }

    @Test
    @DisplayName("Deve ser calculada a media e o status do discente")
    void deveCalcularMediaParcial(){
        Matricula matricula = criarMatriculaExemplo();
        
        matricula.cadastrarNota1(new BigDecimal(8));
        matricula.cadastrarNota2(new BigDecimal(7));
        matricula.cadastrarNota3(new BigDecimal(9.5));

        matricula.cadastrarFrequencia(80);

        matricula.consolidarParcialmente();

        assertEquals(StatusAprovacao.APR, matricula.getStatus());
    }

    @Test
    @DisplayName("Deve checar nota da unidade 1")
    void deveChecarNota1(){
        Matricula matricula = criarMatriculaExemplo();

        assertThrows(IllegalArgumentException.class, ()->{
            matricula.cadastrarNota1(new BigDecimal(1));
        });
    }
}
