package com.weg.GestaoEscolar.Mapper;

import com.weg.GestaoEscolar.Dtos.TurmaDtos.TurmaRequestDtos;
import com.weg.GestaoEscolar.Dtos.TurmaDtos.TurmaResponseDtos;
import com.weg.GestaoEscolar.Model.Turma;
import org.springframework.stereotype.Component;

@Component
public class TurmaMapper {

    public Turma paraEntidade (TurmaRequestDtos turmaRequestDtos){

        return new Turma(

                turmaRequestDtos.nomeTurma(),
                turmaRequestDtos.curso(),
                turmaRequestDtos.professor()
        );
    }

    public TurmaResponseDtos paraDtos(Turma turma){

        return new TurmaResponseDtos(
                turma.getId(),
                turma.getNomeTurma(),
                turma.getCurso(),
                turma.getProfessor()
        );
    }
}
