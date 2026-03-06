package com.weg.GestaoEscolar.Mapper;

import com.weg.GestaoEscolar.Dtos.AulaDtos.AulaRequestDtos;
import com.weg.GestaoEscolar.Dtos.AulaDtos.AulaResponseDtos;
import com.weg.GestaoEscolar.Model.Aula;
import org.springframework.stereotype.Component;

@Component
public class AulaMapper {

    public Aula paraEntidades(AulaRequestDtos aulaRequestDtos){

        return new Aula(

                aulaRequestDtos.turma(),
                aulaRequestDtos.dataHora(),
                aulaRequestDtos.assuntos()
        );

    }

    public AulaResponseDtos paraDtos(Aula aula){

        return new AulaResponseDtos(

                aula.getId(),
                aula.getTurma(),
                aula.getDataHora(),
                aula.getAssuntos()
        );
    }

}
