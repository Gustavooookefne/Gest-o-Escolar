package com.weg.GestaoEscolar.Mapper;

import com.weg.GestaoEscolar.Dtos.ProfessorDtos.ProfessorRequestDtos;
import com.weg.GestaoEscolar.Dtos.ProfessorDtos.ProfessorResponseDtos;
import com.weg.GestaoEscolar.Model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor paraEntidade(ProfessorRequestDtos professorRequestDtos){

        return new Professor(

                professorRequestDtos.nome(),
                professorRequestDtos.email(),
                professorRequestDtos.disiplina()

        );
    }

    public ProfessorResponseDtos paraDtos(Professor professor){

        return new ProfessorResponseDtos(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisiplina()

        );
    }
}
