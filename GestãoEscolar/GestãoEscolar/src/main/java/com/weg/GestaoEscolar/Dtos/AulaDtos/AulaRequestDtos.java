package com.weg.GestaoEscolar.Dtos.AulaDtos;

import com.weg.GestaoEscolar.Model.Turma;

import java.time.LocalDate;

public record AulaRequestDtos (

         Turma turma,
         LocalDate dataHora,
         String assuntos

){

}
