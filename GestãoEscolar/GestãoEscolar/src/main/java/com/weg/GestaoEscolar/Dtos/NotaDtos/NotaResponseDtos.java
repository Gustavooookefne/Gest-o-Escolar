package com.weg.GestaoEscolar.Dtos.NotaDtos;

import com.weg.GestaoEscolar.Model.Aluno;
import com.weg.GestaoEscolar.Model.Aula;

public record NotaResponseDtos (

         long id,
         Aluno aluno,
         Aula aula,
         double nota
){

}
