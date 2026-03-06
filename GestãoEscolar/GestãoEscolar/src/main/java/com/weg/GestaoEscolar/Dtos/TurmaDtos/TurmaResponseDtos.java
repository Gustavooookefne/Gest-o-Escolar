package com.weg.GestaoEscolar.Dtos.TurmaDtos;

import com.weg.GestaoEscolar.Model.Curso;
import com.weg.GestaoEscolar.Model.Professor;

public record TurmaResponseDtos (

         long id,
         String nomeTurma,
         Curso curso,
         Professor professor
){

}
