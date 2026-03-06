package com.weg.GestaoEscolar.Dtos.NotaDtos;

import com.weg.GestaoEscolar.Model.Aluno;
import com.weg.GestaoEscolar.Model.Aula;

public record NotaRequestDtos (

         Aluno aluno,
         Aula aula,
         double nota

){

}
