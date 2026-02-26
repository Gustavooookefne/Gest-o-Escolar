package com.weg.GestaoEscolar.Model;

import java.time.LocalDate;

public class Aula {
    private long id;
    private Turma turma;
    private LocalDate dataHora;
    private String assuntos;

    public Aula(long id, Turma turma, LocalDate dataHora, String assuntos) {
        this.id = id;
        this.turma = turma;
        this.dataHora = dataHora;
        this.assuntos = assuntos;
    }

    public Aula(Turma turma, LocalDate dataHora, String assuntos) {
        this.turma = turma;
        this.dataHora = dataHora;
        this.assuntos = assuntos;
    }

    public Aula() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public String getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(String assuntos) {
        this.assuntos = assuntos;
    }
}
