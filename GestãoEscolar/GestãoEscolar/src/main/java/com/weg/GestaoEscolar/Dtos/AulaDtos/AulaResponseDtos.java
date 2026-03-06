package com.weg.GestaoEscolar.Dtos.AulaDtos;

import com.weg.GestaoEscolar.Model.Turma;

import java.time.LocalDate;

public record AulaResponseDtos (

         long id,
         Turma turma,
         LocalDate dataHora,
         String assuntos

){

}
