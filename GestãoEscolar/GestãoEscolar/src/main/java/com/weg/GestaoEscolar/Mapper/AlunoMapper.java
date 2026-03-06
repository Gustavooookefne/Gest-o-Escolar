package com.weg.GestaoEscolar.Mapper;

import com.weg.GestaoEscolar.Dtos.AlunoDtos.AlunoRequestDtos;
import com.weg.GestaoEscolar.Dtos.AlunoDtos.AlunoResponseDtos;
import com.weg.GestaoEscolar.Model.Aluno;
import com.weg.GestaoEscolar.Repository.AlunoRepository;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public Aluno paraEntidade (AlunoRequestDtos alunoRequestDtos){

        return new Aluno(
                alunoRequestDtos.nome(),
                alunoRequestDtos.email(),
                alunoRequestDtos.matricula(),
                alunoRequestDtos.dataNacimento()
        );

    }

    public Aluno paraDtos (Aluno aluno){

        return new Aluno(

                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getDataNacimento()
        );
    }

}
