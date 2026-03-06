package com.weg.GestaoEscolar.Mapper;

import com.weg.GestaoEscolar.Dtos.CursoDtos.CursoRequestDtos;
import com.weg.GestaoEscolar.Dtos.CursoDtos.CursoResponseDtos;
import com.weg.GestaoEscolar.Model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public Curso paraEntidade(CursoRequestDtos cursoRequestDtos){

        return new Curso(

                cursoRequestDtos.nomeCurso(),
                cursoRequestDtos.codigo()
        );

    }

    public CursoResponseDtos paraDtos (Curso curso){

        return new CursoResponseDtos(

                curso.getId(),
                curso.getNomeCurso(),
                curso.getCodigo()
        );

    }
}
