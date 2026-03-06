package com.weg.GestaoEscolar.Service;

import com.weg.GestaoEscolar.Model.Curso;
import com.weg.GestaoEscolar.Repository.CursoRepository;

import java.sql.SQLException;
import java.util.List;

public class CursoService {
        CursoRepository cursoRepository = new CursoRepository();
    public Curso cadastrarCurso(Curso curso)throws SQLException{
           if(curso.getNomeCurso().isEmpty()){
               throw new RuntimeException("Curso não cadastrado");
           }
           return cursoRepository.novaCurso(curso);
    }

    public List<Curso> listarTodosOsCursos()throws SQLException{
           List<Curso> cursos = cursoRepository.listarCurso();
           if(cursos.isEmpty()){
               throw new RuntimeException("lista vazia");
           }

        return cursos;
    }

    public Curso listarPorId(long id)throws SQLException{
           Curso curso = cursoRepository.buscarPorId(id);
           if(curso == null){
               throw new RuntimeException("lista esta vazia");
           }
        return curso;
    }

    public Curso atualizarTodosOsCursos(Curso curso, long id)throws SQLException{
           Curso cursos = cursoRepository.buscarPorId(id);
           if(cursos == null){
               throw new RuntimeException("Curso não encontrado");
           }
            return cursoRepository.atualizarCurso(curso);
    }

    public void deletarCurso(long id)throws SQLException{
        Curso curso = cursoRepository.buscarPorId(id);
        if(curso == null){
            throw new RuntimeException("Curso não encontrado");
        }
        cursoRepository.deletarCurso(id);
    }
}
