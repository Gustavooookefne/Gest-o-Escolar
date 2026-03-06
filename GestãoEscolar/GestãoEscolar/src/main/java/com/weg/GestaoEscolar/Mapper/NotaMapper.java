package com.weg.GestaoEscolar.Mapper;

import com.weg.GestaoEscolar.Dtos.NotaDtos.NotaRequestDtos;
import com.weg.GestaoEscolar.Dtos.NotaDtos.NotaResponseDtos;
import com.weg.GestaoEscolar.Model.Nota;
import org.springframework.stereotype.Component;

@Component
public class NotaMapper {

    public Nota paraEntidade(NotaRequestDtos notaRequestDtos){

        return new Nota(

                notaRequestDtos.aluno(),
                notaRequestDtos.aula(),
                notaRequestDtos.nota()
        );

    }

    public NotaResponseDtos paraDtos(Nota nota){

        return new NotaResponseDtos(

                nota.getId(),
                nota.getAluno(),
                nota.getAula(),
                nota.getNota()
        );
    }
}
