package br.ufrn.imd;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit test for simple App.
 */

public class MatriculaTest {

    private static Discente discente;
    private static Docente docente;
    private static Disciplina disciplina;
    private static Turma turma;

    @BeforeAll
    public static void setup(){
        discente = new Discente();
        discente.setNome("Aluno de teste ");
        discente.setMatricula(43214321);

        docente = new Docente();
        docente.setNome("Docente de teste");
        docente.setSiape(12341234);

        disciplina = new Disciplina();
        disciplina.setNome("Testes de Software");
        disciplina.setCodigo("DIM0507");

        turma = new Turma(docente, disciplina);
    }

    @ParameterizedTest
    @CsvSource({
        "8, 9, 10, 80, APR",
        "7, 7, 7, 75, APR",
        "6, 6, 6, 100, APR",
        "9, 4, 7, 90, APR",
        "10, 10, 10, 85, APR",
        "5, 5, 5, 80, REC",
        "4, 6, 5, 90, REC",
        "3, 6, 5, 75, REC",
        "5, 3, 4, 100, REC",
        "5, 5, 4, 80, REC",
        "2, 2, 2, 100, REP",
        "1, 5, 2, 90, REP",
        "2, 3, 2, 80, REP",
        "0, 0, 0, 85, REP",
        "2, 2, 4, 95, REP",
        "8, 9, 10, 70, REPF",
        "6, 6, 6, 60, REPF",
        "2, 2, 2, 60, REPMF",
        "1, 5, 2, 50, REPMF"
    })

    @DisplayName("Deve calcular média e status corretamente")
    void deveCalcularMediaParcial(BigDecimal n1, BigDecimal n2, BigDecimal n3, int frequencia, StatusAprovacao statusEsperado){
        Matricula matricula = new Matricula(discente, turma);
        
        matricula.cadastrarNota1(n1);
        matricula.cadastrarNota2(n2);
        matricula.cadastrarNota3(n3);

        matricula.cadastrarFrequencia(frequencia);

        matricula.consolidarParcialmente();

        StatusAprovacao statusRetornado = matricula.getStatus();

        assertEquals(statusEsperado, statusRetornado);
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 5, 5",
        "11, 5, 5",
        "5, -1, 5",
        "5, 11, 5",
        "5, 5, -1",
        "5, 5, 11",
        "-2, -3, 5",
        "12, 13, 14",
        "0, -5, 15",
        "-1, 11, -2"
    })

    @DisplayName("Deve exibir exceção para notas inválidas")
    void deveExibirExcessaoParaNotaErrada(BigDecimal n1, BigDecimal n2, BigDecimal n3){
        
        Matricula matricula = new Matricula(discente, turma);

        assertThrows(IllegalArgumentException.class, () -> {
            matricula.cadastrarNota1(n1);
            matricula.cadastrarNota2(n2);
            matricula.cadastrarNota3(n3);
        });
    }

    @ParameterizedTest
    @CsvSource({"-1", "101", "-5", "150", "-10", "200"})

    @DisplayName("Deve exibir exceção para frequências inválidas")
    void deveExibirExcessaoParaFrequenciaErrada(int frequencia){
        
        Matricula matricula = new Matricula(discente, turma);

        assertThrows(IllegalArgumentException.class, () -> {
            matricula.cadastrarFrequencia(frequencia);
        });
    }
}
