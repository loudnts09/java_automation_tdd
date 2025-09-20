# Sistema de Consolidação Parcial de Notas

Este projeto foi desenvolvido como parte da disciplina **Testes de Software**, com foco em **Automatização de Testes** e **Test-Driven Development (TDD)**.  

O objetivo é implementar um sistema de consolidação parcial das notas de uma turma de graduação, aplicando regras de aprovação, recuperação e reprovação, além de validar os casos com **testes automatizados** usando **JUnit 5**.

---

## Tecnologias Utilizadas
- **Java 17+**
- **JUnit 5** (para testes unitários)
- **Maven** (build e gerenciamento de dependências)

---

## Estrutura do Projeto
```
meu-projeto/
├── pom.xml
└── src
├── main/java/br/ufrn/imd
│ ├── Discente.java
│ ├── Disciplina.java
│ ├── Docente.java
│ ├── Matricula.java
│ ├── Turma.java
│ └── StatusAprovacao.java
└── test/java/br/ufrn/imd
└── MatriculaTest.java
```

---

## Regras de Aprovação

1. **Aprovação Direta (APR)**  
   - Média ≥ 6,0  
   - Nenhuma nota < 4,0  
   - Frequência ≥ 75%  

2. **Recuperação (REC)**  
   - Frequência ≥ 75%  
   - Média ≥ 3,0 e < 6,0  

3. **Reprovação por Média (REP)**  
   - Média < 3,0  
   - Frequência ≥ 75%  

4. **Reprovação por Faltas (REPF)**  
   - Frequência < 75%  
   - Média ≥ 3,0  

5. **Reprovação por Média e Faltas (REPMF)**  
   - Frequência < 75%  
   - Média < 3,0  

---

## Testes Automatizados

Os testes foram implementados com **JUnit 5**, usando:
- `@ParameterizedTest` com `@CsvSource` para cobrir múltiplos cenários de aprovação, recuperação e reprovação.  
- `assertThrows` para validar exceções em notas ou frequências inválidas.  